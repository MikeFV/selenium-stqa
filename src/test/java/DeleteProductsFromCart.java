import Base.BaseManager;
import PageSteps.AddProductToCartPageSteps;
import PageSteps.CheckoutPageSteps;
import PageSteps.MainUnauthorizedPageSteps;
import PageSteps.ProductDetailPageSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DeleteProductsFromCart {
    private BaseManager bm = BaseManager.getInstance();
    private WebDriver wd = bm.getWebDriverManager().getDriver();
    private MainUnauthorizedPageSteps mainUnauthorizedPageSteps = new MainUnauthorizedPageSteps();
    private ProductDetailPageSteps productDetailPageSteps = new ProductDetailPageSteps();
    private CheckoutPageSteps checkoutPageSteps = new CheckoutPageSteps();
    private AddProductToCartPageSteps addProductToCartPageSteps = new AddProductToCartPageSteps();


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void deleteProductsFromCart() {
        mainUnauthorizedPageSteps.openMainPage();
        addProductToCartPageSteps.addProductsToCart(3);
        productDetailPageSteps.clickCheckoutButton();
        checkoutPageSteps.removeProductsFromCart(3);
    }

    @After
    public void tearDown() throws Exception {
        wd.quit();
    }

}