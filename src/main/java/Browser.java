import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum Browser {
    CHROME (ChromeDriver.class, "chromedriver.exe", "webdriver.chrome.driver");

    Browser(Class<ChromeDriver> webDriver , String driverFileName, String driverSystemPropertyName) {}
}
