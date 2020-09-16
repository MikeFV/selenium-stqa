package PageObjects;

import Objects.Element;

public class RegistrationPage {
    private Element registrationFormHeader = new Element("//h1[contains(.,'Create Account')]");
    private Element taxId = new Element("//input[@type = 'text'][@name = 'tax_id']");
    private Element company = new Element("//input[@type = 'text'][@name = 'company']");
    private Element firstname = new Element("//input[@type = 'text'][@name = 'firstname']");
    private Element lastName = new Element("//input[@type = 'text'][@name = 'lastname']");
    private Element firstAddress = new Element("//input[@type = 'text'][@name = 'address1']");
    private Element secondAddress = new Element("//input[@type = 'text'][@name = 'address2']");
    private Element postcode = new Element("//input[@type = 'text'][@name = 'postcode']");
    private Element city = new Element("//input[@type = 'text'][@name = 'city']");
    private Element email = new Element("//input[@type = 'email'][@name = 'email']");
    private Element phone = new Element("//input[@type = 'tel'][@name = 'phone']");
    private Element desiredPassword = new Element("//input[@type = 'password'][@name = 'password']");
    private Element confirmPassword = new Element("//input[@type = 'password'][@name = 'confirmed_password']");
    private Element createAccountButton = new Element("//button[@type = 'submit'][@name = 'create_account']");

    public Element getRegistrationFormHeader() {
        return registrationFormHeader;
    }

    public Element getTaxId() {
        return taxId;
    }

    public Element getCompany() {
        return company;
    }

    public Element getFirstname() {
        return firstname;
    }

    public Element getLastName() {
        return lastName;
    }

    public Element getFirstAddress() {
        return firstAddress;
    }

    public Element getSecondAddress() {
        return secondAddress;
    }

    public Element getPostcode() {
        return postcode;
    }

    public Element getCity() {
        return city;
    }

    public Element getEmail() {
        return email;
    }

    public Element getPhone() {
        return phone;
    }

    public Element getDesiredPassword() {
        return desiredPassword;
    }

    public Element getConfirmPassword() {
        return confirmPassword;
    }

    public Element getCreateAccountButton() {
        return createAccountButton;
    }
}
