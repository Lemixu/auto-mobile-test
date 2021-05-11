package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class AndroidMyListPageObject extends MyListsPageObject {

    static {
        FOLDER_NAME_TPL = "xpath://android.widget.TextView[@text='{SUBSTRING}']";
        ARTICLE_IN_FOLDER_TPL = "xpath://*[@text='{SUBSTRING}']";
        DOWNLOAD_LIST_ICON = "id:org.wikipedia:id/page_list_item_action";
    }


    public AndroidMyListPageObject(AppiumDriver driver) {
        super(driver);
    }
}
