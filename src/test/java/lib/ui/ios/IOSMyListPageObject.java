package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IOSMyListPageObject extends MyListsPageObject {

    static {
        ARTICLE_IN_FOLDER_TPL = "xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}']";
        DELETE_BUTTON = "id:swipe action delete";
        FOLDER_NAME_TPL = "xpath://XCUIElementTypeStaticText[contains(@name, '{SUBSTRING}')]";
    }


    public IOSMyListPageObject(AppiumDriver driver) {
        super(driver);
    }
}
