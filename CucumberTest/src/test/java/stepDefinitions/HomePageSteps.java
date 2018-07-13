package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.TestContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.HomePage;
import selenium.WaitPage;

public class HomePageSteps {
	TestContext testContext;
	HomePage homePage;
	
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage=testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("^user is on Home page$")
	public void user_is_on_Home_page() {
		homePage.navigate_to_HomePage();
		
	}
	

 
	@When("^user search for \"([^\"]*)\"$")
	public void user_search_for(String arg1){
			
		
		homePage.perform_Search(arg1);

	}

}
