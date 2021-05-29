package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject {
    protected static String
            SEARCH_INPUT,
            BUTTON_SKIP,
            SEARCH_INPUT_ACTIVE,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            EMPTY_RESULT_LABEL,
            PAGE_LIST_ITEM;


    // TEMPLATES METHODS
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getPageItemXpath(String title, String description){
        return PAGE_LIST_ITEM
                .replace("{TITLE}", title)
                .replace("{DESCRIPTION}", description);
    }
    //TEMPLATE METHODS


    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }


    public void initClickSkip() {
        this.waitForElementAndClick(
                BUTTON_SKIP,
                "Cannot find the button 'SKIP'",
                5);
    }

    @Step("Initializing the search input")
    public void initSearchInput() {
        this.waitForElementAndClick(
                SEARCH_INPUT,
                "Cannot find search input",
                5);
    }

    @Step("Typing '{search_line}' to the search line")
    public void typeSearchLine(String search_line) {
        this.waitForElementAndSenKeys(
                SEARCH_INPUT_ACTIVE,
                search_line,
                "Cannot find search input",
                5);

    }

    @Step("Waiting for search result")
    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(
                search_result_xpath,
                "Cannot find search result: " + search_result_xpath);
    }

    @Step("Waiting gor button to cancel search result")
    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(
                SEARCH_CANCEL_BUTTON,
                "Cannot find cancel button",
                5);
    }

    @Step("Waiting for search cancel button to disappear")
    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(
                SEARCH_CANCEL_BUTTON,
                "Search cancel button is still present",
                5);
    }

    @Step("Clicking cancel button")
    public void clickCancelButton() {
        this.waitForElementAndClick(
                SEARCH_CANCEL_BUTTON,
                "Cannot find and click cancel button",
                5);
    }

    @Step("Waiting for search result and select an article by substring in article title")
    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(
                search_result_xpath,
                "Cannot find  and click search result: " + search_result_xpath,
                10);
    }

    @Step("Getting amount of found articles")
    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request ",
                15);
        return this.getAmountOfElements(
               SEARCH_RESULT_ELEMENT);

    }

    @Step("Waiting for empty results label")
    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(
                EMPTY_RESULT_LABEL,
                "Cannot find empty results label",
                10);
    }

    @Step("Making sure that there are no results for the search ")
    public void assertThereIsNoResultOfSearch() {
        this.assertElementNotPresent(
                SEARCH_RESULT_ELEMENT,
                "We supposed to find any results");
    }

    //tests.Ex9
    @Step("Waiting for the article by title and description")
    public void waitForElementByTitleAndDescription(String title, String description) {
        String page_item = this.getPageItemXpath(title,description);
        this.waitForElementPresent(
                page_item,
                "Cannot find research result by title: " +
                        title + " and description: " + description + "\nThe locator: " + page_item);
    }


}
