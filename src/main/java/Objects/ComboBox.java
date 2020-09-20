package Objects;

import org.openqa.selenium.By;

public class ComboBox extends Element {
    public ComboBox(String xpath) {
        super(xpath);
    }

    public void setValue(String value) {
        getElement().click();
        getElement().findElement(By.xpath(String.format(".//option[contains(.,'%s')]", value))).click();
    }

    public void setRandomValue() {
        getElement().click();
        if (getElement().findElements(By.xpath(".//option")).size() > 1) {
            getElement().findElements(By.xpath(".//option")).get(1).click();
        }
        else throw new IllegalStateException("can't set random property because property list is empty");
    }
}
