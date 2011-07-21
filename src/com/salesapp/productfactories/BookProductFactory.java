/*
 * 
 */
package com.salesapp.productfactories;
import java.util.List;

import com.salesapp.products.BookProduct;

/**
 * The BookProductFactory is a factory class to create a new BookProduct object with specified properties.
 * 
 * @author archugs
 */
public class BookProductFactory extends ProductFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @return BookProduct	
	 */
	@Override
	public BookProduct createProduct(String name, double price, boolean imported, int quantity) 
	{
			return new BookProduct(name, price, imported, quantity);
	}

}
