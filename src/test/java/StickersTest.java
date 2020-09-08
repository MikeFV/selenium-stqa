import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class StickersTest {
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
    public void stickers() {
        wd.get("http://localhost/litecart/en/");
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[@id = 'logotype-wrapper']"))));
        List<WebElement> products = getProducts();
        for (WebElement product : products) {
            Boolean onlyOneStickerFound = (getStickers(product).size() == 1);
            Assert.assertTrue(onlyOneStickerFound);
            String productName = product.findElement(By.xpath(".//div[contains(@class, 'name')]")).getText();
            if (onlyOneStickerFound) {
                String stickerName = product.findElement(By.xpath(".//div[contains(@class, 'sticker')]")).getText();
                System.out.println(String.format("Product '%s' has sticker '%s'", productName, stickerName));
            }
            else {
                System.out.println("Product '%s' does not have stickers");
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        wd.close();
    }

    private List<WebElement> getProducts() {
        return wd.findElements(By.xpath("//li[contains(@class, 'product')]"));
    }

    private List<WebElement> getStickers(WebElement product) {
        return product.findElements(By.xpath(".//div[contains(@class, 'sticker')]"));
    }

}