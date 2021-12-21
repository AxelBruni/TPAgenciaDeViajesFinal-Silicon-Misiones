package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Cliente;
import logica.Controladora;

/**
 *
 * @author axelb
 */
@WebServlet(name = "SvBuscarCliente", urlPatterns = {"/SvBuscarCliente"})
public class SvBuscarCliente extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String tipoVenta = (String)request.getParameter("tipo");
        int dniClie = Integer.parseInt(request.getParameter("dniClie"));
        
        Cliente clie = control.buscarClientePorDni(dniClie);
             
        if(clie == null) {
            response.sendRedirect("AltaCliente.jsp");
        }
        else {
            request.getSession().setAttribute("clienteVenta", clie);
            request.getSession().setAttribute("tiposPago", control.mostrarTiposPago());
            if (tipoVenta.equals("servicio")) {
                request.getSession().setAttribute("listaServicios", control.mostrarServicios());
                response.sendRedirect("VentaServicio.jsp");
            }
            else {
                request.getSession().setAttribute("listaPaquetes", control.mostrarPaquetes());
                response.sendRedirect("VentaPaquete.jsp");
            }    
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
