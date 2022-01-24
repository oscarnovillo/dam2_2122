package login.quevedo.servidor.EE.rest;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.SecurityContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import login.quevedo.servidor.EE.filters.Filtro;
import login.quevedo.servidor.config.ConfigurationQuevedo;
import login.quevedo.servidor.modelo.Alumno;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Path("/alumno")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestAlumnos {

    private final ConfigurationQuevedo config;

    private final SecurityContext security;

    private final Key key;


    @Inject
    public RestAlumnos(ConfigurationQuevedo config, @Context SecurityContext security, @Named("JWT") Key key) {
        this.config = config;
        this.security = security;
        this.key = key;
    }

    @GET
    @RolesAllowed("user")
    public Alumno get() {
        return Alumno.builder().nombre("kkk").build();
    }

    @GET
    @PermitAll
    @Path("pati")
    public String getOK() {

        return config.getRuta() + security.getCallerPrincipal().getName();
    }

    @GET
    @Filtro
    @Path("filtro")
    public Response getOK2() throws NoSuchAlgorithmException, UnsupportedEncodingException {

        // clave aleatoria
        //Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);


        final MessageDigest digest =
                MessageDigest.getInstance("SHA-512");
        digest.update("clave".getBytes(StandardCharsets.UTF_8));
        final SecretKeySpec key2 = new SecretKeySpec(
                digest.digest(), 0, 64, "AES");
        SecretKey keyConfig = Keys.hmacShaKeyFor(key2.getEncoded());

        String jws = Jwts.builder()
                .setSubject("Joe")
                .setIssuer("yo")
                .setExpiration(Date
                        .from(LocalDateTime.now().plusSeconds(60).atZone(ZoneId.systemDefault())
                                .toInstant()))
                .claim("user", "juan")
                .claim("group", "admins")
                .signWith(key).compact();

        return Response.ok(Base64.getUrlEncoder().encodeToString(key.getEncoded()))
                .header(HttpHeaders.AUTHORIZATION, jws).build();
    }


    @GET
    @Filtro
    @Path("verify")
    public Response verify(@HeaderParam("JWT") String auth) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        // clave aleatoria
        //Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);


        final MessageDigest digest =
                MessageDigest.getInstance("SHA-512");
        digest.update("clave".getBytes(StandardCharsets.UTF_8));
        final SecretKeySpec key2 = new SecretKeySpec(
                digest.digest(), 0, 64, "AES");
        SecretKey key22 = Keys.hmacShaKeyFor(key2.getEncoded());


        Jws<Claims> jws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(auth);

        return Response.ok(jws.getBody().get("user"))
                .build();
    }


}
