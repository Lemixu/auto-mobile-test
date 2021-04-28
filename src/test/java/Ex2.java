import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Ex2 extends CoreTestCase {
    private lib.ui.MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    public void assertElementHasText(By by, String expected, String error_message) {
        WebElement element = MainPageObject.waitForElementPresent(by, error_message, 5);
        String element_text =element.getAttribute("text");
        Assert.assertEquals(
                error_message,
                expected,
                element_text);
    }

    @Test
    public void checkTextInSearchInput(){
        assertElementHasText(
                By.xpath("//android.widget.TextView[@text='Search Wikipedia']"),
                "Search Wikipedia",
                "We see unexpected text");
    }
    }



