package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTest extends CoreTestCase {

    @Test
    public void testCompareArticleTitle() {
        SearchPageObject search = SearchPageObjectFactory.get(driver);
        ArticlePageObject article = ArticlePageObjectFactory.get(driver);
        String title = "Java (programming language)";

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
        SearchPageObject search = SearchPageObjectFactory.get(driver);
        ArticlePageObject article = ArticlePageObjectFactory.get(driver);
        String title = "Object-oriented programming language";

        search.initSearchInput();
        search.typeSearchLine("Java");
        search.clickByArticleWithSubstring(title);
        article.waitForTitleElement(title);
        article.swipeToFooter();

    }
}
