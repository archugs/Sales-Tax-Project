/**
 * 
 */
package main;

import static org.junit.Assert.*;

import org.junit.Test;

import com.salesapp.shopdomain.ShoppingStore;


/**
 * The MainTest contains test cases for all combinations of different user inputs.
 * 
 * @author archugs
 */
public class MainTest 
{

	/** Creates a test fixture */
	ShoppingStore store = new ShoppingStore();
	
	/** Test case for non-imported products */
	@Test
	public void testNonImportedProducts()
	{
		store.retrieveOrderAndPlaceInCart("book", 12.49, false, 1);
		store.retrieveOrderAndPlaceInCart("music CD", 14.99, false, 1);
		store.retrieveOrderAndPlaceInCart("chocolate bar", 0.85, false, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 3, store.getCart().getCartSize());
		store.getPaymentCounter().billItemsInCart(store.getCart());
		assertEquals("Total sales tax for all products. No import duty added as products are not imported ", 1.50, store.getPaymentCounter().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 29.83, store.getPaymentCounter().getReceipt().getTotalAmount(), 0);
		
	}
	
	/** Test case for only imported products */
	@Test
	public void testImportedProducts()
	{
		store.retrieveOrderAndPlaceInCart("box of chocolates", 10, true, 1);
		store.retrieveOrderAndPlaceInCart("bottle of perfume", 47.50, true, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 2, store.getCart().getCartSize());
		store.getPaymentCounter().billItemsInCart(store.getCart());
		assertEquals("Total tax for all products(i.e) sales tax and imported duty", 7.65, store.getPaymentCounter().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 65.15, store.getPaymentCounter().getReceipt().getTotalAmount(), 0);
	}
	
	/** Test case for both imported and non-imported products */
	@Test
	public void testGeneralCase()
	{
		store.retrieveOrderAndPlaceInCart("bottle of perfume", 27.99, true, 1);
		store.retrieveOrderAndPlaceInCart("bottle of perfume", 18.99, false, 1);
		store.retrieveOrderAndPlaceInCart("packet of headache pills", 9.75, false, 1);
		store.retrieveOrderAndPlaceInCart("box of chocolates", 11.25, true, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 4, store.getCart().getCartSize());
		store.getPaymentCounter().billItemsInCart(store.getCart());
		assertEquals("Total tax for all products(i.e) sales tax and imported duty", 6.65, store.getPaymentCounter().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 74.63, store.getPaymentCounter().getReceipt().getTotalAmount(), 0);
	}
	
	/** Test case for tax exempt items which are non-imported */
	@Test
	public void testTaxExemptNonImportedProducts()
	{
		store.retrieveOrderAndPlaceInCart("book", 12.49, false, 1);
		store.retrieveOrderAndPlaceInCart("chocolate bar", 10, false, 1);
		store.retrieveOrderAndPlaceInCart("packet of headache pills", 5.45, false, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 3, store.getCart().getCartSize());
		store.getPaymentCounter().billItemsInCart(store.getCart());
		assertEquals("books, chocolates and pills belong to books, food and medical category respectively. So sales tax is exempted. As all products are not imported no import duty added ", 0, store.getPaymentCounter().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 27.94, store.getPaymentCounter().getReceipt().getTotalAmount(), 0);
	}
	
	/** Test case for tax exempt items which are imported */
	@Test
	public void testTaxExemptImportedProducts()
	{
	
		store.retrieveOrderAndPlaceInCart("book", 12.49, true, 1);
		store.retrieveOrderAndPlaceInCart("chocolate bar", 10, true, 1);
		store.retrieveOrderAndPlaceInCart("packet of headache pills", 9.75, true, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 3, store.getCart().getCartSize());
		store.getPaymentCounter().billItemsInCart(store.getCart());
		assertEquals("books, chocolates and pills belong to books, food and medical category respectively. So sales tax is exempted. As all products are imported, import duty added for all ", 1.60, store.getPaymentCounter().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 33.84, store.getPaymentCounter().getReceipt().getTotalAmount(), 0);
	}
	
	/** Test case for taxable items which are not imported */
	@Test
	public void testTaxableNonImportedProducts()
	{
		store.retrieveOrderAndPlaceInCart("music CD", 14.99, false, 1);
		store.retrieveOrderAndPlaceInCart("bottle of perfume", 47.50, false, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 2, store.getCart().getCartSize());
		store.getPaymentCounter().billItemsInCart(store.getCart());
		assertEquals("products dont belong to food,books and medical category respectively so sales tax is added. As all products are not imported so no import duty is added", 6.25, store.getPaymentCounter().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 68.74, store.getPaymentCounter().getReceipt().getTotalAmount(), 0);
	}
	
	/** Test case for taxable items which are imported */
	@Test
	public void testTaxableImportedProducts()
	{
		store.retrieveOrderAndPlaceInCart("music CD", 14.99, true, 1);
		store.retrieveOrderAndPlaceInCart("bottle of perfume", 47.50, true, 1);
		assertNotNull("Shopping cart cannot be null as there are products in it", store.getCart());
		assertEquals("number of products in shopping cart", 2, store.getCart().getCartSize());
		store.getPaymentCounter().billItemsInCart(store.getCart());
		assertEquals("products dont belong to food,books and medical category respectively so sales tax is added. As all products are imported so import duty is added", 9.40, store.getPaymentCounter().getReceipt().getTotalSalesTax() , 0);
		assertEquals("Total amount payable for all products", 71.89, store.getPaymentCounter().getReceipt().getTotalAmount(), 0);
	}
}
