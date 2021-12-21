package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.ServicioTuristico;

/**
 *
 * @author axelb
 */
@WebServlet(name = "SvModificarServicio", urlPatterns = {"/SvModificarServicio"})
public class SvModificarServicio extends HttpServlet {
    
    Controladora control = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            

            //traer datos
            int cod = Integer.parseInt(request.getParameter("cod"));
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String destino = request.getParameter("destino");
            String fecha = request.getParameter("fecha");
            String costo = request.getParameter("costo");
            
        try {
            //paso los atributos a la controladora, no creo el objeto aquí, me pide agregar excepcion
            control.modificarServicio(cod, nombre, descripcion, destino, fecha, costo);
        } catch (Exception ex) {
            Logger.getLogger(SvModificarServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
 
            //actualizo la lista de servicios de la sesión
            request.getSession().setAttribute("listaServicios", control.mostrarServicios());
            response.sendRedirect("Servicios.jsp");    
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int cod = Integer.parseInt(request.getParameter("cod"));
        
        ServicioTuristico serv = control.buscarServicio(cod);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("servicio", serv);
        
        response.sendRedirect("ModificarServicio.jsp");
        
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
