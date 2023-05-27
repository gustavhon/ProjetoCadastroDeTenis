package controller;

import dao.MarcaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Marca;

@WebServlet(name = "GravarMarca", urlPatterns = {"/GravarMarca"})
public class GravarMarca extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            int codigoMarca = request.getParameter("codigoMarca").isEmpty() ? 0 : Integer.parseInt(request.getParameter("codigoMarca"));
            String nomeMarca = request.getParameter("nomeMarca");
            Marca marca = new Marca(codigoMarca, nomeMarca);
            MarcaDAO marcaDAO = new MarcaDAO();
            marcaDAO.gravar(marca);
            request.setAttribute("mensagem", "Marca gravada com sucesso");
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.getRequestDispatcher("ListarMarca").forward(request, response);
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