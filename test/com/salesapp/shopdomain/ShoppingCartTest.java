/**
 * 
 */
package com.salesapp.shopdomain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.salesapp.products.*;

/**
 * The ShoppingCartTest is used to test the ShoppingCart class.
 *
 * @author archugs
 */
public class ShoppingCartTest {

	
	/** Creates a test fixture. */
	ShoppingCart cart;
	Product product;
	
	/**
	 * Initializes the fixture.
	 */
	@Before
	public void setUp()
	{
		cart = new ShoppingCart();
		product = new BookProduct();
	}

	/**
	 * Test method for {@link com.salesapp.shopdomain.ShoppingCart#addItemToCart(com.salesapp.products.Product)}.
	 */
	@Test
	public void testAddItemToCart() 
	{
		cart.addItemToCart(product);
		assertEquals(1, cart.getCartSize());
	}

	/**
	 * Test method for {@link com.salesapp.shopdomain.ShoppingCart#getItemsFromCart()}.
	 */
	@Test
	public void testGetItemsFromCart() 
	{
		cart.addItemToCart(product);
		assertEquals(product ,cart.getItemsFromCart().get(0));
		BookProductTest test = new BookProductTest();
		test.testBookProduct();
		
	}

}
