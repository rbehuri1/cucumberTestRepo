package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.ProductListingPage;

public class PageObjectManager {
	
	private WebDriver driver;
	 
	private ProductListingPage productListingPage;
 
	private CartPage cartPage;
 
	private HomePage homePage;
 
	private CheckoutPage checkoutPage;
	private LoginPage loginPage;
	private LogoutPage logoutPage;
	public PageObjectManager(WebDriver driver) {
		 
		this.driver = driver;
 
	}

	public HomePage getHomePage(){

		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}

	

	public ProductListingPage getProductListingPage() {

		return (productListingPage == null) ? productListingPage = new ProductListingPage(driver) : productListingPage;

	}

	

	public CartPage getCartPage() {

		return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;

	}

	

	public CheckoutPage getCheckoutPage() {

		return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;

	}
	
	public LoginPage getLoginPage() {

		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

	}
	
	public LogoutPage getLogoutPage() {

		return (logoutPage == null) ? logoutPage = new LogoutPage(driver) : logoutPage;

	}
}
