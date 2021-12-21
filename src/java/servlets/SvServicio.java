/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import logica.Controladora;
import logica.ServicioTuristico;

/**
 *
 * @author axelb
 */
@WebServlet(name = "SvServicio", urlPatterns = {"/SvServicio"})
public class SvServicio extends HttpServlet {

       Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
                
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        List <ServicioTuristico> listaServicios = control.mostrarServicios();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaServicios", listaServicios);

        response.sendRedirect("Servicios.jsp");
 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String destino = request.getParameter("destino");
        String fecha = request.getParameter("fecha");
        String costo = request.getParameter("costo");
        
           try {
               control.crearServicio(nombre, descripcion, destino, fecha, costo);
           } catch (ParseException ex) {
               Logger.getLogger(SvServicio.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        List <ServicioTuristico> listaServicios = control.mostrarServicios();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaServicios", listaServicios);
        response.sendRedirect("Servicios.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
