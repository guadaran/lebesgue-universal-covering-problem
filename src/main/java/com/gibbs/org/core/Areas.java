package com.gibbs.org.core;

import com.gibbs.org.util.Util;

public abstract class Areas {

	/**
	 * Compute the area of a polygon
	 * 
	 * @param p
	 * @return
	 */
	public static double polygon(double p[][]) {
		int n = p.length; // number of points
		double area = 0.0;

		for (int i = 0; i < n; i++) {
			int j = (i + 1) % n; // plus one mod n
			area += 0.5 * Util.cross(p[i], p[j]);
		}
		return area;
	}

	/**
	 * Area of a segment of a circle of radius one on the chord from a to b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double segment(double a[], double b[]) {
		double d = Util.dist(a, b);
		double theta = 2.0 * Math.asin(0.5 * d);
		double area = 0.5 * (theta - Math.sin(theta));
		return area;
	}

}
