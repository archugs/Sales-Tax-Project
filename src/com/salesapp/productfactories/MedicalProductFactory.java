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
	public MedicalProduct createProduct(List productProperties) 
	{
		
		String name = (String)(productProperties.get(0));
		Double price = (Double)(productProperties.get(1));
		Boolean imported = (Boolean)(productProperties.get(2));
		Integer quantity = (Integer)(productProperties.get(3));
		return new MedicalProduct(name, price, imported, quantity);
	}

}
