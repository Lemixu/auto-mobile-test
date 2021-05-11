package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;


abstract public class MyListsPageObject extends MainPageObject {

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    protected static String
            FOLDER_NAME_TPL,
            ARTICLE_IN_FOLDER_TPL,
            DOWNLOAD_LIST_ICON,
            DELETE_BUTTON;


    private static String getFolderElement(String substring) {
        return ARTICLE_IN_FOLDER_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getSavedArticle(String substring) {
        return ARTICLE_IN_FOLDER_TPL.replace("{SUBSTRING}", substring);
    }


    public void openArticleByName(String name_of_folder) {
        String nameFolder = getSavedArticle(name_of_folder);
        this.waitForElementAndClick(
                nameFolder,
                "Cannot find folder by name " + name_of_folder,
                5);
    }

    public void swipeArticleToDelete(String article_title) {
        this.waitForArticleAppearByTitle(article_title);
        String name_of_article = getSavedArticle(article_title) + "/..";
        this.swipeElementToLeft(
                name_of_article,
                "Cannot swipe the article");
        if(Platform.getInstance().isIOS()){
            clickDeleteArticleButton();
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_xpath = getSavedArticle(article_title);
        this.waitForElementNotPresent(
                article_xpath,
                "Saved article still present with title " + article_title,
                15);
    }

    public void waitForArticleAppearByTitle(String article_title) {
        String article_xpath = getSavedArticle(article_title);
        this.waitForElementPresent(
                article_xpath,
                "Cannot find the article with title " + article_title,
                15);
    }

    public void waitDownloadListIconDisappear() {
        this.waitForElementNotPresent(
                DOWNLOAD_LIST_ICON,
                "The download icon didnt disappear",
                15);
    }

    public void clickDeleteArticleButton() {
        this.waitForElementAndClick(
                DELETE_BUTTON,
                "Cannot find the delete button",
                10);
    }

//    public void openArticle(String title){
//
//        String title_of_article = getFolderElement(title);
//        this.waitForElementAndClick(
//                By.xpath(title_of_article),
//                "Cannot click on article '" +title+"'",
//                5);
//    }
}
