package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Class for the wikipedia test.
 * @author juan.montes
 */
public class TestSuite extends BaseTest {

    @DataProvider(name = "languages")
    public Object[][] inputData() {
        return new Object[][] {{"English"}, {"Español"}, {"Italiano"}};
    }

    @AfterMethod
    @Parameters({"url"})
    public void launchHomePage(String url) {
        driver.getDriver().get(url);
    }

    @Test(description = "example test search in wikipedia", dataProviderClass = Data.class, dataProvider = "countries")
    public void testCaseSearch(String country) {
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        Assert.assertEquals(homePage.getTitle(), "Wikipedia","TITLE IS NO AS EXPECTED");
        log.info("Search: " + country);
        SignUpPage signUpPage = homePage.search(country);
        Assert.assertEquals(signUpPage.getTitle(), country, "TITLE IS NO AS EXPECTED");
    }

    @Test(description = "example test select language wikipedia", dataProvider = "languages")
    public void testCaseLanguage(String language) {
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        Assert.assertEquals(homePage.getTitle(), "Wikipedia","TITLE IS NO AS EXPECTED");
        log.info("language: " + language);
        MainPage mainPage = homePage.selectLanguage(language);
        Assert.assertTrue(mainPage.verifyLanguage(language), "LANGUAGE IS NOT THE EXPECTED");
    }
}
