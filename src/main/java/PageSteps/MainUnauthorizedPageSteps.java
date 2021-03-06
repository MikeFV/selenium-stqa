package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import Contexts.LoginContext;
import PageObjects.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainUnauthorizedPageSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;
    private LoginContext loginContext;

    public MainUnauthorizedPageSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
        this.loginContext = LoginContext.getInstance();
    }

    public void openMainPage() {
        wd.get("http://localhost/litecart/en/");
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getMainUnauthorizedPage().getLoginForm().getElement()));
    }

    public void clickRegistrationButton() {
        pages.getMainUnauthorizedPage().getRegisterButton().getElement().click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getRegistrationPage().getRegistrationFormHeader().getElement()));
    }

    public void setEmail() {
        pages.getMainUnauthorizedPage().getEmail().getElement().sendKeys(loginContext.getEmail());
    }

    public void setPassword(String password) {
        pages.getMainUnauthorizedPage().getPassword().getElement().sendKeys(password);
    }

    public void clickLoginButton() {
        pages.getMainUnauthorizedPage().getLoginButton().getElement().click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getMainAuthorizedPage().getAuthorizationSuccess().getElement()));
    }

    public void clickOnMostPopularProduct(Integer orderOfProductInCategory) {
        if (orderOfProductInCategory < 0) throw new IllegalArgumentException("Номер продукта должен быть >= 0");
        List<WebElement> products = pages.getMainUnauthorizedPage().getMostPopularProducts().getElements();
        if (products.isEmpty()) throw new IllegalArgumentException("В разделе отсутствуют продукты");
        if (products.size() < orderOfProductInCategory) throw new IllegalArgumentException("В разделе отсутствует продукт с указанным номером: " + orderOfProductInCategory);
        products.get(orderOfProductInCategory).click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getProductDetailPage().getProductDetailFragment().getElement()));
    }
}
