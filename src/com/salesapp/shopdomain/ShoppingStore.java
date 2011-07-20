/**
 * 
 */
package com.salesapp.shopdomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.salesapp.products.Product;


/**
 * The ShoppingStore deals with getting a sales order and placing in shopping cart and billing the items in the cart.
 * 
 * @author archugs
 */
public class ShoppingStore 
{


	/** The cart holds the purchased items to be billed. */
	private ShoppingCart sc;
	
	/** The storeshelf contains the products of the store */
	private StoreShelf ss;
	
	/** gets user input of products */
	Scanner input;
	
	/**
	 * Instantiates a new shopping store containing a shopping cart and storeshelf.
	 */
	public ShoppingStore()
	{
		sc = new ShoppingCart();
		ss = new StoreShelf();
		input = new Scanner(System.in);
	}
	
	/**
	 * Gets the sales order from the customer.
	 */
	public void getSalesOrder()
	{
		do
		{
		String name = getProductName();
		double price = getProductPrice();
		boolean imported = isProductImported();
		int quantity = getQuantity();
		List product = getProductPropertiesList(name, price, imported, quantity);
		retrieveOrderAndPlaceInCart(product);
		}
		while(isAddAnotherProduct());
	}
	
	/**
	 * Retrieves order items and places in cart.
	 *
	 * @param prodProperties - the properties of the product to be purchased
	 */
	public void retrieveOrderAndPlaceInCart(List prodProperties)
	{
		Product product = ss.searchAndRetrieveItemFromShelf(prodProperties);
		sc.addItemToCart(product);
	}
	
	/**
	 * Gets the product properties list.
	 *
	 * @param name - name of the product item
	 * @param price - price of the product
	 * @param imported - specifies whether product imported or not
	 * @param quantity -  the quantity of the product
	 * 
	 * @return List
	 */
	public List getProductPropertiesList(String name, double price, boolean imported, int quantity)
	{
		List prodProperties = new ArrayList();
		prodProperties.add(name);
		prodProperties.add(price);
		prodProperties.add(imported);
		prodProperties.add(quantity);
		return prodProperties;
	}
	
	/**
	 * Gets the product name from the user.
	 *
	 * @return String
	 */
	public String getProductName()
	{
		System.out.println("Enter the product name:\n");
		return input.nextLine();
	}
	
	/**
	 * Gets the product price from the user.
	 *
	 * @return double
	 */
	public double getProductPrice()
	{
		System.out.println("Enter the product price:\n");
		while(!(input.hasNextDouble()))
		{	
			System.out.println("Invalid price. Enter a number");
		}
		return input.nextDouble();
	}
	
	/**
	 * Asks the user whether product imported.
	 *
	 * @return <code>true</code>, if  product imported, else <code>false</code>
	 */
	public boolean isProductImported()
	{
		System.out.println("Is product imported or not?(Y/N)\n");
		while(!(input.hasNext()))
		{
			System.out.println("Invalid input. Enter (Y/N)");
		}
		
		char ans = input.next().charAt(0);
		boolean imported = parseBoolean(ans);
		return imported;
	}
	
	/**
	 * Gets the quantity of product from user
	 *
	 * @return int
	 */
	public int getQuantity()
	{
		System.out.println("Enter the quantity:\n");
		while(!(input.hasNextInt()))
		{
			System.out.println("Invalid input. Enter a integer");
		}
		return input.nextInt();
	}
	
	/**
	 * Asks the user whether to add another product
	 *
	 * @return <code>true</code>, if another product adds, else <code>false</code>
	 */
	public boolean isAddAnotherProduct()
	{
		System.out.println("Do you want to add another Product?(Y/N)");
		while(!(input.hasNext()))
		{
			System.out.println("Invalid input. Enter (Y/N)");
		}
		char ans = input.next().charAt(0);
		boolean addAnotherProduct = parseBoolean(ans);
		input.nextLine();
		return addAnotherProduct;
	}
	
	/**
	 * Parses the character value of 'Y' or 'N' into boolean value
	 *
	 * @param value - the character to be parsed
	 * @return <code>true</code>, if value is 'Y', else <code>false</code>
	 */
	public boolean parseBoolean(char value)
	{
		boolean flag = true;
		boolean boolValue = false;
		
		while(flag)
		{
			if(value == 'Y' || value == 'y')
			{
				boolValue = true;
				flag = false;
			}
		
			else if(value == 'N' || value == 'n')
			{
				boolValue = false;
				flag = false;
			}
		
			else
			{
				System.out.println("Invalid input. Enter (Y/N)");
			}
		}
		
		return boolValue;
	}
	
	/**
	 * gets the cart containing product items.
	 * 
	 * @return ShoppingCart
	 */
	public ShoppingCart getCart()
	{
		return sc;
	}
}
