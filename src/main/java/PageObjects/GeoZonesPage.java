package PageObjects;

import Objects.Element;

public class GeoZonesPage extends SideMenuPage {
    private Element geoZonesTableRow = new Element("//form[@name = 'geo_zones_form']//table[contains(@class, 'dataTable')]//tr[contains(@class, 'row')]");
    private Element countryName = new Element(".//td[3]");
    private Element zonesCount = new Element(".//td[4]");

    public Element getGeoZonesTableRow() {
        return geoZonesTableRow;
    }

    public Element getCountryName() {
        return countryName;
    }

    public Element getCountryByName(String countryName) {
        return new Element(String.format("//td/a[contains(.,'%s')]", countryName));
    }

    public Element getZonesCount() {
        return zonesCount;
    }
}
