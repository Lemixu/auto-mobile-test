package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {
    private static final String
            SEARCH_INPUT = "xpath://androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']",
            BUTTON_SKIP = "xpath://*[contains(@text,'SKIP')]",
            SEARCH_INPUT_ACTIVE = "xpath://android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']",
            SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://android.widget.TextView[@text='{SUBSTRING}']",
            SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id=\"org.wikipedia:id/page_list_item_title\"]",
            EMPTY_RESULT_LABEL = "xpath://*[@text='No results']",
            PAGE_LIST_ITEM =
                    "xpath://android.view.ViewGroup[" +
                            "./android.widget.TextView[@text='{TITLE}']]" +
                            "/android.widget.TextView[@text='{DESCRIPTION}']";


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


    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void initClickSkip() {
        this.waitForElementAndClick(
                BUTTON_SKIP,
                "Cannot find the button 'SKIP'",
                5);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(
                SEARCH_INPUT,
                "Cannot find search input",
                5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSenKeys(
                SEARCH_INPUT_ACTIVE,
                search_line,
                "Cannot find search input",
                5);

    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(
                search_result_xpath,
                "Cannot find search result: " + search_result_xpath);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(
                SEARCH_CANCEL_BUTTON,
                "Cannot find cancel button",
                5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(
                SEARCH_CANCEL_BUTTON,
                "Search cancel button is still present",
                5);
    }

    public void clickCancelButton() {
        this.waitForElementAndClick(
                SEARCH_CANCEL_BUTTON,
                "Cannot find and click cancel button",
                5);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(
                search_result_xpath,
                "Cannot find  and click search result: " + search_result_xpath,
                10);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request ",
                15);
        return this.getAmountOfElements(
               SEARCH_RESULT_ELEMENT);

    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(
                EMPTY_RESULT_LABEL,
                "Cannot find empty results label",
                10);
    }

    public void assertThereIsNoResultOfSearch() {
        this.assertElementNotPresent(
                SEARCH_RESULT_ELEMENT,
                "We supposed to find any results");
    }

    //Ex9
    public void waitForElementByTitleAndDescription(String title, String description) {
        String page_item = this.getPageItemXpath(title,description);
        this.waitForElementPresent(
                page_item,
                "Cannot find research result by title: " +
                        title + " and description: " + description);
    }


}
