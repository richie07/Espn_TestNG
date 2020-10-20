package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateAccountPage extends BasePage{

    @FindBy(id = "cancel-account")
    private WebElement linkDelete;

    @FindBy(css = "button[type='submit']")
    private WebElement btnDelete;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public UpdateAccountPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Delete Account Espn
     */
    public void deleteAcount(){
        clickElement(linkDelete);
        clickElement(btnDelete);
    }
}
