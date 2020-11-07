package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.data.User;
import com.automation.web.pages.HomePage;
import com.automation.web.pages.LoginPage;
import com.automation.web.pages.MenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDisableAccount extends BaseTest{

    @BeforeMethod(alwaysRun = true)
    public void createAccountAndLogin(Object[] data ){
        log.info("Create and Login");
        User user = (User) data[0];
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        MenuPage menu =homePage.goMenuLogin();
        LoginPage login = menu.goLogin();
        login.goSignUp();
        homePage = login.createAccount(user);
        menu =homePage.goMenuLogin();
        log.info("Log Out Page");
        menu.logOutUser();
        log.info("Get Home Page");
        homePage = getHomePage();
        log.info("Go MenuLogin");
        menu =homePage.goMenuLogin();
        LoginPage loginPage =  menu.goLogin();
        log.info("Login Account");
        homePage = loginPage.doLogInToPageHome(user);
        driver.getDriver().getCurrentUrl();
        //driver.getDriver().navigate().refresh();


    }

    @Test(description = "Validate page account Espn",dataProviderClass = Data.class, dataProvider = "dataLogin")
    public void testCaseDisableAccount(User user) {
        log.info("Stated test Case ");
        HomePage homePage = getHomePage();
        log.info("Go MenuLogin");
        MenuPage menu =homePage.goMenuLogin();
        Assert.assertTrue(menu.getTextNameUser().contains(user.getName()),user.getName() +" IS NOT PRESENT");
        LoginPage loginPage = menu.clickBtnEspProfile();
        loginPage.doDeleteAccount();
        Assert.assertEquals(loginPage.getTextDeleteAccount(),"Your account has been deleted.","TITLE DELETE IS NOT PRESENT");
        homePage =loginPage.returnPageHome();
        menu = homePage.goMenuLogin();
        loginPage=  menu.goLogin();
        loginPage.doLogInPage(user.getEmail(),user.getPassword());
        Assert.assertEquals(loginPage.getTextDisableAccount(),"Account Deactivated","TITLE DEACTIVATED IS NOT PRESENT");

    }
}
