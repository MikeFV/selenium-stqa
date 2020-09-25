package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import PageObjects.Pages;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.Set;

public class EditCountryPageSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;

    public EditCountryPageSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
    }

    public void openExternalLinks() {
        List<WebElement> externalLinks = pages.getEditCountryPage().getExternalLinks();
        for (WebElement externalLink : externalLinks) {
            openExternalLink(externalLink);
        }
    }

    private void openExternalLink(WebElement externalLink) {
        String currentWindow = wd.getWindowHandle();
        Set<String> oldWindows = wd.getWindowHandles();
        externalLink.click();
        baseHelper.fluentWait().until(anyWindowOtherThanOpened(oldWindows));
        Set<String> newWindows = wd.getWindowHandles();
        newWindows.removeAll(oldWindows);
        String openedWindow = newWindows.iterator().next();
        wd.switchTo().window(openedWindow);
        wd.close();
        wd.switchTo().window(currentWindow);
    }


    private ExpectedCondition<String> anyWindowOtherThanOpened(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            @NullableDecl
            @Override
            public String apply(@NullableDecl WebDriver input) {
                Set<String> handles = wd.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }
}
