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
@WebServlet(name = "SvBorrarServicio", urlPatterns = {"/SvBorrarServicio"})
public class SvBorrarServicio extends HttpServlet {
    
    Controladora control = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            
            int cod = Integer.parseInt(request.getParameter("cod"));
            
            control.borrarServicio(cod);
            
            //actualizo la lista de servicios
            request.getSession().setAttribute("listaServicios", control.mostrarServicios());
            response.sendRedirect("Servicios.jsp");
        } catch (Exception ex) {
            Logger.getLogger(SvBorrarServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
