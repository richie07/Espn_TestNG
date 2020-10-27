package com.automation.web.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
     * @param name String
     * @param lastname String
     * @param email String
     * @param password String
     * @return {@link HomePage}
     */
    public HomePage createAccount(String name,String lastname,String email,String password){
        log.info("Create account : "+name+" "+lastname+" "+email+ " "+password);
        sendElementText(txtName,name);
        sendElementText(txtLastName,lastname);
        sendElementText(txtEmail,email);
        sendElementText(txtPassword,password);
        log.info("Click SignUp Account");
        clickElement(btnSignUpAccount);
        waitElementInvisible(frmVistaAccount);
        return returnPageHome();
    }

    /**
     * Do log in Page Espn
     * @param email String
     * @param password String
     * @return {@link HomePage}
     */
    public HomePage doLogInToPageHome(String email, String password){
        doLogInPage(email,password);
        waitElementInvisible(frmVistaAccount);
        return returnPageHome();

    }

    /**
     * Do delete Account EspnPage
     */
    public void doDeleteAccount(){
        waitFrameAvailable(ifrLogin);
        waitElementVisibility(LblTitleUpdateAccount);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
