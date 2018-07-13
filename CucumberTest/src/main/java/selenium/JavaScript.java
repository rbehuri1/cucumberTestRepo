package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScript {
	
	private static WebDriver driver;
	
	public  JavaScript(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public static Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}
	public static Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;

		return exe.executeScript(script, args);
	}

	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])",
				element.getLocation().x, element.getLocation().y);
	
	}

	public void scrollToElemet(By locator) {
		scrollToElemet(driver.findElement(locator));
		
	}

	public void scrollToElemetAndClick(By locator) {
		WebElement element = driver.findElement(locator);
		scrollToElemet(element);
		element.click();
	
	}

	public void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
		
	}

	public static void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
		
	}

	public void scrollIntoView(By locator) {
		scrollIntoView(driver.findElement(locator));
		
	}

	public void scrollIntoViewAndClick(By locator) {
		WebElement element = driver.findElement(locator);
		scrollIntoView(element);
		element.click();
		
	}

	public static void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
	
	}

}
