package Base;

import java.util.Properties;

public class BaseManager {
    private static BaseManager instance = null;
    private WebDriverManager webDriverManager;
    private BaseHelper baseHelper;
    private Properties properties;

    private BaseManager() {
        webDriverManager = new WebDriverManager(Browser.valueOf(getProperty("browser")));
        baseHelper = BaseHelper.getInstance();
    }

    public static BaseManager getInstance() {
        if (instance == null) {
            instance = new BaseManager();
        }
        return instance;
    }

    public String getProperty(String propertyName) {
        if (properties == null) {
            PropertiesLoader propertiesLoader = new PropertiesLoader();
            properties = propertiesLoader.loadProperties();
        }
        return properties.getProperty(propertyName);
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public BaseHelper getBaseHelper() {
        return baseHelper;
    }
}
