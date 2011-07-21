/**
 * 
 */
package com.salesapp.taxcalculations;



/**
 * The Enum LocalTaxValues contains local tax rates of different products.
 *
 * @author archugs
 */
public enum LocalTaxValues implements ITaxValues
{
	
	/** The tax values of various products. */
	BOOK_TAX(0.0),
	FOOD_TAX(0.0),
	MEDICAL_TAX(0.0),
	MISC_TAX(0.10);
	
	/** The item tax value. */
	private double itemTaxValue;
	
	/**
	 * Instantiates a new LocalTaxValues item.
	 *
	 * @param taxValue - the tax rate of the product item.
	 */
	private LocalTaxValues(double taxValue)
	{
		itemTaxValue = taxValue;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public double getTax()
	{
		return itemTaxValue;
	}
	
}
