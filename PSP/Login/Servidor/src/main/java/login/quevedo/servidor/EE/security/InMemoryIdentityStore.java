package login.quevedo.servidor.EE.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

import java.util.Collections;

import static jakarta.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

@ApplicationScoped
public class InMemoryIdentityStore implements IdentityStore {

    @Override
    public int priority() {
        return 10;
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {

        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential user = UsernamePasswordCredential
                    .class.cast(credential);



            switch (user.getCaller()) {
                case "admin":
                    return new CredentialValidationResult("admin", Collections.singleton("ADMIN"));
                case "paco":
                    return new CredentialValidationResult("paco", Collections.singleton("user"));
                case "user":
                    return new CredentialValidationResult("user", Collections.singleton("user"));
                default:
                    return INVALID_RESULT;
            }

        }
        return INVALID_RESULT;
    }

}
