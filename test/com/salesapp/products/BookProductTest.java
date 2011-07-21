/**
 * 
 */
package com.salesapp.products;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test case for {@link com.salesapp.products.BookProduct)
 * 
 * @author archugs
 */
public class BookProductTest {

	Product p;
	
	/**
	 * Test method for {@link com.salesapp.products.BookProduct#BookProduct()}.
	 */
	@Test
	public void testBookProduct() 
	{
		p = new BookProduct();
		assertEquals("", p.getName());
		assertEquals(0.0, p.getPrice(), 0.0009);
		assertEquals(false, p.isImported());
		assertEquals(0, p.getQuantity());
		assertEquals(0.0, p.getTaxedCost(), 0.0009);
	}

	/**
	 * Test method for {@link com.salesapp.products.BookProduct#BookProduct(java.lang.String, double, boolean, int)}.
	 */
	@Test
	public void testBookProductParaConst()
	{
	
		p = new BookProduct("book", 95.00, true, 3);
		assertEquals("book", p.getName());
		assertEquals(285.0, p.getPrice(), 0.0009);
		assertEquals(true, p.isImported());
		assertEquals(3, p.getQuantity());
	}

	
	/**
	 * Test method for {@link com.salesapp.products.BookProduct#getTaxValue(String)}.
	 */
	@Test
	public void testGetTaxValue()
	{
		p = new BookProduct("book", 95.00, true, 3);
		assertEquals(0.0, p.getTaxValue("Local"), 0.0009);
	}
}
