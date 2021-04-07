import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Ex2 extends First{

    public void assertElementHasText(By by, String expected, String error_message) {
        WebElement element = waitForElementPresent(by, error_message, 5);
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
