package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject {

    public WelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    private static final String
    LEARN_MORE_LINK = "xpath://XCUIElementTypeStaticText[@name=\"Learn more about Wikipedia\"]",
    NEXT_BUTTON = "id:Next",
    NEW_WAYS_TO_EXPLORE = "xpath://XCUIElementTypeStaticText[@name=\"New ways to explore\"]",
    ADD_PREFERRED_LANGUAGES = "xpath://XCUIElementTypeStaticText[@name=\"Add or edit preferred languages\"]",
    LEARN_MORE_ABOUT_DATA = "xpath://XCUIElementTypeStaticText[@name=\"Learn more about data collected\"]",
    GET_STARTED_BUTTON = "xpath://XCUIElementTypeStaticText[@name=\"Get started\"]";


    public void waitMoreAboutWiki() {
        this.waitForElementPresent(
                LEARN_MORE_LINK,
                "Cannot find 'Learn more about Wikipedia' link",
                10);
    }


    public void clickNextButton() {
        this.waitForElementAndClick(
                NEXT_BUTTON,
                "Cannot find Next button",
                10);
    }

    public void waitForNewWaysToExploreText() {
        this.waitForElementPresent(
                NEW_WAYS_TO_EXPLORE,
                "Cannot find text 'For new ways to explore'",
                10);
    }

    public void waitAddLanguages() {
        this.waitForElementPresent(
                ADD_PREFERRED_LANGUAGES,
                "Cannot find 'Add preferred languages url'",
                10);
    }


    public void waitLearnMore() {
        this.waitForElementPresent(
                LEARN_MORE_ABOUT_DATA,
                "Cannot find 'Learn more about data collected'",
                10);
    }


    public void clickGetStartedButton() {
        this.waitForElementAndClick(
                GET_STARTED_BUTTON,
                "Cannot find 'Get started' button",
                10);
    }




}
