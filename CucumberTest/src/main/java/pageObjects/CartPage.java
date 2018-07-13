package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;
import selenium.JavaExecutor;
import selenium.WaitPage;
import selenium.WaitWebElement;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;
	WaitPage waitPage;
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="div.view-bag")
	By addToCartButtonLocator=By.cssSelector("div.view-bag");
	private WebElement addToCartButton;
	
	@FindBy(how=How.LINK_TEXT, using="PLACE ORDER")
	By placeOrderButtonLocator=By.linkText("PLACE ORDER");
	private WebElement placeOrderButton;
	
	@FindBy(how=How.CSS, using="section#main div.view-bag > a")
	By viewBagButtonlocator=By.cssSelector("section#main div.view-bag > a");
	private WebElement viewbagButton;
	
	@FindBy(how=How.CSS, using="div.cart-notification.row")
	By viewCartLocator=By.cssSelector("div.cart-notification.row");
	private WebElement viewCart;
	
	@FindBy(how=How.CSS, using="section#header-bag-sec")
	By addToCartBagButtonlocator=By.cssSelector("section#header-bag-sec");
	private WebElement addToCartBagButton;
	
	
	
	public void click_addToCartBag() {
		WaitWebElement.isElementInVisible(driver, viewCartLocator);
		//section#header-bag-sec > a
		((JavascriptExecutor) driver).executeScript("document.querySelector('section#header-bag-sec > a').click();");
		
	     
		
	}
	
	public void click_viewbagButton() {
		WaitWebElement.isElementInVisible(driver, viewCartLocator);
		//((JavascriptExecutor) driver).executeScript("document.querySelector('a.btn btn-primary').click();");
		//WaitWebElement.isElementVisible(driver, viewBagButtonlocator);
		//WaitWebElement.isElementClickable(driver, viewBagButtonlocator);
		//driver.switchTo().defaultContent();
		
		((JavascriptExecutor) driver).executeScript("document.querySelector('section#main div.view-bag > a').click();");
	     
		    
		
	}
	
	public void click_addToCart() throws InterruptedException {
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl()+"cart/");
		//Thread.sleep(2000);
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
		//addToCartButton.click();
	}
	

	public void click_placeOrder() {

		
		((JavascriptExecutor) driver).executeScript("document.querySelector('div#cart-btn > a').click();");
		waitPage.untilJqueryIsDone(driver);
		waitPage.untilPageLoadComplete(driver);
	}
}
