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
	String name = "mock";
	double price = 45.00;
	boolean imported = true;
	int quantity = 2;
	
	/**
	 * Test method for {@link com.salesapp.productfactories.BookProductFactory#createProduct(java.util.List)}.
	 */
	@Test
	public void testCreateBookProduct() 
	{
		factory = new BookProductFactory();
		factory.createProduct(name, price, imported, quantity);
	}

	/**
	 * Test method for {@link com.salesapp.productfactories.FoodProductFactory#createProduct(java.util.List)}.
	 */
	@Test
	public void testCreateFoodProduct() 
	{
		factory = new FoodProductFactory();
		factory.createProduct(name, price, imported, quantity);
	}

	/**
	 * Test method for {@link com.salesapp.productfactories.MedicalProductFactory#createProduct(java.util.List)}.
	 */
	@Test
	public void testCreateMedicalProduct() 
	{
		factory = new MedicalProductFactory();
		factory.createProduct(name, price, imported, quantity);
	}

	/**
	 * Test method for {@link com.salesapp.productfactories.MiscellaneousProductFactory#createProduct(java.util.List)}.
	 */
	@Test
	public void testCreateMiscellaneousProduct() 
	{
		factory = new MiscellaneousProductFactory();
		factory.createProduct(name, price, imported, quantity);
	}

	
}
