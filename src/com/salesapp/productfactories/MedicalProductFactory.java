package com.salesapp.productfactories;

import java.util.List;

import com.salesapp.products.MedicalProduct;

/**
 * The MedicalProductFactory is a factory class to create a new MedicalProduct object with specified properties.
 * 
 * @author archugs
 */
public class MedicalProductFactory extends ProductFactory {

	/** 
	 * {@inheritDoc}
	 * 
	 * @return MedicalProduct
	 */
	@Override
	public MedicalProduct createProduct(String name, double price, boolean imported, int quantity) 
	{
		return new MedicalProduct(name, price, imported, quantity);
	}

}
