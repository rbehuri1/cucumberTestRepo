package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import selenium.WaitPage;

public class HomePage {
	WebDriver driver;
	ConfigFileReader configFileReader;
	WaitPage waitPage;
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		configFileReader= new ConfigFileReader();
		
	}
	
	public void perform_Search(String search) {
		
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl() +"find/"+search+"/?q="+search+"&tt="+search+"&rank=0&qc="+search);
		waitPage.untilJqueryIsDone(driver);
	}
	
	public void navigate_to_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		waitPage.untilPageLoadComplete(driver);
	}

}
