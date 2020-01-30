import ca.pragra.wd2.framwork.config.FrameworkConfig;
import ca.pragra.wd2.framwork.drivermanager.DriverManager;
import ca.pragra.wd2.framwork.utils.Utility;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import data.LoginDataProvider;
import listener.ScreeshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import reports.HTMLReports;

import java.util.Arrays;

@Listeners(ScreeshotListener.class)
public class DummyTest {

    WebDriver driver;
    //ExtentTest test = HTMLReports.createTest("DummyTest");

    @BeforeSuite
    public void setUp(){
        driver = DriverManager.getDriverInstance();
    }

    @Test()
    public void test(){
        driver.get("https://google.com");
        //test.log(Status.PASS, "");
        //test.log(Status.INFO, "Browser opened successfuly");

    }

    @Test()
    public void anyTest(){
        try {
            System.out.println(5/0);
            //test.log(Status.PASS, "Browser Pragra successfuly");
        }catch (Exception ex){
            //test.log(Status.FAIL, Arrays.toString(ex.getStackTrace()));
        }
        driver.get("https://pragra.co");

    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
        HTMLReports.flushReport();
    }
}
