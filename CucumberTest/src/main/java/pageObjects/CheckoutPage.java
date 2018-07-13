package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import selenium.Wait;
import selenium.WaitPage;
import selenium.WaitWebElement;
import testDataTypes.Customer;
import selenium.JavaExecutor;
import selenium.JavaScript;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.JavaScript;
import selenium.Wait;


public class CheckoutPage {
	WebDriver driver;
	
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindAll(@FindBy(how=How.CSS, using="#addressForm>div>input"))
	private List<WebElement> add_Address_List;
	
	@FindBy(how=How.CSS, using="input#do-guest-checkout")
	private WebElement checkoutAsGuestCheckBox;
	
	@FindBy(how=How.CSS, using="input#login-email.form-control")
	private WebElement emailTextBox;
	
	@FindBy(how=How.CSS, using="button#btn-login-checkout")
	By continueAsGuestButtonlocator=By.cssSelector("button#btn-login-checkout ");
	private WebElement continueAsGuestButton;
	
	@FindBy(how=How.CSS, using="#postcode")
	By pinCodeTextBoxlocator=By.cssSelector("#postcode");
	private WebElement pinCodeTextBox;
	
	@FindBy(how=How.CSS, using="input#first_name.form-control")
	By nameTextBoxlocator=By.cssSelector("input#first_name.form-control");
	String nameTextBoxString="first_name";
	private WebElement nameTextBox;
	
	@FindBy(how=How.CSS, using="#address1")
	By addressTextBoxlocator=By.cssSelector("#address1");
	private WebElement addressTextBox;
	
	@FindBy(how=How.CSS, using="input#phone.form-control")
	By phoneNumberTextBoxlocator=By.cssSelector("input#phone.form-control");
	private WebElement phoneNumberTextBox;
	
	@FindBy(how=How.CSS, using="div.custom-checkbox")
	private WebElement sameAddressCheckBox;
	
	@FindBy(how=How.CSS, using="button.btn.btn-payment.add-to-cart")
	By deliverToThisAddressButtonlocator=By.cssSelector("button.btn.btn-payment.add-to-cart");
	private WebElement deliverToThisAddressButton;
	
	public void check_checkoutAsGuest(Boolean value)
	{
		if(value) checkoutAsGuestCheckBox.click();
	}
	
	public void enter_email(String email)
	{
		emailTextBox.sendKeys(email);
	}
	
	public void click_continueAsGuest() throws InterruptedException
	{
		//WaitWebElement.isElementClickable(driver, continueAsGuestButtonlocator);
		((JavascriptExecutor) driver).executeScript("document.getElementById('btn-login-checkout').click();");
		//WaitWebElement.isElementDisplayed(driver, nameTextBoxlocator);
		//continueAsGuestButton.click();
		//btn-login-checkout
		//new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOf(addressTextBox));
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", addressTextBox);
	}
	public void enter_pinCode(String pincode)
	{
		
		WaitWebElement.isElementPresent(driver, pinCodeTextBoxlocator);
		
		((JavascriptExecutor) driver).executeScript("document.getElementById('postcode').setAttribute('value', '" + pincode +"')");
	}
	public void enter_name(String name)
	{
	
		WaitWebElement.isElementPresent(driver, nameTextBoxlocator);

		((JavascriptExecutor) driver).executeScript("document.getElementById('first_name').setAttribute('value', '" + name +"')");
		//nameTextBox.sendKeys(name);
		 

			
	
		
		
	}
	public void enter_address(String address)
	{

		//new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOf(addressTextBox));
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", addressTextBox);
		WaitWebElement.isElementPresent(driver, addressTextBoxlocator);
		((JavascriptExecutor) driver).executeScript("document.getElementById('address1').setAttribute('value', '" + address +"')");
	}
	public void enter_phoneNumber(String phoneNumber)
	{

		WaitWebElement.isElementPresent(driver, phoneNumberTextBoxlocator);

		((JavascriptExecutor) driver).executeScript("document.getElementById('phone').setAttribute('value', '" + phoneNumber +"')");
		//n
	}
	public void check_sameAddress(Boolean value)
	{
		if(value) sameAddressCheckBox.click();
	}
	
	public void click_deliverToThisAddress()
	{
		WaitWebElement.isElementPresent(driver, deliverToThisAddressButtonlocator);
		deliverToThisAddressButton.click();
	}
	
	/*public void fill_personalDetail()
	{
		enter_address("address");
	
		enter_phoneNumber("9742094704");
		enter_pinCode("560037");
		enter_name("radha behuria");
	}*/
	
	public void fill_PersonalDetails(Customer customer) {
		enter_name(customer.firstName);
		
		enter_phoneNumber(customer.phoneNumber.mob);
		
		
		enter_address(customer.address.streetAddress);
		enter_pinCode(customer.address.postCode);
			
	}
}
