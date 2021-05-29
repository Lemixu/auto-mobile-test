package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for change app conditions")
public class ChangeAppConditionTests extends CoreTestCase {


    @Test
    @Features(value={@Feature(value="Search"), @Feature(value="Article")})
    @DisplayName("check article title after changing screen rotation")
    @Severity(value= SeverityLevel.MINOR)
    public void testChangeOrientation(){

        if(Platform.getInstance().isMW()){
            return;
        }
        String searchLine = "Java";
        String search_result_locator ="//*[@resource-id=\"org.wikipedia:id/page_list_item_title\"]";
        SearchPageObject search = SearchPageObjectFactory.get(driver);
        ArticlePageObject article = ArticlePageObjectFactory.get(driver);

        search.initSearchInput();
        search.typeSearchLine(searchLine);
        search.clickByArticleWithSubstring(searchLine);

        String title_before_rotation = article.getArticleTitle();

        this.rotateScreenLandscape();

        String title_after_rotation = article.getArticleTitle();

        Assert.assertEquals("Article title have been change after screen rotation",
                title_before_rotation,
                title_after_rotation);

        this.rotateScreenPortrait();

        String title_after_second_rotation = article.getArticleTitle();

        Assert.assertEquals("Article title have been change after screen rotation",
                title_after_rotation,
                title_after_second_rotation);

    }

    @Test
    @Features(value={@Feature(value="Search"), @Feature(value="Article")})
    @DisplayName("check the search result after sending the app to background")
    @Description("firstly enter the search word to search line^ wait the search results and send the app to background")
    @Severity(value= SeverityLevel.MINOR)
    public void testCheckSearchArticleInBackground(){
        String searchLine = "Java";
        String search_result_locator ="//android.widget.TextView[@text='Java (programming language)']";
        SearchPageObject search = SearchPageObjectFactory.get(driver);

        search.initSearchInput();
        search.typeSearchLine(searchLine);
        search.waitForSearchResult(searchLine);
        this.backgroundApp(2);
        search.waitForSearchResult(searchLine);
    }

}
