package EE.servlet;

import jakarta.inject.Inject;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "hash",urlPatterns = {"/hash"})
public class CreateHash extends HttpServlet {


    private Pbkdf2PasswordHash passwordHash;

    @Inject
    public CreateHash(Pbkdf2PasswordHash passwordHash) {
        this.passwordHash = passwordHash;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3072");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        parameters.put("Pbkdf2PasswordHash.KeySizeBytes", "64");
        passwordHash.initialize(parameters);

        String password = req.getParameter("pass");

        req.setAttribute("hash",passwordHash.generate(password.toCharArray()));

        String s = "PBKDF2WithHmacSHA256:2048:/iYLdVpyv0Ux8pJbM5wYjEFAOdQL2V3l8fMjbdazh9Q=:NSS7upNSmyziDmvP/vg3nXO95y5a8g9Skq5wd5EsPxU=";

        req.setAttribute("ok",passwordHash.verify(password.toCharArray(),s));

        req.getRequestDispatcher("info.jsp").forward(req,resp);



    }
}
