package Utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ExtentListeners extends BaseClass implements ITestListener {
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = ReportManager.startTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
        ReportManager.endCurrentTest();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        captureScreenshot("Test Failed: "+result.getMethod().getMethodName());
        ReportManager.endCurrentTest();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped: "+result.getMethod().getMethodName());
        extentTest.get().skip(result.getThrowable());
        ReportManager.endCurrentTest();
    }


    @Override
    public void onStart(ITestContext context) {
        System.out.println("Execution started :" + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Execution finished :" + context.getName());
    }
}
