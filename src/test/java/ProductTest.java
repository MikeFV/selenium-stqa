import Objects.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.*;

public class ProductTest {
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
        openMainPage();

        WebElement firstProduct = wd.findElement(By.xpath("//div[contains(@id, 'box-campaigns')]//li[contains(@class, 'product')]"));
        Product productCard = new Product();
        WebElement firstProductName = firstProduct.findElement(By.xpath(".//div[contains(@class, 'name')]"));
        WebElement firstProductRegularPrice = firstProduct.findElement(By.xpath(".//s[contains(@class, 'regular-price')]"));
        WebElement firstProductCampaignPrice = firstProduct.findElement(By.xpath(".//strong[contains(@class, 'campaign-price')]"));

        productCard.setName(firstProductName.getText());
        productCard.setRegularPrice(firstProductRegularPrice.getText());
        productCard.setCampaignPrice(firstProductCampaignPrice.getText());

        System.out.println(firstProductRegularPrice.getCssValue("color"));
        System.out.println(firstProductRegularPrice.getCssValue("font-weight"));
        System.out.println(firstProductRegularPrice.getCssValue("text-decoration-line"));
            //font-weight
        System.out.println(productCard.toString());

        firstProduct.click();
        String productPageName = String.format(".//h1[contains(.,'%s')]", productCard.getName());
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath(productPageName))));
        WebElement product = wd.findElement(By.xpath("//div[@id = 'box-product']"));
        WebElement productName = product.findElement(By.xpath(".//h1"));
        WebElement productRegularPrice = product.findElement(By.xpath(".//s[contains(@class, 'regular-price')]"));
        WebElement productCampaignPrice = product.findElement(By.xpath(".//strong[contains(@class, 'campaign-price')]"));
        //<s class="regular-price">$20</s>
        //<strong class="campaign-price" itemprop="price">$18</strong>

        System.out.println(productRegularPrice.getCssValue("color"));
        System.out.println(productRegularPrice.getCssValue("font-weight"));
        System.out.println(productRegularPrice.getCssValue("text-decoration-line"));
    }

    @After
    public void tearDown() throws Exception {
        wd.close();
    }


    private void openMainPage() {
        wd.get("http://localhost/litecart/en/");
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[@id = 'logotype-wrapper']"))));
    }

    private List<WebElement> getProducts() {
        return wd.findElements(By.xpath("//li[contains(@class, 'product')]"));
    }



}