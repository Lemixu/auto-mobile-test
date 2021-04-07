import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Ex3 extends First{

    @Test
    public void cancelSearch() {
        waitForElementAndClick(
                By.xpath("//androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']"),
                "Cannot find search input",
                5
        );
        waitForElementAndSenKeys(
                By.xpath("//android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']"),
                "Hippo",
                "Cannot find search input",
                5);

        waitForElementPresent(By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find close button",
                15);


        waitForElementPresent(By.id("org.wikipedia:id/page_list_item_title"),
                "Cannot find articles",
                15);

       int count = driver.findElements(By.id("org.wikipedia:id/page_list_item_title")).size();

        Assert.assertTrue("Count of articles dont more than 1",count > 1);

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find close button",
                5);


        count = driver.findElements(By.id("org.wikipedia:id/page_list_item_title")).size();

        Assert.assertTrue("Count of articles dont equal 0",count==0);
    }

}
