package stepDefinitions;


import org.junit.Assert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import managers.FileReaderManager;
import pageObjects.ProductListingPage;
import testDataTypes.Customer;

public class ProductPageSteps {
	TestContext testContext;
	ProductListingPage productListingPage;
	
	public ProductPageSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}
	@When("^choose \\\"(.*)\\\" to buy the first item$")
	public void choose_to_buy_the_first_item(String customerName) {
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		String productName = productListingPage.getProductName(customer); 
		System.out.println(productName);
		testContext.scenarioContext.setContext(Context.PRODUCT_NAME, productName);
		
		productListingPage.fill_productDetails(customer);
		productListingPage.click_addToCart();
		//productListingPage.verify_itemAddToCart();

      productListingPage.wait_viewCart();
     productListingPage.verify_itemAddToCart();
	}
	@Then("^verify the order details$")
	public void verify_the_order_details(){
		String productName = (String)testContext.scenarioContext.getContext(Context.PRODUCT_NAME);
		System.out.println(productName);
		//Assert.assertTrue(productListingPage.getProductNames().stream().filter(x -> x.contains(productName)).findFirst().get().length()>0);		
	}
	/*@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		
		productListingPage.fill_productDetails();
		productListingPage.click_addToCart();
		//productListingPage.verify_itemAddToCart();

      productListingPage.wait_viewCart();
     productListingPage.verify_itemAddToCart();
	}*/

}
