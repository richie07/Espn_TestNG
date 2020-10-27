package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.data.User;
import com.automation.web.pages.HomePage;
import com.automation.web.pages.LoginPage;
import com.automation.web.pages.MenuLogin;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLogIn extends BaseTest{

    @AfterMethod
    @Parameters({"url"})
    public void launchHomePage(String url) {
        driver.getDriver().get(url);
        HomePage homePage = getHomePage();
        MenuLogin menu =homePage.goMenuLogin();
        menu.logOutUser();

    }

    @Parameters({"url"})
    @BeforeMethod(alwaysRun = true)
    public void createAccountAndLogOut(Object[] data,String url){
        HomePage homePage = getHomePage();
        MenuLogin menu =homePage.goMenuLogin();
        LoginPage login = menu.goLogin();
        login.goSignUp();
        homePage = login.createAccount((String)data[0],(String)data[1],(String)data[2],(String)data[3]);
        menu =homePage.goMenuLogin();
        menu.logOutUser();
        driver.getDriver().get(url);
        driver.getDriver().navigate().refresh();
    }

    @Test(description = "Verify login in EspnPage",dataProviderClass = Data.class, dataProvider = "dataLogin")
    public void testCaseLogin(String name,String lastname,String email,String password) {
        log.info("Stated test Case Login");
        HomePage homePage = getHomePage();
        MenuLogin menu =homePage.goMenuLogin();
        Assert.assertEquals(menu.getTextWelcome(),"Welcome!","NAME WELCOME IS NOT PRESENT");
        LoginPage loginPage =  menu.goLogin();
        homePage = loginPage.doLogInToPageHome(email, password);
        homePage.goMenuLogin();
        Assert.assertTrue(menu.getTextNameUser().contains(name),name +" IS NOT PRESENT");
    }


}
