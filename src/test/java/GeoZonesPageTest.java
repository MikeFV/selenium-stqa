import Base.BaseHelper;
import Base.BaseManager;
import Objects.Countries;
import PageObjects.Pages;
import PageSteps.AdminLoginPageSteps;
import PageSteps.AdminMainPageSteps;
import PageSteps.GeoZonesPageSteps;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class GeoZonesPageTest {
    private BaseManager bm;
    private WebDriver wd;
    private BaseHelper baseHelper;
    private Pages pages;
    private AdminLoginPageSteps adminLoginPageSteps;
    private AdminMainPageSteps adminMainPageSteps;
    private GeoZonesPageSteps geoZonesPageSteps;

    @Before
    public void setUp() throws Exception {
        bm = BaseManager.getInstance();
        wd = bm.getWebDriverManager().getDriver();
        baseHelper = bm.getBaseHelper();
        pages = Pages.getInstance();
        adminLoginPageSteps = new AdminLoginPageSteps();
        adminMainPageSteps = new AdminMainPageSteps();
        geoZonesPageSteps = new GeoZonesPageSteps();
    }

    @Test
    public void geoZonesSortTest() {
        adminLoginPageSteps.login();
        List<Boolean> validationResults = new ArrayList<>();
        adminMainPageSteps.openSideMenuPage("Geo Zones");
        List<Countries> countries = geoZonesPageSteps.getCountriesFromTable();
        for (Countries country : countries) {
            geoZonesPageSteps.openGeoZoneEditPage(country.getName());
            validationResults.add(geoZonesPageSteps.geoZonesListSorted(geoZonesPageSteps.getGeoZones()));
            adminMainPageSteps.openSideMenuPage("Geo Zones");
        }
        Assert.assertTrue(validationResults.stream().allMatch(validationResult -> validationResult));
    }

    @After
    public void tearDown() throws Exception {
        wd.close();
    }
}