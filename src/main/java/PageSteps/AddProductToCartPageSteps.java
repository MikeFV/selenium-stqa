package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import PageObjects.Pages;
import org.openqa.selenium.WebDriver;

public class AddProductToCartPageSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;
    private MainUnauthorizedPageSteps mainUnauthorizedPageSteps;
    private ProductDetailPageSteps productDetailPageSteps;

    public AddProductToCartPageSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
        this.productDetailPageSteps = new ProductDetailPageSteps();
        this.mainUnauthorizedPageSteps = new MainUnauthorizedPageSteps();
    }

    public void addProductsToCart(Integer countOfProducts) {
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
