package triptop.groepB4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import triptop.groepB4.domein.IdentityProviderLoginBody;
import triptop.groepB4.service.IdentityProviderLoginService;
import triptop.groepB4.service.IdentityProviderLoginServiceAdapter;

@RestController
@RequestMapping("/login/identity-provider")
public class IdentityProviderLoginController {
    @PostMapping
    ResponseEntity<String> login(@RequestBody IdentityProviderLoginBody identityProviderLoginBody) {
        return ResponseEntity.ok(new IdentityProviderLoginServiceAdapter(new IdentityProviderLoginService(identityProviderLoginBody.username, identityProviderLoginBody.password)).login());
    }
}
