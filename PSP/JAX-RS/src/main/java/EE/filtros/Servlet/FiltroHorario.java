package EE.filtros.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter(filterName = "FilterLogin",urlPatterns = {"/*"})
public class FiltroHorario implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        LocalDateTime date = LocalDateTime.now();

        if (date.getSecond()>= 30)
        {
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else
        {
            servletRequest.getRequestDispatcher("/errorFiltro.html").forward(servletRequest,servletResponse);
        }


    }
}
