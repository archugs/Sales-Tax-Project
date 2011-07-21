/**
 * 
 */
package com.salesapp.taxcalculations;

import java.util.HashMap;

/**
 * The TaxCalculatorFactory returns the appropriate tax calculator suitable for a region.
 *  
 * @author archugs
 */
public class TaxCalculatorFactory 
{

	/** Maps the taxcalculators with their key strategy values */
	private HashMap<String, ITaxCalculator> taxCalculators;
	
	/**
	 * Instantiates a new tax calculator factory.
	 */
	public TaxCalculatorFactory()
	{
		taxCalculators = new HashMap<String, ITaxCalculator>();
		registerInFactory("Local", new LocalTaxCalculator());
	}
	
	/**
	 * Registers a taxcalculator in the factory and maps it to the strategy
	 *
	 * @param strategy - the strategy of tax calculation followed in a particular region
	 * @param taxCalc - the taxCalculator
	 */
	public void registerInFactory(String strategy, ITaxCalculator taxCalc)
	{
		taxCalculators.put(strategy, taxCalc);
	}
	
	/**
	 * Gets the tax calculator object.
	 *
	 * @param strategy - the strategy of tax calculation followed in a particular region
	 * @return taxCalc - the taxCalculator
	 */
	public ITaxCalculator getTaxCalculator(String strategy)
	{
		ITaxCalculator taxCalc = (ITaxCalculator)taxCalculators.get(strategy);
		return taxCalc;
	}
	
	/**
	 * Gets the number of taxcalculators registered in the factory.
	 * @return int
	 */
	public int getFactorySize()
	{
		return taxCalculators.size();
	}
}
