public class BaseManager {
    private static BaseManager instance = null;
    private WebDriverManager webDriverManager;
    private BaseHelper baseHelper;

    private BaseManager() {
        webDriverManager = new WebDriverManager();
        baseHelper = BaseHelper.getInstance();
    }

    public static BaseManager getInstance() {
        if (instance == null) {
            instance = new BaseManager();
        }
        return instance;
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public BaseHelper getBaseHelper() {
        return baseHelper;
    }
}
