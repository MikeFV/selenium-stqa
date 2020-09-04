import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class Main {
    public static void main(String[] args) {
        BaseManager bm = BaseManager.getInstance();
        System.out.println(bm.getProperty("browser"));
    }
}
