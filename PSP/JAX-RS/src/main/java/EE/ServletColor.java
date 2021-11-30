package EE;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletColor", value = "/color")
public class ServletColor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var color = request.getSession().getAttribute("color");
        Map m = new HashMap();
        m.put("j","j");

        m.get("j");
        response.getWriter().println("<html><body bgcolor=\""+color+"\" ></body></html>");

        request.getSession().setAttribute("color",null);
        request.getSession().invalidate();



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
