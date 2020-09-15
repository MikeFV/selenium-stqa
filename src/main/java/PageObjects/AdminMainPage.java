package PageObjects;

import Objects.Element;

public class AdminMainPage {
    private Element sideMenu = new Element("//ul[@id = 'box-apps-menu']");

    public Element getSideMenuElement(String sideMenuElementName) {
        return new Element(String.format("//ul[@id = 'box-apps-menu']/li[@id = 'app-'][contains(.,'%s')]", sideMenuElementName));
    }
}
