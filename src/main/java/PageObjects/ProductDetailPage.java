package PageObjects;

import Objects.ComboBox;
import Objects.Element;

public class ProductDetailPage {
    private Element productDetailFragment = new Element("//div[@id = 'box-product']");
    private Element addToCartButton = new Element("//button[@type = 'submit'][@name = 'add_cart_product']");
    private Element cartProductsQuantity = new Element("//span[contains(@class, 'quantity')]");
    private Element checkoutButton = new Element("//a[contains(., 'Checkout')]");
    private Element mainPageButton = new Element("//li[contains(@class, 'general-0')]");
    private ComboBox productProperties = new ComboBox("//select");

    public Element getProductDetailFragment() {
        return productDetailFragment;
    }

    public Element getAddToCartButton() {
        return addToCartButton;
    }

    public Element getCartProductsQuantity() {
        return cartProductsQuantity;
    }

    public Element getCheckoutButton() {
        return checkoutButton;
    }

    public Element getMainPageButton() {
        return mainPageButton;
    }

    public ComboBox getProductProperties() {
        return productProperties;
    }
}
