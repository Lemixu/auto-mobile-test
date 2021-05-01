package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    private static final String
    SAVED_BUTTON = "xpath://android.widget.FrameLayout[@content-desc='Saved']",
    BACK_BUTTON = "xpath://android.widget.ImageButton";

    public void clickMyLists(){
        this.waitForElementAndClick(
                SAVED_BUTTON,
                "Cannot find the button 'Saved'",
                5);
    }

    public void clickBackButton(){
        this.waitForElementAndClick(
                BACK_BUTTON,
                "Cannot find the button 'Navigate up'",
                5);
    }
}
