package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import PageObjects.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPageSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;

    public ProductDetailPageSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
    }

    public void clickAddToCartButton() {
        Integer cartProductsQuantity = Integer.valueOf(pages
            .getProductDetailPage()
            .getCartProductsQuantity()
            .getElement()
            .getAttribute("innerText")
        );
        pages.getProductDetailPage().getAddToCartButton().click();
        baseHelper.fluentWait().until(ExpectedConditions.attributeContains(
            pages.getProductDetailPage().getCartProductsQuantity().getElement(),
            "innerText",
            String.valueOf(cartProductsQuantity + 1))
        );
    }

    public void clickMainPageButton() {
        pages.getProductDetailPage().getMainPageButton().click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getMainUnauthorizedPage().getLoginForm().getElement()));
    }

    public void clickCheckoutButton() {
        pages.getProductDetailPage().getCheckoutButton().click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getCheckoutPage().getCheckoutProductsFragment().getElement()));
    }

    public void setRandomProductPropertyIfExists() {
        if (!pages.getProductDetailPage().getProductProperties().getElements().isEmpty()) {
            pages.getProductDetailPage().getProductProperties().setRandomValue();
        }
    }
}
