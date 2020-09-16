package Objects;

public class CheckBox extends Element {
    public CheckBox(String xpath) {
        super(xpath);
    }

    public void set() {
        if (!isSet()) {
            getElement().click();
        }
    }

    public void unset() {
        if (isSet()) {
            getElement().click();
        }
    }

    private Boolean isSet() {
        return wd.findElement(xpath).getAttribute("checked") != null;
    }

}
