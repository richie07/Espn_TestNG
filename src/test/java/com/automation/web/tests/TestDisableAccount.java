package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.data.User;
import com.automation.web.pages.HomePage;
import com.automation.web.pages.LoginIframe;
import com.automation.web.pages.MenuPage;
import com.automation.web.pages.ProfileIframe;
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
        LoginIframe login = menu.goLoginIframe();
        login.goSignUp();
        homePage = login.createAccountAndReturnHome(user);
        menu =homePage.goMenuLogin();
        log.info("Log Out Page");
        menu.logOutUser();
        log.info("Get Home Page");
        homePage = getHomePage();
        log.info("Go MenuLogin");
        menu =homePage.goMenuLogin();
        LoginIframe loginIframe =  menu.goLoginIframe();
        log.info("Login Account");
        homePage = loginIframe.doLogInToPageHome(user);
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
        ProfileIframe profile = menu.goProfileIframe();
        profile.doDeleteAccount();
        Assert.assertEquals(profile.getTextDeleteAccount(),"Your account has been deleted.","TITLE DELETE IS NOT PRESENT");
        homePage =profile.returnPageHome();
        menu = homePage.goMenuLogin();
        LoginIframe login =  menu.goLoginIframe();
        login.doLogInPage(user.getEmail(),user.getPassword());
        Assert.assertEquals(login.getTextDisableAccount(),"Account Deactivated","TITLE DEACTIVATED IS NOT PRESENT");

    }
}
