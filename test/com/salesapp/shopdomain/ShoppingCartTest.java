/**
 * 
 */
package com.salesapp.shopdomain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.salesapp.products.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ShoppingCartTest.
 *
 * @author user
 */
public class ShoppingCartTest {

	
	/** Creates a test fixture. */
	ShoppingCart cart;
	Product product;
	
	/**
	 * Initialize the fixture.
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
