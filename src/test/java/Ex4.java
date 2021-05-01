import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public class Ex4 extends CoreTestCase {
    private lib.ui.MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }
    String inputText = "JAVA";

    @Test
    public void checkWordsInSearch() { /*
        MainPageObject.waitForElementAndClick(
                By.xpath("//androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']"),
                "Cannot find search input",
                5);
        MainPageObject.waitForElementAndSenKeys(
                By.xpath("//android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']"),
                inputText,
                "Cannot find search input",
                5);

        MainPageObject.waitForElementPresent(By.id("org.wikipedia:id/page_list_item_title"),
                "Cannot find articles",
                15);

        int count = driver.findElements(By.id("org.wikipedia:id/page_list_item_title")).size();

        List<WebElement> element_title = driver.findElementsByXPath(
                "//android.widget.TextView[contains(@text, '" + firstUpperCase(inputText) + "')]");
        Assert.assertEquals("There are some articles without input word",
                count, element_title.size());


    }

    public String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "Input word is empty";
        word = word.toLowerCase(Locale.ROOT);
        return word.substring(0, 1).toUpperCase() + word.substring(1); */
    }


}
