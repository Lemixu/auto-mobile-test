package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUi extends NavigationUI {

    public MWNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        SAVED_BUTTON = "css:a[data-event-name='menu.unStar']";
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";

    }
}
