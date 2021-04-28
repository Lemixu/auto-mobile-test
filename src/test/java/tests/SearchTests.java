package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    @Test
    public void testSearch() {
        SearchPageObject search =new SearchPageObject(driver);

        search.initClickSkip();
        search.initSearchInput();
        search.typeSearchLine("Java");
        search.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCancelSearch(){
        SearchPageObject search =new SearchPageObject(driver);

        search.initClickSkip();
        search.initSearchInput();
        search.typeSearchLine("Java");
        search.waitForCancelButtonToAppear();
        search.clickCancelButton();
        search.waitForCancelButtonToDisappear();
    }

    @Test
    public void testAmountOfNotEmptySearch(){

        SearchPageObject search = new SearchPageObject(driver);
        String searchLine = "Hippo";

        search.initClickSkip();
        search.initSearchInput();
        search.typeSearchLine(searchLine);
        int amount_of_search_results = search.getAmountOfFoundArticles();

        assertTrue(
                "We found too few results!",
                amount_of_search_results>0);

    }

    @Test
    public void testAmountOfEmptySearch(){

        SearchPageObject search = new SearchPageObject(driver);
        String searchLine = "afrtldml";

        search.initClickSkip();
        search.initSearchInput();
        search.typeSearchLine(searchLine);
        search.waitForEmptyResultsLabel();
        search.assertThereIsNoResultOfSearch();
    }
}
