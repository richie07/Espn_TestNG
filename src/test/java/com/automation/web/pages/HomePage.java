package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Class for interact with the home page.
 * @author juan.montes
 */
public class HomePage extends BasePage {

    @FindBy(id= "global-user-trigger")
    private WebElement icoLogin;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Constructor.
     * @param driver WebDriver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click IconLogin
     * @return {@link MenuPage}
     */
    public MenuPage goMenuLogin() {
        log.info("Click icon Menu");
        clickElement(icoLogin);
        return new MenuPage(getDriver());
    }

}
