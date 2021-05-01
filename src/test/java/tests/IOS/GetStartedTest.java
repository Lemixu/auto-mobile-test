package tests.IOS;

import lib.CoreTestCase;
import lib.IOSTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome(){

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
