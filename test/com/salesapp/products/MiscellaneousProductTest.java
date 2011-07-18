/**
 * 
 */
package com.salesapp.products;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The MiscellaneousProductTest tests the MiscellaneousProduct class.
 * 
 * @author archugs
 */
public class MiscellaneousProductTest {

	Product p;
	
	/**
	 * Test method for {@link com.salesapp.products.MiscellaneousProduct#MiscellaneousProduct()}.
	 */
	@Test
	public void testMiscellaneousProduct() 
	{
		p = new MiscellaneousProduct();
		assertEquals("", p.getName());
		assertEquals(0.0, p.getPrice(), 0.0009);
		assertEquals(false, p.isImported());
		assertEquals(0, p.getQuantity());
		assertEquals(0.0, p.getTaxedCost(), 0.0009);
	}

	/**
	 * Test method for {@link com.salesapp.products.MiscellaneousProduct#MiscellaneousProduct(java.lang.String, double, boolean, int)}.
	 */
	@Test
	public void testMiscellaneousProductStringDoubleBooleanInt()
	{
		p = new MiscellaneousProduct("a bottle of perfume", 95.00, true, 3);
		assertEquals("a bottle of perfume", p.getName());
		assertEquals(285.0, p.getPrice(), 0.0009);
		assertEquals(true, p.isImported());
		assertEquals(3, p.getQuantity());
	}

}
