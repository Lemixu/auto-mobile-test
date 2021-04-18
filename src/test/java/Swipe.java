import io.appium.java_client.TouchAction;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class Swipe extends BaseClass {

    //@Test
    public void testSwipeArticle() {
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


        waitForElementPresent(
                By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
                "Cannot find text 'Java (programming language)'",
                15);

        swipeUp(2);
        swipeUp(2);

    }

    //@Test
    public void testSwipeQuickArticle(){

        waitForElementAndClick(
                By.xpath("//androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']"),
                "Cannot find search input",
                5);

        waitForElementAndSenKeys(
                By.xpath("//android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']"),
                "Appium",
                "Cannot find search input",
                5);

        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='Appium']"),
                "Cannot find 'Appium'",
                15);

        waitForElementPresent(
                By.xpath("//android.view.View[@content-desc='Appium']"),
                "Cannot find text 'Appium'",
                15);

        // //android.widget.TextView[@text='View page in browser']

        swipeUptoFindElement(
                By.xpath("//android.view.View[@content-desc='View article in browser']"),
                "Cannot find the end of the article",
                20);



    }





    protected void swipeUp(int timeOfSwipe){


        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int) (size.height*0.8);
        int end_y = (int) (size.height*0.2);

        action
                .press(point(x,start_y))
                .waitAction(waitOptions(ofSeconds(timeOfSwipe)))
                .moveTo(point(x,end_y)).release().perform();

    }

    protected void swipeUpQuick(){
        swipeUp(1);
    }

    protected void swipeUptoFindElement(By by, String error_message, int max_swipes){

        int swipes = 0;
        while(driver.findElements(by).size()==0){
            if(swipes>max_swipes){
                waitForElementPresent(by,
                        "Cannot find element by swipping up  \n" + error_message,
                        0);
                return;
            }
            swipeUpQuick();
            ++swipes;
        }
    }


    protected void swipeElementToLeft(By by, String error_message){
        WebElement element = waitForElementPresent(by, error_message,10);
        int left_x =element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y+lower_y)/2;

        TouchAction action = new TouchAction(driver);
        action
                .press(point(right_x,middle_y))
                .waitAction(waitOptions(ofMillis(300)))
                .moveTo(point(left_x,middle_y)).release().perform();


    }



}
