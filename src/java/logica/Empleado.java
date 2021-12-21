package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author axelb
 */

@Entity
@PrimaryKeyJoinColumn(name = "idEmpleado")
public class Empleado extends Persona implements Serializable {
    

    private String cargo;
    private int sueldo;
    
    public Empleado() {
    }

    public Empleado(String cargo, int sueldo, String nombre, String apellido, String direccion, int dni,Date fechaNac, String nacionalidad, int celular, String email) {
        super(nombre, apellido, direccion, dni, fechaNac, nacionalidad, celular, email);
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String toStringEmpleado() {
        return "Empleado{ , cargo=" + cargo + ", sueldo=" + sueldo + '}';
    }
    
    
    
}
