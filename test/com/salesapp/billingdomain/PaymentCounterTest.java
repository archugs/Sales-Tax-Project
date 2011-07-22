/**
 * 
 */
package com.salesapp.billingdomain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.salesapp.products.*;
import com.salesapp.shopdomain.ShoppingCart;

/**
 * Test case for {@link com.salesapp.billingdomain.PaymentCounter}
 * 
 * @author archugs
 */
public class PaymentCounterTest 
{

	/** Creates a test fixture */
	BookProduct book;
	FoodProduct food;
	MiscellaneousProduct misc;
	PaymentCounter pay;
	ShoppingCart cart;
	
	/** Initializes the test fixture */
	@Before
	public void setUp()
	{
		cart = new ShoppingCart();
		book = new BookProduct("book", 40.00, true, 1);
		food = new FoodProduct("box of chocolates", 30.00, false, 1);
		misc = new MiscellaneousProduct("bottle of perfume", 89.00, false, 1);
		cart.addItemToCart(book);
		cart.addItemToCart(food);
		cart.addItemToCart(misc);
		pay = new PaymentCounter(cart, "Local");
	}
	
	/**
	 * Test method for {@link com.salesapp.billingdomain.PaymentCounter#billItemsInCart()}.
	 */
	@Test
	public void testBillItemsInCart() 
	{
		pay.billItemsInCart();
		assertEquals(42.00, book.getTaxedCost(), 0.0009);
		assertEquals(30.00, food.getTaxedCost(), 0.0009);
		assertEquals(97.9, misc.getTaxedCost(), 0.0009);
		
	}
	
	/**
	 * Test method for {@link com.salesapp.billingdomain.PaymentCounter#getReceipt()}.
	 */
	@Test
	public void testGetReceipt()
	{
		pay.billItemsInCart();
		pay.getReceipt();
	}

}
