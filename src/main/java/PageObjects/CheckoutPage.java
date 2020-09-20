package PageObjects;

import Objects.Element;

public class CheckoutPage {
    private Element checkoutProductsFragment = new Element("//div[@id = 'checkout-cart-wrapper']");
    private Element productName = new Element("//form[@name = 'cart_form']/div//a");
    private Element productPreview = new Element("//ul[contains(@class, 'shortcut')]/li[contains(@class, 'shortcut')]");
    private Element orderSummaryTable = new Element("//table[contains(@class,'dataTable')]");
    private Element removeProductButton = new Element("//button[@type = 'submit'][@name = 'remove_cart_item']");

    public Element getCheckoutProductsFragment() {
        return checkoutProductsFragment;
    }

    public Element getProductName() {
        return productName;
    }

    public Element getProductPreview() {
        return productPreview;
    }

    public Element getOrderSummaryRow(String productName) {
        return new Element(String.format("//td[contains(.,'%s')][contains(@class, 'item')]/parent::tr", productName));
    }

    public Element getOrderSummaryTable() {
        return orderSummaryTable;
    }

    public Element getRemoveProductButton() {
        return removeProductButton;
    }
}
