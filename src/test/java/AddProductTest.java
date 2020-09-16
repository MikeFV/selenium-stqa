import Base.BaseHelper;
import Base.BaseManager;
import Objects.ProductGroup;
import PageObjects.Pages;
import PageObjects.ProductStatus;
import PageSteps.AddNewProductPageSteps;
import PageSteps.AdminLoginPageSteps;
import PageSteps.AdminMainPageSteps;
import PageSteps.CatalogPageSteps;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.Date;

public class AddProductTest {
    private BaseManager bm;
    private WebDriver wd;
    private BaseHelper baseHelper;
    private Pages pages;
    private AdminLoginPageSteps adminLoginPageSteps;
    private AdminMainPageSteps adminMainPageSteps;
    private CatalogPageSteps catalogPageSteps;
    private AddNewProductPageSteps addNewProductPageSteps;
    private Calendar calendar = Calendar.getInstance();


    @Before
    public void setUp() throws Exception {
        bm = BaseManager.getInstance();
        wd = bm.getWebDriverManager().getDriver();
        baseHelper = bm.getBaseHelper();
        pages = Pages.getInstance();
        adminLoginPageSteps = new AdminLoginPageSteps();
        adminMainPageSteps = new AdminMainPageSteps();
        catalogPageSteps = new CatalogPageSteps();
        addNewProductPageSteps = new AddNewProductPageSteps();
    }

    @Test
    public void addProductTest() {
        String productName = "product name value 3";
        Date dateFrom = calendar.getTime();
        calendar.add(Calendar.YEAR, 1);
        Date dateTo = calendar.getTime();

        adminLoginPageSteps.login();
        adminMainPageSteps.openSideMenuPage("Catalog");
        catalogPageSteps.addNewProduct();
        addNewProductPageSteps.setStatus(ProductStatus.ENABLED);
        addNewProductPageSteps.setName(productName);
        addNewProductPageSteps.setCode("code value");
        addNewProductPageSteps.setProductGroup(ProductGroup.FEMALE);
        addNewProductPageSteps.setProductGroup(ProductGroup.MALE);
        addNewProductPageSteps.setQuantity(100);
        addNewProductPageSteps.uploadImage("smile.png");
        addNewProductPageSteps.setDateValidFrom(dateFrom);
        addNewProductPageSteps.setDateValidTo(dateTo);
        addNewProductPageSteps.switchToInformationTab();
        addNewProductPageSteps.setKeywords("keywords value");
        addNewProductPageSteps.setShortDescription("short description value");
        addNewProductPageSteps.setDescription("description value");
        addNewProductPageSteps.setHeadTitle("head title value");
        addNewProductPageSteps.setMetaDescription("meta description value");
        addNewProductPageSteps.switchToDataTab();
        addNewProductPageSteps.setSku("sku value");
        addNewProductPageSteps.setGtin("gtin value");
        addNewProductPageSteps.setTaric("taric value");
        addNewProductPageSteps.setWeight(1);
        addNewProductPageSteps.setWidth(10);
        addNewProductPageSteps.setHeight(10);
        addNewProductPageSteps.setLength(10);
        addNewProductPageSteps.setAttributes("attributes value");
        addNewProductPageSteps.save();
        Assert.assertTrue(catalogPageSteps.assertProductCreated(productName));
    }

    @After
    public void tearDown() throws Exception {
        wd.close();
    }
}