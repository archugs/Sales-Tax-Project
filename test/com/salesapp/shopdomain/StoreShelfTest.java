/**
 * 
 */
package com.salesapp.shopdomain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.salesapp.products.FoodProduct;
import com.salesapp.products.FoodProductTest;
import com.salesapp.products.Product;


/**
 * Test case for {@link com.salesapp.shopdomain.StoreShelf}
 * 
 * @author archugs
 */
public class StoreShelfTest {

	/** Creates a test fixture */
	StoreShelf shelf;
	List prodProperties;
	
	/** Initializes the test fixture */
	@Before
	public void setUp()
	{
		shelf = new StoreShelf();
		prodProperties = new ArrayList();
		prodProperties.add("box of chocolates");
		prodProperties.add(45.00);
		prodProperties.add(true);
		prodProperties.add(2);
	}
	
	/**
	 * Test method for {@link com.salesapp.shopdomain.StoreShelf#StoreShelf()}.
	 */
	@Test
	public void testStoreShelf() 
	{
		assertEquals(6, shelf.getShelfSize());
	}

	/**
	 * Test method for {@link com.salesapp.shopdomain.StoreShelf#addProductItemsToShelf(java.lang.String, com.salesapp.products.Product)}.
	 */
	@Test
	public void testAddProductItemsToShelf() 
	{
		shelf.addProductItemsToShelf("juice bottle", new FoodProduct());
		assertEquals(7, shelf.getShelfSize());
		FoodProductTest test = new FoodProductTest();
		test.testFoodProduct();
	}

	/**
	 * Test method for {@link com.salesapp.shopdomain.StoreShelf#searchAndRetrieveItemFromShelf(java.util.List)}.
	 */
	@Test
	public void testSearchAndRetrieveItemFromShelf() 
	{
		Product product = shelf.searchAndRetrieveItemFromShelf(prodProperties);
		assertEquals("box of chocolates", product.getName());
		assertEquals(90.00, product.getPrice(), 0.0009);
		assertEquals(true, product.isImported());
		assertEquals(2, product.getQuantity());
	}

}
