package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
            ARTICLE_TITLE = "//android.view.View[@content-desc='{SUBSTRING}']",
            FOOTER_ELEMENT = "//android.view.View[@content-desc='View article in browser']",
            SAVE_BUTTON = "org.wikipedia:id/article_menu_bookmark",
            ADD_TO_LIST_BUTTON = "org.wikipedia:id/snackbar_action",
            OK_BUTTON = "android:id/button1",
            NAVIGATE_UP_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
            NAME_OF_EXIST_LIST = "//android.widget.TextView[@text='{SUBSTRING}']",
            VIEW_LIST_BUTTON = "org.wikipedia:id/snackbar_action";


    private static String getTitleElement(String substring) {
        return ARTICLE_TITLE.replace("{SUBSTRING}", substring);
    }

    private static String getNameOfExistList(String substring){
        return NAME_OF_EXIST_LIST.replace("{SUBSTRING}",substring);
    }

    public WebElement waitForTitleElement(String substring) {
        String article_title = getTitleElement(substring);
        return waitForElementPresent(
                By.xpath(article_title),
                "Cannot find article title on the page",
                15);
    }

    public String getArticleTitle(String titleElement) {
        WebElement title_element = waitForTitleElement(titleElement);
        return title_element.getAttribute("content-desc");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of article",
                20);
    }

    public void addArticleToNewList(String nameOfFolder) {
        this.waitForElementAndClick(
                By.id(SAVE_BUTTON),
                "Cannot find button 'Save",
                5);

        this.waitForElementAndClick(
                By.id(ADD_TO_LIST_BUTTON),
                "Cannot find the button 'Add to List",
                5);

        this.waitForElementAndSenKeys(
                By.id("org.wikipedia:id/text_input"),
                nameOfFolder,
                "Cannot find text input",
                5);

        this.waitForElementAndClick(
                By.id(OK_BUTTON),
                "Cannot find the button 'OK'",
                5);
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                By.xpath(NAVIGATE_UP_BUTTON),
                "Cannot find the button 'Navigate up'",
                5);
    }

    public void addArticleToOldListAndOpen(String nameOfFolder) {
        this.waitForElementAndClick(
                By.id(SAVE_BUTTON),
                "Cannot find button 'Save",
                5);

        this.waitForElementAndClick(
                By.id(ADD_TO_LIST_BUTTON),
                "Cannot find the button 'Add to List",
                5);


        String name_of_list = getNameOfExistList(nameOfFolder);
        this.waitForElementAndClick(
                By.xpath(name_of_list),
                "Cannot find the list named '" + nameOfFolder + "'",
                5);

        this.waitForElementAndClick(
                By.id(VIEW_LIST_BUTTON),
                "Cannot find the button 'View List'",
                5);
    }

   public void assertTitleOfArticleIsPresent(String title) {
        String title_of_article = getTitleElement(title);
       Boolean element_present = this.elementIsDisplayed(By.xpath(title_of_article));

       if(element_present==false){
           String default_message = "An element '" + title_of_article + "' supposed to be present";
           throw new AssertionError(default_message + " " + "There is no title on this page");
       }
   }

}
