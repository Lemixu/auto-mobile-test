import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex3 extends CoreTestCase {


    @Test
    public void testCancelSearch() {

        SearchPageObject search = new SearchPageObject(driver);
        String searchLine = "Java";

        search.initClickSkip();
        search.initSearchInput();
        search.typeSearchLine(searchLine);
        search.waitForSearchResult(searchLine);
        int count = search.getAmountOfFoundArticles();
        assertTrue("Count of articles dont more than 1",count > 1);
        search.clickCancelButton();
        search.assertThereIsNoResultOfSearch();
    }

}
