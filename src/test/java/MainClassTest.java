import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{

    @Test
    public void testGetLocalNumber(){
        Assert.assertEquals("Возвращаемое число не равно 14",14,getLocalNumber());
        System.out.println("Hello");

    }
}
