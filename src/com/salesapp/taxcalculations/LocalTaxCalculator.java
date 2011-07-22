/**
 * 
 */
package com.salesapp.taxcalculations;


// TODO: Auto-generated Javadoc
/**
 * The LocalTaxCalculator calculates the total tax cost according to local region specifications.
 * 
 * @author archugs
 */
public class LocalTaxCalculator implements ITaxCalculator 
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double calculateTax(double price, double localTax, boolean imported)
	{
		//Calculates tax cost
		double tax = price * localTax;
		
		//Calculates imported duty
		if(imported == true)
		{
			tax += (price * 0.05);
		}
		
		//rounds off to nearest 0.05 paise
		tax = MathHelper.roundoff(tax);
		
		return tax;
	}

}
