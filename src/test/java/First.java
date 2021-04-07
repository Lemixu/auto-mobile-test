import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

public class First {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {

        File f = new File("apks");
        File fc = new File(f, "org.wikipedia.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        //capabilities.setCapability("app", "/Users/a18740877/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");
        capabilities.setCapability("app", fc.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find the button 'SKIP'",
                5);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /*@Test
    public void firstTest() {


        waitForElementAndClick(
                By.xpath("//androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']"),
                "Cannot find search input",
                5);

        waitForElementAndSenKeys(
                By.xpath("//android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']"),
                "Java",
                "Cannot find search input",
                5);

        waitForElementPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' searching by 'Java'",
                15);
    }
    @Test
    public void testCancelSearch(){


        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find search input",
                5);

        waitForElementAndSenKeys(
                By.id("org.wikipedia:id/search_container"),
                "Jaaajaja",
                "Cannot find search input",
                5);

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find search input",
                5);

        waitForElementAndSenKeys(
                By.id("org.wikipedia:id/search_container"),
                "J",
                "Cannot find search input",
                5);

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find close button",
                5);

        waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "Close button still present on the page",
                5);
    }

    @Test
    public void testCompareArticleTitle() {


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

        WebElement title_element =
                waitForElementPresent(
                        By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
                        "Cannot find text 'Java (programming language)'",
                        15);

       String article_title = title_element.getAttribute("name");

        Assert.assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title);

    } */


    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    public WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSenKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }


    public boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementAndClear(By by, String error_message, long timeoutsInSecond) {
        WebElement element = waitForElementPresent(by, error_message, timeoutsInSecond);
        element.clear();
        return element;
    }


}
