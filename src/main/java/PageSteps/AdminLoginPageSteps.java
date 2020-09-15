package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import PageObjects.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminLoginPageSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;

    public AdminLoginPageSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
    }

    public void openAdminPage() {
        wd.get("http://localhost/litecart/admin/");
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getAdminLoginPage().getUserNameField().getElement()));
    }

    public void enterLogin(String login) {
        pages.getAdminLoginPage().getUserNameField().getElement().sendKeys(login);
    }

    public void enterPassword(String password) {
        pages.getAdminLoginPage().getPasswordField().getElement().sendKeys(password);
    }

    public void clickLoginButton() {
        pages.getAdminLoginPage().getLoginButton().getElement().click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.id("sidebar"))));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void login() {
        openAdminPage();
        enterLogin("admin");
        enterPassword("admin_pass");
        clickLoginButton();
    }
}
