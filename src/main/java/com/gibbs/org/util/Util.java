package com.gibbs.org.util;

public abstract class Util {
	
	/**
	 * 2d cross product
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double cross(double a[], double b[]) {
		double c = a[0] * b[1] - a[1] * b[0];
		return c;
	}
	
	/**
	 * Distance from a to b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double dist(double a[], double b[]) {
		double dx = a[0] - b[0];
		double dy = a[1] - b[1];
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}
	
	public static double angle(double a[], double b[], double c[]) {
		double ba0 = b[0] - a[0];
		double ba1 = b[1] - a[1];
		double bc0 = b[0] - c[0];
		double bc1 = b[1] - c[1];

		double badotbc = ba0 * bc0 + ba1 * bc1;
		double cosabc = badotbc / (dist(a, b) * dist(b, c));
		double abc = Math.acos(cosabc) * 180.0 / Math.PI;
		return abc;
	}
}
