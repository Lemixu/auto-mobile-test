package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INPUT = "xpath://androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']";
        BUTTON_SKIP = "xpath://*[contains(@text,'SKIP')]";
        SEARCH_INPUT_ACTIVE = "xpath://android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://android.widget.TextView[@text='{SUBSTRING}']";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id=\"org.wikipedia:id/page_list_item_title\"]";
        EMPTY_RESULT_LABEL = "xpath://*[@text='No results']";
        PAGE_LIST_ITEM =
                "xpath://android.view.ViewGroup[" +
                        "./android.widget.TextView[@text='{TITLE}']]" +
                        "/android.widget.TextView[@text='{DESCRIPTION}']";
    }

    public AndroidSearchPageObject(AppiumDriver driver) {
        super(driver);
    }


}
