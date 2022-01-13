package login.quevedo.servidor.EE.rest;

import jakarta.annotation.security.DeclareRoles;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


@BasicAuthenticationMechanismDefinition(realmName = "")
@ApplicationPath("/api")
@DeclareRoles({"admin","user"})
public class JAXRSApplication extends Application {


}
