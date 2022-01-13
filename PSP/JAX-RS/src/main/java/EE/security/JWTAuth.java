package EE.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationException;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import jakarta.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.HttpHeaders;

import java.util.Set;


@ApplicationScoped
public class JWTAuth implements HttpAuthenticationMechanism
{

    @Inject
    private InMemoryIdentityStore identity;


    //@Override
    public AuthenticationStatus validateRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse
            , HttpMessageContext httpMessageContext) throws AuthenticationException {


        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        identity.validate(new UsernamePasswordCredential("nombre","ppp")).getStatus();
        if (header!=null)
             return httpMessageContext.notifyContainerAboutLogin(
                "admin", Set.of("ADMIN"));
            else
        return httpMessageContext.doNothing();
    }
}
