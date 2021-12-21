package logica;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    int idEmpleadoLogueado;
    
    
    
    public Controladora() {      
    }
    
    // <editor-fold defaultstate="collapsed" desc="Manejo de Servicios">
    public void crearServicio(String nombre, String descripcion, String destino, String fecha, String costo) throws ParseException {
        
        ServicioTuristico serv = new ServicioTuristico();
        
        serv.setNombre(nombre);
        serv.setDescripcionBreve(descripcion);
        serv.setDestino(destino);
        serv.setFecha(formatoFecha.parse(fecha));
        serv.setCosto(Integer.parseInt(costo));
        
        controlPersis.crearServicioTuristico(serv);
        
        
    }
    
    public ServicioTuristico buscarServicio(int cod) {
        
        return controlPersis.buscarServicio(cod);
        
    }
    
    public void modificarServicio(int cod, String nombre, String descripcion, String destino, String fecha, String costo) throws ParseException, Exception {
        
        ServicioTuristico serv = this.buscarServicio(cod);
        
        serv.setNombre(nombre);
        serv.setDescripcionBreve(descripcion);
        serv.setDestino(destino);
        serv.setFecha(formatoFecha.parse(fecha));
        serv.setCosto(Integer.parseInt(costo));
        
        controlPersis.actualizarServicioTuristico(serv);
        
        
    }
    
    public void borrarServicio(int cod) throws Exception {
        
        //busco el servicio
        ServicioTuristico serv = this.buscarServicio(cod);
        //lo seteo como falso
        serv.setHabilitado(0);
        //lo modifico
        controlPersis.actualizarServicioTuristico(serv);
        
        
    }
    
    public List<ServicioTuristico> mostrarServicios() {
        return controlPersis.mostrarServiciosTuristicos();
    }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Manejo de Clientes">
    public List<Cliente> mostrarClientes() {
        return controlPersis.mostrarClientes();
    }
    
    public void crearCliente(String nombre, String apellido, String dni, String nacionalidad, String direccion, String fecha, String celular, String email) throws ParseException {
        
        Cliente clie = new Cliente();
        
        clie.setNombre(nombre);
        clie.setApellido(apellido);
        clie.setDni(Integer.parseInt(dni));
        clie.setNacionalidad(nacionalidad);
        clie.setDireccion(direccion);
        clie.setFechaNac(formatoFecha.parse(fecha));
        clie.setCelular(Integer.parseInt(celular));
        clie.setEmail(email);
        
        controlPersis.crearCliente(clie);
    }
    
    public Cliente buscarCliente(int idClie) {
        return controlPersis.buscarCliente(idClie);
    }
    
    public void modificarCliente(int id, String nombre, String apellido, String dni, String nacionalidad, String direccion, String fecha, String celular, String email) throws ParseException, Exception {
        
        Cliente clie = this.buscarCliente(id);
        
        clie.setNombre(nombre);
        clie.setApellido(apellido);
        clie.setDni(Integer.parseInt(dni));
        clie.setNacionalidad(nacionalidad);
        clie.setDireccion(direccion);
        clie.setFechaNac(formatoFecha.parse(fecha));
        clie.setCelular(Integer.parseInt(celular));
        clie.setEmail(email);
        
        controlPersis.actualizarCliente(clie);
        
    }
    
    public void borrarCliente(int idCLie) throws Exception {
        
        Cliente clie = this.buscarCliente(idCLie);
        
        clie.setHabilitado(0);
        
        controlPersis.actualizarCliente(clie);
    }
    
    public Cliente buscarClientePorDni(int dni){
        
        List<Cliente> clientes = controlPersis.buscarClientePorDni(dni);
        
        if (clientes == null || clientes.isEmpty()) {
            return null;
        }
        else {
            return clientes.get(0);
        }
        
    }
    
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Manejo de Empleados">
    public void crearEmpleado (String nombreUsu, String pass, String nombres, String apellido, String email, String direccion, 
                               String documento, String fechaNac, String nacionalidad, String celular, String cargo, String sueldo) throws ParseException {
        
        Empleado emp = new Empleado();
        emp.setNombre(nombres);
        emp.setApellido(apellido);
        emp.setEmail(email);
        emp.setDireccion(direccion);
        emp.setDni(Integer.parseInt(documento));
        emp.setFechaNac(formatoFecha.parse(fechaNac));
        emp.setNacionalidad(nacionalidad);
        emp.setCelular(Integer.parseInt(celular));
        emp.setCargo(cargo);
        emp.setSueldo(Integer.parseInt(sueldo));
        
        Usuario usu = new Usuario();
        usu.setNombre(nombreUsu);
        usu.setContraseña(pass);
        
        usu.setEmpleado(emp);
        
        controlPersis.crearEmpleado(emp);
        controlPersis.crearUsuario(usu);
           
    }
    
    public List<Empleado> mostrarEmpleados() {
        return controlPersis.mostrarEmpleados();
    }
    
    public Empleado buscarEmpleado(int idEmp) {
        return controlPersis.buscarEmpleado(idEmp);
    }
    
    public void modificarEmpleado(int idEmp, String nombreUsu, String pass, 
                                 String nombres, String apellido, String email, String direccion, 
                                 String documento, String fechaNac, String nacionalidad, String celular, 
                                 String cargo, String sueldo) throws ParseException, Exception {
        
        Empleado emp = this.buscarEmpleado(idEmp);
        
        emp.setNombre(nombres);
        emp.setApellido(apellido);
        emp.setEmail(email);
        emp.setDireccion(direccion);
        emp.setDni(Integer.parseInt(documento));
        emp.setFechaNac(formatoFecha.parse(fechaNac));
        emp.setNacionalidad(nacionalidad);
        emp.setCelular(Integer.parseInt(celular));
        emp.setCargo(cargo);
        emp.setSueldo(Integer.parseInt(sueldo));
        
        controlPersis.actualizarEmpleado(emp);
        
    }
    
    public void borrarEmpleado(int idEmp) throws Exception {
        
        Empleado emp = this.buscarEmpleado(idEmp);
        
        emp.setHabilitado(0);
        
        controlPersis.actualizarEmpleado(emp);
    }
    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Manejo de Paquetes">
    
    public List<PaqueteTuristico> mostrarPaquetes() {
        return controlPersis.mostrarPaquetesTuristicos();
    }
    
    public void crearPaquete(String[] idsServicios) {
        
        PaqueteTuristico paq = new PaqueteTuristico();
        ArrayList <ServicioTuristico> servicios = new ArrayList<ServicioTuristico>();
        
        for(int i = 0; i < idsServicios.length; i++ ) {
            ServicioTuristico serv = this.buscarServicio(Integer.parseInt(idsServicios[i]));
            servicios.add(serv);
        }
        

        paq.setServiciosIncluidos(servicios);
        
        controlPersis.crearPaqueteTuristico(paq);
        
    }
    
    public void modificarPaquete(int codPaq, String[] idsServicios) throws Exception {
        
        PaqueteTuristico paq = this.buscarPaquete(codPaq);
        
        ArrayList <ServicioTuristico> servicios = new ArrayList<ServicioTuristico>();
        
        for(int i = 0; i < idsServicios.length; i++ ) {
            ServicioTuristico serv = this.buscarServicio(Integer.parseInt(idsServicios[i]));
            servicios.add(serv);
        }
        

        paq.setServiciosIncluidos(servicios);
        
        controlPersis.actualizarPaqueteTuristico(paq);     
    }
    
    public PaqueteTuristico buscarPaquete(int codPaq) {
        return controlPersis.buscarPaquete(codPaq);
    }
    
    public void borrarPaquete(int codPaq) throws Exception {
        
        PaqueteTuristico paq = this.buscarPaquete(codPaq);
        
        paq.setHabilitado(0);
        
        controlPersis.actualizarPaqueteTuristico(paq);
    }
    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Manejo de Ventas">
    
    public void crearVentaServicio(int idProd, int idTipoPago, int idClie, int usu, String tipoVenta) {
        
        Venta venta = new Venta();
        Date fecha = new Date();
        
        if (tipoVenta.equals("Servicio")){
            venta.setServicio(this.buscarServicio(idProd));
        }
        else {
            venta.setPaquete(this.buscarPaquete(idProd));
        }
                
        venta.setCliente(this.buscarCliente(idClie));
        venta.setEmpleado(this.buscarUsuario(usu).getEmpleado());
        venta.setTipoPago(this.buscarTipoPago(idTipoPago));
        venta.setFechaVenta(fecha);
        
        controlPersis.crearVenta(venta);
    
    }
    
    public void modificarVenta(int id, int idProd, int idTipoPago, int usu, String tipoVenta) throws Exception {
        
        Venta venta = this.buscarVenta(id);
        Date fecha = new Date();
        
        if (tipoVenta.equals("Servicio")){
            venta.setServicio(this.buscarServicio(idProd));
            venta.setPaquete(null);
        }
        else {
            venta.setPaquete(this.buscarPaquete(idProd));
            venta.setServicio(null);
        }
                
        venta.setEmpleado(this.buscarUsuario(usu).getEmpleado());
        venta.setTipoPago(this.buscarTipoPago(idTipoPago));
        venta.setFechaVenta(fecha);
        
        controlPersis.actualizarVenta(venta);
    
    }
    
    public void borrarVenta(int id) throws Exception {
        
        Venta venta = this.buscarVenta(id);
        
        venta.setHabilitado(0);
        
        controlPersis.actualizarVenta(venta);
    }
    
    public Venta buscarVenta(int id) {
        return controlPersis.buscarVenta(id);
    }
    
    public List<Venta> mostrarVentas() {
        return controlPersis.mostrarVentas();
    }
    
    public double mostrarGananciaDia(String fechaComparar) throws ParseException {
        
        /* Las fechas las comparo como strings, porque los meses de tipo Date
        *  van de 0 a 11, es decir, comienzan con índice 0.
        *  Aparte, un objeto date, si le pedimos su año, lo retorna como el año ese menos 1900,
        *  para mostrarlo con dos dígitos.
        */
        
        List<Venta> ventas = this.mostrarVentas();
        double acumulador = 0;
        
        for(Venta ven : ventas) {
            String fechaVenta = String.valueOf(ven.getFechaVenta().getYear() + 1900) + "-" + String.valueOf(ven.getFechaVenta().getMonth() + 1) + "-" + String.valueOf(ven.getFechaVenta().getDate());
            if (fechaVenta.equals(fechaComparar)) {
                acumulador += ven.calcularGanancia();
            }       
        }
        
        return acumulador;   
    }
    
    //</editor-fold>
    
    
    public List<TipoPago> mostrarTiposPago() {
        return controlPersis.mostrarTipoPagos();
    }
    
    public TipoPago buscarTipoPago(int id){
        return controlPersis.buscarTipoPago(id);
    }
    
    
    
    
    
    public int verificarUsuario(String usuario, String contrasenia) {
        
        List<Usuario> listaUsuarios = controlPersis.mostrarUsuarios();
        
        if(listaUsuarios != null) {
            for(Usuario usu : listaUsuarios){
                if(usu.getNombre().equals(usuario) && usu.getContraseña().equals(contrasenia)) {
                    return usu.getIdUsuario();
                    
                }
            }
        }
        
        return -1;
    }
    
    public Usuario buscarUsuario(int id) {
        return controlPersis.buscarUsuario(id);
    }
    
    
}
