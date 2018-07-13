package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;

public class Wait {
	WebDriver driver;
	ConfigFileReader reader;
	public Wait(WebDriver driver,ConfigFileReader reader) {
		
		this.driver = driver;
		this.reader = reader;
		
	}
	
	private WebDriverWait getWait(int timeOutInSeconds,int pollingEveryInMiliSec) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	public void setImplicitWait(long timeout,TimeUnit unit) {
		
		driver
		.manage()
		.timeouts()
		.implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}
	
	public void waitForElementVisible(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
		
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		setImplicitWait(reader.getImplicitlyWait(), TimeUnit.SECONDS);
	}

	public static void hardWait(int timeOutInMiliSec) throws InterruptedException {
		
		Thread.sleep(timeOutInMiliSec);
	}
	
	public WebElement handleStaleElement(By locator,int retryCount,int delayInSeconds) throws InterruptedException {
		
		WebElement element = null;
		
		while (retryCount >= 0) {
			try {
				element = driver.findElement(locator);
				return element;
			} catch (StaleElementReferenceException e) {
				hardWait(delayInSeconds);
				retryCount--;
			}
		}
		throw new StaleElementReferenceException("Element cannot be recovered");
	}
	
	public void elementExits(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
		
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(elementLocatedBy(locator));
		setImplicitWait(reader.getImplicitlyWait(), TimeUnit.SECONDS);
	}
	
	public void elementExistAndVisible(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
		
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(elementLocatedBy(locator));
		new JavaScript(driver).scrollIntoView(locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		setImplicitWait(reader.getImplicitlyWait(), TimeUnit.SECONDS);
		
	}
	
	public void waitForIframe(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
		
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		driver.switchTo().defaultContent();
		setImplicitWait(reader.getImplicitlyWait(), TimeUnit.SECONDS);
	}
	
	private Function<WebDriver, Boolean> elementLocatedBy(final By locator){
		return new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
			
				return driver.findElements(locator).size() >= 1;
			}
		};
	}
}


