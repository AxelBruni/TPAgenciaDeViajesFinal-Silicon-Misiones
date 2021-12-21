package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;

/**
 *
 * @author axelb
 */
@WebServlet(name = "SvBorrarCliente", urlPatterns = {"/SvBorrarCliente"})
public class SvBorrarCliente extends HttpServlet {
    
    private Controladora control = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idClie = Integer.parseInt(request.getParameter("idClie"));
        
        try {
            control.borrarCliente(idClie);
        } catch (Exception ex) {
            Logger.getLogger(SvBorrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getSession().setAttribute("listaClientes", control.mostrarClientes());
        response.sendRedirect("Clientes.jsp");
        
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
