package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class MyListsPageObject extends MainPageObject {

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    protected static String
            FOLDER_NAME_TPL,
            ARTICLE_IN_FOLDER_TPL,
            DOWNLOAD_LIST_ICON,
            DELETE_BUTTON,
            REMOVE_FROM_SAVED_BUTTON;


    private static String getFolderElement(String substring) {
        return ARTICLE_IN_FOLDER_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getSavedArticle(String substring) {
        return ARTICLE_IN_FOLDER_TPL.replace("{SUBSTRING}", substring);
    }
    private static String getRemoveButtonByTitle(String substring) {
        return REMOVE_FROM_SAVED_BUTTON.replace("{SUBSTRING}", substring);
    }


    @Step("Opening the article by name= {name_of_folder}")
    public void openArticleByName(String name_of_folder) {
        String nameFolder = getSavedArticle(name_of_folder);
        this.waitForElementAndClick(
                nameFolder,
                "Cannot find folder by name " + name_of_folder,
                5);
    }

    @Step("Imitating the swipe for delete the article my name = {article_title}")
    public void swipeArticleToDelete(String article_title) throws InterruptedException {
        this.waitForArticleAppearByTitle(article_title);
        String name_of_article = getSavedArticle(article_title) + "/..";

        if((Platform.getInstance().isIOS()) || (Platform.getInstance().isAndroid())) {
            this.swipeElementToLeft(
                    name_of_article,
                    "Cannot swipe the article");
        }
        else {
            String remove_locator =  getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(
                    remove_locator,
                    "Cannot click button to remove article",
                    10);
        }
        if(Platform.getInstance().isIOS()){
            clickDeleteArticleButton();
        }
        if(Platform.getInstance().isMW()){
            Thread.sleep(1000);
            driver.navigate().refresh();
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    @Step("Waiting the article to disappear from 'My list' by name = {article_title}")
    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_xpath = getSavedArticle(article_title);
        this.waitForElementNotPresent(
                article_xpath,
                "Saved article still present with title " + article_title,
                15);
    }

    @Step("Waiting the article to appear in 'My List' by name = {article_title}")
    public void waitForArticleAppearByTitle(String article_title) {
        String article_xpath = getSavedArticle(article_title);
        this.waitForElementPresent(
                article_xpath,
                "Cannot find the article with title " + article_title,
                15);
    }

    @Step("Waiting the download icon to Disappear")
    public void waitDownloadListIconDisappear() {
        this.waitForElementNotPresent(
                DOWNLOAD_LIST_ICON,
                "The download icon didnt disappear",
                15);
    }

    @Step("Clicking the delete button")
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
