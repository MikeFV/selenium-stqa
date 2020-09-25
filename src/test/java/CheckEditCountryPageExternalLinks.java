import Base.BaseManager;
import PageSteps.AdminLoginPageSteps;
import PageSteps.AdminMainPageSteps;
import PageSteps.CountriesPagesSteps;
import PageSteps.EditCountryPageSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CheckEditCountryPageExternalLinks {
    private BaseManager bm;
    private WebDriver wd;
    private AdminLoginPageSteps adminLoginPageSteps;
    private AdminMainPageSteps adminMainPageSteps;
    private CountriesPagesSteps countriesPagesSteps;
    private EditCountryPageSteps editCountryPageSteps;


    @Before
    public void setUp() throws Exception {
        bm = BaseManager.getInstance();
        wd = bm.getWebDriverManager().getDriver();
        adminLoginPageSteps = new AdminLoginPageSteps();
        adminMainPageSteps = new AdminMainPageSteps();
        countriesPagesSteps = new CountriesPagesSteps();
        editCountryPageSteps = new EditCountryPageSteps();
    }

    @Test
    public void checkEditCountryPageExternalLinks() {
        adminLoginPageSteps.login();
        adminMainPageSteps.openSideMenuPage("Countries");
        countriesPagesSteps.openCountryEditPage();
        editCountryPageSteps.openExternalLinks();
    }

    @After
    public void tearDown() throws Exception {
        wd.quit();
    }
}