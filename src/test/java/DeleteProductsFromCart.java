import Base.BaseHelper;
import Base.BaseManager;
import PageObjects.Pages;
import PageSteps.CheckoutPageSteps;
import PageSteps.MainUnauthorizedPageSteps;
import PageSteps.ProductDetailPageSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DeleteProductsFromCart {
    private BaseManager bm;
    private WebDriver wd;
    private BaseHelper baseHelper;
    private Pages pages;
    private MainUnauthorizedPageSteps mainUnauthorizedPageSteps = new MainUnauthorizedPageSteps();
    private ProductDetailPageSteps productDetailPageSteps = new ProductDetailPageSteps();
    private CheckoutPageSteps checkoutPageSteps = new CheckoutPageSteps();


    @Before
    public void setUp() throws Exception {
        bm = BaseManager.getInstance();
        wd = bm.getWebDriverManager().getDriver();
        baseHelper = bm.getBaseHelper();
        pages = Pages.getInstance();
    }

    @Test
    public void deleteProductsFromCart() {
        mainUnauthorizedPageSteps.openMainPage();
        addProductsToCart(3);
        productDetailPageSteps.clickCheckoutButton();
        checkoutPageSteps.removeProducts(3);
    }

    @After
    public void tearDown() throws Exception {
        wd.close();
    }

    private void addProductsToCart(Integer countOfProducts) {
        for (Integer productsCounter = 0; productsCounter < countOfProducts; productsCounter++) {
            mainUnauthorizedPageSteps.clickOnMostPopularProduct(0);
            productDetailPageSteps.setRandomProductPropertyIfExists();
            productDetailPageSteps.clickAddToCartButton();
            if (productsCounter < countOfProducts) {
                productDetailPageSteps.clickMainPageButton();
            }

        }
    }

}