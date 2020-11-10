package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.data.User;
import com.automation.web.pages.HomePage;
import com.automation.web.pages.LoginIframe;
import com.automation.web.pages.MenuPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLogIn extends BaseTest{

    @AfterMethod
    public void launchHomePage() {
        HomePage homePage = getHomePage();
        MenuPage menu =homePage.goMenuLogin();
        menu.logOutUser();
    }

    @BeforeMethod(alwaysRun = true)
    public void createAccountAndLogOut(Object[] data){
        User user = (User)data[0];
        HomePage homePage = getHomePage();
        MenuPage menu =homePage.goMenuLogin();
        LoginIframe login = menu.goLoginIframe();
        login.goSignUp();
        homePage = login.createAccountAndReturnHome(user);
        menu =homePage.goMenuLogin();
        menu.logOutUser();

    }

    @Test(description = "Verify login in EspnPage",dataProviderClass = Data.class, dataProvider = "dataLogin")
    public void testCaseLogin(User user) {
        log.info("Stated test Case Login");
        HomePage homePage = getHomePage();
        MenuPage menu =homePage.goMenuLogin();
        Assert.assertEquals(menu.getTextWelcome(),"Welcome!","NAME WELCOME IS NOT PRESENT");
        LoginIframe loginIframe =  menu.goLoginIframe();
        homePage = loginIframe.doLogInToPageHome(user);
        homePage.goMenuLogin();
        Assert.assertTrue(menu.getTextNameUser().contains(user.getName()),user.getName() +" IS NOT PRESENT");
    }


}
