package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import PageObjects.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainAuthorizedPageSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;

    public MainAuthorizedPageSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
    }

    public void clickLogoutButton() {
        pages.getMainAuthorizedPage().getLogoutButton().getElement().click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getMainUnauthorizedPage().getLoginForm().getElement()));
    }
}
