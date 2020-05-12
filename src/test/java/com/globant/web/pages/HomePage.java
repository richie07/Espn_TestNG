package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

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
    private List<WebElement> idioms;

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
        waitElementVisibility(title);
        return title.getText();
    }

    /**
     * Search a word
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

    public MainPage selectIdiom(String language) {
        waitElementsVisibility(idioms);
        Optional<WebElement> selectIdiom = idioms.stream()
                .filter(idiom -> idiom.getText().equals(language)).findFirst();
        selectIdiom.ifPresent(WebElement::click);
        return new MainPage(getDriver());
    }
}
