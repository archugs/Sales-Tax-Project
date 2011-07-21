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
		assertEquals(6.00, taxcalc.calculateTax(40.00, 0.10, true), 0.0009);
		assertEquals(2.00, taxcalc.calculateTax(40.00, 0, true), 0.0009);
		assertEquals(4.00, taxcalc.calculateTax(40.00, 0.10, false), 0.0009);
		assertEquals(0, taxcalc.calculateTax(40.00, 0, false), 0.0009);
	}

}
