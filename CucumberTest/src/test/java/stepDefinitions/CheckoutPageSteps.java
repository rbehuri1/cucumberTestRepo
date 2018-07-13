package stepDefinitions;


import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;

public class CheckoutPageSteps {
	
	TestContext testContext;
	CheckoutPage checkoutPage;
	
	public CheckoutPageSteps(TestContext context) {
		testContext = context;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
	}
	
	@When("^enter \\\"(.*)\\\" personal details on checkout page$")
	public void enter_personal_details_on_checkout_page(String customerName) throws InterruptedException{
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		checkoutPage.check_checkoutAsGuest(true);
		checkoutPage.enter_email("radhabehuria508@gmail.com");
		checkoutPage.click_continueAsGuest();
		checkoutPage.fill_PersonalDetails(customer);	
	}
	
	/*@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws InterruptedException{

		checkoutPage.check_checkoutAsGuest(true);
		checkoutPage.enter_email("radhabehuria508@gmail.com");
		checkoutPage.click_continueAsGuest();
		checkoutPage.fill_personalDetail();
		
		
		
		
		
	}*/

	@When("^select same delivery address$")
	public void select_same_delivery_address() {
	
		checkoutPage.check_sameAddress(true);
		checkoutPage.click_deliverToThisAddress();
	
		
	}

	@When("^select payment as \"([^\"]*)\" payment$")
	public void select_payment_as_payment(String arg1) {

	}

	@When("^place an order$")
	public void place_an_order() {

	}

}
