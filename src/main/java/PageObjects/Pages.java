package PageObjects;

public class Pages {
    private static Pages instance = null;

    private AdminLoginPage adminLoginPage = new AdminLoginPage();
    private AdminMainPage adminMainPage = new AdminMainPage();
    private GeoZonesPage geoZonesPage = new GeoZonesPage();
    private GeoZoneEditPage geoZoneEditPage = new GeoZoneEditPage();
    private CatalogPage catalogPage = new CatalogPage();
    private AddNewProductPage addNewProductPage = new AddNewProductPage();
    private MainUnauthorizedPage mainUnauthorizedPage = new MainUnauthorizedPage();
    private MainAuthorizedPage mainAuthorizedPage = new MainAuthorizedPage();
    private RegistrationPage registrationPage = new RegistrationPage();
    private ProductDetailPage productDetailPage = new ProductDetailPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private CountriesPage countriesPage = new CountriesPage();
    private EditCountryPage editCountryPage = new EditCountryPage();


    private Pages() {}

    public static Pages getInstance() {
        if (instance == null) {
            instance = new Pages();
        }
        return instance;
    }

    public AdminLoginPage getAdminLoginPage() {
        return adminLoginPage;
    }

    public AdminMainPage getAdminMainPage() {
        return adminMainPage;
    }

    public GeoZonesPage getGeoZonesPage() {
        return geoZonesPage;
    }

    public GeoZoneEditPage getGeoZoneEditPage() {
        return geoZoneEditPage;
    }

    public CatalogPage getCatalogPage() {
        return catalogPage;
    }

    public AddNewProductPage getAddNewProductPage() {
        return addNewProductPage;
    }

    public MainUnauthorizedPage getMainUnauthorizedPage() {
        return mainUnauthorizedPage;
    }

    public MainAuthorizedPage getMainAuthorizedPage() {
        return mainAuthorizedPage;
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
    }

    public ProductDetailPage getProductDetailPage() {
        return productDetailPage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage;
    }

    public CountriesPage getCountriesPage() {
        return countriesPage;
    }

    public EditCountryPage getEditCountryPage() {
        return editCountryPage;
    }
}
