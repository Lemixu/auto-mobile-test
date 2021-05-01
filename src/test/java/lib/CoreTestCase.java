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
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CoreTestCase extends TestCase {


    public AppiumDriver driver;
    String AppiumUrl = "http://127.0.0.1:4723/wd/hub";
    private static final String
            PLATFORM_IOS = "ios",
            PLATFORM_ANDROID = "android";

    /*@BeforeAll
    public void runEmulator() throws IOException, InterruptedException {

        String cmd = "emulator @device1 -dns-server 8.8.8.8";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        while ((line = buf.readLine()) != null) {
            System.out.println(line);
        }
    } */


    @Override
    protected void setUp() throws Exception {

        super.setUp();

      //  File f = new File("apks");

        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();
        driver = getDriver();
       // this.rotateScreenPortrait();


    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();

    }

    protected void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds) {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

    protected void implicitlyWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");

        File f = new File("apks");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equals(PLATFORM_ANDROID)) {

            File fc = new File(f, "org.wikipedia.apk");

            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidTestDevice");
            capabilities.setCapability("platformVersion", "8.1");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("app", fc.getAbsolutePath());

        } else if (platform.equals(PLATFORM_IOS)) {

            File fc = new File(f, "Wikipedia-2.app");

            capabilities.setCapability("platformName", "IOS");
            capabilities.setCapability("deviceName", "iPhone 12 Pro");
            capabilities.setCapability("platformVersion", "14.4");
            capabilities.setCapability("app", fc.getAbsolutePath());

        } else {
            throw new Exception("Cannot get run platform from env variable. Platform value: " + platform);
        }

        return capabilities;


    }

    /*private File setFile() throws Exception {
        String platform = System.getenv("PLATFORM");
        File f = new File("apks");
        File fc;
        if (platform.equals("android")) {
            fc = new File(f, "org.wikipedia.apk");
        } else if (platform.equals("ios")) {
            fc = new File(f, "Wikipedia-2.app");
        } else {
            throw new Exception("Cannot get run platform from env variable. Platform value: " + platform);
        }
        return fc;
    } */

    private AppiumDriver getDriver() throws Exception {
        AppiumDriver driver;
        String platform = System.getenv("PLATFORM");

        if (platform.equals(PLATFORM_ANDROID)) {
            driver = new AndroidDriver(new URL(AppiumUrl), this.getCapabilitiesByPlatformEnv());
        } else if (platform.equals(PLATFORM_IOS)) {
            driver = new IOSDriver(new URL(AppiumUrl), this.getCapabilitiesByPlatformEnv());
        } else {
            throw new Exception("Cannot get run platform from env variable. Platform value: " + platform);
        }
        return driver;

    }
}




