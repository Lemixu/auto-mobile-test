package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Platform {

    private static final String
            PLATFORM_IOS = "ios",
            PLATFORM_ANDROID = "android",
            APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    //singleton
    private static Platform instance;
    private Platform() {}
    public static Platform getInstance() {
        if(instance==null) {
            instance = new Platform();
        }
        return instance;
    }


    public AppiumDriver getDriver() throws Exception {
        URL URL = new URL(APPIUM_URL);
        if(this.isAndroid()) {
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        }
        else if(this.isIOS()) {
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());
        } else {
            throw new Exception("Cannot detect type of the driver  Platform value: " + this.getPlatformVar());
        }

    }

    public boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS() {
        return isPlatform(PLATFORM_IOS);
    }


    private DesiredCapabilities getAndroidDesiredCapabilities(){
        File f = new File("apks");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        File fc = new File(f, "org.wikipedia.apk");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", fc.getAbsolutePath());
        return capabilities;

    }

    private DesiredCapabilities getIOSDesiredCapabilities() {
        File f = new File("apks");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        File fc = new File(f, "Wikipedia-2.app");

        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("deviceName", "iPhone 12 Pro");
        capabilities.setCapability("platformVersion", "14.4");
        capabilities.setCapability("app", fc.getAbsolutePath());

        return capabilities;

    }

    private String getPlatformVar() {
        return System.getenv("PLATFORM");
    }

    private Boolean isPlatform(String my_platform) {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }



}
