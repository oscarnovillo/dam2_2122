package EE.servlet;

import dao.DaoUsuario;
import dao.modelo.Usuario;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cielito",urlPatterns = {"/addUser"})
public class ServletCielto extends HttpServlet {

    private DaoUsuario dao;

    @Inject
    public ServletCielto(DaoUsuario dao) {
        this.dao = dao;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var cielito = (String)request.getSession().getAttribute("cielito");

        dao.addUser(new Usuario("prueba","prueba"));


        if (cielito !=null )
            response.getWriter().println(cielito);
        else
            response.getWriter().println("error");
    }
}
