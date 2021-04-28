package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {
    private static final String
            SEARCH_INPUT = "//androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']",
            BUTTON_SKIP = "//*[contains(@text,'SKIP')]",
            SEARCH_INPUT_ACTIVE = "//android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//android.widget.TextView[@text='{SUBSTRING}']",
            SEARCH_RESULT_ELEMENT = "//*[@resource-id=\"org.wikipedia:id/page_list_item_title\"]",
            EMPTY_RESULT_LABEL = "//*[@text='No results']";
    ;

    // TEMPLATES METHODS
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    //TEMPLATE METHODS


    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void initClickSkip() {
        this.waitForElementAndClick(
                By.xpath(BUTTON_SKIP),
                "Cannot find the button 'SKIP'",
                5);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(
                By.xpath(SEARCH_INPUT),
                "Cannot find search input",
                5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSenKeys(By.xpath(SEARCH_INPUT_ACTIVE),
                search_line,
                "Cannot find search input",
                5);

    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath),
                "Cannot find search result: " + search_result_xpath);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(
                By.id(SEARCH_CANCEL_BUTTON),
                "Cannot find cancel button",
                5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(
                By.id(SEARCH_CANCEL_BUTTON),
                "Search cancel button is still present",
                5);
    }

    public void clickCancelButton() {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON),
                "Cannot find and click cancel button", 5);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(
                By.xpath(search_result_xpath),
                "Cannot find  and click search result: " + search_result_xpath,
                10);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by the request ",
                15);
        return this.getAmountOfElements(
                By.xpath(SEARCH_RESULT_ELEMENT));

    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(
                By.xpath(EMPTY_RESULT_LABEL),
                "Cannot find empty results label",
                10);
    }

    public void assertThereIsNoResultOfSearch(){
        this.assertElementNotPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "We supposed to find any results");
    }


}
