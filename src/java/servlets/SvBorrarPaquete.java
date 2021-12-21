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


@WebServlet(name = "SvBorrarPaquete", urlPatterns = {"/SvBorrarPaquete"})
public class SvBorrarPaquete extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int codPaq = Integer.parseInt(request.getParameter("cod"));
        
        try {
            control.borrarPaquete(codPaq);
        } catch (Exception ex) {
            Logger.getLogger(SvBorrarPaquete.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getSession().setAttribute("listaPaquetes", control.mostrarPaquetes());
        response.sendRedirect("Paquetes.jsp");     
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
