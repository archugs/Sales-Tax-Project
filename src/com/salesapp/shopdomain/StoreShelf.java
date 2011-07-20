package com.salesapp.shopdomain;
import java.util.*;

import com.salesapp.products.*;


/**
 * The StoreShelf stores all the different categories of product items of the shoppingstore from which a product of a specific category can be retrieved for billing.
 * 
 * @author archugs
 */
public class StoreShelf {

	/** The product items mapped to their respective categories */
	private HashMap<String, Product> productItems;
	
	
	/**
	 * Instantiates a new store shelf with the product items.
	 */
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
	
	/**
	 * Adds the product items to store shelf in their respective categories.
	 *
	 * @param productItem - the product item
	 * @param productCategory - the product category to which a particular item belongs.
	 */
	public void addProductItemsToShelf(String productItem, Product productCategory)
	{
		productItems.put(productItem, productCategory);
		
	}
	
	/**
	 * Searches for the item using the string name and maps it to the product category to create a new Product object.
	 *
	 * @param productProperties - the properties of the product
	 * 
	 * @return Product
	 */
	public Product searchAndRetrieveItemFromShelf(List productProperties)
	{
		String prodItemName = (String)(productProperties.get(0));
		Product productItem = productItems.get(prodItemName).getFactory().createProduct(productProperties);
		return productItem;
	}
	
	/**
	 * gets the total number of items present in shelf.
	 * 
	 * @return int
	 */
	public int getShelfSize()
	{
		return productItems.size();
	}
}

