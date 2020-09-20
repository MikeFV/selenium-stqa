import Base.BaseManager;
import PageSteps.MainAuthorizedPageSteps;
import PageSteps.MainUnauthorizedPageSteps;
import PageSteps.RegistrationPageSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegistrationTest {
    private BaseManager bm;
    private WebDriver wd;
    private MainUnauthorizedPageSteps mainUnauthorizedPageSteps = new MainUnauthorizedPageSteps();
    private RegistrationPageSteps registrationPageSteps = new RegistrationPageSteps();
    private MainAuthorizedPageSteps mainAuthorizedPage = new MainAuthorizedPageSteps();


    @Before
    public void setUp() throws Exception {
        bm = BaseManager.getInstance();
        wd = bm.getWebDriverManager().getDriver();
    }

    @Test
    public void registrationTest() {
        String password = "pass";

        mainUnauthorizedPageSteps.openMainPage();
        mainUnauthorizedPageSteps.clickRegistrationButton();
        registrationPageSteps.setTaxId("tax id value");
        registrationPageSteps.setCompany("company value");

        registrationPageSteps.setFirstName("first name value");
        registrationPageSteps.setLastName("last name value");
        registrationPageSteps.setAddress1("first address value");
        registrationPageSteps.setAddress2("second address value");
        registrationPageSteps.setValidPostCode();
        registrationPageSteps.setCity("city value");
        registrationPageSteps.setValidEmail();
        registrationPageSteps.setValidPhone();
        registrationPageSteps.setDesiredPassword(password);
        registrationPageSteps.setConfirmPassword(password);
        registrationPageSteps.clickCreateAccountButton();
        mainAuthorizedPage.clickLogoutButton();
        mainUnauthorizedPageSteps.setEmail();
        mainUnauthorizedPageSteps.setPassword(password);
        mainUnauthorizedPageSteps.clickLoginButton();
        mainAuthorizedPage.clickLogoutButton();
    }

    @After
    public void tearDown() throws Exception {
        wd.close();
    }
}
