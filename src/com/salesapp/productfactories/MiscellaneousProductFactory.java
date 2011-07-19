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
	public MiscellaneousProduct createProduct(List productProperties) 
	{
		
		String name = (String)(productProperties.get(0));
		Double price = (Double)(productProperties.get(1));
		Boolean imported = (Boolean)(productProperties.get(2));
		Integer quantity = (Integer)(productProperties.get(3));
		return new MiscellaneousProduct(name, price, imported, quantity);
	}

}
