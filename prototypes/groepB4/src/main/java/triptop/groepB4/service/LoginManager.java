package triptop.groepB4.service;

public class LoginManager {
    private LoginService loginService;

    public LoginManager(LoginService loginService) {
        this.loginService = loginService;
    }

    public String login() {
        return loginService.getUsername(); // convert to JWT
    }
}
