import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private String driversPath = "drivers";
    private String chromedriverWin = "chromedriver.exe";
    private WebDriver webDriver = null;


    public WebDriverManager() {}

    private Path getAbsPathToWD() {
        return Paths.get((this.driversPath + File.separator + this.chromedriverWin)).toAbsolutePath();
    }

    private void setEnvironmentVariable() {
        System.setProperty("webdriver.chrome.driver", getAbsPathToWD().toString());
    }

    public WebDriver getDriver() {
        if (this.webDriver == null) {
            setEnvironmentVariable();
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
        return this.webDriver;
    }

}
