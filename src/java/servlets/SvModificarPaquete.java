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
import javax.servlet.http.HttpSession;
import logica.Controladora;


@WebServlet(name = "SvModificarPaquete", urlPatterns = {"/SvModificarPaquete"})
public class SvModificarPaquete extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int codPaq = Integer.parseInt(request.getParameter("codPaq"));
        
        String[] idsServicios = request.getParameterValues("idServ");
        if (idsServicios == null) {
            response.sendRedirect("ModificarPaquete.jsp");
        }
        else {
            try {
                control.modificarPaquete(codPaq, idsServicios);
            } catch (Exception ex) {
                Logger.getLogger(SvModificarPaquete.class.getName()).log(Level.SEVERE, null, ex);
            }
            HttpSession misession = request.getSession();    
            misession.setAttribute("listaPaquetes", control.mostrarPaquetes());


            response.sendRedirect("Paquetes.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int codPaq = Integer.parseInt(request.getParameter("cod"));
        
        HttpSession misession = request.getSession();
        misession.setAttribute("codPaquete", codPaq);
        
        response.sendRedirect("ModificarPaquete.jsp");
        
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
