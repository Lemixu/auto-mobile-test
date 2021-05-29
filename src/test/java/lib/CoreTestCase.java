package lib;


import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import junit.framework.TestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CoreTestCase {

    //export PLATFORM=android; mvn -Dtest=ArticleTest#testCompareArticleTitle test
    //brew services start jenkins-lts


    public RemoteWebDriver driver;
    protected static Properties prop;


    @Before
    @Step("Run driver and session")
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
        this.createAllurePropertyFile();
       // this.rotateScreenPortrait();
        this.initProperties();
        this.openWikiWebPageForMobileWeb();

        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.skipWelcomePage();
        }

    }

    @After
    @Step("Remove driver and session")
    public void tearDown(){
        driver.quit();

    }

    @Step("Rotate screen to portrait mode")
    protected void rotateScreenPortrait() {

        if(driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateScreenPorttrait() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }


    }

    @Step("Rotate screen to landscape mode")
    protected void rotateScreenLandscape() {

        if(driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateScreenLandscape() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Send mobile app to background (Dont work for MW)")
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

    @Step("Skip welcome page")
    protected void skipWelcomePage() {

        SearchPageObject welcome = SearchPageObjectFactory.get(driver);
        welcome.initClickSkip();
    }

    protected void initProperties() throws IOException {
        prop = new Properties();
        FileInputStream fis=new FileInputStream("src/test/java/testData/data.properties");
        prop.load(fis);
    }

    @Step("Open Wiki URL for Mobile Web")
    protected void openWikiWebPageForMobileWeb() {
        if(Platform.getInstance().isMW()) {
            driver.get("https://en.m.wikipedia.org");
        } else {
            System.out.println("Method openWikiWebPageForMobileWeb() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    private void createAllurePropertyFile(){
        String path = System.getProperty("allure.results.directory");
        try {
            Properties props =  new Properties();
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            props.setProperty("Environment", Platform.getInstance().getPlatformVar());
            props.store(fos,  "See https://docs.qameta.io/allure/#_environment");
            fos.close();
        } catch (Exception e){
            System.err.println("IO problem  when whriting allure properties file");
            e.printStackTrace();

        }
    }


}




