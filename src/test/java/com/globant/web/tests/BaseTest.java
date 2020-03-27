package com.globant.web.tests;

import com.globant.web.driver.Driver;
import com.globant.web.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Parent of the other classes of test.
 * @author juan.montes
 */
public class BaseTest {
	
	Driver driver;
	
	private HomePage Home;
	public Logger log = Logger.getLogger(BaseTest.class);
	
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser", "url"})
	public void beforeTest(String browser, String url) {
		driver = new Driver(browser);
		Home= new HomePage(driver.getDriver(), url);
	}

	@AfterTest(alwaysRun=true)
	public void afterTest() {
		Home.dispose();
	}
	
	/**
	 * Get the home page.
	 * @return HomePage
	 */
	public HomePage getHomePage() {
		return Home;
	}

}
