package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css= "a[did-translate='login.label.CREATE_ACCOUNT']")
    private WebElement btnSignUp;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public LoginPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Click SignUP
     * @return {@link CreateAccountPage}
     */
    public CreateAccountPage goMenuLogin() {
        log.info("click");
        clickElement(btnSignUp);
        return new CreateAccountPage(getDriver());
    }
}
