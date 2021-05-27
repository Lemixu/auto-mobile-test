package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject  extends ArticlePageObject {

    static {
            ARTICLE_TITLE = "xpath://android.view.View[@content-desc='{SUBSTRING}']";
            FOOTER_ELEMENT = "xpath://android.view.View[@content-desc='View article in browser']";
            SAVE_BUTTON = "id:org.wikipedia:id/article_menu_bookmark";
            ADD_TO_LIST_BUTTON = "id:org.wikipedia:id/snackbar_action";
            OK_BUTTON = "id:android:id/button1";
            GO_BACK_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
            NAME_OF_EXIST_LIST = "xpath://android.widget.TextView[@text='{SUBSTRING}']";
            VIEW_LIST_BUTTON = "id:org.wikipedia:id/snackbar_action";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
