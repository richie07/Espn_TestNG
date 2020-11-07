package com.automation.web.pages;

import com.automation.web.data.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class LoginPage extends BasePage{

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

    @FindBy(id = "disneyid-iframe")
    private WebElement ifrLogin;

    @FindBy(css = "h2")
    private WebElement lblCreateAccount;

    @FindBy(id = "did-ui-view")
    private WebElement frmVistaAccount;

    @FindBy(css = "section.section-divider:nth-child(1) > h3:nth-child(1)")
    private WebElement LblTitleUpdateAccount;

    @FindBy(id = "cancel-account")
    private WebElement btnDeleteAccount;

    @FindBy(css = "#did-ui-view button[ng-click='vm.confirm()']")
    private WebElement btnDeleteThisAccount;

    @FindBy(css = "h2[did-translate$='deactivate.successful.messages.header'")
    private WebElement lblMessageDeleteAccount;

    @FindBy(css = "#did-ui-view h2[did-translate$='profile_disabled.HEADER'")
    private WebElement lblDisableAccount;

    @FindBy(className = "loading-indicator")
    private WebElement loading;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public LoginPage(WebDriver pDriver) {
        super(pDriver);
    }

    /**
     * Click Sign Up for create AccountPage
     */
    public void goSignUp() {
        waitFrameAvailable(ifrLogin);
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
    public HomePage createAccount(User user){
        log.info("Create account : "+user.getName()+" "+user.getLastName()+" "+user.getEmail()+ " "+user.getPassword());
        sendElementText(txtName,user.getName());
        sendElementText(txtLastName,user.getLastName());
        sendElementText(txtEmail,user.getEmail());
        sendElementText(txtPassword,user.getPassword());
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
     * Do delete Account EspnPage
     */
    public void doDeleteAccount(){
        waitFrameAvailable(ifrLogin);
        waitElementVisibility(LblTitleUpdateAccount);

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

    /**
     * Action to return PageHome
     * @return {@link HomePage}
     */
    public HomePage returnPageHome(){
        log.info("Go Home");
        switchToOriginalContext();
        getDriver().navigate().refresh();
        return new HomePage(getDriver());
    }

    /**
     * Action to do Login Page
     * @param email String
     * @param password String
     */
    public void doLogInPage(String email, String password) {
        log.info("Login with " + email + " and " + password);
        waitFrameAvailable(ifrLogin);
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
