/**
 * 
 */
package com.salesapp.productfactories;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.salesapp.products.BookProduct;
import com.salesapp.products.Product;

/**
 * The ProductFactoriesTest tests the product factory classes.
 * 
 * @author archugs
 */
public class ProductFactoriesTest {

	/**Creates a test fixture */
	ProductFactory factory;
	List prodProperties;
	
	/**Initializes the fixture */
	@Before
	public void setUp()
	{
		prodProperties = new ArrayList();
		prodProperties.add("mock");
		prodProperties.add(45.00);
		prodProperties.add(true);
		prodProperties.add(2);
		
	}
	/**
	 * Test method for {@link com.salesapp.productfactories.BookProductFactory#createProduct(java.util.List)}.
	 */
	@Test
	public void testCreateBookProduct() 
	{
		factory = new BookProductFactory();
		createProduct(factory);
	}

	/**
	 * Test method for {@link com.salesapp.productfactories.FoodProductFactory#createProduct(java.util.List)}.
	 */
	@Test
	public void testCreateFoodProduct() 
	{
		factory = new FoodProductFactory();
		createProduct(factory);
	}

	/**
	 * Test method for {@link com.salesapp.productfactories.MedicalProductFactory#createProduct(java.util.List)}.
	 */
	@Test
	public void testCreateMedicalProduct() 
	{
		factory = new MedicalProductFactory();
		createProduct(factory);
	}

	/**
	 * Test method for {@link com.salesapp.productfactories.MiscellaneousProductFactory#createProduct(java.util.List)}.
	 */
	@Test
	public void testCreateMiscellaneousProduct() 
	{
		factory = new MiscellaneousProductFactory();
		createProduct(factory);
	}

	/** 
	 * creation and testing of product.
	 */
	public void createProduct(ProductFactory factory)
	{
		Product product = factory.createProduct(prodProperties);
		assertEquals("mock", product.getName());
		assertEquals(90.00, product.getPrice(), 0.0009);
		assertEquals(true, product.isImported());
		assertEquals(2, product.getQuantity());
	}
}
