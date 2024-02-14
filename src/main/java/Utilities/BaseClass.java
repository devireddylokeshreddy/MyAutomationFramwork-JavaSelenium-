package Utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class BaseClass{
	public static WebDriver driver = DriverManager.getInstance().getDriver();
	
	public void gotoHomePage(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://Google.com");
		captureScreenshot("google screen");
	}

	public void captureScreenshot(String fileName) {
		Media mediaModel = null;
		try {
			mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ReportManager.getCurrentTest().info(fileName, mediaModel);

		} catch (NullPointerException ignored) {

		}
	}


}
