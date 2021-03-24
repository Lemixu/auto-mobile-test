import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{

    @Test
    public void testGetClassString(){
        Assert.assertTrue("Строка не содержит подстроки Hello или hello",
                getClassString().contains("Hello") ||
                        getClassString().contains("hello"));

    }
}
