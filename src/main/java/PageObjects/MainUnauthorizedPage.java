package PageObjects;

import Objects.Element;

public class MainUnauthorizedPage {
    private Element loginForm = new Element("//div[@id = 'box-account-login']");
    private Element registerButton = new Element("//a[contains(.,'New customers click here')]");
    private Element email = new Element("//input[@type = 'text'][@name = 'email']");
    private Element password = new Element("//input[@type = 'password'][@name = 'password']");
    private Element loginButton = new Element("//button[@type = 'submit'][@name = 'login']");

    public Element getLoginForm() {
        return loginForm;
    }

    public Element getRegisterButton() {
        return registerButton;
    }

    public Element getEmail() {
        return email;
    }

    public Element getPassword() {
        return password;
    }

    public Element getLoginButton() {
        return loginButton;
    }
}
