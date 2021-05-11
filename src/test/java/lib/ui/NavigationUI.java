package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class NavigationUI extends MainPageObject {

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    protected static String
            SAVED_BUTTON,
            BACK_BUTTON;

    public void clickMyLists() {
        this.waitForElementAndClick(
                SAVED_BUTTON,
                "Cannot find the button 'Saved'",
                5);
    }

    public void clickBackButton() {
        this.waitForElementAndClick(
                BACK_BUTTON,
                "Cannot find the button 'Navigate up'",
                5);
    }

}
