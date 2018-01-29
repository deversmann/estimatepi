package com.eversmann.examples.estimatepi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import static com.eversmann.examples.estimatepi.EstimatePiUtils.*;

public class EstimatePiUtilsTest {
	@Test
	public void testGcd() throws Exception {
		assertEquals("gcd() failed", 6, gcd(6,12));
		assertEquals("gcd() failed", 1, gcd(5,8));
		assertEquals("gcd() failed", 1, gcd(9,14));
		assertEquals("gcd() failed", 3, gcd(12,15));
	}
	
	@Test
	public void testRandomWithMax() throws Exception {
		assertTrue("randomWithMax(max) exceeded max", randomWithMax(10)<10);
		assertTrue("randomWithMax(max) exceeded max", randomWithMax(100)<100);
		assertTrue("randomWithMax(max) exceeded max", randomWithMax(10000)<10000);
		assertTrue("randomWithMax(max) exceeded max", randomWithMax(100000000)<100000000);
	}

}
