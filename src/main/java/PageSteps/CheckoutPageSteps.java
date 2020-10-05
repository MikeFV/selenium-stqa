package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import PageObjects.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPageSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;

    public CheckoutPageSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
    }

    public void removeProductsFromCart(Integer countOfProducts) {
        if (pages.getCheckoutPage().getProductPreview().getElements().size() > 0) {
            pages.getCheckoutPage().getProductPreview().getElements().get(0).click();
        }
        for (Integer product = 0; product < countOfProducts; product++) {
            WebElement checkoutProductTable = pages.getCheckoutPage().getOrderSummaryTable().getElement();
            pages.getCheckoutPage().getRemoveProductButton().click();
            baseHelper.fluentWait().until(ExpectedConditions.stalenessOf(checkoutProductTable));
        }
    }
}
