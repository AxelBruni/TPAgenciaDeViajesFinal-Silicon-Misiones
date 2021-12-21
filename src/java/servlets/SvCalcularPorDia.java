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


@WebServlet(name = "SvCalcularPorDia", urlPatterns = {"/SvCalcularPorDia"})
public class SvCalcularPorDia extends HttpServlet {
    
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
        
        String fecha = (String) request.getParameter("fecha");
        
        try {
            double ganancia = control.mostrarGananciaDia(fecha);
            HttpSession misession = request.getSession();
            misession.setAttribute("fechaG", fecha);
            misession.setAttribute("ganancia", ganancia);
            response.sendRedirect("VerGanancia.jsp");
        } catch (ParseException ex) {
            response.sendRedirect("Ganancias.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
