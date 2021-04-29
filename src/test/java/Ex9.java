import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex9 extends CoreTestCase {

    @Test
    public void testFindResultByTitleAndDescription(){

        String title1 = "Java";
        String description1 = "Indonesian island";
        String title2 = "JavaScript";
        String description2 = "High-level programming language";
        String title3 = "Java (programming language)";
        String description3 = "Object-oriented programming language";
        SearchPageObject search = new SearchPageObject(driver);
        String searchLine = "Java";

        search.initClickSkip();
        search.initSearchInput();
        search.typeSearchLine(searchLine);
        search.waitForElementByTitleAndDescription(title1,description1);
        search.waitForElementByTitleAndDescription(title2,description2);
        search.waitForElementByTitleAndDescription(title3, description3);
    }
}
