package Contexts;

public class LoginContext {
    private String email;

    private static LoginContext ourInstance = new LoginContext();

    public static LoginContext getInstance() {
        return ourInstance;
    }

    private LoginContext() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static LoginContext getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(LoginContext ourInstance) {
        LoginContext.ourInstance = ourInstance;
    }
}
