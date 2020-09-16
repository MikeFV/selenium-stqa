package Objects;

public class NumberField extends Element {
    public NumberField(String xpath) {
        super(xpath);
    }

    public void setValue(String value) {
        getElement().clear();
        getElement().sendKeys(value);
    }

    public void setValue(Integer value) {
        getElement().clear();
        getElement().sendKeys(String.valueOf(value));
    }

    public void setValue(Float value) {
        getElement().clear();
        getElement().sendKeys(String.valueOf(value));
    }
}
