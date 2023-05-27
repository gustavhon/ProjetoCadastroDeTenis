package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

@WebFilter(filterName = "RequestFilter", urlPatterns = {"/home.jsp",
    "/gravarTenis.jsp", "/gravarMarca.jsp",
    "/listarTenis.jsp", "/listarMarca.jsp"},
     servletNames = {"NovoTenis", "NovaMarca", "ListarMarca",
            "ListarTenis", "GravarMarca", "GravarTenis",
            "ExcluirMarca", "ExcluirTenis",
            "ConsultarMarca", "ConsultarTenis"})

public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession sessao = req.getSession(false);
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");

        if (usuario != null) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect(req.getContextPath());
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void destroy() {
    }
}