package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {
    static {
        ARTICLE_TITLE = "id:{SUBSTRING}";
        FOOTER_ELEMENT = "id:View article in browser";
        SAVE_BUTTON = "id:Save for later";
        GO_BACK_BUTTON = "id:Back";
        NAME_OF_EXIST_LIST = "xpath://android.widget.TextView[@text='{SUBSTRING}']";
        VIEW_LIST_BUTTON = "id:org.wikipedia:id/snackbar_action";
        CLOSE_BANNER_BUTTON = "id:places auth close";
    }

    public IOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
