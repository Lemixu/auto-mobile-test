package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject {

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    protected static String
            ARTICLE_TITLE,
            FOOTER_ELEMENT,
            SAVE_BUTTON,
            ADD_TO_LIST_BUTTON,
            OK_BUTTON,
            GO_BACK_BUTTON,
            NAME_OF_EXIST_LIST,
            VIEW_LIST_BUTTON,
            CLOSE_BANNER_BUTTON; //places auth close


    private static String getTitleElement(String substring) {
        return ARTICLE_TITLE.replace("{SUBSTRING}", substring);
    }

    private static String getNameOfExistList(String substring) {
        return NAME_OF_EXIST_LIST.replace("{SUBSTRING}", substring);
    }

    public WebElement waitForTitleElement(String substring) {
        String article_title = getTitleElement(substring);
        return waitForElementPresent(
                article_title,
                "Cannot find article title on the page",
                15);
    }

    public String getArticleTitle(String titleElement) {
        WebElement title_element = waitForTitleElement(titleElement);
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("content-desc");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        } else this.swipeUpTillElementAppear(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                40);
    }

    public void addArticleToNewList(String nameOfFolder) {
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find button 'Save",
                5);

        this.waitForElementAndClick(
                ADD_TO_LIST_BUTTON,
                "Cannot find the button 'Add to List",
                5);

        this.waitForElementAndSenKeys(
                "id:org.wikipedia:id/text_input",
                nameOfFolder,
                "Cannot find text input",
                5);

        this.waitForElementAndClick(
                OK_BUTTON,
                "Cannot find the button 'OK'",
                5);
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                GO_BACK_BUTTON,
                "Cannot find the button 'Navigate up'",
                5);
    }

    public void addArticleToOldListAndOpen(String nameOfFolder) {
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find button 'Save",
                5);

        this.waitForElementAndClick(
                ADD_TO_LIST_BUTTON,
                "Cannot find the button 'Add to List",
                5);


        String name_of_list = getNameOfExistList(nameOfFolder);
        this.waitForElementAndClick(
                name_of_list,
                "Cannot find the list named '" + nameOfFolder + "'",
                5);

        this.waitForElementAndClick(
                VIEW_LIST_BUTTON,
                "Cannot find the button 'View List'",
                5);
    }

    public void assertTitleOfArticleIsPresent(String title) {
        String title_of_article = getTitleElement(title);
        Boolean element_present = this.elementIsDisplayed(title_of_article);

        if (element_present == false) {
            String default_message = "An element '" + title_of_article + "' supposed to be present";
            throw new AssertionError(default_message + " " + "There is no title on this page");
        }
    }

    public void addArticlesToMySaved() {
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find the Save button",
                5);
    }

    public void closeBannerAfterSaveArticle() {
        this.waitForElementAndClick(
                CLOSE_BANNER_BUTTON,
                "Cannot find the close button on the banner",
                15);

    }

}
