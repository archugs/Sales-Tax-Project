package com.salesapp.productfactories;
import java.util.List;

import com.salesapp.products.Product;


/**
 * The ProductFactory is an abstract factory class.
 * 
 * @author archugs
 */
public abstract class ProductFactory 
{
	
	/**
	 * Creates a new product object.
	 *
	 * @param productProperties - the attributes of the product to be created.
	 * 
	 * @return Product
	 */
	public abstract Product createProduct(List productProperties);
	
	
}
