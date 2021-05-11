package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INPUT = "id:Search Wikipedia";
        BUTTON_SKIP = "id:Skip";
        SEARCH_INPUT_ACTIVE = "xpath:(//XCUIElementTypeSearchField)[2]";
        SEARCH_CANCEL_BUTTON = "id:Close";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name, '{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeCell";
        EMPTY_RESULT_LABEL = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        /*PAGE_LIST_ITEM =
                "xpath://android.view.ViewGroup[" +
                        "./android.widget.TextView[@text='{TITLE}']]" +
                        "/android.widget.TextView[@text='{DESCRIPTION}']"; */
    }

    public IOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
