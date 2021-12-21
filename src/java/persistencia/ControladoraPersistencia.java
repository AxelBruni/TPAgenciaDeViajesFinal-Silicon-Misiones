package persistencia;

import java.util.ArrayList;
import java.util.List;
import logica.Cliente;
import logica.Empleado;
import logica.PaqueteTuristico;
import logica.ServicioTuristico;
import logica.TipoPago;
import logica.Usuario;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author axelb
 */
public class ControladoraPersistencia {
      
    private ClienteJpaController clienteJPA = new ClienteJpaController();
    private EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    private PaqueteTuristicoJpaController paqueteJPA = new PaqueteTuristicoJpaController();
    private PersonaJpaController personaJPA = new PersonaJpaController();
    private ServicioTuristicoJpaController servicioJPA = new ServicioTuristicoJpaController();
    private UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    private VentaJpaController ventaJPA = new VentaJpaController();
    private TipoPagoJpaController tipoPagoJPA = new TipoPagoJpaController();
    
    public ControladoraPersistencia() {     
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="CRUD Clientes">
    public void crearCliente(Cliente cliente) {       
        clienteJPA.create(cliente);
    }

    public void borrarCliente(int id) throws NonexistentEntityException{    
        clienteJPA.destroy(id);
    }
    
    public void actualizarCliente(Cliente cliente) throws Exception{
        clienteJPA.edit(cliente);
    }
            
    public List<Cliente> mostrarClientes(){
        return clienteJPA.findClienteEntities();
    }
    
    public Cliente buscarCliente(int id) {
        return clienteJPA.findCliente(id);
    }
    
    public List<Cliente> buscarClientePorDni(int dni){
        return clienteJPA.buscarClientePorDni(dni);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CRUD Empleados">
    public void crearEmpleado(Empleado empleado){
        empleadoJPA.create(empleado);
    }        
    public void borrarEmpleado(int id) throws NonexistentEntityException{
        empleadoJPA.destroy(id);
    }        
    public void actualizarEmpleado(Empleado empleado) throws Exception{
        empleadoJPA.edit(empleado);
    }        
    public List<Empleado> mostrarEmpleados(){
        return empleadoJPA.findEmpleadoEntities();        
    }
    
    public Empleado buscarEmpleado(int idEmp) {
        return empleadoJPA.findEmpleado(idEmp);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CRUD Paquetes Turísticos">
    public void crearPaqueteTuristico(PaqueteTuristico paquete){
        paqueteJPA.create(paquete);
    }
    public void borrarPaqueteTuristico(int id) throws NonexistentEntityException{
        paqueteJPA.destroy(id);
    }        
    public void actualizarPaqueteTuristico(PaqueteTuristico paquete) throws Exception{
        paqueteJPA.edit(paquete);
    }
    public List<PaqueteTuristico> mostrarPaquetesTuristicos(){
        return paqueteJPA.findPaqueteTuristicoEntities();
    }
    
    public PaqueteTuristico buscarPaquete(int codPaq) {
        return paqueteJPA.findPaqueteTuristico(codPaq);
    }
    // </editor-fold>
       
    // <editor-fold defaultstate="collapsed" desc="CRUD Servicios Turísticos ">
    public void crearServicioTuristico(ServicioTuristico servicio) {
        servicioJPA.create(servicio);
    }
    public void borrarServicioTuristico(int id) throws NonexistentEntityException {
        servicioJPA.destroy(id);
    }        
    public void actualizarServicioTuristico(ServicioTuristico servicio) throws Exception {
        servicioJPA.edit(servicio);
    }
    public List<ServicioTuristico> mostrarServiciosTuristicos() {
        return servicioJPA.findServicioTuristicoEntities();
    }
    
    public ServicioTuristico buscarServicio(int cod) {
        return servicioJPA.findServicioTuristico(cod);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CRUD Usuarios ">
    public void crearUsuario(Usuario usuario) {
        usuarioJPA.create(usuario);
    }
    public void borrarUsuario(int id) throws NonexistentEntityException {
        usuarioJPA.destroy(id);
    }        
    public void actualizarUsuario(Usuario usuario) throws Exception {
        usuarioJPA.edit(usuario);
    }
    public List<Usuario> mostrarUsuarios() {
        return usuarioJPA.findUsuarioEntities();
    }
    
    public Usuario buscarUsuario(int id) {
        return usuarioJPA.findUsuario(id);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CRUD Ventas ">
    public void crearVenta(Venta venta) {
        ventaJPA.create(venta);
    }
    public void borrarVenta(int id) throws NonexistentEntityException {
        ventaJPA.destroy(id);
    }        
    public void actualizarVenta(Venta venta) throws Exception {
        ventaJPA.edit(venta);
    }
    public List<Venta> mostrarVentas() {
        return ventaJPA.findVentaEntities();
    }
    
    public Venta buscarVenta(int id) {
        return ventaJPA.findVenta(id);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CRUD Tipos de Pago ">
    public void crearTipoPago(TipoPago tipoPago) {
        tipoPagoJPA.create(tipoPago);
    }
    public void borrarTipoPago(int id) throws NonexistentEntityException {
        tipoPagoJPA.destroy(id);
    }        
    public void actualizarTipoPago(TipoPago tipoPago) throws Exception {
        tipoPagoJPA.edit(tipoPago);
    }
    public List<TipoPago> mostrarTipoPagos() {
        return tipoPagoJPA.findTipoPagoEntities();
    }
    
    public TipoPago buscarTipoPago(int id){
        return tipoPagoJPA.findTipoPago(id);
    }
    // </editor-fold>


    
}
