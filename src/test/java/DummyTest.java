import ca.pragra.wd2.framwork.drivermanager.DriverManager;
import ca.pragra.wd2.framwork.utils.Utility;
import data.LoginDataProvider;
import listener.ScreeshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreeshotListener.class)
public class DummyTest {
    WebDriver driver = DriverManager.getDriverInstance();

    @Test()
    public void test(){
        driver.get("https://google.com");

    }

    @Test()
    public void anyTest(){

        driver.navigate().to("https://pragra.co");
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
