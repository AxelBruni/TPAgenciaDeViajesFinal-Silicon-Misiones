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
import logica.Venta;


@WebServlet(name = "SvModificarVenta", urlPatterns = {"/SvModificarVenta"})
public class SvModificarVenta extends HttpServlet {
    
    Controladora control = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
      
        int idVenta = Integer.parseInt(request.getParameter("cod"));
        String tipoModif = (String) request.getParameter("tipo");
        Venta ventaModificar = control.buscarVenta(idVenta);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("idClieModificar", ventaModificar.getCliente().getIdPersona());
        misession.setAttribute("idVentaModificar", ventaModificar.getNumVenta());
        misession.setAttribute("listaServicios", control.mostrarServicios());
        misession.setAttribute("listaPaquetes", control.mostrarPaquetes());
        misession.setAttribute("tiposPago", control.mostrarTiposPago());
        
        try {
            if (tipoModif.equals("Servicio")) {
                response.sendRedirect("ModificarVentaServicio.jsp");
            }
            else{
                if (tipoModif.equals("Paquete")) {
                    response.sendRedirect("ModificarVentaPaquete.jsp");
                }
            }
        }
        catch (Exception e) {
            response.sendRedirect("Ventas.jsp");
        }   
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        HttpSession misession = request.getSession();
        
        String tipo = (String) request.getParameter("tipo");
        
            if (tipo.equals("Servicio")) {
                
            try {
                int idServ = Integer.parseInt(request.getParameter("servVenta"));
                int idTipoPago = Integer.parseInt(request.getParameter("tipoPago"));
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                int idVenta = Integer.parseInt(request.getParameter("idVenta"));

                control.modificarVenta(idVenta, idServ, idTipoPago, idUsuario, "Servicio");
                misession.setAttribute("listaVentas", control.mostrarVentas());
            } catch (Exception ex) {
                Logger.getLogger(SvModificarVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else {
            try {
                int idPaq = Integer.parseInt(request.getParameter("paqVenta"));
                int idTipoPago = Integer.parseInt(request.getParameter("tipoPago"));
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                int idVenta = Integer.parseInt(request.getParameter("idVenta"));

                control.modificarVenta(idVenta, idPaq, idTipoPago, idUsuario, "Paquete");
                misession.setAttribute("listaVentas", control.mostrarVentas());
            } catch (Exception ex) {
                Logger.getLogger(SvModificarVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
            response.sendRedirect("Ventas.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
