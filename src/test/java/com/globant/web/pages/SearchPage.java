package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(id = "firstHeading")
    private WebElement title;

    /**
     * Constructor.
     * @param driver : WebDriver
     */
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get Text title
     *
     * @return String text title
     */
    public String getTitle() {
        log.info("Get Text title");
        waitElementVisibility(title);
        return title.getText();
    }
}
