package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileIframe extends BasePage{

    @FindBy(id = "cancel-account")
    private WebElement btnDeleteAccount;

    @FindBy(css = "#did-ui-view button[ng-click='vm.confirm()']")
    private WebElement btnDeleteThisAccount;

    @FindBy(className = "loading-indicator")
    private WebElement loading;

    @FindBy(css = "h2[did-translate$='deactivate.successful.messages.header'")
    private WebElement lblMessageDeleteAccount;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ProfileIframe(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Do delete Account EspnPage
     */
    public void doDeleteAccount(){
        log.info("Delete Account");
        waitElementInvisible(loading);
        scrollDownToElement(btnDeleteAccount);
        waitElementInvisible(loading);
        clickElement(btnDeleteAccount);
        clickElement(btnDeleteThisAccount);
    }

    /**
     * Get text title Delete Account
     * @return String
     */
    public String getTextDeleteAccount(){
        return getElementText(lblMessageDeleteAccount);
    }

}
