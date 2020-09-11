package PageObjects;

public class Pages {
    private static Pages instance = null;

    private AdminLogin adminLogin;


    private Pages() {
        adminLogin = new AdminLogin();
    }

    public static Pages getInstance() {
        if (instance == null) {
            instance = new Pages();
        }
        return instance;
    }

    public AdminLogin getAdminLogin() {
        return adminLogin;
    }
}
