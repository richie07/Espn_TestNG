package com.automation.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Parent of the other classes of pages.
 * @author juan.montes
 */
public class BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	public Logger log = Logger.getLogger(BasePage.class);
	
	/**
	 * Constructor.
	 * @param pDriver WebDriver
	 */
	public BasePage (WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		wait = new WebDriverWait(pDriver, 20);
		driver = pDriver;
	}

	/**
	 * Get the web driver wait.
	 * @return {@link WebDriverWait}
	 */
	protected WebDriverWait getWait() {
		return wait;
	}

	/**
	 * Get the  web driver.
	 * @return {@link WebDriver}
	 */
	protected WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * Close the web driver.
	 */
	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Wait element to be visible.
	 * @param element WebElement
	 */
	public void waitElementVisibility(WebElement element) {
		getWait().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait element to be visible.
	 * @param elements list WebElement
	 */
	public void waitElementsVisibility(List<WebElement> elements) {
		getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	/**
	 * Get element text
	 * @param element WebElement
	 * @return String
	 */
	public String getElementText(WebElement element) {
		waitElementVisibility(element);
		return element.getText();
	}

	/**
	 * Write and send text
	 * @param element WebElement
	 * @param text String
	 */
	public void sendElementText(WebElement element, String text) {
		waitElementVisibility(element);
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Wait element to be clickable.
	 * @param element WebElement
	 */
	public void waitElementClickable(WebElement element) {
		getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Click WebElement
	 * @param element WebElement
	 */
	public void clickElement(WebElement element){
		waitElementClickable(element);
		element.click();
	}

	/**
	 * Wait Frame to be available and switch.
	 * @param frame WebElement
	 */
	public void waitFrameAvailable(WebElement frame) {
		getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	}

	/**
	 * Wait element is not visible.
	 * @param element WebElement
	 */
	public void waitElementInvisible(WebElement element) {
		getWait().until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * Back to the original Context
	 */
	public void switchToOriginalContext() {
		getDriver().switchTo().parentFrame();
	}

	/**
	 * Expected the webelement is Displayed
	 * @param element WebElement
	 * @return boolean
	 */
	public boolean isWebElementPresent(WebElement element) {
		try{
			element.isDisplayed();
			return true;
		}
		catch(NoSuchElementException e){
			return false;
		}
	}

}
