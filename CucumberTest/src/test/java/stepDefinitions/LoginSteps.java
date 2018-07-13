package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.LoginPage;
import pageObjects.ProductListingPage;
import testDataTypes.Customer;

public class LoginSteps {
	
	TestContext testContext;
	LoginPage loginPage;
	
	public LoginSteps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
	}
	


	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page(){
	    loginPage.click_SignIn();
	    
	}

	@When("^User enters \\\"(.*)\\\" UserName and Password$")
	public void user_enters_UserName_and_Password(String customerName)  {
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
	   loginPage.fill_CredentialDetails(customer);
	   loginPage.click_SignInButton();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully(){
	    // Write code here that turns the phrase above into concrete actions
	  
	}

}
