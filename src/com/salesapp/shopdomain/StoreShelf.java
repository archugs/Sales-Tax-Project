package com.salesapp.shopdomain;
import java.util.*;

import com.salesapp.products.*;


/**
 * 
 */

/**
 * @author user
 *
 */
public class StoreShelf {

	private HashMap<String, Product> productItems;
	
	
	public StoreShelf()
	{
		productItems = new HashMap<String, Product>();
		addProductItemsToShelf("book", new BookProduct());
		addProductItemsToShelf("music CD" , new MiscellaneousProduct());
		addProductItemsToShelf("chocolate bar", new FoodProduct());
		addProductItemsToShelf("box of chocolates" , new FoodProduct());
		addProductItemsToShelf("bottle of perfume", new MiscellaneousProduct());
		addProductItemsToShelf("packet of headache pills", new MedicalProduct());
		
		
	}
	
	public void addProductItemsToShelf(String productItem, Product productCategory)
	{
		productItems.put(productItem, productCategory);
		
	}
	
	public Product searchAndRetrieveItemFromShelf(List productProperties)
	{
		String prodItemName = (String)(productProperties.get(0));
		Product productItem = ((Product)productItems.get(prodItemName).getFactory().createProduct(productProperties));
		return productItem;
	}
}

