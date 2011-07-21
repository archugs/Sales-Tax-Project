package com.salesapp.productfactories;
import java.util.List;

import com.salesapp.products.MiscellaneousProduct;

/**
 * The MiscellaneousProductFactory is a factory class to create a new MiscellaneousProduct object with specified properties.
 * 
 * @author archugs
 */
public class MiscellaneousProductFactory extends ProductFactory {

	/**
	 * {@inheritDoc}
	 * 
	 * @return MiscellaneousProduct
	 */
	@Override
	public MiscellaneousProduct createProduct(String name, double price, boolean imported, int quantity) 
	{
		return new MiscellaneousProduct(name, price, imported, quantity);
	}

}
