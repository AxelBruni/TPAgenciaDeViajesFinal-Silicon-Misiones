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
import logica.Empleado;

/**
 *
 * @author axelb
 */
@WebServlet(name = "SvModificarEmpleado", urlPatterns = {"/SvModificarEmpleado"})
public class SvModificarEmpleado extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
            
        
            int idEmp = Integer.parseInt(request.getParameter("idEmp"));
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
            
        try {
            control.modificarEmpleado(idEmp, nombres, cargo, nombres, apellido, email, direccion, documento, fechaNac, nacionalidad, celular, cargo, sueldo);
        } catch (Exception ex) {
            Logger.getLogger(SvModificarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            HttpSession misession = request.getSession();
            misession.setAttribute("listaEmpleados", control.mostrarEmpleados());
            response.sendRedirect("Empleados.jsp");
        

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idEmp = Integer.parseInt(request.getParameter("idEmp"));
        
        Empleado emp = control.buscarEmpleado(idEmp);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("empMod", emp);
        
        response.sendRedirect("ModificarEmpleado.jsp");
   
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
