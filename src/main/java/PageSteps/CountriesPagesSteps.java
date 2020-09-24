package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import PageObjects.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CountriesPagesSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;

    public CountriesPagesSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
    }

    public void openCountryEditPage(String countryName) {
        pages.getCountriesPage().getCountryName(countryName).click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getEditCountryPage().getAddressFormatExternalLink().getElement()));
    }

    public void openCountryEditPage() {
        pages.getCountriesPage().getCountriesNames().get(0).click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getEditCountryPage().getAddressFormatExternalLink().getElement()));
    }
}
