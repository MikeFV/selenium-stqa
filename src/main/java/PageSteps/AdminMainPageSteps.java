package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import Objects.Element;
import PageObjects.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminMainPageSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;

    public AdminMainPageSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
    }

    public void openSideMenuPage(String sideMenuElementName) {
        Element sideMenuElement = pages.getAdminMainPage().getSideMenuElement(sideMenuElementName);
        sideMenuElement.getElement().click();
        baseHelper
            .fluentWait()
            .until(ExpectedConditions
                .attributeToBe(sideMenuElement.getElement(), "class", "selected")
            );
    }
}
