package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    @FindBy(name = "firstName")
    private WebElement txtName;

    @FindBy(name = "LastName")
    private WebElement txtLastName;

    @FindBy(name = "email")
    private WebElement txtEmail;

    @FindBy(name = "newPassword")
    private WebElement txtPassword;

    @FindBy(css = "div.btn-group button[type='submit']")
    private WebElement btnSignUp;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public CreateAccountPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Creat New Account EspnPage
     * @param name String
     * @param lastname String
     * @param email String
     * @param password String
     * @return {@link HomePage}
     */
    public HomePage createAccount(String name,String lastname,String email,String password){
        sendElementText(txtName,name);
        sendElementText(txtLastName,lastname);
        sendElementText(txtEmail,email);
        sendElementText(txtPassword,password);
        clickElement(btnSignUp);
        return new HomePage(getDriver());
    }
}
