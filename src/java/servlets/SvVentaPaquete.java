package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;


@WebServlet(name = "SvVentaPaquete", urlPatterns = {"/SvVentaPaquete"})
public class SvVentaPaquete extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        HttpSession misession = request.getSession();
        
        try {
        int idServ = Integer.parseInt(request.getParameter("paqVenta"));
        int idTipoPago = Integer.parseInt(request.getParameter("tipoPago"));
        int idClie = Integer.parseInt(request.getParameter("clie"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        
        control.crearVentaServicio(idServ, idTipoPago, idClie, idUsuario, "Paquete");
        misession.setAttribute("listaVentas", control.mostrarVentas());
        response.sendRedirect("Ventas.jsp");
        }
        catch (Exception e) {
            response.sendRedirect("VentaPaquete.jsp");
        }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
