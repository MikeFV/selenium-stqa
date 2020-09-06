import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private Browser browser;
    private String driversPath = "drivers";
    private WebDriver webDriver = null;


    public WebDriverManager(Browser browser) {
        this.browser = browser;
    }

    private String getAbsPathToWD() {
        return Paths.get((this.driversPath + File.separator + this.browser.getDriverFileName())).toAbsolutePath().toString();
    }

    private void setEnvironmentVariable() {
        System.setProperty(this.browser.getDriverSystemPropertyName(), getAbsPathToWD());
    }

    public WebDriver getDriver() {
        if (this.webDriver == null) {
            setEnvironmentVariable();
            switch (browser) {
                case CHROME: webDriver = new ChromeDriver();
                    break;
                case FIREFOX: webDriver = new FirefoxDriver();
                    break;
            }
            }
            webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return this.webDriver;
    }

}
