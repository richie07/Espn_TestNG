package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.data.User;
import com.automation.web.pages.HomePage;
import com.automation.web.pages.LoginIframe;
import com.automation.web.pages.MenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogOut extends BaseTest{

    @BeforeMethod(alwaysRun = true)
    public void createAccountAndLogin(Object[] data){
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

    }

    @Test(description = "Validate logout page Espn",dataProviderClass = Data.class, dataProvider = "dataLogin")
    public void testCaseLogOut(User user) {
        log.info("Stated test Case ");
        HomePage homePage = getHomePage();
        log.info("Go MenuLogin");
        MenuPage menu =homePage.goMenuLogin();
        Assert.assertTrue(menu.getTextNameUser().contains(user.getName()),user.getName() +" IS NOT PRESENT");
        log.info("Account LogOut");
        homePage = menu.logOutUser();
        log.info("Get Home Page");
        menu = homePage.goMenuLogin();
        Assert.assertFalse(menu.isPresentTextNameUser());

    }
}
