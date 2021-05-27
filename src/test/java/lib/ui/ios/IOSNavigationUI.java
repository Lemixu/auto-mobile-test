package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUI extends NavigationUI {

    static {
        SAVED_BUTTON = "id:Saved";
    }


    public IOSNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
