package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import selenium.WaitPage;

public class LogoutPage {
	WebDriver driver;
	WaitPage waitPage;

	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
