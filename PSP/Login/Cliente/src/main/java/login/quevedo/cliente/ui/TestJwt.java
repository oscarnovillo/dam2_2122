package login.quevedo.cliente.ui;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class TestJwt {



    private static class Cred{
        public Set<String> groups = Set.of("kk","gg");
    }

    public static void main(String[] args) {



        Cred c = new Cred();

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String jws = Jwts.builder()
                .setSubject("Joe")
                .setIssuer("yo")

                .setExpiration(Date
                        .from(LocalDateTime.now().plusSeconds(60).atZone(ZoneId.systemDefault())
                                .toInstant()))
                .claim("user", "juan")
                .claim("group", c.groups)
                .signWith(key).compact();

        System.out.println(jws);


        Jws<Claims> jwsV = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jws);

        List<String> s = (List<String>) jwsV.getBody().get("group");

        s.forEach(s1 -> System.out.println(s1 + " :::: "));

        new HashSet<String>(s);

    }

}
