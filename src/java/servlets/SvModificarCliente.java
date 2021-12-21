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
import logica.Cliente;
import logica.Controladora;

/**
 *
 * @author axelb
 */
@WebServlet(name = "SvModificarCliente", urlPatterns = {"/SvModificarCliente"})
public class SvModificarCliente extends HttpServlet {
    
    private Controladora control = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idClie = Integer.parseInt(request.getParameter("idClie"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String nacionalidad = request.getParameter("nacionalidad");
        String direccion = request.getParameter("direccion");
        String fecha = request.getParameter("fecha");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        
        try {
            control.modificarCliente(idClie, nombre, apellido, dni, nacionalidad, direccion, fecha, celular, email);
        } catch (Exception ex) {
            Logger.getLogger(SvModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getSession().setAttribute("listaClientes", control.mostrarClientes());
        response.sendRedirect("Clientes.jsp");
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idClie = Integer.parseInt(request.getParameter("idClie"));
        
        Cliente clie = control.buscarCliente(idClie);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("clienteMod", clie);
        
        response.sendRedirect("ModificarCliente.jsp");
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
