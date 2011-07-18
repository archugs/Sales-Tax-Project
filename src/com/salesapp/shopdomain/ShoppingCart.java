/**
 * 
 */
package com.salesapp.shopdomain;

import java.util.ArrayList;
import java.util.List;

import com.salesapp.products.Product;

// TODO: Auto-generated Javadoc
/**
 * The ShoppingCart holds the products purchased and from it the products are retrieved for billing.
 * 
 * @author archugs
 */
public class ShoppingCart
{

	/** A list to store the products. */
	private List<Product> productList;
	
	/**
	 * Instantiates a new shopping cart to which products can be added.
	 */
	public ShoppingCart()
	{
		productList = new ArrayList<Product>();
	}
	
	/**
	 * Adds the item to the cart.
	 *
	 * @param product - the product to be added to the cart.
	 */
	public void addItemToCart(Product product)
	{
		productList.add(product);
	}
	
	/**
	 * Retrieves the items from cart.
	 *
	 * @return a list containing Products
	 */
	public List<Product> getItemsFromCart()
	{
		return productList;
	}

	/**
	 * Gets the number of products in the cart.
	 *
	 * @return int
	 */
	public int getCartSize()
	{
		return productList.size();
	}
}
