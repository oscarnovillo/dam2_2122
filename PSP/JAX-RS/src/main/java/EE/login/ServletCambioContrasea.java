package EE.login;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletCambioContraseña", value = "/ServletCambioContraseña")
public class ServletCambioContrasea extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recibe la contraseña

        //recibe el codigo aleatorio

        //miras la fecha para el tiempo maximo.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
