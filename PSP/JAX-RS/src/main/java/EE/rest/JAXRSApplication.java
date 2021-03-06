package EE.rest;

import EE.filtros.Horario;
import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
@BasicAuthenticationMechanismDefinition(realmName = "")
@Horario
@DeclareRoles({"ADMIN","user"})
public class JAXRSApplication extends Application {


}
