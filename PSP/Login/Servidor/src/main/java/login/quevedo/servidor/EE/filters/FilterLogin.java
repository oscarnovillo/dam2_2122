package login.quevedo.servidor.EE.filters;

import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.Context;


import java.io.IOException;

@WebFilter(filterName = "FilterLogin",urlPatterns = {"/*"})
public class FilterLogin implements Filter {


    private final SecurityContext securityContext;


    @Inject
    public FilterLogin(@Context SecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // codigo para comprobar session usuario
        if (securityContext!=null && securityContext.getCallerPrincipal()!=null && securityContext.getCallerPrincipal().getName() != null)
            chain.doFilter(req, resp);
        else
            ((HttpServletResponse)resp).sendError(HttpServletResponse.SC_FORBIDDEN,"FORBIDEN");


    }

    public void init(FilterConfig config) throws ServletException {

    }
}
