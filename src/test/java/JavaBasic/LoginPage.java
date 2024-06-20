package JavaBasic;

import Utilities.BaseClass;
import Utilities.ExtentListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


@Listeners({ExtentListeners.class})
public class LoginPage extends BaseClass {
    BaseClass base;
    public WebDriver driver;
    public PageObject obj;

    @BeforeClass
    public void before() {
        base = new BaseClass();
        driver = BaseClass.driver;
        obj = new PageObject(driver);
    }

    @Test(priority = 0)
    public void login() throws IOException {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println(a);
        base.gotoHomePage();
        System.out.println(obj.getTitle());
        Assert.assertTrue(true);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("chrome://settings/");
        JavascriptExecutor script = (JavascriptExecutor)driver;
        WebElement ele = (WebElement) script.executeScript("return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#leftMenu\").shadowRoot.querySelector(\"#appearance\")");
        File src = ele.getScreenshotAs(OutputType.FILE);
        File dst = new File("C:\\Users\\devgurul\\IdeaProjects\\MyAutomationFramwork-JavaSelenium-\\Reports\\screenshot1.png");
        FileUtils.copyFile(src, dst);
        File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dst1 = new File("C:\\Users\\devgurul\\IdeaProjects\\MyAutomationFramwork-JavaSelenium-\\Reports\\screenshot2.png");
        FileUtils.copyFile(src1, dst1);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "lokesh");
        map.put(2, "sateesh");
        for (Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    @Test(priority = 1)
    public void kind() {
        base.gotoHomePage();
        Assert.assertTrue(true);
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }

}
