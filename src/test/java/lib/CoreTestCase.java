package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.openqa.selenium.ScreenOrientation;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CoreTestCase extends TestCase {


    public AppiumDriver driver;


    @Override
    protected void setUp() throws Exception {

        super.setUp();
        driver = Platform.getInstance().getDriver();
       // this.rotateScreenPortrait();
        this.skipWelcomePage();
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

    protected void skipWelcomePage() {
        SearchPageObject welcome = SearchPageObjectFactory.get(driver);
        welcome.initClickSkip();
    }



}




