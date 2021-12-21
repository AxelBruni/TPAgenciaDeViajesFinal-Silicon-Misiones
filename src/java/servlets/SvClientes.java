package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Cliente;
import logica.Controladora;

/**
 *
 * @author axelb
 */
@WebServlet(name = "SvClientes", urlPatterns = {"/SvClientes"})
public class SvClientes extends HttpServlet {
    
    Controladora control = new Controladora();

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        List<Cliente> listaClientes = control.mostrarClientes();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaClientes", listaClientes);
        response.sendRedirect("Clientes.jsp");
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombreClie = request.getParameter("nombre"); 
        String apellidoClie = request.getParameter("apellido"); 
        String dniClie = request.getParameter("dni"); 
        String nacClie = request.getParameter("nacionalidad"); 
        String direClie = request.getParameter("direccion"); 
        String fechaClie = request.getParameter("fecha"); 
        String celClie = request.getParameter("celular"); 
        String emailClie = request.getParameter("email");
        
        try {
            control.crearCliente(nombreClie, apellidoClie, dniClie, nacClie, direClie, fechaClie, celClie, emailClie );
        } catch (ParseException ex) {
            Logger.getLogger(SvClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Cliente> listaClientes = control.mostrarClientes();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaClientes", listaClientes);
        response.sendRedirect("Clientes.jsp");
 
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
