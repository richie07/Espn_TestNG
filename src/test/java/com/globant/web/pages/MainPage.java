package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the main page.
 * @author juan.montes
 */
public class MainPage extends BasePage {

    @FindBy(id = "mw-content-text")
    private WebElement mainContainer;

    /**
     * Constructor.
     * @param driver WebDriver
     */
    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verify Language.
     * @param language String
     * @return true if is the same language.
     */
    public boolean verifyLanguage(String language) {
        log.info("Verify Language");
        waitElementVisibility(mainContainer);
        log.info(language.toLowerCase().substring(0,2));
        log.info(mainContainer.getAttribute("lang"));
        return mainContainer.getAttribute("lang").equals(language.toLowerCase().substring(0,2));
    }
}
