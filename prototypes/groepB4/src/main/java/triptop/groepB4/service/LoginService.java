package triptop.groepB4.service;

public abstract class LoginService {
    abstract String getUsername();
    public String login() {
        String username = getUsername();
        // convert to JWT
        return username;
    }
}
