/**
 * 
 */
package com.salesapp.taxcalculations;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test case for {@link com.salesapp.taxcalculations.LocalTaxCalculator}
 * 
 * @author archugs
 */
public class LocalTaxCalculatorTest {

	/** Creates a test fixture */
	ITaxCalculator taxcalc = new LocalTaxCalculator();
	
	/**
	 * Test method for {@link com.salesapp.taxcalculations.LocalTaxCalculator#calculateTax(double, double, boolean)}.
	 */
	@Test
	public void testCalculateTax()
	{
		assertEquals(7.15, taxcalc.calculateTax(47.50, 0.10, true), 0);
		assertEquals(0.50, taxcalc.calculateTax(10.00, 0, true), 0);
		assertEquals(1.50, taxcalc.calculateTax(14.99, 0.10, false),0);
		assertEquals(0, taxcalc.calculateTax(12.49, 0, false), 0);
	}

}
