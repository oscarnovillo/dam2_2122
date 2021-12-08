package EE.servlet;

import config.Configuration;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletConfig",urlPatterns = {"/config"})
public class ServletConfig extends HttpServlet {


    Configuration config;

    @Inject
    public ServletConfig(Configuration config) {
        this.config = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.getWriter().println(config.getRuta());

    }
}
