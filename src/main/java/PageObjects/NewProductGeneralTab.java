package PageObjects;

import Objects.*;

public class NewProductGeneralTab {
    //todo: создать кастомный тип для radiobutton
    private Radiobutton statusEnabled = new Radiobutton("//input[@type = 'radio']/parent::label[contains(text(), 'Enabled')]/input");
    private Radiobutton statusDisabled = new Radiobutton("//input[@type = 'radio']/parent::label[contains(text(), 'Disabled')]/input");
    private Element name = new Element("//strong[contains(text(), 'Name')]/following-sibling::span/input");
    private Element code = new Element("//input[@type= 'text'][@name = 'code']");
    private Element groups = new Element("//strong[contains(text(), 'Product Groups')]/following-sibling::div");
    //todo: кастомный тип кастомный тип (clear, затем send keys)
    private NumberField quantity = new NumberField("//input[@type = 'number'][@name = 'quantity']");
    private UploadImage uploadImages = new UploadImage("//input[@type = 'file']");
    //todo: создать кастомный тип для календаря
    private DatePicker dateValidFrom = new DatePicker("//strong[contains(text(), 'Date Valid From')]/following-sibling::input[@type = 'date']");
    private DatePicker dateValidTo = new DatePicker("//strong[contains(text(), 'Date Valid To')]/following-sibling::input[@type = 'date']");


    public Element getGroups() {
        return groups;
    }

    public CheckBox getProductGroup(String productGroup) {
        return new CheckBox(String.format("//td[contains(text(), '%s')]/preceding-sibling::td/input", productGroup));
    }

    public Radiobutton getStatusEnabled() {
        return statusEnabled;
    }

    public Radiobutton getStatusDisabled() {
        return statusDisabled;
    }

    public Element getName() {
        return name;
    }

    public Element getCode() {
        return code;
    }

    public NumberField getQuantity() {
        return quantity;
    }

    public UploadImage getUploadImages() {
        return uploadImages;
    }

    public DatePicker getDateValidFrom() {
        return dateValidFrom;
    }

    public DatePicker getDateValidTo() {
        return dateValidTo;
    }
}
