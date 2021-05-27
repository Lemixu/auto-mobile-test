package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListPageObject extends MyListsPageObject {

    static {
        ARTICLE_IN_FOLDER_TPL = "xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}']";
        DELETE_BUTTON = "id:swipe action delete";
        FOLDER_NAME_TPL = "xpath://XCUIElementTypeStaticText[contains(@name, '{SUBSTRING}')]";
    }


    public IOSMyListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
