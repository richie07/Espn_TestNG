package com.globant.web.tests;

import com.globant.web.data.Data;
import com.globant.web.pages.HomePage;
import com.globant.web.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {

    @AfterMethod
    @Parameters({"url"})
    public void launchHomePage(String url) {
        driver.getDriver().get(url);
    }

    @Test(description = "example test wikipedia", dataProviderClass = Data.class, dataProvider = "countries")
    public void testCase(String country) {
        log.info(getHomePage());
        HomePage homePage = getHomePage();
        Assert.assertEquals(homePage.getTitle(), "Wikipedia","TITLE IS NO AS EXPECTED");
        log.info("Search: " + country);
        SearchPage searchPage = homePage.search(country);
        Assert.assertEquals(searchPage.getTitle(), country, "TITLE IS NO AS EXPECTED");
    }
}
