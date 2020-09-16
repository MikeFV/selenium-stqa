package PageObjects;

import Objects.Element;

public class MainAuthorizedPage {
    private Element authorizationSuccess = new Element("//div[contains(@class, 'notice success')][contains(.,'You are now logged in as')]");
    private Element registrationSuccess = new Element("//div[contains(@class, 'notice success')][contains(.,'Your customer account has been created.')]");
    private Element logoutButton = new Element("//div[@id = 'box-account']//a[contains(text(),'Logout')]");

    public Element getAuthorizationSuccess() {
        return authorizationSuccess;
    }

    public Element getLogoutButton() {
        return logoutButton;
    }

    public Element getRegistrationSuccess() {
        return registrationSuccess;
    }
}
