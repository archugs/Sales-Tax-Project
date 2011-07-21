/**
 * 
 */
package com.salesapp.products;

import com.salesapp.productfactories.ProductFactory;

/** MockProduct is a mock object used to test the abstract Product class.
 * 
 * @author user
 *
 */
public class MockProduct extends Product {

	/**
	 * Default constructor to initialize a new mock product.
	 */
	public MockProduct() 
	{
		super();
	}

	/**
	 * Parameterized constructor to initialize the values of the <code>MockProduct</code> attributes.
	 *
	 * @param name - the name of the mock product
	 * @param price - the price of the mock product
	 * @param imported - boolean value of whether the mock product imported or not
	 * @param quantity - quantity of mock product items
	 */	
	public MockProduct(String name, double price, boolean imported, int quantity)
	{
		super(name, price, imported, quantity);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductFactory getFactory() 
	{	
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getTaxValue(String country) 
	{
		return 0;
	}

}
