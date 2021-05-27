package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {

    @Test
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

        assertEquals("Article title have been change after screen rotation",
                title_before_rotation,
                title_after_rotation);

        this.rotateScreenPortrait();

        String title_after_second_rotation = article.getArticleTitle();

        assertEquals("Article title have been change after screen rotation",
                title_after_rotation,
                title_after_second_rotation);

    }

    @Test
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
