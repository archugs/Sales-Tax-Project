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
	public FoodProduct createProduct(String name, double price, boolean imported, int quantity) 
	{
		return new FoodProduct(name, price, imported, quantity);
	}

}
