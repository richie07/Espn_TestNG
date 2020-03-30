package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "central-textlogo__image")
    private WebElement title;

    @FindBy(id = "searchInput")
    private WebElement searchField;

    @FindBy(className = "pure-button")
    private WebElement searchButton;

    /**
     * Constructor.
     * @param driver : WebDriver
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
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

    /**
     * Search a word
     *
     * @param word String search word
     * @return {@link SearchPage}
     */
    public SearchPage search(String word) {
        log.info("Set value: " + word);
        searchField.sendKeys(word);
        log.info("click");
        searchButton.click();
        return new SearchPage(getDriver());
    }
}
