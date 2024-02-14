package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReportManager {
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static ExtentTest test;
    public static Map<Long, ExtentTest> testMap = new HashMap<>();
    public static String dateStamp;


	public static ExtentReports getExtent(){
		if(extent==null){
			startReport();
		}
		return extent;
	}
	public static void startReport() {
        dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/WebReport_" + dateStamp + ".html");
        spark.config().setReportName("Web Automation Results");
        spark.config().setDocumentTitle("Test Results");
        spark.config().setTheme(Theme.DARK);
        extent.attachReporter(spark);
    }

    public static synchronized ExtentTest startTest(String testName) {
        test = getExtent().createTest(testName);
        testMap.put(Thread.currentThread().getId(), test);
        return test;
    }

	public static void endCurrentTest() {
		getCurrentTest().getExtent().flush();
		testMap.remove(Thread.currentThread().getId());
	}

    public static ExtentTest getCurrentTest() {
        return testMap.get(Thread.currentThread().getId());
    }

}
