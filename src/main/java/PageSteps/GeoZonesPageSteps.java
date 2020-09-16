package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import Objects.Countries;
import Objects.Zone;
import Objects.ZonesComparator;
import PageObjects.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GeoZonesPageSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;

    public GeoZonesPageSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
    }

    public List<Countries> getCountriesFromTable() {
        List<WebElement> rows = pages.getGeoZonesPage().getGeoZonesTableRow().getElements();
        return rows
            .stream()
            .map(WebElement -> new Countries(WebElement
                    .findElement(pages
                        .getGeoZonesPage()
                        .getCountryName()
                        .getXpath())
                            .getText(),
                Integer.valueOf(WebElement
                    .findElement(pages
                        .getGeoZonesPage()
                        .getZonesCount()
                        .getXpath())
                            .getText())))
                .collect(Collectors.toList());
    }

    public void validateSortOfGeoZones(List<Countries> countries) {
        List<Boolean> validationResults = new ArrayList<>();
        for (Countries country : countries) {
            openGeoZoneEditPage(country.getName());
            validationResults.add(geoZonesListSorted(getGeoZones()));
        }
    }

    public void openGeoZoneEditPage(String countryName) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pages.getGeoZonesPage().getCountryByName(countryName).getElement().click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getGeoZoneEditPage().getHeaderByName("Edit Geo Zone").getElement()));
    }

    public List<Zone> getGeoZones() {
        List<WebElement> rows = pages.getGeoZoneEditPage().getGeoZonesEditTableRow().getElements();
        return rows.stream().map(WebElement -> new Zone(WebElement.findElement(pages.getGeoZoneEditPage().getGetZoneName().getXpath()).getText())).collect(Collectors.toList());
    }

    public Boolean geoZonesListSorted(List<Zone> zones) {
        List<Zone> sortedZones = new ArrayList<>(zones);
        sortedZones.sort(new ZonesComparator());
        return zones.equals(sortedZones);
    }
}
