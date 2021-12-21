package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author axelb
 */


/* Para la herencia, se utiliza la estrategia que une a las tablas de las clases
*  hijas con la tabla de la superclase, debido que asegura la integridad de los datos
*  y no repite columnas en la BD. Sin embargo, esta estrategia presenta una performance
*  en las consultas más baja en relación con las otras estrategias, debido a que cada consulta
*  debe hacerse uniendo tablas.
*/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPersona;
    
    private String nombre;
    private String apellido;
    private String direccion;
    private int dni;
    
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    
    private String nacionalidad;
    private int celular;
    private String email;
    
    //Para el borrado lógico.
    private int habilitado = 1;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String direccion, int dni, Date fechaNac, String nacionalidad, int celular, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.email = email;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", dni=" + dni + ", fechaNac=" + fechaNac + ", nacionalidad=" + nacionalidad + ", celular=" + celular + ", email=" + email + ", habilitado=" + habilitado + '}';
    }

    
    
}
