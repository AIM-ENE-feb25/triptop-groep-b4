package triptop.groepB4;

import triptop.groepB4.service.IdentityProviderLoginService;
import triptop.groepB4.service.IdentityProviderLoginServiceAdapter;
import triptop.groepB4.service.LoginService;

public class Main {
    public static void main(String[] args) {
        LoginService loginService = new IdentityProviderLoginServiceAdapter(new IdentityProviderLoginService("username", "password"));
        String token = loginService.login();
    }
}
