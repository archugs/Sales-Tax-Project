/**
 * 
 */
package com.salesapp.shopdomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.salesapp.billingdomain.PaymentCounter;
import com.salesapp.billingdomain.Receipt;
import com.salesapp.products.Product;


// TODO: Auto-generated Javadoc
/**
 * The ShoppingStore deals with getting a sales order and placing in shopping cart and billing the items in the cart.
 * 
 * @author archugs
 */
public class ShoppingStore 
{


	/** The cart holds the purchased items to be billed. */
	private ShoppingCart sc;
	
	/** The storeshelf contains the products of the store. */
	private StoreShelf ss;
	
	/** The payment counter performs billing and generates receipt. */
	private PaymentCounter pc;
	
	/** gets user input of products. */
	private Scanner input;

	/** The regional province where sales tax and imported duty applied. */
	String country;
	
	/**
	 * Instantiates a new shopping store containing a shopping cart, storeshelf and payment counter.
	 */
	public ShoppingStore()
	{
		country = "Local";
		sc = new ShoppingCart();
		ss = new StoreShelf();
		pc = new PaymentCounter(country);
		input = new Scanner(System.in);
	}
	
	/**
	 * Gets the sales order from the customer.
	 *
	 * @return the sales order
	 */
	public void getSalesOrder()
	{
		do
		{
		String name = getProductName();
		double price = getProductPrice();
		boolean imported = isProductImported();
		int quantity = getQuantity();
		retrieveOrderAndPlaceInCart(name, price, imported, quantity);
		}
		while(isAddAnotherProduct());
	}
	
	
	/**
	 * Retrieves order items and places in cart.
	 *
	 * @param name - name of the product
	 * @param price - price of product
	 * @param imported - boolean value of whether imported or not
	 * @param quantity - quantity of product
	 */
	public void retrieveOrderAndPlaceInCart(String name, double price, boolean imported, int quantity)
	{
		Product product = ss.searchAndRetrieveItemFromShelf(name, price, imported, quantity);
		sc.addItemToCart(product);
	}
	
	/**
	 * Performs billing operation of purchased items and generates receipt.
	 */
	public void checkOut()
	{
		pc.billItemsInCart(sc);
		Receipt receipt = pc.getReceipt();
		pc.printReceipt(receipt);
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
		
		//validates user input
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
		
		//validates user input
		while(!(input.hasNext()))
		{
			System.out.println("Invalid input. Enter (Y/N)");
		}
		
		char ans = input.next().charAt(0);
		
		//parses char value of 'imported' into a boolean value
		boolean imported = parseBoolean(ans);
		return imported;
	}
	
	/**
	 * Gets the quantity of product from user.
	 *
	 * @return int
	 */
	public int getQuantity()
	{
		System.out.println("Enter the quantity:\n");
		
		//validates user input
		while(!(input.hasNextInt()))
		{
			System.out.println("Invalid input. Enter a integer");
		}
		return input.nextInt();
	}
	
	/**
	 * Asks the user whether to add another product.
	 *
	 * @return <code>true</code>, if another product adds, else <code>false</code>
	 */
	public boolean isAddAnotherProduct()
	{
		System.out.println("Do you want to add another Product?(Y/N)");
		
		//validates user input
		while(!(input.hasNext()))
		{
			System.out.println("Invalid input. Enter (Y/N)");
		}
		
		char ans = input.next().charAt(0);
		
		//parses the answer into a boolean value
		boolean addAnotherProduct = parseBoolean(ans);
		
		//moves scanner to next line to get next input value
		input.nextLine();
		return addAnotherProduct;
	}
	
	/**
	 * Parses the character value of 'Y' or 'N' into boolean value.
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
			//parses 'Y' into 'true'
			if(value == 'Y' || value == 'y')
			{
				boolValue = true;
				flag = false;
			}
		
			//parses 'N' into 'false'
			else if(value == 'N' || value == 'n')
			{
				boolValue = false;
				flag = false;
			}
		
			//validates user input
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

	public PaymentCounter getPaymentCounter()
	{
		return pc;
	}
}

