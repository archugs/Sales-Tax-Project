package com.salesapp.billingdomain;


import java.util.List;

import com.salesapp.products.Product;

 

/**
 * The Receipt is the string representation of the products purchased with their taxed cost, the total tax and total amount payable.
 * 
 * @author archugs
 */
public class Receipt
{
	/** The list of products purchased. */
	private List<Product> productList;
	
	/** The net tax cost of all products purchased */
	private double totalSalesTax;
	
	/** The net amount payable for all products purchased. */
	private double totalAmount;
	
	/**
	 * Instantiates a new Receipt object.
	 * 
	 * @param prod - the list of products purchased
	 * @param tax - the net tax cost of all products
	 * @param amount - the net amount payable
	 */
	public Receipt(List<Product> prod, double tax, double amount)
	{
		productList = prod;
		totalSalesTax = tax;
		totalAmount = amount;
	}
	

	/**
	 * Gets the list of purchased products.
	 * 
	 * @return List<Product>
	 */
	public List<Product> getProductList() 
	{
		return productList;
	}

	/**
	 * Sets the list of products purchased.
	 * 
	 * @param productList - the purchased products
	 */
	public void setProductList(List<Product> productList) 
	{
		this.productList = productList;
	}

	/**
	 * Gets the net sales tax of all products
	 * 
	 * @return double
	 */
	public double getTotalSalesTax() 
	{
		return totalSalesTax;
	}

	/**
	 * Sets the net sales tax of all products
	 * 
	 * @param totalSalesTax - the net tax cost
	 */
	public void setTotalSalesTax(double totalSalesTax) 
	{
		this.totalSalesTax = totalSalesTax;
	}

	/**
	 * Gets the net amount payable for all products.
	 * 
	 * @return double
	 */
	public double getTotalAmount() 
	{	
		return totalAmount;
	}

	/**
	 * Sets the net amount payable of all products
	 * 
	 * @param totalAmount - the net payable amount
	 */
	public void setTotalAmount(double totalAmount) 
	{
		this.totalAmount = totalAmount;
	}

	/**
	 * Gets the total number of items purchased.
	 * 
	 * @return int
	 */
	public int getTotalNumberOfItems()
	{
		return productList.size();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() 
	{
		String receipt = "";
		
		for(Product p: productList)
		{
			receipt += (p.toString() + "\n");
		}
		
		receipt += "Total sales tax = " + totalSalesTax + "\n";
		receipt += "Total amount = " + totalAmount + "\n";
		
		return receipt;
	}
	
}
