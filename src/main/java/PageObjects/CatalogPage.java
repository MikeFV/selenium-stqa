package PageObjects;

import Objects.Element;

public class CatalogPage extends SideMenuPage {
    private Element addNewProductButton = new Element("//a[contains(@class, 'button')][contains(text(), 'Add New Product')]");
    private Element newProductTableRow = new Element("//tr[contains(@class, 'row')]");
    private Element newProductName = new Element(".//a");

    public Element getAddNewProductButton() {
        return addNewProductButton;
    }

    public Element getNewProductTableRow() {
        return newProductTableRow;
    }

    public Element getNewProductName() {
        return newProductName;
    }
}
