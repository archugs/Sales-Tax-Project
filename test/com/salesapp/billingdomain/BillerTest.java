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
import com.salesapp.taxcalculations.LocalTaxCalculator;

/**
 * Test case for {@link com.salesapp.billingdomain.Biller}
 * 
 * @author archugs
 */
public class BillerTest {

	/** Creates a test fixture */
	Biller b;
	List<Product> prodList;
	BookProduct book;
	FoodProduct food;
	
	/** Initializes the test fixture */
	@Before
	public void setUp()
	{
		b = new Biller(new LocalTaxCalculator());
		book = new BookProduct("book", 40.00, true, 1);
		food = new FoodProduct("box of chocolates", 30.00, false, 1);
		book.setTaxedCost(45.00);
		food.setTaxedCost(37.00);
		prodList = new ArrayList<Product>();
		prodList.add(book);
		prodList.add(food);
	}
	
	/**
	 * Test method for {@link com.salesapp.billingdomain.Biller#calculateTax(double, double, boolean)}.
	 */
	@Test
	public void testCalculateTax() 
	{
		assertEquals(6.00, b.calculateTax(40.00, 0.10, true), 0.0009);
	}

	/**
	 * Test method for {@link com.salesapp.billingdomain.Biller#calcTotalProductCost(double, double)}.
	 */
	@Test
	public void testCalcTotalProductCost() 
	{
		assertEquals(46.00, b.calcTotalProductCost(40.00, 6.00), 0.0009);
	}

	/**
	 * Test method for {@link com.salesapp.billingdomain.Biller#calcTotalTax(java.util.List)}.
	 */
	@Test
	public void testCalcTotalTax()
	{
		assertEquals(12, b.calcTotalTax(prodList), 0.0009);
	}

	/**
	 * Test method for {@link com.salesapp.billingdomain.Biller#calcTotalAmount(java.util.List)}.
	 */
	@Test
	public void testCalcTotalAmount() 
	{
		assertEquals(82, b.calcTotalAmount(prodList), 0.0009);
	}

	/**
	 * Test method for {@link com.salesapp.billingdomain.Biller#createNewReceipt(java.util.List, double, double)}.
	 */
	@Test
	public void testCreateNewReceipt()
	{
		Receipt r = b.createNewReceipt(prodList, 9.00, 45.00);
		assertEquals(2, r.getTotalNumberOfItems());
		assertEquals(9.00, r.getTotalSalesTax(), 0.0009);
		assertEquals(45.00, r.getTotalAmount(), 0.0009);
	}
	
	/**
	 * Test method for {@link com.salesapp.billingdomain.Biller#generateReceipt(Receipt))}.
	 */
	@Test
	public void testGenerateReceipt()
	{
		Receipt r = b.createNewReceipt(prodList, 9.00, 45.00);
		b.generateReceipt(r);
	}
}