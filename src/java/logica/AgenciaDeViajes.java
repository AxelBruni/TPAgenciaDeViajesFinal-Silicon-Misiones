package logica;
import java.text.ParseException;
import persistencia.ControladoraPersistencia;
import java.text.SimpleDateFormat; 
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author axelb
 */
public class AgenciaDeViajes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        ControladoraPersistencia contPers = new ControladoraPersistencia();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd"); 
        
//        Empleado empleado = new Empleado("Programador", 50000, "Nombre", "Apellido", "Evergreen", 35366539, formatoFecha.parse("1990-10-27"), 
//                                          "Arg", 213456, "asfkmqa@af.com");
//        contPers.crearEmpleado(empleado);
//        Cliente cliente = new Cliente("asf", "asf", "asdgfsg", 354987, formatoFecha.parse("1989-09-10"), "Argggg", 63536, "sdg");
//        contPers.crearCliente(cliente);
//        

        List <Empleado> empleados = contPers.mostrarEmpleados();
        Empleado emp1 = empleados.get(0);
        System.out.println(emp1.toString());
        System.out.println(emp1.toStringEmpleado());
        
        // TODO: Buscar un template. Revisar como trabajan las fechas. 
        
    }
    
}
