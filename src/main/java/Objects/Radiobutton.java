package Objects;

public class Radiobutton extends Element {
    public Radiobutton(String xpath) {
        super(xpath);
    }

    public void set() {
        if (getElement().getAttribute("checked") == null) {
            getElement().click();
        }
    }
}
