package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

@WebServlet(name = "EfetuarLogin", urlPatterns = {"/EfetuarLogin"})
public class EfetuarLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setCharacterEncoding("UTF-8");
        
        try {
            String nomeUsuario = request.getParameter("nomeUsuario");
            String senhaUsuario = request.getParameter("senhaUsuario");
            String perfilUsuario = request.getParameter("perfilUsuario");
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.logarUsuario(nomeUsuario, senhaUsuario, perfilUsuario);
            if (usuario != null) {
                HttpSession sessao = request.getSession(true);
                sessao.setAttribute("usuario", usuario);
                response.sendRedirect(request.getContextPath() + "/home.jsp");
            } else {
                request.setAttribute("mensagem", "Credenciais de acesso inválidas");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}