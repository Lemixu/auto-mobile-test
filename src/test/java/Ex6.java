import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class Ex6 extends CoreTestCase {

    @Test
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