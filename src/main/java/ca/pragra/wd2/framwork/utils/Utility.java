package ca.pragra.wd2.framwork.utils;

import ca.pragra.wd2.framwork.config.FrameworkConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    private static String getTimeStamp(){
        SimpleDateFormat format = new SimpleDateFormat(FrameworkConfig.getProperty("dateformat"));
        return format.format(new Date());
    }

    public static File generateScreenshotFile(String testName){
        String fileName = testName+"_"+getTimeStamp()+".png";
        Path path =
                Paths.get(FrameworkConfig.getProperty("screenshot.dir"), fileName);
        return path.toFile();
    }

    private static void createDirs() {
      Path path = Paths.get(FrameworkConfig.getProperty("screenshot.dir"));
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void captureScreenShot(WebDriver driver, String testName){
        createDirs();
        File shotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(shotFile.toPath(),generateScreenshotFile(testName).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
