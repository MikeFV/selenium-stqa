package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import Objects.Element;
import PageObjects.Pages;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

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

    public void openAndCloseExternalLinks() {
        openExternalLink(pages.getEditCountryPage().getCodeAlpha2ExternalLink());
        openExternalLink(pages.getEditCountryPage().getCodeAlpha3ExternalLinkv());
        openExternalLink(pages.getEditCountryPage().getTaxIdFormatExternalLink());
        openExternalLink(pages.getEditCountryPage().getAddressFormatExternalLink());
        openExternalLink(pages.getEditCountryPage().getPostCodeFormatExternalLink());
        openExternalLink(pages.getEditCountryPage().getCurrencyCodeFormatExternalLink());
        openExternalLink(pages.getEditCountryPage().getPhoneCountryCodeFormatExternalLink());
    }

    private void openExternalLink(Element externalLink) {
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
