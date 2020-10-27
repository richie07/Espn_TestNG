package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.pages.HomePage;
import com.automation.web.pages.LoginPage;
import com.automation.web.pages.MenuLogin;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDisableAccount extends BaseTest{

    @AfterMethod
    @Parameters({"url"})
    public void launchHomePage(String url) {
       driver.getDriver().get(url);

    }

    @Parameters({"url"})
    @BeforeMethod(alwaysRun = true)
    public void createAccountAndLogin(Object[] data,String url){
        driver.getDriver().get(url);
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        MenuLogin menu =homePage.goMenuLogin();
        LoginPage login = menu.goLogin();
        login.goSignUp();
        homePage = login.createAccount((String)data[0],(String)data[1],(String)data[2],(String)data[3]);
        menu =homePage.goMenuLogin();
        log.info("Log Out Page");
        menu.logOutUser();
        log.info("Get Home Page");
        homePage = getHomePage();
        log.info("Go MenuLogin");
        menu =homePage.goMenuLogin();
        LoginPage loginPage =  menu.goLogin();
        log.info("Login Account");
        homePage = loginPage.doLogInToPageHome((String) data[2],(String) data[3]);
        driver.getDriver().get(url);
        driver.getDriver().navigate().refresh();


    }

    @Test(description = "Validate page account Espn",dataProviderClass = Data.class, dataProvider = "dataLogin")
    public void testCaseDisableAccount(String name,String lastname,String email,String password) {
        log.info("Stated test Case ");
        HomePage homePage = getHomePage();
        log.info("Go MenuLogin");
        MenuLogin menu =homePage.goMenuLogin();
        Assert.assertTrue(menu.getTextNameUser().contains(name),name +" IS NOT PRESENT");
        LoginPage loginPage = menu.clickBtnEspProfile();
        loginPage.doDeleteAccount();
        Assert.assertEquals(loginPage.getTextDeleteAccount(),"Your account has been deleted.","TITLE DELETE IS NOT PRESENT");
        homePage =loginPage.returnPageHome();
        menu = homePage.goMenuLogin();
        loginPage=  menu.goLogin();
        loginPage.doLogInPage(email,password);
        Assert.assertEquals(loginPage.getTextDisableAccount(),"Account Deactivated","TITLE DEACTIVATED IS NOT PRESENT");

    }
}
