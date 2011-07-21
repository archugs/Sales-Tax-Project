/**
 * 
 */
package com.salesapp.products;

import com.salesapp.productfactories.ProductFactory;




/**
 * The Product is the item which is purchased in the shopping store and for which a receipt is generated.
 *
 * @author archugs
 * 
 */
public abstract class Product 
{
	
	/** name - name of the Product. */
	protected String name;
	
	/** price - original price of the product excluding tax for the number of items specified in the quantity. */
	protected double price;
	
	/** imported - boolean value which indicates whether product is imported or not. */
	protected Boolean imported;
	
	/** quantity - the quantity of the product to be purchased. */
	protected int quantity;
	
	/** taxedCost - the net price of the product including tax. */
	protected double taxedCost;

	/**
	 * Default constructor to instantiate Product.
	 */
	public Product()
	{
		this.name = "";
		this.price = 0.0;
		this.imported = false;
		this.quantity = 0;
		this.taxedCost = 0.0;
	}
	
	/**
	 * Parameterized constructor to initialize the values of the product attributes.
	 *
	 * @param name - the name of the product
	 * @param price - the price of the product
	 * @param imported - boolean value of whether product imported or not
	 * @param quantity - quantity of product item
	 */	
	public Product(String name, double price, boolean imported, int quantity)
	{
		this.name = name;
		this.price = price * quantity;
		this.imported = imported;
		this.quantity = quantity;
	}
	
	
	
	/**
	 * Gets the name of the product
	 *
	 * @return String
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the product
	 *
	 * @param name - the product's name as a String
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * Gets the price of the product.
	 *
	 * @return double
	 */
	public double getPrice() 
	{
		return price;
	}

	/**
	 * Calculates the price for the number of items mentioned in the quantity.
	 *
	 * @param price - the product's price as a double
	 */
	public void setPrice(double price) 
	{
		this.price = price * quantity;
	}

	/**
	 * Checks if product is imported.
	 *
	 * @return <code>true</code> if the product is imported, otherwise <code>false</code>
	 */
	public boolean isImported()
	{
		return imported;
	}

	/**
	 * Sets a boolean value for <code>imported</code> attribute
	 *
	 * @param imported - a boolean value which is <code>true</code> if the product is imported, otherwise <code>false</code>
	 */
	public void setImported(boolean imported)
	{
		this.imported = imported;
	}
			
	/**
	 * Gets the quantity of the product.
	 *
	 * @return int
	 */
	public int getQuantity() 
	{
		return quantity;
	}
	
	/**
	 * Sets the quantity of product.
	 *
	 * @param quantity - the product's quantity as an int
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	/**
	 * Gets the net cost of the product including tax.
	 *
	 * @return double
	 */
	public double getTaxedCost()
	{
		return taxedCost;
	}

	/**
	 * Sets the total taxed cost of the product.
	 *
	 * @param taxedCost - the product's total taxed value as a double
	 */
	public void setTaxedCost(double taxedCost) 
	{
		this.taxedCost = taxedCost;
	}

	
	/** @inheritDoc */
	@Override
	public String toString()
	{
		return (quantity + " " + toString(imported) + " " + name + " : " + taxedCost);
	}
	
	/**
	 * Gets a String representation for the <code>imported</code> attribute.
	 *
	 * @param imported - boolean value for imported
	 * @return String
	 */
	public String toString(boolean imported)
	{
		if(imported == false)
		{
			return "";
		}
		
		else
		{
			return "imported";
		}
	}
	
	/**
	 * Gets the factory object to create a product.
	 *
	 * @return ProductFactory
	 */
	public abstract ProductFactory getFactory();
	
	/** 
	 * Gets the tax value of the product.
	 * 
	 * @param country - the regional tax rates 
	 * @return double
	 */
	public abstract double getTaxValue(String country);
}
