package triptop.groepB4.service;

public class SmsVerifyLoginService {
    public String verificationCode;

    public SmsVerifyLoginService(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getUsername() {
        // get username from verification code
        return "bob"; // mock data
    }

    public boolean authenticate() {
        return verificationCode != null && !verificationCode.isEmpty();
    }
}
