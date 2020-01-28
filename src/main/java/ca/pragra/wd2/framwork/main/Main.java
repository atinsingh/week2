package ca.pragra.wd2.framwork.main;

import ca.pragra.wd2.framwork.config.FrameworkConfig;
import ca.pragra.wd2.framwork.drivermanager.DriverManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(FrameworkConfig.getProperty("firefox.executable"));
        DriverManager.getDriverInstance().get("https://facebook.com");
        Thread.sleep(8000);
        DriverManager.getDriverInstance().quit();
    }
}
