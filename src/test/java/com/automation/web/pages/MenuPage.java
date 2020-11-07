package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{

    @FindBy(css= "div.global-user:first-of-type a[data-affiliatename='espn']")
    private WebElement btnLogin;

    @FindBy(css= "#global-header  ul.account-management a[onclick*='logout()']")
    private WebElement btnLogOut;

    @FindBy(css = "#global-header a[tref$='/members/v3_1/modifyAccount']")
    private WebElement btnEspProfile;

    @FindBy(css = "#global-header ul.account-management > li.display-user > span")
    private  WebElement lblNameUser;

    @FindBy(css = "#global-header  ul.account-management > li.display-user")
    private WebElement lblWelcome;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public MenuPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Click IconoLogin
     * @return {@link MenuPage}
     */
    public LoginPage goLogin() {
        log.info("click");
        clickElement(btnLogin);
        return new LoginPage(getDriver());
    }

    /**
     * Log Out EspnPage
     * @return {@link HomePage}
     */
    public HomePage logOutUser(){
        log.info("Click LogOut");
        clickElement(btnLogOut);
        getDriver().navigate().refresh();
        return new HomePage((getDriver()));
    }

    /**
     * Enter Account User EspnPage
     * @return {@link LoginPage}
     */
    public LoginPage clickBtnEspProfile() {
        log.info("click EspnProfile");
        clickElement(btnEspProfile);
        return new LoginPage(getDriver());
    }

    /**
     * Get text Name User
     * @return String
     */
    public String getTextNameUser(){
        return getElementText(lblNameUser);
    }

    /**
     *Return if textNameUser is present
     * @return boolean
     */
    public boolean isPresentTextNameUser(){
        return isWebElementPresent(lblNameUser);
    }

    /**
     * Action to get text welcome
     * @return
     */
    public String getTextWelcome(){
        return getElementText(lblWelcome);
    }

}
