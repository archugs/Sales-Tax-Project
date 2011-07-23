/**
 * 
 */
package com.salesapp.billingdomain;

import java.util.List;

import com.salesapp.products.Product;
import com.salesapp.shopdomain.ShoppingCart;
import com.salesapp.taxcalculations.ITaxCalculator;
import com.salesapp.taxcalculations.TaxCalculatorFactory;

// TODO: Auto-generated Javadoc
/**
 * The PaymentCounter contains a Biller which performs billing of items in the cart and generates the receipt.
 * 
 * @author archugs
 */
public class PaymentCounter
{

	private Biller b1;
	private Receipt receipt;
	private List<Product> productList;
	private String country;
	
	/**
	 * Instantiates a new payment counter.
	 *
	 * @param country - the regional province for tax calculations
	 */
	public PaymentCounter(String country)
	{
		this.country = country;
	}
	
	/**
	 * Bills all the items in the shopping cart.
	 * 
	 * @param cart - the cart containing the items to be billed.
	 */
	public void billItemsInCart(ShoppingCart cart)
	{
		//retrieves all the products from cart
		productList = cart.getItemsFromCart();
		
		for(Product p : productList)
		{
			b1 = getBiller(country);
			
			//computes the total tax of product by a regional tax rates
			double productTax = b1.calculateTax(p.getPrice(), p.getTaxValue(country), p.isImported());
			
			//computes the total taxedcost of the product
			double taxedCost = b1.calcTotalProductCost(p.getPrice(), productTax);
			
			//sets the taxed cost of the product
			p.setTaxedCost(taxedCost);
		}
		
	}
	
	/**
	 * Generates a new receipt for the products purchased with their taxes and net payable amount.
	 * 
	 * @return Receipt
	 */
	public Receipt getReceipt()
	{
		double totalTax = b1.calcTotalTax(productList);
		double totalAmount = b1.calcTotalAmount(productList);
		receipt = b1.createNewReceipt(productList, totalTax, totalAmount);
		return receipt;
	}
	
	/**
	 * Prints out the receipt
	 * 
	 * @param - the receipt to be printed
	 */
	public void printReceipt(Receipt receipt)
	{
		b1.generateReceipt(receipt);
	}
	
	/**
	 * Gets the biller object to perform billing operations.
	 *
	 * @param strategy - the regional strategy for tax calculations
	 * @return Biller
	 */
	public Biller getBiller(String strategy)
	{
		TaxCalculatorFactory factory = new TaxCalculatorFactory();
		ITaxCalculator taxCal = factory.getTaxCalculator(strategy);
		return new Biller(taxCal);
	}

}
