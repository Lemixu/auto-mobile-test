package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class Ex6 extends CoreTestCase {

    @Test
    @Features(value={@Feature(value="Search"), @Feature(value="Article")})
    @DisplayName("Test that the article title is present")
    @Severity(value= SeverityLevel.CRITICAL)
    public void testAttributeTitleIsPresent(){

        String searchLine = "Java";
        SearchPageObject search = SearchPageObjectFactory.get(driver);
        ArticlePageObject article = ArticlePageObjectFactory.get(driver);
        this.implicitlyWait(10);

        search.initSearchInput();
        search.typeSearchLine(searchLine);
        search.clickByArticleWithSubstring(searchLine);
        article.assertTitleOfArticleIsPresent(searchLine);

    }


}