package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.PaqueteTuristico;
import logica.ServicioTuristico;



@WebServlet(name = "SvPaquete", urlPatterns = {"/SvPaquete"})
public class SvPaquete extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Agego también la lista de servicios, porque voy a necesitarlos cuando
        //cree un paquete.
        List <PaqueteTuristico> listaPaquetes = control.mostrarPaquetes();
        List <ServicioTuristico> listaServicios = control.mostrarServicios();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaPaquetes", listaPaquetes);
        misession.setAttribute("listaServicios", listaServicios);

        response.sendRedirect("Paquetes.jsp");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Verifica si hay dos o más servicios agregados
        String[] idsServicios = request.getParameterValues("idServ");
        if (idsServicios == null) {
            response.sendRedirect("AltaPaquete.jsp");
        }
        else {
            control.crearPaquete(idsServicios);
        HttpSession misession = request.getSession();    
        misession.setAttribute("listaPaquetes", control.mostrarPaquetes());


        response.sendRedirect("Paquetes.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
