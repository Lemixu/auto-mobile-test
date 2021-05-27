package lib;


import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CoreTestCase extends TestCase {

    //export PLATFORM=android; mvn -Dtest=ArticleTest#testCompareArticleTitle test
    //brew services start jenkins-lts


    public RemoteWebDriver driver;
    protected static Properties prop;


    @Override
    protected void setUp() throws Exception {

        super.setUp();
        driver = Platform.getInstance().getDriver();
       // this.rotateScreenPortrait();
        this.initProperties();
        this.openWikiWebPageForMobileWeb();

        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.skipWelcomePage();
        }

    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();

    }

    protected void rotateScreenPortrait() {

        if(driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateScreenPorttrait() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }


    }

    protected void rotateScreenLandscape() {

        if(driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateScreenLandscape() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void backgroundApp(int seconds) {
        if(driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(Duration.ofSeconds(seconds));
        } else {
            System.out.println("Method backgroundApp() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void implicitlyWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    protected void skipWelcomePage() {

        SearchPageObject welcome = SearchPageObjectFactory.get(driver);
        welcome.initClickSkip();
    }

    protected void initProperties() throws IOException {
        prop = new Properties();
        FileInputStream fis=new FileInputStream("src/test/java/testData/data.properties");
        prop.load(fis);
    }

    protected void openWikiWebPageForMobileWeb() {
        if(Platform.getInstance().isMW()) {
            driver.get("https://en.m.wikipedia.org");
        } else {
            System.out.println("Method openWikiWebPageForMobileWeb() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }


}




