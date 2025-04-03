package triptop.groepB4;

import triptop.groepB4.service.*;

public class Main {
    public static void main(String[] args) {
        LoginService loginService1 = new IdentityProviderLoginServiceAdapter(new IdentityProviderLoginService("username", "password"));
        String token1 = loginService1.login();

        LoginService loginService2 = new SmsVerifyLoginServiceAdapter(new SmsVerifyLoginService("abc123"));
        String token2 = loginService2.login();
    }
}
