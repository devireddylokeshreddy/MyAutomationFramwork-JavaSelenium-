package JavaBasic;

import Utilities.BaseClass;
import Utilities.ExtentListeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


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
    public void login() {
        base.gotoHomePage();
        System.out.println(obj.getTitle());
        Assert.assertTrue(true);
    }

    @Test(priority = 1)
    public void kind() {
        base.gotoHomePage();
        Assert.assertTrue(true);
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }

}
