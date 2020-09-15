package PageObjects;

import Objects.Element;

public class SideMenuPage {
    private Element header = new Element("//h1");

    public Element getHeader() {
        return header;
    }

    public Element getHeaderByName(String header) {
        return new Element(String.format("//h1[contains(text(),'%s')]", header));
    }
}
