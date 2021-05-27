package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    @Test
    public void testSearch() {
        SearchPageObject search = SearchPageObjectFactory.get(driver);

        search.initSearchInput();
        search.typeSearchLine("Java");
        search.waitForSearchResult("bject-oriented programming language");
    }

    @Test
    public void testCancelSearch(){
        SearchPageObject search =SearchPageObjectFactory.get(driver);

        search.initSearchInput();
        search.typeSearchLine("Java");
        search.waitForSearchResult("bject-oriented programming language");
        search.waitForCancelButtonToAppear();
        search.clickCancelButton();
        search.waitForCancelButtonToDisappear();
    }

    @Test
    public void testAmountOfNotEmptySearch(){

        SearchPageObject search = SearchPageObjectFactory.get(driver);
        String searchLine = "Hippo";

        search.initSearchInput();
        search.typeSearchLine(searchLine);
        int amount_of_search_results = search.getAmountOfFoundArticles();

        assertTrue(
                "We found too few results!",
                amount_of_search_results>0);

    }

    @Test
    public void testAmountOfEmptySearch(){

        SearchPageObject search = SearchPageObjectFactory.get(driver);
        String searchLine = "afrtldml";

        search.initSearchInput();
        search.typeSearchLine(searchLine);
        search.waitForEmptyResultsLabel();
        //search.assertThereIsNoResultOfSearch();
    }
}
