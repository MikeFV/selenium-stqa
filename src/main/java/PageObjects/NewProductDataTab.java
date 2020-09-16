package PageObjects;

import Objects.Element;
import Objects.NumberField;

public class NewProductDataTab {
    private Element sku = new Element("//input[@type = 'text'][@name = 'sku']");
    private Element gtin = new Element("//input[@type = 'text'][@name = 'gtin']");
    private Element taric = new Element("//input[@type = 'text'][@name = 'taric']");
    private NumberField weight = new NumberField("//strong[contains(.,'Weight')]/following-sibling::input[@type = 'number']");
    private NumberField width = new NumberField("//input[@type = 'number'][@name = 'dim_x']");
    private NumberField height = new NumberField("//input[@type = 'number'][@name = 'dim_y']");
    private NumberField length = new NumberField("//input[@type = 'number'][@name = 'dim_z']");
    private Element attributes = new Element("//textarea[@name = 'attributes[en]']");

    public Element getSku() {
        return sku;
    }

    public Element getGtin() {
        return gtin;
    }

    public Element getTaric() {
        return taric;
    }

    public NumberField getWeight() {
        return weight;
    }

    public NumberField getWidth() {
        return width;
    }

    public NumberField getHeight() {
        return height;
    }

    public NumberField getLength() {
        return length;
    }

    public Element getAttributes() {
        return attributes;
    }
}
