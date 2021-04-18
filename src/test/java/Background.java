import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class Background extends BaseClass{

    @Test
    public void testCheckSearchArticleInBackground(){
        String searchLine = "Java";
        String search_result_locator ="//android.widget.TextView[@text='Java (programming language)']";


        waitForElementAndClick(
                By.xpath("//androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']"),
                "Cannot find search input",
                5);


        waitForElementAndSenKeys(
                By.xpath("//android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']"),
                searchLine,
                "Cannot find search input",
                5);

        waitForElementPresent(
                By.xpath(search_result_locator),
                "Cannot find text 'Java (programming language)'",
                15);

        driver.runAppInBackground(Duration.ofSeconds(2));

        waitForElementPresent(
                By.xpath(search_result_locator),
                "Cannot find text 'Java (programming language)'",
                15);
    }



}
