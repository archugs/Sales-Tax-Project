/**
 * 
 */
package com.salesapp.products;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Test case for {@link com.salesapp.products.Product)
 *
 * @author archugs
 */
public class ProductTest {

	/** Creates a test fixture. */
	Product product;
	
	/**
	 * Initialize the fixture by instantiating the mock object.
	 */
	@Before
	public void setUp()
	{
		product = new MockProduct("Mock", 50.00, true, 2);
	}

	/**
	 * Test method for {@link com.salesapp.products.Product#getName()}.
	 */
	@Test
	public void testGetName() 
	{
	
		assertEquals("Mock", product.getName());
	}

	
	/**
	 * Test method for {@link com.salesapp.products.Product#getPrice()}.
	 */
	@Test
	public void testGetPrice() 
	{
		assertEquals(100.00, product.getPrice(), 0.0009);
	}

	/**
	 * Test method for {@link com.salesapp.products.Product#isImported()}.
	 */
	@Test
	public void testIsImported() 
	{
		assertEquals(true, product.isImported());
	}


	/**
	 * Test method for {@link com.salesapp.products.Product#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() 
	{
		assertEquals(2, product.getQuantity());
	}

	/**
	 * Test method for {@link com.salesapp.products.Product#getTaxedCost()}.
	 */
	@Test
	public void testGetTaxedCost() 
	{
		assertEquals(0.0, product.getTaxedCost(), 0.0009);
	}

	/**
	 * Test method for {@link com.salesapp.products.Product#toString()}.
	 */
	@Test
	public void testToString()
	{
		assertEquals("2 imported Mock : 0.0", product.toString());
	}

	/**
	 * Test method for {@link com.salesapp.products.Product#toString(boolean)}.
	 */
	@Test
	public void testToStringBoolean()
	{
		assertEquals("imported", product.toString(product.isImported()));
	}

}
