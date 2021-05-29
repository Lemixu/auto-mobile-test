package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        ARTICLE_TITLE = "css:#content h1";
        FOOTER_ELEMENT = "xpath://ul[@id='footer-places']";
        SAVE_BUTTON = "css:#ca-watch";

        VIEW_LIST_BUTTON = "id:org.wikipedia:id/snackbar_action";
        ADD_TO_LIST_BUTTON = "xpath://a[text()='Watch']";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "xpath://a[text()='Unwatch']";
    }

}
