package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{

    public MyListsPageObject(AppiumDriver driver){
        super(driver);
    }

    public static final String
    FOLDER_NAME_TPL = "xpath://android.widget.TextView[@text='{SUBSTRING}']",
    ARTICLE_IN_FOLDER_TPL = "xpath://*[@text='{SUBSTRING}']",
    DOWNLOAD_LIST_ICON = "id:org.wikipedia:id/page_list_item_action";


    private static String getFolderElement(String substring){
       return FOLDER_NAME_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getSavedArticle(String substring){
        return ARTICLE_IN_FOLDER_TPL.replace("{SUBSTRING}", substring);
    }


    public void openFolderByName(String name_of_folder){
        String nameFolder = getFolderElement(name_of_folder);
        this.waitForElementAndClick(
                nameFolder,
                "Cannot find folder by name " + name_of_folder,
                5);
    }

    public void swipeArticleToDelete(String article_title) {
        this.waitForArticleAppearByTitle(article_title);
        String name_of_article = getSavedArticle(article_title);
        this.swipeElementToLeft(
               name_of_article,
                "Cannot swipe the article");
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void waitForArticleToDisappearByTitle(String article_title){
        String article_xpath = getSavedArticle(article_title);
        this.waitForElementNotPresent(
                article_xpath,
                "Saved article still present with title " + article_title,
                15);
    }
    public void waitForArticleAppearByTitle(String article_title){
        String article_xpath = getSavedArticle(article_title);
        this.waitForElementPresent(
                article_xpath,
                "Cannor find the article with title " + article_title,
                15);
    }

    public void waitDownloadListIconDisappear(){
        this.waitForElementNotPresent(
                DOWNLOAD_LIST_ICON,
                "The download icon didnt disappear",
                15);
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
