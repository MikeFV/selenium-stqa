import Objects.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        WebElement productCardElement = wd.findElement(By.xpath("//div[contains(@id, 'box-campaigns')]//li[contains(@class, 'product')]"));

        WebElement productCardName = productCardElement.findElement(By.xpath(".//div[contains(@class, 'name')]"));
        WebElement productCardRegularPrice = productCardElement.findElement(By.xpath(".//s[contains(@class, 'regular-price')]"));
        WebElement productCardCampaignPrice = productCardElement.findElement(By.xpath(".//strong[contains(@class, 'campaign-price')]"));

        Product productCard = new Product();
        productCard.setName(productCardName.getText());
        productCard.setRegularPrice(productCardRegularPrice.getText());
        productCard.setCampaignPrice(productCardCampaignPrice.getText());

        assertTrue(productCardRegularPriceStyleIsValid(productCardRegularPrice));
        assertTrue(campaignPriceStyleIsValid(productCardCampaignPrice));
        assertTrue(campaignPriceLargerThanRegularPrice(productCardRegularPrice, productCardCampaignPrice));

        productCardElement.click();
        String productPageName = String.format(".//h1[contains(.,'%s')]", productCard.getName());
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath(productPageName))));

        WebElement productElement = wd.findElement(By.xpath("//div[@id = 'box-product']"));
        WebElement productName = productElement.findElement(By.xpath(".//h1"));
        WebElement productRegularPrice = productElement.findElement(By.xpath(".//s[contains(@class, 'regular-price')]"));
        WebElement productCampaignPrice = productElement.findElement(By.xpath(".//strong[contains(@class, 'campaign-price')]"));

        Product product = new Product();
        product.setName(productName.getText());
        product.setRegularPrice(productRegularPrice.getText());
        product.setCampaignPrice(productCampaignPrice.getText());

        assertTrue(productDetailRegularPriceStyleIsValid(productRegularPrice));
        assertTrue(campaignPriceStyleIsValid(productCampaignPrice));
        assertTrue(campaignPriceLargerThanRegularPrice(productRegularPrice, productCampaignPrice));

        assertEquals(productCard, product);

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

    private Boolean elementColorIsValid(WebElement element, String rgbColor, String rgbaColor) {
        String elementColor = element.getCssValue("color");
        return (elementColor.equals(rgbColor) || elementColor.equals(rgbaColor));
    }

    private Boolean productCardRegularPriceStyleIsValid(WebElement element) {
        return element.getCssValue("text-decoration-line").equals("line-through") &&
                elementColorIsValid(element, "rgb(119, 119, 119)", "rgba(119, 119, 119, 1)");

    }

    private Boolean productDetailRegularPriceStyleIsValid(WebElement element) {
        return element.getCssValue("text-decoration-line").equals("line-through") &&
                elementColorIsValid(element, "rgb(102, 102, 102)", "rgba(102, 102, 102, 1)");

    }

    private Boolean campaignPriceStyleIsValid(WebElement element) {
        return element.getCssValue("font-weight").equals("900") &&
                elementColorIsValid(element, "rgb(204, 0, 0)", "rgba(204, 0, 0, 1)");
    }

    private Boolean campaignPriceLargerThanRegularPrice(WebElement regularPrice, WebElement campaignPrice) {
        return regularPrice.getSize().getHeight() * regularPrice.getSize().getWidth() < campaignPrice.getSize().getHeight() * campaignPrice.getSize().getWidth();
    }

    private String getColorType(String color) {
        String searchedPattern = "[a-z]*";
        Pattern pattern = Pattern.compile(searchedPattern);
        Matcher matcher = pattern.matcher(color);

        if (matcher.find()) {
            return matcher.group(0);
        }
        else {
            throw new IllegalStateException("Color type not found");
        }
    }

    private List<Integer> getColorValue(String color) {
        String searchedPattern = "([0-9])+";
        Pattern pattern = Pattern.compile(searchedPattern);
        Matcher matcher = pattern.matcher(color);
        List<Integer> colorValues = new ArrayList<>();
        while (matcher.find()) {
            colorValues.add(Integer.valueOf(matcher.group(0)));
        }
        return colorValues;
    }

    private Color colorConverter(String color) {
        String colorType = getColorType(color);
        List<Integer> colorValues = getColorValue(color);
        if (colorType.equals("rgb")) {
            return new Color(colorValues.get(0), colorValues.get(1), colorValues.get(2));
        }
        if (colorType.equals("rgba")) {
            return new Color(colorValues.get(0), colorValues.get(1), colorValues.get(2), colorValues.get(3));
        }
        throw new IllegalArgumentException("Can't parse color " + color);
    }
}