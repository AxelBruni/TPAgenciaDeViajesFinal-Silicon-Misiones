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

@WebServlet(name = "SvBorrarEmpleado", urlPatterns = {"/SvBorrarEmpleado"})
public class SvBorrarEmpleado extends HttpServlet {
    
    Controladora control = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idEmp = Integer.parseInt(request.getParameter("idEmp"));
        
        try {
            control.borrarEmpleado(idEmp);
        } catch (Exception ex) {
            Logger.getLogger(SvBorrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HttpSession misession = request.getSession();
        misession.setAttribute("listaEmpleados", control.mostrarEmpleados());
        response.sendRedirect("Empleados.jsp");
        
        
        
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
