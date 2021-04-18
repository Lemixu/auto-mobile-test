import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

public class PhoneRotation extends BaseClass{

    @Test
    public void testChangeOrientation(){

        String searchLine = "Java";
        String search_result_locator ="//*[@resource-id=\"org.wikipedia:id/page_list_item_title\"]";


        waitForElementAndClick(
                By.xpath("//androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']"),
                "Cannot find search input",
                5);


        waitForElementAndSenKeys(
                By.xpath("//android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']"),
                searchLine,
                "Cannot find search input",
                5);

        waitForElementAndClick(
                By.xpath(search_result_locator),
                "Cannot find topic searching by '"+searchLine+"'",
                15);
        String title_before_rotation = waitElementAndGetAttribute(
                By.xpath("(//android.view.View[@content-desc=\"Java\"])[1]"),
                "content-desc",
                "Cannot find title of article",
                10);

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = waitElementAndGetAttribute(
                By.xpath("(//android.view.View[@content-desc=\"Java\"])[1]"),
                "content-desc",
                "Cannot find title of article",
                10);
        Assert.assertEquals("Article title have been change after screen rotation",
                title_before_rotation,
                title_after_rotation);

        driver.rotate(ScreenOrientation.PORTRAIT);
        String title_after_second_rotation = waitElementAndGetAttribute(
                By.xpath("(//android.view.View[@content-desc=\"Java\"])[1]"),
                "content-desc",
                "Cannot find title of article",
                10);
        Assert.assertEquals("Article title have been change after screen rotation",
                title_after_rotation,
                title_after_second_rotation);

    }


}
