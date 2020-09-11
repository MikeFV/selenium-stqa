import Objects.Countries;
import Objects.CountriesComparator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class CountriesTest {
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
    public void countriesTest() {
        wd.get("http://localhost/litecart/admin/");
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//input[@name = 'username']"))));
        wd.findElement(By.xpath("//input[@name = 'username']")).sendKeys("admin");
        wd.findElement(By.xpath("//input[@name = 'password']")).sendKeys("admin_pass");
        wd.findElement(By.xpath("//button[@name = 'login']")).click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.id("sidebar"))));
        wd.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h1[contains(.,'Countries')]"))));
        List<WebElement> dataRows = wd.findElements(By.xpath("//table[@class = 'dataTable']//tr[@class = 'row']"));
        List<Countries> countries = dataRows
                .stream()
                .map(WebElement -> new Countries(WebElement.findElement(By.xpath(".//td[5]")).getText(),
                                                Integer.valueOf(WebElement.findElement(By.xpath(".//td[6]")).getText())))
                .collect(Collectors.toList());

        assertTrue(countriesListSorted(countries));
        
    }

    @After
    public void tearDown() throws Exception {
        wd.close();
    }

    private Boolean countriesListSorted(List<Countries> countries) {
        List<Countries> sortedCountries = new ArrayList<>(countries);
        sortedCountries.sort(new CountriesComparator());
        return countries.equals(sortedCountries);
    }
}