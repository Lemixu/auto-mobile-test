package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import sun.security.krb5.internal.TGSRep;

public class Ex3 extends CoreTestCase {


    @Test
    @Feature(value = "Search")
    @DisplayName("Test cancel search result")
    @Severity(value= SeverityLevel.CRITICAL)
    public void testCancelSearch() throws InterruptedException {

        SearchPageObject search = SearchPageObjectFactory.get(driver);
        String searchLine = "Java";

        search.initSearchInput();
        search.typeSearchLine(searchLine);
        search.waitForSearchResult(searchLine);
        int count = search.getAmountOfFoundArticles();
        Assert.assertTrue("Count of articles dont more than 1",count > 1);
        search.clickCancelButton();
        driver.navigate().refresh();
        search.assertThereIsNoResultOfSearch();
    }

}
