package PageObjects;

import Base.BaseManager;
import Objects.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CountriesPage {
    private WebDriver wd;

    public CountriesPage() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
    }

    public List<WebElement> getCountriesNames() {
        return wd.findElements(By.xpath("//table[@class = 'dataTable']//tr[@class = 'row']/td[5]/a"));
    }

    public Element getCountryName(String countryName) {
        return new Element(String.format("//a[contains(.,'%s')]", countryName));
    }
}
