package com.gibbs.org.core;

import com.gibbs.org.util.Util;

public abstract class Points {

	/**
	 * Find the point on line through a and b, which is nearest to c
	 * a point on the segment is given by a(1-s) + bs for parameter s
	 * distance from c is (a-b)^2 s^2 - 2(a-b).(a-c) s + (a-c)^2
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static double[] nearest(double a[], double b[], double c[]) {
		double ab[] = { a[0] - b[0], a[1] - b[1] };
		double ac[] = { a[0] - c[0], a[1] - c[1] };

		double A = dot(ab, ab);
		double B = dot(ab, ac);
		//TODO: The value of the local variable C is not used... why?
		double C = dot(ac, ac) - 1.0;

		// find minimum of As^2 - 2Bs + C = 0
		double s = B / A;
		double d[] = { a[0] * (1.0 - s) + b[0] * s, a[1] * (1.0 - s) + b[1] * s };
		return d;
	}

	/**
	 * Find the point on line through a and b, near b which is at distance one from c
	 * a point on the segment is given by a(1-s) + bs for parameter s distance
	 * squared from c is (a-b)^2 s^2 - 2(a-b).(a-c) s + (a-c)^2 = 1
	 *
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static double[] radial(double a[], double b[], double c[]) {
		double ab[] = { a[0] - b[0], a[1] - b[1] };
		double ac[] = { a[0] - c[0], a[1] - c[1] };
		double A = dot(ab, ab);
		double B = dot(ab, ac);
		double C = dot(ac, ac) - 1.0;

		// solve As^2 - 2Bs + C = 0
		double s = (B + Math.sqrt(B * B - A * C)) / A;
		double d[] = { a[0] * (1.0 - s) + b[0] * s, a[1] * (1.0 - s) + b[1] * s };
		return d;
	}

	/**
	 * Mid Point 
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double[] mid(double a[], double b[]) {
		double m[] = { 0.5 * (a[0] + b[0]), 0.5 * (a[1] + b[1]) };
		return m;
	}
	
	/**
	 * 2d dot product
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double dot(double a[], double b[]) {
		double d = a[0] * b[0] + a[1] * b[1];
		return d;
	}
	
	/**
	 * Finds a point of distance 1 from a and b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double[] triangulate(double a[], double b[]) {
		double d = Util.dist(a, b);

		if (d >= 1.0) {
			System.err.println("Points too far apart to trianglulate");
			return a;
		}
		double dx = (b[0] - a[0]) / d;
		double dy = (b[1] - a[1]) / d;
		double mx = (a[0] + b[0]) * 0.5;
		double my = (a[1] + b[1]) * 0.5;
		double l = Math.sqrt(1.0 - d * d * 0.25);
		double t[] = { mx - dy * l, my + dx * l };
		return t;
	}

}
