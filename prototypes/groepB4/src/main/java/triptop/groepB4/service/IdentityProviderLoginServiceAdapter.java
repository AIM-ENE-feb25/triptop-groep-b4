package triptop.groepB4.service;

public class IdentityProviderLoginServiceAdapter implements LoginService {
    private IdentityProviderLoginService identityProviderLoginService;

    public IdentityProviderLoginServiceAdapter(IdentityProviderLoginService identityProviderLoginService) {
        this.identityProviderLoginService = identityProviderLoginService;
    }

    @Override
    public String getUsername() {
        if (identityProviderLoginService.authenticate()) {
            return identityProviderLoginService.getUsername();
        } else {
            return null;
        }
    }
}
