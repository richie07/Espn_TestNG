package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuLogin extends BasePage{ //  esto hace parte de la home page

    @FindBy(css= "div.global-user:first-of-type a[data-affiliatename='espn']")
    private WebElement btnLogin;

    @FindBy(css= "ul.account-management a[onclick*='espn.memberservices.logout()']")
    private List<WebElement> btnLogOuts;

    @FindBy(css = "div.global-user a[tref$='modifyAccount']")
    private List<WebElement> btnProfiles;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public MenuLogin(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Click IconoLogin
     * @return {@link MenuLogin}
     */
    public MenuLogin goMenuLogin() {
        log.info("click");
        clickElement(btnLogin);
        return new MenuLogin(getDriver());
    }

    /**
     * Log Out EspnPage
     */
    public void logOutUser(){
        log.info("Click");
        WebElement btnLogOut = btnLogOuts.get(0);
        clickElement(btnLogOut);
    }

    /**
     * Enter Account User EspnPage
     * @return {@link UpdateAccountPage}
     */
    public UpdateAccountPage clickOptionDelete() {
        log.info("click");
        WebElement btnProfile = btnProfiles.get(0);
        clickElement(btnProfile);
        return new UpdateAccountPage(getDriver());
    }


}
