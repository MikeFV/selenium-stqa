package Objects;

import java.io.File;
import java.nio.file.Paths;

public class UploadImage extends Element {

    public UploadImage(String xpath) {
        super(xpath);
    }

    public void upload(String fileName) {
        getElement().sendKeys(
            Paths.get((
                "src" + File.separator +
                "main" + File.separator +
                "resources" + File.separator +
                "images" + File.separator +
                fileName))
                    .toAbsolutePath()
                    .toString()
        );
    }

    private void set() {}
}
