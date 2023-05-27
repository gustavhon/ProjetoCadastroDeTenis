package controller;

import dao.TenisDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tenis;
import model.Marca;

@WebServlet(name = "GravarTenis", urlPatterns = {"/GravarTenis"})
public class GravarTenis extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try{
            int codigoTenis = request.getParameter("codigoTenis").isEmpty() 
                    ? 0 : Integer.parseInt(request.getParameter("codigoTenis"));
            
            String nomeTenis = request.getParameter("nomeTenis");
            
            int codigoMarca = Integer.parseInt(request.getParameter("codigoMarca"));
            Marca marca = new Marca();
            marca.setCodigoMarca(codigoMarca);
            
            Tenis Tenis = new Tenis(codigoTenis, nomeTenis, marca);
            
            TenisDAO TenisDAO = new TenisDAO();
            TenisDAO.gravar(Tenis);
            
            request.setAttribute("mensagem", "Tênis gravado com sucesso");    
        }
        catch(SQLException | ClassNotFoundException ex){
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.getRequestDispatcher("ListarTenis")
                .forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
