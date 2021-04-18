import org.junit.Test;
import org.openqa.selenium.By;

public class SaveTheArticle extends Swipe {

    //@Test
    public void saveFirstArticle(){

        String text = "Learning programming";

        waitForElementAndClick(
                By.xpath("//androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']"),
                "Cannot find search input",
                5);

        waitForElementAndSenKeys(
                By.xpath("//android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']"),
                "Java",
                "Cannot find search input",
                5);

        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='Java (programming language)']"),
                "Cannot find 'Object-oriented programming language' searching by 'Java'",
                15);


        waitForElementAndClick(
                By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
                "Cannot find text 'Java (programming language)'",
                15);

        waitForElementPresent(
                        By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
                        "Cannot find text 'Java (programming language)'",
                        15);

//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
//                "Cannot find element //android.widget.ImageView[@content-desc='More options']",
//                10);
        waitForElementAndClick(
                By.id("org.wikipedia:id/article_menu_bookmark"),
                        "Cannot find button 'Save",
                        5);

        waitForElementAndClick(
                By.id("org.wikipedia:id/snackbar_action"),
                "Cannot find the button 'Add to List",
                5);


        waitForElementAndSenKeys(
                By.id("org.wikipedia:id/text_input"),
                text,
                "Cannot find text input",
                5);

        waitForElementAndClick(
                By.id("android:id/button1"),
                "Cannot find the button 'OK'",
                5);

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot find the butoon 'Navigate up'",
                5);


        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton"),
                "Cannot find the butoon 'Navigate up'",
                5);



        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='Saved']"),
                "Cannot find the butoon 'Saved'",
                5);
        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='"+text+"']"),
                "Cannot find List named '"+text+"'",
                5);

        swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot swipe the article");
    }

    @Test
    public void testAmountOfEmptySearch(){
        waitForElementAndClick(
                By.xpath("//androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']"),
                "Cannot find search input",
                5);

        String searchLine = "afrtldml";

        waitForElementAndSenKeys(
                By.xpath("//android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']"),
                searchLine,
                "Cannot find search input",
                5);
        String empty_result_label = "//*[@text='No results']";
        String search_result_locator ="//*[@resource-id=\"org.wikipedia:id/page_list_item_title\"]";
        waitForElementPresent(
                By.xpath(empty_result_label),
                "Cannot find empty result label by the request " + searchLine);

        assertElementNotPresent(
                By.xpath(search_result_locator),
                "We found some results by request" +searchLine);



    }

}
