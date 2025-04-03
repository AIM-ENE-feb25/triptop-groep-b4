package triptop.groepB4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import triptop.groepB4.service.SmsVerifyLoginService;
import triptop.groepB4.service.SmsVerifyLoginServiceAdapter;

@RestController
@RequestMapping("/login/sms-verify")
public class SmsVerifyLoginController {
    @PostMapping
    ResponseEntity<String> login(@RequestBody String verificationCode) {
        return ResponseEntity.ok(new SmsVerifyLoginServiceAdapter(new SmsVerifyLoginService(verificationCode)).login());
    }
}
