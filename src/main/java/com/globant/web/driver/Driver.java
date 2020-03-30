package com.globant.web.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Driver class
 * @author juan.montes
 */
public class Driver {
	
	private WebDriver driver;
	
	/**
	 * Constructor.
	 * @param browser : String
	 */
	public Driver (String browser) {
		switch (browser) {
			case "remoteFirefox":
				try {
					driver = new RemoteWebDriver(new URL("http://172.18.0.1:4444/wd/hub"), DesiredCapabilities.firefox());
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverMac80");
				driver = new ChromeDriver();
				break;
			default:
				break;
		}
	}
	
	/**
	 * 	Get the driver.
	 * @return WebDriver with the driver
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

}
