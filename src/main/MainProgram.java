/**
 * 
 */
package main;

import com.salesapp.shopdomain.ShoppingStore;

/**
 * The MainProgram test drives the sales tax project
 * 
 * @author archugs
 */
public class MainProgram {

	/**
	 * Main method
	 */
	public static void main(String[] args)
	{
		ShoppingStore store = new ShoppingStore();
		store.getSalesOrder();
		store.checkOut();
	}

}
