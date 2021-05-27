package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INPUT = "id:Search Wikipedia";
        BUTTON_SKIP = "id:Skip";
        SEARCH_INPUT_ACTIVE = "xpath:(//XCUIElementTypeSearchField)[2]";
        SEARCH_CANCEL_BUTTON = "id:Close";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name, '{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeCell";
        EMPTY_RESULT_LABEL = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        PAGE_LIST_ITEM = "xpath://XCUIElementTypeOther[" +
                "./XCUIElementTypeStaticText[@name='{TITLE}']]" +
                "/XCUIElementTypeStaticText[@name='{DESCRIPTION}']";
    }

    //XCUIElementTypeOther[./XCUIElementTypeStaticText[@name="Java"]]/XCUIElementTypeStaticText[@name="Island of Indonesia"]/..
    public IOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
