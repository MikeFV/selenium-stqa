import Base.BaseHelper;
import Base.BaseManager;
import Objects.Countries;
import Objects.CountriesComparator;
import Objects.Zone;
import Objects.ZonesComparator;
import PageObjects.Pages;
import PageSteps.AdminLoginPageSteps;
import PageSteps.AdminMainPageSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CountriesTest {
    private BaseManager bm;
    private WebDriver wd;
    private BaseHelper baseHelper;
    private Pages pages;
    private AdminLoginPageSteps adminLoginPageSteps;
    private AdminMainPageSteps adminMainPageSteps;

    @Before
    public void setUp() throws Exception {
        bm = BaseManager.getInstance();
        wd = bm.getWebDriverManager().getDriver();
        baseHelper = bm.getBaseHelper();
        pages = Pages.getInstance();
        adminLoginPageSteps = new AdminLoginPageSteps();
        adminMainPageSteps = new AdminMainPageSteps();
    }

    @Test
    public void countriesTest() {
        adminLoginPageSteps.login();
        adminMainPageSteps.openSideMenuPage("Countries");

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
            List<Zone> zones = timeZoneRows
                    .stream()
                    .map(WebElement -> new Zone(WebElement.findElement(By.xpath("./td[3]")).getText()))
                    .collect(Collectors.toList());
            zoneListSortResults.add(zoneListSorted(zones));
            adminMainPageSteps.openSideMenuPage("Countries");
        }
        return zoneListSortResults.stream().allMatch(sortResult -> sortResult);
    }
}