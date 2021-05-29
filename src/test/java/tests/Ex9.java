package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class Ex9 extends CoreTestCase {

    @Test
    @Feature(value = "Search")
    @DisplayName("Test the search result bu title abd description")
    @Severity(value= SeverityLevel.NORMAL)
    public void testFindResultByTitleAndDescription(){

        String title1 = prop.getProperty("title1");
        String description1 = prop.getProperty("description1");
        String title2 = prop.getProperty("title2");
        String description2 = prop.getProperty("description2");
        String title3 = prop.getProperty("title3");
        String description3 = prop.getProperty("description3");
        SearchPageObject search = SearchPageObjectFactory.get(driver);
        String searchLine = prop.getProperty("searchLine");

        search.initSearchInput();
        search.typeSearchLine(searchLine);
        search.waitForElementByTitleAndDescription(title1,description1);
        search.waitForElementByTitleAndDescription(title2,description2);
        search.waitForElementByTitleAndDescription(title3, description3);
    }
}
