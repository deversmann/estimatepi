package com.eversmann.examples.estimatepi;

public class EstimatePiUtils {
	
	public static int gcd(int a, int b) {
		return (b==0 ? a : gcd (b, a%b));
	}
	
	public static int randomWithMax(int maxNumber) {
		return (int)(Math.random()*maxNumber);
	}

}
