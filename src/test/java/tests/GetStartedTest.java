package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;

@Epic("Welcome page")
public class GetStartedTest extends CoreTestCase {

    @Test
    @DisplayName("Pass through wolcome pages")
    @Description("check some links on welcome screens and click next button")
    @Severity(value= SeverityLevel.NORMAL)
    public void testPassThroughWelcome(){

        if((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMW()))  {
            return;
        }
        WelcomePageObject welcome = new WelcomePageObject(driver);

        welcome.waitMoreAboutWiki();
        welcome.clickNextButton();

        welcome.waitForNewWaysToExploreText();
        welcome.clickNextButton();

        welcome.waitAddLanguages();
        welcome.clickNextButton();

        welcome.waitLearnMore();
        welcome.clickGetStartedButton();

    }
}
