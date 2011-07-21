/**
 * 
 */
package com.salesapp.taxcalculations;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test case for {@link com.salesapp.taxcalculations.TaxCalculatorFactory}
 * 
 * @author archugs
 */
public class TaxCalculatorFactoryTest
{
	TaxCalculatorFactory factory = new TaxCalculatorFactory();

	/**
	 * Test method for {@link com.salesapp.taxcalculations.TaxCalculatorFactory#TaxCalculatorFactory()}.
	 */
	@Test
	public void testTaxCalculatorFactory() 
	{
		assertEquals(1, factory.getFactorySize());
	}

}
