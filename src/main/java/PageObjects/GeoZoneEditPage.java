package PageObjects;

import Objects.Element;

public class GeoZoneEditPage extends SideMenuPage {
    private Element geoZonesEditTableRow = new Element("//table[@id = 'table-zones']//tr/td/input/parent::td/parent::tr");
    private Element getZoneName = new Element(".//td[3]");

    public Element getGeoZonesEditTableRow() {
        return geoZonesEditTableRow;
    }

    public Element getGetZoneName() {
        return getZoneName;
    }
}
