package login.quevedo.servidor.EE.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import login.quevedo.servidor.config.ConfigurationQuevedo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ServletFicheros", value = "/ServletFicheros")
public class ServletFicheros extends HttpServlet {

    private ConfigurationQuevedo config;

    @Inject
    public ServletFicheros(ConfigurationQuevedo config) {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> lineas = Files.readAllLines(Paths.get(config.getRutaKeyStores()+"nombre.txt"));
        List<String> lineas2 = Files.readAllLines(Paths.get("nombre.txt"));


        response.getWriter().println(String.join("<br>", lineas));
        response.getWriter().println(String.join("<br>", lineas2));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FileWriter w2 = new FileWriter(this.getServletContext().getRealPath("/WEB-INF")+"\\nombre.txt",false);
        FileWriter w1 = new FileWriter("nombre.txt",false);
        FileWriter w = new FileWriter(config.getRutaKeyStores()+"nombre.txt");

        w.write("hola mundo");
        w1.write("hola mundo");
        w2.write("hola mundo");

        w.close();
        w1.close();
        w2.close();


    }
}
