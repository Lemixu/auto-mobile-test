package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for search")
public class SearchTests extends CoreTestCase {

    @Test
    @Feature(value = "Search")
    @DisplayName("Testing search by entering some text in the search line")
    @Severity(value=SeverityLevel.BLOCKER)
    public void testSearch() {
        SearchPageObject search = SearchPageObjectFactory.get(driver);

        search.initSearchInput();
        search.typeSearchLine("Java");
        search.waitForSearchResult("bject-oriented programming language");
    }

    @Test
    @Feature(value = "Search")
    @DisplayName("Test to cancel the search result")
    @Severity(value=SeverityLevel.NORMAL)
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
    @Feature(value = "Search")
    @DisplayName("Test tha search result not empty")
    @Severity(value=SeverityLevel.BLOCKER)
    public void testAmountOfNotEmptySearch(){

        SearchPageObject search = SearchPageObjectFactory.get(driver);
        String searchLine = "Hippo";

        search.initSearchInput();
        search.typeSearchLine(searchLine);
        int amount_of_search_results = search.getAmountOfFoundArticles();

        Assert.assertTrue(
                "We found too few results!",
                amount_of_search_results>0);

    }

    @Test
    @Feature(value = "Search")
    @DisplayName("Test that search result is empty")
    @Severity(value=SeverityLevel.NORMAL)
    public void testAmountOfEmptySearch(){

        SearchPageObject search = SearchPageObjectFactory.get(driver);
        String searchLine = "afrtldml";

        search.initSearchInput();
        search.typeSearchLine(searchLine);
        search.waitForEmptyResultsLabel();
        //search.assertThereIsNoResultOfSearch();
    }
}
