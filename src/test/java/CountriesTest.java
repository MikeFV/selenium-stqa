import Objects.Countries;
import Objects.CountriesComparator;
import Objects.Zone;
import Objects.ZonesComparator;
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
        login();
        openCountriesPage();

        List<Countries> countries = getCountriesFromTable();
        assertTrue(countriesListSorted(countries));

        List<Countries> countriesWithTimeZones = getCountriesWithZones(countries);
        assertTrue(zoneListsSorted(countriesWithTimeZones));

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

    private Boolean zoneListSorted(List<Zone> zones) {
        List<Zone> sortedZones = new ArrayList<>(zones);
        sortedZones.sort(new ZonesComparator());
        return zones.equals(sortedZones);
    }

    private void login() {
        wd.get("http://localhost/litecart/admin/");
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//input[@name = 'username']"))));
        wd.findElement(By.xpath("//input[@name = 'username']")).sendKeys("admin");
        wd.findElement(By.xpath("//input[@name = 'password']")).sendKeys("admin_pass");
        wd.findElement(By.xpath("//button[@name = 'login']")).click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.id("sidebar"))));
    }

    private void openCountriesPage() {
        wd.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h1[contains(.,'Countries')]"))));
    }

    private List<Countries> getCountriesFromTable() {
        List<WebElement> dataRows = wd.findElements(By.xpath("//table[@class = 'dataTable']//tr[@class = 'row']"));
        return dataRows
                .stream()
                .map(WebElement -> new Countries(WebElement.findElement(By.xpath(".//td[5]")).getText(),
                        Integer.valueOf(WebElement.findElement(By.xpath(".//td[6]")).getText())))
                .collect(Collectors.toList());
    }

    private List<Countries> getCountriesWithZones(List<Countries> countries) {
        return countries.stream().filter(country -> country.getZonesCount() > 0).collect(Collectors.toList());
    }

    private Boolean zoneListsSorted(List<Countries> countriesWithZones) {
        List<Boolean> zoneListSortResults = new ArrayList<>();
        for (Countries country : countriesWithZones) {
            wd.findElement(By.xpath(String.format("//a[contains(.,'%s')]", country.getName()))).click();
            baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h1[contains(.,'Edit Country')]"))));
            List<WebElement> timeZoneRows = wd.findElements(By.xpath("//table[contains(@class,'dataTable')]//tr[not(contains(@class, 'header')) and not(contains(@class, 'footer'))]"));
            timeZoneRows.remove(timeZoneRows.size() - 1);
            List<Zone> zones = timeZoneRows.stream().map(WebElement -> new Zone(WebElement.findElement(By.xpath("./td[3]")).getText())).collect(Collectors.toList());
            zoneListSortResults.add(zoneListSorted(zones));
            openCountriesPage();
        }

        return zoneListSortResults.stream().allMatch(sortResult -> sortResult);
    }
}