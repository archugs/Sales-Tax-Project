/**
 * 
 */
package com.salesapp.products;

import com.salesapp.productfactories.BookProductFactory;
import com.salesapp.productfactories.ProductFactory;
import com.salesapp.taxcalculations.LocalTaxValues;


/**
 * BookProduct is an item belonging to the category 'Book' in the shopping store.
 *
 * @author archugs
 */
public class BookProduct extends Product {

	/**
	 * Default constructor to initialize a new book product.
	 */
	public BookProduct()
	{
		super();
	}

	/**
	 * Parameterized constructor to initialize the values of the <code>BookProduct</code> attributes.
	 *
	 * @param name - the name of the book product
	 * @param price - the price of the book product
	 * @param imported - boolean value of whether the book product imported or not
	 * @param quantity - quantity of book product items
	 */	
	public BookProduct(String name, double price, boolean imported, int quantity) 
	{
		super(name, price, imported, quantity);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return BookProductFactory
	 */
	@Override
	public BookProductFactory getFactory() 
	{
		return new BookProductFactory();
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getTaxValue(String country)
	{		
		if(country == "Local")
		{
			return LocalTaxValues.BOOK_TAX.getTax();
		}
		else
		{
			return 0;
		}
	}
}
