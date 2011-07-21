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
	 * @param name - name of the product
	 * @param price - price of product
	 * @param imported - boolean value of whether imported or not
	 * @param quantity - quantity of product
	 * @return Product
	 */
	public Product searchAndRetrieveItemFromShelf(String name, double price, boolean imported, int quantity)
	{
		Product productItem = productItems.get(name).getFactory().createProduct(name, price, imported, quantity);
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

