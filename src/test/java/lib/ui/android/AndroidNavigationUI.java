package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class AndroidNavigationUI extends NavigationUI {

    static {
        SAVED_BUTTON = "xpath://android.widget.FrameLayout[@content-desc='Saved']";
        BACK_BUTTON = "xpath://android.widget.ImageButton";
    }


    public AndroidNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}
