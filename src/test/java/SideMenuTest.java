import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SideMenuTest {
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
    public void sideMenu() {
        wd.get("http://localhost/litecart/admin/");
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//input[@name = 'username']"))));
        wd.findElement(By.xpath("//input[@name = 'username']")).sendKeys("admin");
        wd.findElement(By.xpath("//input[@name = 'password']")).sendKeys("admin_pass");
        wd.findElement(By.xpath("//button[@name = 'stickers']")).click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.id("sidebar"))));
        List<WebElement> menuElements = wd.findElements(By.xpath("//ul[@id = 'box-apps-menu']/li[@id = 'app-']"));
        int menuItemsCount = menuElements.size();
        for (int menuItemsCounter = 1; menuItemsCounter < menuItemsCount; menuItemsCounter++) {
            getCurrentMenuItemElement(menuItemsCounter).click();
            waitUntilElementToBeActive(getCurrentMenuItemElement(menuItemsCounter));
            if (currentMenuItemHasSubElements(menuItemsCounter)) {
                int submenuElementsCount = getCurrentMenuItemSubElements(menuItemsCounter).size();
                    for (int subElementCounter = 0; subElementCounter < submenuElementsCount; subElementCounter++) {
                        getCurrentMenuItemSubElement(menuItemsCounter, subElementCounter).click();
                        waitUntilElementToBeActive(getCurrentMenuItemSubElement(menuItemsCounter,subElementCounter));
                    }
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        wd.close();
    }

    private WebElement getCurrentMenuItemElement(int elementCounter) {
        return wd.findElements(By.xpath("//ul[@id = 'box-apps-menu']/li[@id = 'app-']")).get(elementCounter);
    }

    private List<WebElement> getCurrentMenuItemSubElements(int elementCounter) {
        return getCurrentMenuItemElement(elementCounter).findElements(By.xpath(".//li"));
    }

    private WebElement getCurrentMenuItemSubElement(int elementCounter, int subElementCounter) {
        return getCurrentMenuItemSubElements(elementCounter).get(subElementCounter);
    }

    private Boolean currentMenuItemHasSubElements(int elementCounter) {
        return getCurrentMenuItemSubElements(elementCounter).size() > 0;

    }
    private void waitUntilElementToBeActive(WebElement element)  {
        baseHelper.fluentWait().until(ExpectedConditions.attributeToBe(element, "class", "selected"));
    }
}