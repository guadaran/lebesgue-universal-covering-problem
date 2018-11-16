package com.gibbs.org.core;

public abstract class Figures {

	/**
	 * @return a regular hexagon
	 */
	public static double[][] hexagon() {
		double hex[][] = new double[6][2]; // six (x,y) points
		hex[0] = edgePoint(30.0); // first point F1 is on left edge of hexagon

		// the remaining five points are constructed by rotations of 60 degrees
		for (int i = 1; i < 6; i++) {
			hex[i] = rotate(hex[i - 1], 60.0);
		}

		return hex;
	}

	/**
	 * @return a square
	 */
	public static double[][] square() {
		double squ[][] = new double[4][2]; // four (x,y) points
		squ[0][0] = 0.0;
		squ[0][1] = 1.0;

		// the remaining three points are constructed by rotations of 90 degrees
		for (int i = 1; i < 4; i++) {
			squ[i] = rotate(squ[i - 1], 90.0);
		}

		return squ;
	}

	/**
	 * Returns a twelve sided polygon formed by cutting off corners from a regular
	 * hexagon with cuts tangent to an inscribed circle of unit diameter at a
	 * slanted angle
	 * 
	 * @param slant
	 * @return a twelve sided polygon
	 */
	public static double[][] dodecagon(double slant) {
		double dod[][] = new double[12][2]; // twelve (x,y) points
		dod[0] = edgePoint(15.0 - slant * 0.5); // first point F3 is on left edge of hexagon
		dod[1] = edgePoint(-15.0 - slant * 0.5); // second point E2 is also on left edge of hexagon

		// the remaining ten points are constructed by rotations of 60 degrees
		for (int i = 2; i < 12; i++) {
			dod[i] = rotate(dod[i - 2], 60.0);
		}

		return dod;
	}

	/**
	 * A point on the left edge of a hexagon at an angle from the center
	 * 
	 * @param angle angle in radians
	 * @return Edge point
	 */
	public static double[] edgePoint(double angle) {
		double angler = angle * Math.PI / 180.0;
		double e[] = { -0.5, 0.5 * Math.tan(angler) };
		return e;
	}

	/**
	 * Rotate a point an angle about the origin
	 * 
	 * @param a
	 * @param angle
	 * @return
	 */
	public static double[] rotate(double a[], double angle) {
		double angler = angle * Math.PI / 180.0; // angle in radians
		double cos = Math.cos(angler);
		double sin = Math.sin(angler);
		double b[] = { cos * a[0] - sin * a[1], sin * a[0] + cos * a[1] };
		return b;
	}

}
