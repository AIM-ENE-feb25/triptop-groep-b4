package triptop.groepB4.service;

import org.springframework.stereotype.Service;

@Service
public class SmsVerifyLoginServiceAdapter extends LoginService {
    private SmsVerifyLoginService smsVerifyLoginService;

    public SmsVerifyLoginServiceAdapter(SmsVerifyLoginService smsVerifyLoginService) {
        this.smsVerifyLoginService = smsVerifyLoginService;
    }

    @Override
    public String getUsername() {
        if (smsVerifyLoginService.authenticate()) {
            return smsVerifyLoginService.getUsername();
        } else {
            return null;
        }
    }
}
