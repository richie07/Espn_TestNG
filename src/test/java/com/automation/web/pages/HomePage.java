package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Class for interact with the home page.
 * @author juan.montes
 */
public class HomePage extends BasePage {

    @FindBy(className = "central-textlogo__image")
    private WebElement title;

    @FindBy(id = "searchInput")
    private WebElement searchField;

    @FindBy(className = "pure-button")
    private WebElement searchButton;

    @FindBy(css = ".link-box Strong")
    private List<WebElement> languages;

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
     * Get Text title
     * @return String text title
     */
    public String getTitle() {
        log.info("Get Text title");
        return getElementText(title);
    }

    /**
     * Search a word
     * @param word String search word
     * @return {@link SearchPage}
     */
    public SearchPage search(String word) {
        log.info("Set value: " + word);
        sendElementText(searchButton, word);
        log.info("click");
        clickElement(searchButton);
        return new SearchPage(getDriver());
    }

    public MainPage selectLanguage(String language) {
        waitElementsVisibility(languages);
        Optional<WebElement> select = languages.stream()
                .filter(languageElement -> languageElement.getText().equals(language)).findFirst();
        select.ifPresent(WebElement::click);
        return new MainPage(getDriver());
    }
}
