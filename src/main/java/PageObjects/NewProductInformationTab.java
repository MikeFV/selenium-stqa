package PageObjects;

import Objects.Element;

public class NewProductInformationTab {
    private Element keywords = new Element("//input[@type = 'text'][@name = 'keywords']");
    private Element shortDescriptions = new Element("//input[@type = 'text'][@name = 'short_description[en]']");
    private Element description = new Element("//div[contains(@class, 'trumbowyg-editor')][@dir = 'ltr']");
    private Element headTitle = new Element("//input[@type = 'text'][@name = 'head_title[en]']");
    private Element metaDescription = new Element("//input[@type = 'text'][@name = 'meta_description[en]']");

    public Element getKeywords() {
        return keywords;
    }

    public Element getShortDescriptions() {
        return shortDescriptions;
    }

    public Element getDescription() {
        return description;
    }

    public Element getHeadTitle() {
        return headTitle;
    }

    public Element getMetaDescription() {
        return metaDescription;
    }
}
