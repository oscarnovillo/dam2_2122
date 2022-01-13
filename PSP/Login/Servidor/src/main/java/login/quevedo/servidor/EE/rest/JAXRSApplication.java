package login.quevedo.servidor.EE.rest;

import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


@BasicAuthenticationMechanismDefinition
@ApplicationPath("/api")
public class JAXRSApplication extends Application {


}
