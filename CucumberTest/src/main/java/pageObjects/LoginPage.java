package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium.WaitPage;
import selenium.WaitWebElement;
import testDataTypes.Customer;

public class LoginPage {
	
	WebDriver driver;
	WaitPage waitPage;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="signin-model-wishlist")
	By signIn_Linklocator=By.id("signin-model-wishlist");
	private WebElement signIn_Link;
	
	@FindBy(how=How.CSS, using="input#login-email.form-control")
	By email_TextLocator=By.cssSelector("input#login-email.form-control");
	private WebElement email_Text;
	
	@FindBy(how=How.CSS, using="input#login-pwd.form-control")
	By pwd_TextLocator=By.cssSelector("input#login-pwd.form-control");
	private WebElement pwd_Text;
	
	@FindBy(how=How.ID, using="btn-login")
	By signIn_Buttonlocator=By.id("btn-login");
	private WebElement signIn_Button;
	
	public void click_SignIn() {
		WaitWebElement.isElementClickable(driver, signIn_Linklocator);
		((JavascriptExecutor) driver).executeScript("document.getElementById('signin-model-wishlist').click();");
		//signIn_Link.click();
		
	}
	
	public void enter_EmailId(String email) {
		//((JavascriptExecutor) driver).executeScript("document.getElementById('login-email').value=''");
		WaitWebElement.isElementDisplayed(driver, email_TextLocator);
		((JavascriptExecutor) driver).executeScript("document.getElementById('login-email').setAttribute('value','"+email+"')");
		//email_Text.sendKeys(email);
	}
	
	public void enter_password(String pwd) {
		//((JavascriptExecutor) driver).executeScript("document.getElementById('login-email').value=''");
		WaitWebElement.isElementDisplayed(driver, pwd_TextLocator);
		((JavascriptExecutor) driver).executeScript("document.getElementById('login-pwd').setAttribute('value','"+pwd+"')");
		//email_Text.sendKeys(email);
	}
	public void fill_CredentialDetails(Customer customer) {
		enter_EmailId(customer.emailAddress);
		enter_password(customer.passWord);
		//passWord
			
	}
	public void click_SignInButton() {
		WaitWebElement.isElementClickable(driver, signIn_Buttonlocator);
		((JavascriptExecutor) driver).executeScript("document.getElementById('btn-login').click();");
		waitPage.untilPageLoadComplete(driver);
		//signIn_Link.click();
		
	}

}
