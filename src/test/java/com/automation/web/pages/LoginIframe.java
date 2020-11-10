package com.automation.web.pages;

import com.automation.web.data.User;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LoginIframe extends BasePage{

    @FindBy(css= "a[did-translate='login.label.CREATE_ACCOUNT']")
    private WebElement btnSignUp;

    @FindBy(css= "button[ng-click='vm.submitLogin()']")
    private WebElement btnSignUp_Login;

    @FindBy(name = "firstName")
    private WebElement txtName;

    @FindBy(name = "lastName")
    private WebElement txtLastName;

    @FindBy(css = "input[type='email']")
    private WebElement txtEmail;

    @FindBy(css = "input[type='password']")
    private WebElement txtPassword;

    @FindBy(css = "div.btn-group button[type='submit']")
    private WebElement btnSignUpAccount;

    @FindBy(css = "h2")
    private WebElement lblCreateAccount;

    @FindBy(id = "did-ui-view")
    private WebElement frmVistaAccount;

    @FindBy(css = "#did-ui-view h2[did-translate$='profile_disabled.HEADER'")
    private WebElement lblDisableAccount;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public LoginIframe(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Click Sign Up for create AccountPage
     */
    public void goSignUp() {
        log.info("Click button Sign up");
        clickElement(btnSignUp);
        log.info("Account Login Page");

    }

    /**
     * Get title Create Account
     * @return
     */
    public String getTitleCreateAccount(){
        return getElementText(lblCreateAccount);
    }

    /**
     * Create New Account EspnPage
     * @param user User
     * @return {@link HomePage}
     */
    public HomePage createAccountAndReturnHome(User user){
        log.info("Create account : "+user.getName()+" "+user.getLastName()+" "+user.getEmail()+ " "+user.getPassword());
        sendElementText(txtName, user.getName());
        sendElementText(txtLastName, user.getLastName());
        sendElementText(txtEmail,user.getEmail());
        sendElementText(txtPassword, user.getPassword());
        log.info("Click SignUp Account");
        clickElement(btnSignUpAccount);
        waitElementInvisible(frmVistaAccount);
        return returnPageHome();
    }

    /**
     * Do log in Page Espn
     * @param user User
     * @return {@link HomePage}
     */
    public HomePage doLogInToPageHome(User user){

        doLogInPage(user.getEmail(), user.getPassword());
        waitElementInvisible(frmVistaAccount);
        return returnPageHome();

    }


    /**
     * Action to do Login Page
     * @param email String
     * @param password String
     */
    public void doLogInPage(String email, String password) {
        log.info("Login with " + email + " and " + password);
        sendElementText(txtEmail, email);
        sendElementText(txtPassword, password);
        log.info("Click SignUP");
        clickElement(btnSignUp_Login);
    }

    /**
     * Get text Title Disable Account
     * @return String
     */
    public String getTextDisableAccount(){
        return getElementText(lblDisableAccount);
    }



}
