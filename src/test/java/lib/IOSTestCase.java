package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class IOSTestCase extends TestCase {


    public AppiumDriver driver;
    String AppiumUrl = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception {

        super.setUp();

        File f = new File("apks");
        File fc = new File(f, "Wikipedia-2.app");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("deviceName", "iPhone 12 Pro");
        capabilities.setCapability("platformVersion", "14.4");
        capabilities.setCapability("app", fc.getAbsolutePath());

        driver = new IOSDriver(new URL(AppiumUrl), capabilities);


        this.rotateScreenPortrait();


    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();

    }

    protected void rotateScreenPortrait(){
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
    protected void rotateScreenLandscape(){
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds) {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

    protected void implicitlyWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

}
