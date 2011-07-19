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
	public BookProduct createProduct(List productProperties) 
	{
			String name = (String)(productProperties.get(0));
			Double price = (Double)(productProperties.get(1));
			Boolean imported = (Boolean)(productProperties.get(2));
			Integer quantity = (Integer)(productProperties.get(3));
			return new BookProduct(name, price, imported, quantity);
	}

}
