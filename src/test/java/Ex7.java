import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.URL;

public class Ex7 {
    public static AppiumDriver driver;


    @BeforeAll
    public static void setUp() throws Exception {
        System.out.println("Hello");

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

    }

    //Перед каждым тестом положение экрана телефона будет переводиться в исходное состояние
    @BeforeEach
    public void setRotation() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    //пример теста 2. Тест запустится с экраном в положении "Портрет"
    @Test
    public void checkSkipButton(){
        WebElement element = driver.findElement(By.xpath("//*[contains(@text,'SKIP')]"));
        Assert.assertTrue("Cannot find the button 'SKIP'",
                element.isDisplayed());

    }
    //пример теста 1. Даже если он упадет, перед запуском второго теста экран примет положение Портрет
    @Test
    public void checkTheLanguage(){
        driver.rotate(ScreenOrientation.LANDSCAPE);
        WebElement element = driver.findElement(By.id("org.wikipedia:id/option_label"));
        Assert.assertTrue("Cannot find the language 'english",
                element.isDisplayed());
    }
}
