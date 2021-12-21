package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author axelb
 */

@Entity
@PrimaryKeyJoinColumn(name = "idCliente")
public class Cliente extends Persona implements Serializable {
    
    
    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String direccion, int dni, Date fechaNac, String nacionalidad, int celular, String email) {
        super(nombre, apellido, direccion, dni, fechaNac, nacionalidad, celular, email);
    }
    
    

    
}
