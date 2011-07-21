/**
 * 
 */
package com.salesapp.taxcalculations;


/**
 * The Interface ITaxCalculator computes the total tax cost of a product.
 *
 * @author archugs
 */
public interface ITaxCalculator
{
	
	/**
	 * Calculates the tax cost for a product where tax cost is the sum of sales tax and imported duty of product.
	 *
	 * @param price - the price of the product
	 * @param tax - the tax rate of the product
	 * @param imported - boolean value of whether product imported or not
	 * @return double
	 */
	public double calculateTax(double price, double tax, boolean imported);
	
}
