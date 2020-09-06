import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum Browser {
    CHROME ("chromedriver.exe", "webdriver.chrome.driver"),
    FIREFOX ("geckodriver.exe", "webdriver.gecko.driver");


    private String driverFileName;
    private String driverSystemPropertyName;



    Browser(String driverFileName, String driverSystemPropertyName) {

        this.driverFileName = driverFileName;
        this.driverSystemPropertyName = driverSystemPropertyName;
    }

    public String getDriverFileName() {
        return driverFileName;
    }

    public String getDriverSystemPropertyName() {
        return driverSystemPropertyName;
    }
}
