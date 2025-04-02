package triptop.groepB4.service;

public class IdentityProviderLoginService {
    public String username;
    public String password;

    public IdentityProviderLoginService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate() {
        return password != null && !password.isEmpty();
    }
}
