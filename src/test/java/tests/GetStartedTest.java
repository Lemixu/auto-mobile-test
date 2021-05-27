package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
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
