import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{

    @Test
    public void testGetClassNumber(){
        Assert.assertTrue("Возвращаемое значение не больше 45",getClassNumber()>45);
    }
}
