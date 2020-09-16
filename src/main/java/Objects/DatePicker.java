package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePicker extends Element {
    private By xpath;
    private String datePattern = "YYYY-MM-dd";
    private SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);

    public DatePicker(String xpath) {
        super(xpath);
    }

    public void set(Date date) {
        getElement().click();
        getElement().sendKeys(Keys.HOME);
        getElement().sendKeys(dateFormat.format(date));
    }
}
