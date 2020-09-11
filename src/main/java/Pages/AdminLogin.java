package Pages;

public class AdminLogin {
    String userNameField = "//input[@name = 'username']";
    String passwordField = "//input[@name = 'password']";
    String loginButton = "//button[@name = 'login']";

    public String getUserNameField() {
        return userNameField;
    }

    public String getPasswordField() {
        return passwordField;
    }

    public String getLoginButton() {
        return loginButton;
    }
}
