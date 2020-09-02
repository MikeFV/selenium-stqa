import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseHelper {
    private static BaseHelper ourInstance = new BaseHelper();

    public static BaseHelper getInstance() {
        return ourInstance;
    }

    private BaseHelper() {
    }

    public FluentWait<WebDriver> fluentWait() {
        return new WebDriverWait(BaseManager.getInstance().getWebDriverManager().getDriver(), 10).pollingEvery(200, TimeUnit.MILLISECONDS);
    }
}
