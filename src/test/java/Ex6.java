import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Ex6 extends BaseClass{

    @Test
    public void testAttributeTitleIsPresent(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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
        assertElementPresent(
                By.xpath("(//android.view.View)[3]"),
                "Element 'title' isnot present");

    }

    public void assertElementPresent(By by, String error_message){
        Boolean element_present = driver.findElement(by).isDisplayed();
        if(element_present==false){
            String default_message = "An element '" + by.toString() + "' supposed to be present";
            throw new AssertionError(default_message + " " + error_message);
        }

    }
}