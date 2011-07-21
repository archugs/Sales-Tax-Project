/**
 * 
 */
package com.salesapp.products;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test case for {@link com.salesapp.products.MedicalProduct)
 * 
 * @author archugs
 */
public class MedicalProductTest {

	Product p;
	
	/**
	 * Test method for {@link com.salesapp.products.MedicalProduct#MedicalProduct()}.
	 */
	@Test
	public void testMedicalProduct() 
	{
		p = new MedicalProduct();
		assertEquals("", p.getName());
		assertEquals(0.0, p.getPrice(), 0.0009);
		assertEquals(false, p.isImported());
		assertEquals(0, p.getQuantity());
		assertEquals(0.0, p.getTaxedCost(), 0.0009);
	}

	/**
	 * Test method for {@link com.salesapp.products.MedicalProduct#MedicalProduct(java.lang.String, double, boolean, int)}.
	 */
	@Test
	public void testMedicalProductParaConst() 
	{
		p = new MedicalProduct("a packet of headache pills", 95.00, true, 3);
		assertEquals("a packet of headache pills", p.getName());
		assertEquals(285.0, p.getPrice(), 0.0009);
		assertEquals(true, p.isImported());
		assertEquals(3, p.getQuantity());
	}
	
	/**
	 * Test method for {@link com.salesapp.products.MedicalProduct#getTaxValue(String)}.
	 */
	@Test
	public void testGetTaxValue()
	{
		p = new MedicalProduct("a packet of headache pills", 95.00, true, 3);
		assertEquals(0.0, p.getTaxValue("Local"), 0.0009);
	}

}
