package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTest extends CoreTestCase {

    @Test
    public void testCompareArticleTitle() {
        SearchPageObject search =new SearchPageObject(driver);
        ArticlePageObject article = new ArticlePageObject(driver);
        String title = "Java (programming language)";

        search.initClickSkip();
        search.initSearchInput();
        search.typeSearchLine("Java");
        search.clickByArticleWithSubstring(title);
        article.waitForTitleElement(title);
        String article_title = article.getArticleTitle(title);

        assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title);

    }

    @Test
    public void testSwipeArticle() {
        SearchPageObject search = new SearchPageObject(driver);
        ArticlePageObject article = new ArticlePageObject(driver);
        String title = "Appium";

        search.initClickSkip();
        search.initSearchInput();
        search.typeSearchLine("Appium");
        search.clickByArticleWithSubstring(title);
        article.waitForTitleElement(title);
        article.swipeToFooter();

    }
}
