package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the search page.
 * @author juan.montes
 */
public class SearchPage extends BasePage {

    @FindBy(id = "firstHeading")
    private WebElement title;

    /**
     * Constructor.
     * @param driver WebDriver
     */
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get Text title
     * @return String text title
     */
    public String getTitle() {
        log.info("Get Text title");
        return getElementText(title);
    }
}
