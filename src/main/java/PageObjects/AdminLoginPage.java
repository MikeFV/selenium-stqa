package PageObjects;

import Objects.Element;

public class AdminLoginPage {
    private Element userNameField = new Element("//input[@name = 'username']");
    private Element passwordField = new Element("//input[@name = 'password']");
    private Element loginButton = new Element("//button[@name = 'login']");

    public Element getUserNameField() {
        return userNameField;
    }

    public Element getPasswordField() {
        return passwordField;
    }

    public Element getLoginButton() {
        return loginButton;
    }
}
