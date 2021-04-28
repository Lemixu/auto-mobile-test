import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex6 extends CoreTestCase {

    @Test
    public void testAttributeTitleIsPresent(){

        String searchLine = "Java";
        SearchPageObject search = new SearchPageObject(driver);
        ArticlePageObject article = new ArticlePageObject(driver);
        this.implicitlyWait(10);


        search.initClickSkip();
        search.initSearchInput();
        search.typeSearchLine(searchLine);
        search.clickByArticleWithSubstring(searchLine);
        article.assertTitleOfArticleIsPresent(searchLine);

    }


}