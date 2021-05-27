package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListPageObject extends MyListsPageObject {

    public MWMyListPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        ARTICLE_IN_FOLDER_TPL = "xpath://li[@title='{SUBSTRING}']//h3";
        REMOVE_FROM_SAVED_BUTTON = "xpath://li[@title='{SUBSTRING}']//a[contains(@class, 'watched')]";
    }

}
