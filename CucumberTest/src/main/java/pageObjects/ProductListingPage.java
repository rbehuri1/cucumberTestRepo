package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.JavaExecutor;
import selenium.Wait;
import selenium.WaitPage;
import selenium.WaitWebElement;
import testDataTypes.Customer;

public class ProductListingPage {
	WebDriver driver;
	WaitPage waitPage;

	public ProductListingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindAll(@FindBy(how=How.CSS, using="section.row.search-product.animate-products>div"))
	private List<WebElement> prod_List;
	
	@FindAll(@FindBy(how=How.CSS, using="li.first.popover-options"))
	//By size_Listlocator=By.cssSelector("li.first.popover-options");
	private List<WebElement> size_List;
	

	
	@FindBy(how=How.CSS, using="button#add-to-cart.btn.btn-payment.add-to-cart")
	By addToCartButtonLocator=By.cssSelector("button#add-to-cart.btn.btn-payment.add-to-cart");
	private WebElement addToCartButton;
	
	@FindBy(how=How.CSS, using="div.cart-notification.row")
	By viewCartLocator=By.cssSelector("div.cart-notification.row");
	private WebElement viewCart;
	
	@FindBy(how=How.CSS, using="div.added-viewbag")
	By itemAddedToCartTextlocator=By.cssSelector("div.added-viewbag");
	private WebElement itemAddedToCartText;
	

	
	public void select_productNumber(int num) {
		prod_List.get(num).click();
		waitPage.untilPageLoadComplete(driver,(long) 10);
	}
	
	public void select_sizeNumber(int num) {
		//WaitWebElement.isElementClickable(driver, size_Listlocator);
		//size_List.get(num).isDisplayed();
		size_List.get(num).click();
	}
	
	public void click_addToCart() {
	
		WaitWebElement.isElementClickable(driver, addToCartButtonLocator);
		//addToCartButton.isDisplayed();
		//JavaExecutor.scrollToElemet(driver, addToCartButton);
		//String script = "return document.getElementById('add-to-cart').innerHTML= 'ADD TO BAG';";
		((JavascriptExecutor) driver).executeScript("document.getElementById('add-to-cart').click();");
		
		//JavaExecutor.elementClick(driver, addToCartButton);
		
	}
	
	public void verify_itemAddToCart() {
		WaitWebElement.isElementPresent(driver, itemAddedToCartTextlocator);
	}
	
	public void fill_productDetails(Customer customer)
	{
		select_productNumber(customer.productNumber);
		select_sizeNumber(customer.size);

	}
	
	public void wait_viewCart() {
		//javaExecutor.scrollToElemet(driver, viewCart);
		WaitWebElement.isElementInVisible(driver, viewCartLocator);
		//addToCartButton.click();
	}
	
	public String getProductName(Customer customer) {
		return prod_List.get(customer.productNumber).findElement(By.cssSelector("a > div > div.h4 > span")).getText();
	}

	public List<String> getProductNames() {
		List<String> productNames = new ArrayList<>();
		for(WebElement element : prod_List) {
			productNames.add(element.findElement(By.cssSelector("a > div > div.h4 > span")).getText());
			System.out.println(productNames);
		}
		return productNames;
	}
}
