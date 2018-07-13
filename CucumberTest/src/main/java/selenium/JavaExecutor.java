package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaExecutor {
	

	
	
	
	
	public static void scrollToElemet(WebDriver driver,WebElement element) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void elementClick(WebDriver driver,WebElement element) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	public static void enterValueUsingJavaExecutor(WebDriver driver,By locator, String value) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("document.getElementById('"+locator+"').value='"+value+"';");
	}
	
	public static void clickElementUsingJavaExecutor(WebDriver driver,By locator) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("document.getElementById('"+locator+"').click();");
	}
	
	public static void handleCheckBox(WebDriver driver,WebElement element) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("document.getElementById('enter element id').checked=false;");
	}
	
	public static void alertPopupBox(WebDriver driver,WebElement element) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("alert('Welcome To SoftwareTestingMaterial');");
	}
	
	public static void refreshBrowser(WebDriver driver,WebElement element) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("history.go(0)");
	}
	
	public static void getInnerText(WebDriver driver,WebElement element) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;").toString();
		
	}
	
	public static void getTitle(WebDriver driver,WebElement element) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("return document.title;").toString();
		
	}
	public static void getDomain(WebDriver driver,WebElement element) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("return document.domain;").toString();
		
	}
	public static void getURL(WebDriver driver,WebElement element) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("return document.URL;").toString();
		
	}
	
	public static void mouseHover(WebDriver driver,WebElement element) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("$('ul.menus.menu-secondary.sf-js-enabled.sub-menu li').hover()");
		
	}
	
	public static void getStyleColor(WebDriver driver,WebElement element) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("document.getElementById('text-4').style.borderColor = 'Red'");

		
	}
}
