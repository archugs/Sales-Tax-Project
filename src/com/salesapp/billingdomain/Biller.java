/**
 * 
 */
package com.salesapp.billingdomain;

import java.util.List;

import com.salesapp.products.Product;
import com.salesapp.taxcalculations.ITaxCalculator;
import com.salesapp.taxcalculations.MathHelper;

/**
 * The Biller computes the product's taxed cost, the total tax value, and total amount of all products.
 * 
 * @author archugs
 */
public class Biller 
{

	/** The tax calculator. */
	ITaxCalculator taxCalculator;
	
	/**
	 * Instantiates a new biller.
	 *
	 * @param taxCalc - the tax calculator
	 */
	public Biller(ITaxCalculator taxCalc)
	{
		taxCalculator = taxCalc;
	}
	
	/**
	 * Calculates the total product tax using tax calculator.
	 * 
	 * @param price - the price of the product
	 * @param tax - the product's tax rate
	 * @param imported - boolean value of whether product imported or not
	 * @return double
	 */
	public double calculateTax(double price, double tax, boolean imported)
	{
		
		double totalProductTax = taxCalculator.calculateTax(price, tax, imported);
		return totalProductTax;
	}
	
	/**
	 * Calculates the taxed cost of the product which is the sum of the original price and tax value.
	 * 
	 * @param price - the price of the product
	 * @param tax - the product's tax value
	 * @return double
	 */
	public double calcTotalProductCost(double price, double tax)
	{
		return MathHelper.truncate(price + tax);
	}
	
	/**
	 * Computes the net tax values of all products.
	 * 
	 * @param prodList - the list of all products 
	 * @return double
	 */
	public double calcTotalTax(List<Product> prodList)
	{
		double totalTax = 0.0;
		
		//Calculates the tax value which is the difference between the taxed cost and original cost.
		for(Product p : prodList)
		{
			totalTax += (p.getTaxedCost() - p.getPrice());
		}
		
		return MathHelper.truncate(totalTax);
	}
	
	/**
	 * Computes the net amount of all the products.
	 * 
	 * @param prodList - the list of all products
	 * @return double
	 */
	public double calcTotalAmount(List<Product> prodList)
	{
		double totalAmount = 0.0;
		
		//Sums the total cost of all products.
		for(Product p : prodList)
		{
			totalAmount += p.getTaxedCost();
		}
		
		return MathHelper.truncate(totalAmount);
	}
	
	/**
	 * Creates a new Receipt object.
	 * 
	 * @param productList - the products purchased
	 * @param totalTax - the net tax cost
	 * @param totalAmount - the net payable amount
	 * @return Receipt
	 */
	public Receipt createNewReceipt(List<Product> productList, double totalTax, double totalAmount)
	{
		return new Receipt(productList, totalTax, totalAmount);
	}
	
	/**
	 * Prints out the receipt.
	 * 
	 * @param r - the Receipt to be printed
	 */
	public void generateReceipt(Receipt r)
	{
		String receipt = r.toString();
		System.out.println(receipt);
	}
}
