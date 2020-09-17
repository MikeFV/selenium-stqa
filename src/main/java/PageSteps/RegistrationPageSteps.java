package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import Contexts.LoginContext;
import PageObjects.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class RegistrationPageSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;
    private LoginContext loginContext;

    public RegistrationPageSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
        this.loginContext = LoginContext.getInstance();
    }

    public void setTaxId(String taxId) {
        pages.getRegistrationPage().getTaxId().getElement().sendKeys(taxId);
    }

    public void setCompany(String company) {
        pages.getRegistrationPage().getCompany().getElement().sendKeys(company);
    }

    public void setFirstName(String name) {
        pages.getRegistrationPage().getFirstname().getElement().sendKeys(name);
    }

    public void setLastName(String lastName) {
        pages.getRegistrationPage().getLastName().getElement().sendKeys(lastName);
    }

    public void setAddress1(String firstAddress) {
        pages.getRegistrationPage().getFirstAddress().getElement().sendKeys(firstAddress);
    }

    public void setAddress2(String secondAddress) {
        pages.getRegistrationPage().getSecondAddress().getElement().sendKeys(secondAddress);
    }

    public void setValidPostCode() {
        Random random = new Random();
        Integer max = 999999;
        Integer min = 111111;
        String randomIndexValue = String.valueOf(random.nextInt(((max - min) + 1) + min));
        pages.getRegistrationPage().getPostcode().getElement().sendKeys(randomIndexValue);
    }

    public void setCity(String city) {
        pages.getRegistrationPage().getCity().getElement().sendKeys(city);
    }

    public void setValidEmail() {
        String email = generateRandomString(8) + "@" + generateRandomString(3) + "." + generateRandomString(3);
        pages.getRegistrationPage().getEmail().getElement().sendKeys(email);
        loginContext.setEmail(email);
    }

    public void setValidPhone() {
        pages.getRegistrationPage().getPhone().getElement().sendKeys("79876543210");
    }

    public void setDesiredPassword(String password) {
        pages.getRegistrationPage().getDesiredPassword().getElement().sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        pages.getRegistrationPage().getConfirmPassword().getElement().sendKeys(password);
    }

    public void clickCreateAccountButton() {
        pages.getRegistrationPage().getCreateAccountButton().getElement().click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getMainAuthorizedPage().getRegistrationSuccess().getElement()));

    }

    private String generateRandomString(Integer stringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
