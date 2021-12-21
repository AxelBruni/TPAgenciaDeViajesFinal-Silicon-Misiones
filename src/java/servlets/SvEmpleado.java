package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Empleado;


@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        List<Empleado> listaEmpleados = control.mostrarEmpleados();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaEmpleados", listaEmpleados);
        response.sendRedirect("Empleados.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String nombreUsu = request.getParameter("usuario");
            String pass = request.getParameter("pass");
            String nombres = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String direccion = request.getParameter("direccion");
            String documento = request.getParameter("dni");
            String fechaNac = request.getParameter("fecha");
            String nacionalidad = request.getParameter("nacionalidad");
            String celular = request.getParameter("celular");
            String cargo = request.getParameter("cargo");
            String sueldo = request.getParameter("sueldo");
            
            
            control.crearEmpleado(nombreUsu, pass, nombres, apellido, email, direccion, documento, fechaNac, nacionalidad, celular, cargo, sueldo);
            
            List<Empleado> listaEmpleados = control.mostrarEmpleados();
            HttpSession misession = request.getSession();
            misession.setAttribute("listaEmpleados", listaEmpleados);            
            response.sendRedirect("Empleados.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
