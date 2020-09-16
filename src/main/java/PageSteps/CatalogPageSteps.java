package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import Objects.Product;
import PageObjects.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogPageSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;

    public CatalogPageSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
    }

    public void addNewProduct() {
        pages.getCatalogPage().getAddNewProductButton().getElement().click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getAddNewProductPage().getHeaderByName("Add New Product").getElement()));
    }

    public Boolean assertProductCreated(String productName) {
        List<WebElement> rows = pages.getCatalogPage().getNewProductTableRow().getElements();
        List<Product> products = rows.stream().map(WebElement -> new Product(WebElement.findElement(pages.getCatalogPage().getNewProductName().getXpath()).getText(), null, null)).filter(product -> product.getName().equals(productName)).collect(Collectors.toList());
        return products.size() == 1;
    }
}
