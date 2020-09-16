package PageSteps;

import Base.BaseHelper;
import Base.BaseManager;
import Objects.ProductGroup;
import PageObjects.Pages;
import PageObjects.ProductStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Date;

public class AddNewProductPageSteps {
    private WebDriver wd;
    private Pages pages;
    private BaseHelper baseHelper;

    public AddNewProductPageSteps() {
        this.wd = BaseManager.getInstance().getWebDriverManager().getDriver();
        this.pages = Pages.getInstance();
        this.baseHelper = BaseManager.getInstance().getBaseHelper();
    }

    public void setStatus(ProductStatus status) {
        switch (status) {
            case ENABLED: pages.getAddNewProductPage().getGeneralTab().getStatusEnabled().set(); break;
            case DISABLED: pages.getAddNewProductPage().getGeneralTab().getStatusDisabled().set(); break;
        }
    }

    public void setName(String name) {
        pages.getAddNewProductPage().getGeneralTab().getName().getElement().sendKeys(name);
    }

    public void setCode(String code) {
        pages.getAddNewProductPage().getGeneralTab().getCode().getElement().sendKeys(code);
    }

    public void setProductGroup(ProductGroup productGroup) {
        pages.getAddNewProductPage().getGeneralTab().getProductGroup(productGroup.getGroup()).set();
    }

    public void setQuantity(Integer quantity) {
        pages.getAddNewProductPage().getGeneralTab().getQuantity().setValue(quantity);
    }

    public void uploadImage(String imageName) {
        pages.getAddNewProductPage().getGeneralTab().getUploadImages().upload(imageName);
    }

    public void setDateValidFrom(Date date) {
        pages.getAddNewProductPage().getGeneralTab().getDateValidFrom().set(date);
    }

    public void setDateValidTo(Date date) {
        pages.getAddNewProductPage().getGeneralTab().getDateValidTo().set(date);
    }

    public void switchToInformationTab() {
        pages.getAddNewProductPage().getInformationTabSwitcher().getElement().click();
        baseHelper.fluentWait().until(ExpectedConditions.attributeToBe(pages.getAddNewProductPage().getInformationTabSwitcher().getXpath(), "class", "active"));
    }

    public void setKeywords(String keywords) {
        pages.getAddNewProductPage().getInformationTab().getKeywords().getElement().sendKeys(keywords);
    }

    public void setShortDescription(String shortDescription) {
        pages.getAddNewProductPage().getInformationTab().getShortDescriptions().getElement().sendKeys(shortDescription);
    }

    public void setDescription(String description) {
        pages.getAddNewProductPage().getInformationTab().getDescription().getElement().sendKeys(description);
    }

    public void setHeadTitle(String headTitle) {
        pages.getAddNewProductPage().getInformationTab().getHeadTitle().getElement().sendKeys(headTitle);
    }

    public void setMetaDescription(String metaDescription) {
        pages.getAddNewProductPage().getInformationTab().getMetaDescription().getElement().sendKeys(metaDescription);
    }

    public void switchToDataTab() {
        pages.getAddNewProductPage().getDataTabSwitcher().getElement().click();
        baseHelper.fluentWait().until(ExpectedConditions.attributeToBe(pages.getAddNewProductPage().getDataTabSwitcher().getXpath(),"class", "active"));
    }

    public void setSku(String sku) {
        pages.getAddNewProductPage().getDataTab().getSku().getElement().sendKeys(sku);
    }

    public void setGtin(String gtin) {
        pages.getAddNewProductPage().getDataTab().getGtin().getElement().sendKeys(gtin);
    }

    public void setTaric(String taric) {
        pages.getAddNewProductPage().getDataTab().getTaric().getElement().sendKeys(taric);
    }

    public void setWeight(Integer weight) {
        pages.getAddNewProductPage().getDataTab().getWeight().setValue(weight);
    }

    public void setWidth(Integer width) {
        pages.getAddNewProductPage().getDataTab().getWidth().setValue(width);
    }

    public void setHeight(Integer height) {
        pages.getAddNewProductPage().getDataTab().getWidth().setValue(height);
    }

    public void setLength(Integer length) {
        pages.getAddNewProductPage().getDataTab().getLength().setValue(length);
    }

    public void setAttributes(String attributes) {
        pages.getAddNewProductPage().getDataTab().getAttributes().getElement().sendKeys(attributes);
    }

    public void save() {
        pages.getAddNewProductPage().getSaveButton().click();
        baseHelper.fluentWait().until(ExpectedConditions.visibilityOf(pages.getCatalogPage().getHeaderByName("Catalog").getElement()));
    }
}
