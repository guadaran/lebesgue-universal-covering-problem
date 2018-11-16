package com.gibbs.org;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

import com.gibbs.org.core.Areas;
import com.gibbs.org.core.Figures;
import com.gibbs.org.core.Points;
import com.gibbs.org.util.MultiOutputStream;
import com.gibbs.org.util.Util;

/**
 * Lebesgue’s Universal Covering Problem. This program to compute the area for
 * many choices of rotation angle.
 * 
 * @author Based on the code of Philip Gibbs.
 * @see
 *      <ul>
 *      <li><a href=
 *      "https://johncarlosbaez.wordpress.com/2013/12/08/lebesgues-universal-covering-problem/">Lebesgue’s
 *      Universal Covering Problem (Part 1)</a></li>
 *      <li><a href=
 *      "https://johncarlosbaez.wordpress.com/2015/02/03/lebesgues-universal-covering-problem-part-2/">Lebesgue’s
 *      Universal Covering Problem (Part 2)</a></li>
 *      <li><a href=
 *      "https://johncarlosbaez.wordpress.com/2018/10/07/lebesgue-universal-covering-problem-part-3/">Lebesgue’s
 *      Universal Covering Problem (Part 3)</a></li>
 *      </ul>
 */
public class Lebesgue {

	private static double Q[];
	private static double M[];

	static DecimalFormat af = new DecimalFormat("#.############");
	static DecimalFormat af1 = new DecimalFormat("#.###");

	/**
	 * Calculates area for simplest cover with slant and checks angles for BBG paper 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		setOutPrint();
		System.out.println("\t------------------\t-----------------\t------------------");
		System.out.println("\t|      Area      |     \t|    Angle 1    |   \t|     Angle 2    |");
		System.out.println("\t------------------\t-----------------\t------------------");
		for (double a = 0.0; a < 2.001; a += 0.1) {
			double p[][] = cover(a);
			double area = Areas.polygon(p);

			area += Areas.segment(p[7], p[8]);
			area += Areas.segment(p[9], p[10]);
			double ang1 = Util.angle(Q, p[8], p[9]);
			double ang2 = Util.angle(M, p[9], p[8]);
			System.out.println(af1.format(a) + "\t" + area + "\t" + ang1 + "\t" + ang2);

		}
		areas();
	}

	/**
	 * Table of H.C Hansen values
	 */
	public static void areas() {
		double xi = 1.0 - Math.sqrt(3.0) * 0.5;

		System.out.println("\r\n--------------------------------------------------------------------------");
		System.out.println("|                       Table of H.C Hansen values                       |");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\r\n");
		for (int i = 0; i < 7; i++) {
			double xip = 2 * xi * xi / (1 - xi * Math.sqrt(3.0) + Math.sqrt(1.0 - 2.0 * Math.sqrt(3.0) * xi - xi * xi));
			double b = xi + Math.sqrt(3.0) * 0.5 * xip;
			double d = Math.sqrt(xip * xip * 0.25 + b * b);
			double theta = 2.0 * Math.asin(d * 0.5);
			double Ai = xi * xip * 0.25 - (xminussinx(theta)) * 0.5;
			System.out.println(i + "\t" + xi + "\t" + Ai);
			xi = xip;
		}
	}

	public static double xminussinx(double x) {
		double t = -x;
		double y = 0.0;
		double n = 3;

		while (y + t != y) {
			t = -t * x * x / (n * (n - 1));
			y += t;
			n += 2;
		}

		return y;
	}

	public static double[][] cover(double slant) {
		double hex[][] = Figures.hexagon();
		double dod[][] = Figures.dodecagon(slant);

		double cov[][] = new double[11][2];

		cov[0] = hex[0]; // point F1
		cov[1] = dod[1]; // point E2
		cov[2] = dod[2]; // point E3
		cov[3] = hex[2]; // point D1
		cov[4] = dod[5]; // point C2
		cov[5] = dod[6]; // point C3
		cov[6] = hex[4]; // point B1

		// Area removed near A1
		cov[7] = Points.nearest(hex[4], hex[5], dod[2]); // point on edge B1A1 nearest E3
		Q = Points.nearest(hex[2], hex[3], dod[10]); // point Q on edge D1C1 nearest A3
		cov[8] = Points.triangulate(dod[2], Q); // point X at distance one from E3 and Q
		M = Points.mid(hex[1], hex[2]); // midpoint of E1D1
		cov[9] = Points.triangulate(M, dod[5]); // point Y at distance one from M and C2
		cov[10] = Points.nearest(hex[5], hex[0], dod[5]); // point on A1F1 nearest G

		return cov;
	}
	
	
	/**
	 * Redirect <code>System.out</code> to file and to console
	 */
	public static void setOutPrint() {
		try {
			FileOutputStream fout = new FileOutputStream("output.log");
			FileOutputStream ferr = new FileOutputStream("error.log");
			MultiOutputStream multiOut = new MultiOutputStream(System.out, fout);
			MultiOutputStream multiErr = new MultiOutputStream(System.err, ferr);
			PrintStream stdout = new PrintStream(multiOut);
			PrintStream stderr = new PrintStream(multiErr);
			System.setOut(stdout);
			System.setErr(stderr);
		} catch (FileNotFoundException ex) {
			new RuntimeException("Could not create/open the file");
		}
	}
	
	
}