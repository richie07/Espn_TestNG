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

    @FindBy(id = "disneyid-iframe")
    private WebElement ifrLogin;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public MenuPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Go LoginIframe
     * @return {@link LoginIframe}
     */
    public LoginIframe goLoginIframe() {
        log.info("Click menu login");
        clickElement(btnLogin);
        waitFrameAvailable(ifrLogin);
        return new LoginIframe(getDriver());
    }

    /**
     * Log Out EspnPage
     * @return {@link HomePage}
     */
    public HomePage logOutUser(){
        log.info("Click menu logOut");
        clickElement(btnLogOut);
        getDriver().navigate().refresh();
        return new HomePage((getDriver()));
    }

    /**
     * Go Account Profile
     * @return {@link ProfileIframe}
     */
    public ProfileIframe goProfileIframe() {
        log.info("Click menu ProfileIframe");
        clickElement(btnEspProfile);
        waitFrameAvailable(ifrLogin);
        return new ProfileIframe(getDriver());
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
