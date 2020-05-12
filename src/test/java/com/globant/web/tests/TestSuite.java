package com.globant.web.tests;

import com.globant.web.data.Data;
import com.globant.web.pages.HomePage;
import com.globant.web.pages.MainPage;
import com.globant.web.pages.SearchPage;
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

    @DataProvider(name = "idioms")
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
        SearchPage searchPage = homePage.search(country);
        Assert.assertEquals(searchPage.getTitle(), country, "TITLE IS NO AS EXPECTED");
    }

    @Test(description = "example test select idiom wikipedia", dataProvider = "idioms")
    public void testCaseIdiom(String language) {
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        Assert.assertEquals(homePage.getTitle(), "Wikipedia","TITLE IS NO AS EXPECTED");
        log.info("Idiom: " + language);
        MainPage mainPage = homePage.selectIdiom(language);
        Assert.assertTrue(mainPage.verifyLanguage(language), "LANGUAGE IS NOT THE EXPECTED");
    }
}
