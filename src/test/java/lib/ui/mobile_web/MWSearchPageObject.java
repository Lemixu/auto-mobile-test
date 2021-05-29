package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject  extends SearchPageObject {

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    static {
        SEARCH_INPUT = "css:button#searchIcon";
        //BUTTON_SKIP = "css:button.cancel";
        SEARCH_INPUT_ACTIVE = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.clear";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(text(), '{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath://li/a/h3";
        EMPTY_RESULT_LABEL = "css:p.without-results";
        PAGE_LIST_ITEM = "xpath://a[./div[contains(text(), '{DESCRIPTION}')]]/h3/strong[contains(text(), '{TITLE}')]";
    }

}
