package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    public ArticlePageObject(RemoteWebDriver driver) {
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
            CLOSE_BANNER_BUTTON,//places auth close
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON;


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

//    public String getArticleTitle(String titleElement) {
//        WebElement title_element = waitForTitleElement(titleElement);
//        if (Platform.getInstance().isAndroid()) {
//            return title_element.getAttribute("content-desc");
//        } else if (Platform.getInstance().isIOS()) {
//            return title_element.getAttribute("name");
//        } else {
//            return title_element.getText();
//        }
//    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement(ARTICLE_TITLE);
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("content-desc");
        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        } else {
            this.scrollWebPageTillElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        }
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
        if((Platform.getInstance().isAndroid()) || (Platform.getInstance().isIOS())) {
            this.waitForElementAndClick(
                    GO_BACK_BUTTON,
                    "Cannot find the button 'Navigate up'",
                    5);
        } else {
            System.out.println("Method closeArticle() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
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
        if(Platform.getInstance().isMW()) {
            this.removeArticleFromSavedIfItAdded();
        }
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

    public void removeArticleFromSavedIfItAdded(){
        if(this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click the button to remove the article from saved",
                    1);
            this.waitForElementPresent(
                    ADD_TO_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before",
                    5);

        }
    }

}
