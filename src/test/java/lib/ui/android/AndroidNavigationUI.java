package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUI {

    static {
        SAVED_BUTTON = "xpath://android.widget.FrameLayout[@content-desc='Saved']";
        BACK_BUTTON = "xpath://android.widget.ImageButton";
    }


    public AndroidNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
