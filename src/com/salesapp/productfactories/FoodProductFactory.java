package com.salesapp.productfactories;
import java.util.List;

import com.salesapp.products.FoodProduct;



/**
 * The FoodProductFactory is a factory class to create a new FoodProduct object with specified properties.
 * 
 * @author archugs
 */
public class FoodProductFactory extends ProductFactory {

	/** 
	 * {@inheritDoc}
	 * 
	 * @return FoodProduct
	 */
	@Override
	public FoodProduct createProduct(List productProperties) 
	{
		String name = (String)(productProperties.get(0));
		Double price = (Double)(productProperties.get(1));
		Boolean imported = (Boolean)(productProperties.get(2));
		Integer quantity = (Integer)(productProperties.get(3));
		return new FoodProduct(name, price, imported, quantity);
	}

}
