import data.LoginDataProvider;
import org.testng.annotations.Test;

public class DummyTest {

    @Test(dataProvider = "loginProvider", dataProviderClass = LoginDataProvider.class)
    public void test(String name, String add, String zip){
        System.out.println(name);
        System.out.println(add);
        System.out.println(zip);
    }
}
