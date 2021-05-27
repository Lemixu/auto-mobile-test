package lib.ui;


import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class NavigationUI extends MainPageObject {

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    protected static String
            SAVED_BUTTON,
            BACK_BUTTON,
            OPEN_NAVIGATION;

    public void clickMyLists() {
        if(Platform.getInstance().isMW()){
            this.tryClickElementWithFewAttempts(
                    SAVED_BUTTON,
                    "Cannot find navigation button to My List",
                    5);
        }
        else {
            this.waitForElementAndClick(
                    SAVED_BUTTON,
                    "Cannot find the button 'Saved'",
                    5);
        }
    }

    public void clickBackButton() {
        this.waitForElementAndClick(
                BACK_BUTTON,
                "Cannot find the button 'Navigate up'",
                5);
    }

    public void openNavigation() {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION,
                    "Cannot  find and click open navigation button",
                    5);
        } else {
            System.out.println("Method openNavigation() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

}
