/**
 * 
 */
package com.salesapp.shopdomain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Test case for {@link com.salesapp.shopdomain.ShoppingStore}
 * 
 * @author archugs
 */
public class ShoppingStoreTest {

	/** Test fixture */
	ShoppingStore store = new ShoppingStore();
	
	
	/**
	 * Test method for {@link com.salesapp.shopdomain.ShoppingStore#retrieveOrderAndPlaceInCart(java.util.List)}.
	 */
	@Test
	public void testRetrieveOrderAndPlaceInCart() 
	{
		String name = "box of chocolates";
		double price = 45.00;
		boolean imported = true;
		int quantity = 2;
		store.retrieveOrderAndPlaceInCart(name, price, imported, quantity);
		assertEquals(1, store.getCart().getCartSize());
	}

	/**
	 * Test method for {@link com.salesapp.shopdomain.ShoppingStore#getProductName()}.
	 */
	@Test
	public void testGetProductName() 
	{
		assertEquals("book",store.getProductName());
	}

	/**
	 * Test method for {@link com.salesapp.shopdomain.ShoppingStore#getProductPrice()}.
	 */
	@Test
	public void testGetProductPrice() 
	{
		assertEquals(40.00, store.getProductPrice(), 0.0009);
	}

	/**
	 * Test method for {@link com.salesapp.shopdomain.ShoppingStore#isProductImported()}.
	 */
	@Test
	public void testIsProductImported() 
	{
		assertEquals(true, store.isProductImported());
	}

	/**
	 * Test method for {@link com.salesapp.shopdomain.ShoppingStore#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() 
	{
		assertEquals(4, store.getQuantity());
	}

	/**
	 * Test method for {@link com.salesapp.shopdomain.ShoppingStore#isAddAnotherProduct()}.
	 */
	@Test
	public void testIsAddAnotherProduct() 
	{
		assertEquals(false, store.isAddAnotherProduct());
	}

	/**
	 * Test method for {@link com.salesapp.shopdomain.ShoppingStore#parseBoolean(char)}.
	 */
	@Test
	public void testParseBoolean() 
	{
		assertEquals(true, store.parseBoolean('Y'));
	}

}
