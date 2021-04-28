package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    private static final String
    SAVED_BUTTON = "//android.widget.FrameLayout[@content-desc='Saved']",
    BACK_BUTTON = "//android.widget.ImageButton";

    public void clickMyLists(){
        this.waitForElementAndClick(
                By.xpath(SAVED_BUTTON),
                "Cannot find the button 'Saved'",
                5);
    }

    public void clickBackButton(){
        this.waitForElementAndClick(
                By.xpath(BACK_BUTTON),
                "Cannot find the button 'Navigate up'",
                5);
    }
}
