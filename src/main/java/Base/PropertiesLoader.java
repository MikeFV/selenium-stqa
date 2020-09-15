package Base;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private String propertiesFileName = "local.properties";
    private InputStream inputStream;
    private Properties properties;

    public void PropertiesLoader() {}

    public Properties loadProperties() {
        properties = new Properties();
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
            if (inputStream != null) {
                properties.load(inputStream);
                return properties;
            } else throw new FileNotFoundException("Properites file is absent: " + propertiesFileName);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return null;
    }
}
