package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.data.User;
import com.automation.web.pages.HomePage;
import com.automation.web.pages.LoginPage;
import com.automation.web.pages.MenuPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLogIn extends BaseTest{

    @AfterMethod
    @Parameters({"url"})
    public void launchHomePage(String url) {
        driver.getDriver().get(url);
        HomePage homePage = getHomePage();
        MenuPage menu =homePage.goMenuLogin();
        menu.logOutUser();
       // driver.getDriver().close();

    }

    @Parameters({"url"})
    @BeforeMethod(alwaysRun = true)
    public void createAccountAndLogOut(Object[] data,String url){
        User user = (User)data[0];
        HomePage homePage = getHomePage();
        MenuPage menu =homePage.goMenuLogin();
        LoginPage login = menu.goLogin();
        login.goSignUp();
        homePage = login.createAccount(user);
        menu =homePage.goMenuLogin();
        menu.logOutUser();
        driver.getDriver().get(url);
        driver.getDriver().navigate().refresh();
    }

    @Test(description = "Verify login in EspnPage",dataProviderClass = Data.class, dataProvider = "dataLogin")
    public void testCaseLogin(User user) {
        log.info("Stated test Case Login");
        HomePage homePage = getHomePage();
        MenuPage menu =homePage.goMenuLogin();
        Assert.assertEquals(menu.getTextWelcome(),"Welcome!","NAME WELCOME IS NOT PRESENT");
        LoginPage loginPage =  menu.goLogin();
        homePage = loginPage.doLogInToPageHome(user);
        homePage.goMenuLogin();
        Assert.assertTrue(menu.getTextNameUser().contains(user.getName()),user.getName() +" IS NOT PRESENT");
    }


}
