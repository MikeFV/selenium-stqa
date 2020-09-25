package PageObjects;

import Objects.Element;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EditCountryPage {
    private Element codeAlpha2ExternalLink = new Element("//td[contains(.,'(ISO 3166-1 alpha-2)')]/strong[contains(.,'Code')]/following-sibling::a");
    private Element codeAlpha3ExternalLinkv = new Element("//td[contains(.,'(ISO 3166-1 alpha-3)')]/strong[contains(.,'Code')]/following-sibling::a");
    private Element taxIdFormatExternalLink = new Element("//strong[contains(.,'Tax ID Format')]/following-sibling::a");
    private Element addressFormatExternalLink = new Element("//strong[contains(.,'Address Format')]/following-sibling::a[2]");
    private Element postCodeFormatExternalLink = new Element("//strong[contains(.,'Postcode Format')]/following-sibling::a");
    private Element currencyCodeFormatExternalLink = new Element("//strong[contains(.,'Currency Code')]/following-sibling::a");
    private Element phoneCountryCodeFormatExternalLink = new Element("//strong[contains(.,'Phone Country Code')]/following-sibling::a");
    private Element externalLinks = new Element("//form[@method='post']//table//a[not(@id='address-format-hint')]");


    public Element getCodeAlpha2ExternalLink() {
        return codeAlpha2ExternalLink;
    }

    public Element getCodeAlpha3ExternalLinkv() {
        return codeAlpha3ExternalLinkv;
    }

    public Element getTaxIdFormatExternalLink() {
        return taxIdFormatExternalLink;
    }

    public Element getAddressFormatExternalLink() {
        return addressFormatExternalLink;
    }

    public Element getPostCodeFormatExternalLink() {
        return postCodeFormatExternalLink;
    }

    public Element getCurrencyCodeFormatExternalLink() {
        return currencyCodeFormatExternalLink;
    }

    public Element getPhoneCountryCodeFormatExternalLink() {
        return phoneCountryCodeFormatExternalLink;
    }

    public List<WebElement> getExternalLinks() {
        return externalLinks.getElements();
    }
}
