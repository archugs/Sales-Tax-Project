/**
 * 
 */
package com.salesapp.billingdomain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.salesapp.products.BookProduct;
import com.salesapp.products.FoodProduct;
import com.salesapp.products.Product;
import com.salesapp.taxcalculations.LocalTaxCalculator;

/**
 * Test case for {@link com.salesapp.billingdomain.Receipt}
 *
 * @author archugs
 */
public class ReceiptTest {

	/** Creates a test fixture */
	List<Product> prodList;
	BookProduct book;
	FoodProduct food;
	Receipt receipt;
	
	/** Initializes the test fixture */
	@Before
	public void setUp()
	{
		book = new BookProduct("book", 40.00, true, 1);
		food = new FoodProduct("box of chocolates", 30.00, false, 1);
		prodList = new ArrayList<Product>();
		prodList.add(book);
		prodList.add(food);
		receipt = new Receipt(prodList, 9.00, 45.00);
	}
	
	/**
	 * Test method for {@link com.salesapp.billingdomain.Receipt#Receipt(java.util.List, double, double)}.
	 */
	@Test
	public void testReceipt()
	{
		assertEquals(2, receipt.getTotalNumberOfItems());
		assertEquals(9.00, receipt.getTotalSalesTax(), 0.0009);
		assertEquals(45.00, receipt.getTotalAmount(), 0.0009);
	}

}
