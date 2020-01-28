package ca.pragra.wd2.framwork.drivermanager;

import ca.pragra.wd2.framwork.config.FrameworkConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private WebDriver driver;
    private static DriverManager driverManager;

    private DriverManager() {

        if(FrameworkConfig.getProperty("browswer").equals(BrowserTypes.CHROME)){
            System.setProperty("webdriver.chrome.driver", FrameworkConfig.getProperty("chrome.executable"));
            driver = new ChromeDriver();
        }else
        if(FrameworkConfig.getProperty("browswer").equals(BrowserTypes.FIREFOX)){
            System.setProperty("webdriver.gecko.driver", FrameworkConfig.getProperty("firefox.executable"));
            driver = new FirefoxDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", FrameworkConfig.getProperty("chrome.executable"));
            driver = new ChromeDriver();
        }
    }

    public static WebDriver getDriverInstance(){
        if(driverManager==null){
            driverManager = new DriverManager();
        }
        return driverManager.driver;
    }
}
