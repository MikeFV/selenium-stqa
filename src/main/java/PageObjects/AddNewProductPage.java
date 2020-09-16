package PageObjects;

import Objects.Element;

public class AddNewProductPage extends SideMenuPage {
    private NewProductGeneralTab generalTab = new NewProductGeneralTab();
    private NewProductInformationTab informationTab = new NewProductInformationTab();
    private NewProductDataTab dataTab = new NewProductDataTab();
    private Element generalTabSwitcher = new Element("//div[contains(@class, 'tabs')]//a[contains(.,'General')]/parent::li");
    private Element informationTabSwitcher = new Element("//div[contains(@class, 'tabs')]//a[contains(.,'Information')]/parent::li");
    private Element dataTabSwitcher = new Element("//div[contains(@class, 'tabs')]//a[contains(.,'Data')]/parent::li");
    private Element saveButton = new Element("//button[@type = 'submit'][@name = 'save']");

    public Element getGeneralTabSwitcher() {
        return generalTabSwitcher;
    }

    public Element getInformationTabSwitcher() {
        return informationTabSwitcher;
    }

    public Element getDataTabSwitcher() {
        return dataTabSwitcher;
    }

    public Element getSaveButton() {
        return saveButton;
    }

    public NewProductGeneralTab getGeneralTab() {
        return generalTab;
    }

    public NewProductInformationTab getInformationTab() {
        return informationTab;
    }

    public NewProductDataTab getDataTab() {
        return dataTab;
    }


}
