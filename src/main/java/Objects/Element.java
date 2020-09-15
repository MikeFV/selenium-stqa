package Objects;

import Base.BaseHelper;
import Base.BaseManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Element {
    private By xpath;
    private WebDriver wd;
    private BaseHelper bh;

    public Element(String xpath) {
        this.xpath = By.xpath(xpath);
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.bh = BaseManager.getInstance().getBaseHelper();
    }

    public WebElement getElement() {
        return wd.findElement(this.xpath);
    }

    public List<WebElement> getElements() {
        return wd.findElements(this.xpath);
    }

    public By getXpath() {
        return xpath;
    }
}
