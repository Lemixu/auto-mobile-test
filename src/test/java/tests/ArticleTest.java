package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for articles")
public class ArticleTest extends CoreTestCase {

    @Test
    @Features(value={@Feature(value="Search"), @Feature(value="Article")})
    @DisplayName("Compare article title with expected one")
    @Description("Проверяем, что статья совпадает с ожидаемым результатом")
    @Step("Starting test testCompareArticleTitle")
    @Severity(value=SeverityLevel.BLOCKER)
    public void testCompareArticleTitle() {
        SearchPageObject search = SearchPageObjectFactory.get(driver);
        ArticlePageObject article = ArticlePageObjectFactory.get(driver);
        String title = "bject-oriented programming language";

        search.initSearchInput();
        search.typeSearchLine("Java");
        search.clickByArticleWithSubstring(title);
        article.waitForTitleElement(title);
        String article_title = article.getArticleTitle();

        //article.takeScreenshot("article_page");
        Assert.assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title);

    }

    @Test
    @Features(value={@Feature(value="Search"), @Feature(value="Article")})
    @DisplayName("Swipe article to the footer")
    @Description("Свайпаем нашу статью, пока не дойдем до футера")
    @Step("Starting test testSwipeArticle")
    @Severity(value=SeverityLevel.MINOR)
    public void testSwipeArticle() {
        SearchPageObject search = SearchPageObjectFactory.get(driver);
        ArticlePageObject article = ArticlePageObjectFactory.get(driver);
        String title = "bject-oriented programming language";

        search.initSearchInput();
        search.typeSearchLine("Java");
        search.clickByArticleWithSubstring(title);
        article.waitForTitleElement("Java");
        article.swipeToFooter();

    }
}
