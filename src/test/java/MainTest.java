import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.*;

public class MainTest {
    private BaseManager bm;
    private WebDriver wd;
    private BaseHelper baseHelper;

    @Before
    public void setUp() throws Exception {
        bm = BaseManager.getInstance();
        wd = bm.getWebDriverManager().getDriver();
        baseHelper = bm.getBaseHelper();
    }

    @Test
    public void login() {
        wd.get("http://localhost/litecart/admin/");
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//input[@name = 'username']"))));
        wd.findElement(By.xpath("//input[@name = 'username']")).sendKeys("admin");
        wd.findElement(By.xpath("//input[@name = 'password']")).sendKeys("admin_pass");
        wd.findElement(By.xpath("//button[@name = 'login']")).click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.id("sidebar"))));
    }

    @After
    public void tearDown() throws Exception {
        wd.close();
    }
}