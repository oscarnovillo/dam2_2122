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
    public CreateHash() {
        this.passwordHash = null;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3072");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "32");
        parameters.put("Pbkdf2PasswordHash.KeySizeBytes", "32");
        passwordHash.initialize(parameters);

        String password = req.getParameter("pass");

        req.setAttribute("hash",passwordHash.generate(password.toCharArray()));

        String s = "3072:5p4jNbXyIs7an1dYOwSrhwyAp1q98M/G2O8WNgooO+QZpPmgYJ5Fgbl96IrXUnDWee1HRCi+sJDiK3I4/fslPg==:Kx83yTGN7N8NFoqH/z/Ujn5tFs6SE/a0S9+c7bZEWXjoERDVLJFwfD1MQGmvn+rc2JWwSTQiQadkYtiEMwahAw==";

        req.setAttribute("ok",passwordHash.verify(password.toCharArray(),s));

        req.getRequestDispatcher("info.jsp").forward(req,resp);



    }
}
