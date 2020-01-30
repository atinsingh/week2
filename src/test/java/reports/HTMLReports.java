package reports;

import ca.pragra.wd2.framwork.utils.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class HTMLReports {
    private static ExtentReports reports;


    private HTMLReports(){
        reports = new ExtentReports();
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(Utility.getReportFileName());
        reports.attachReporter(reporter);
    }

    public static ExtentTest createTest(String testName){
        if(reports == null){
            new HTMLReports();
        }
        return reports.createTest(testName);
    }

    public static void flushReport(){
        reports.flush();
    }

}
