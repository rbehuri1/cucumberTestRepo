package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;

public class WaitWebElement {
	
	public static void isElementDisplayed(WebDriver driver,By locator) {
	       try {
	            
	            
	            WebDriverWait wait = new WebDriverWait(driver, 10);
	            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	            if (!element.isDisplayed()) {
	                
	                System.err.format("Failed to verify element " + element.toString() + " display");
	            }
	            
	        } catch (NoSuchElementException e) {
	           
	            throw new AssertionError("No such element : " + e + " to verify");

	        } catch (ElementNotVisibleException e) {
	           
	            throw new AssertionError("Element " + e + " was not visible");

	        } catch (StaleElementReferenceException e) {
	            
	            throw new AssertionError("Element " + e + " was no longer displayed in DOM");
	        }
	}
	

	
	public static void isElementPresent(WebDriver driver, By locator) {
		WebDriverWait wait=new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
		
		wait.until((ExpectedConditions.presenceOfElementLocated(locator)));
	}
	
	public static void isElementClickable(WebDriver driver, By locator) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		
		WebDriverWait wait=new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
		wait.until((ExpectedConditions.elementToBeClickable(locator)));
	}
	
	public static void isElementVisible(WebDriver driver, By locator) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
		
		wait.until((ExpectedConditions.visibilityOfElementLocated(locator)));
	}
	
	public static void isElementInVisible(WebDriver driver, By locator) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		
		WebDriverWait wait=new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
		((WebDriverWait) wait).until((ExpectedConditions.invisibilityOfElementLocated(locator)));
	}
	
	public static void waitForinvisibilityOfElement(WebDriver driver, By locator,String  strText) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
		
		((WebDriverWait) wait).until((ExpectedConditions.invisibilityOfElementWithText(locator,strText)));
	}
	
	public static void waitForStalenessOfElement(WebDriver driver, WebElement element) {
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
		
		((WebDriverWait) wait).until((ExpectedConditions.stalenessOf(element)));
	}

}
