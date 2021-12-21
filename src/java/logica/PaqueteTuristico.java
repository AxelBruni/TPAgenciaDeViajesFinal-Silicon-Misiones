package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author axelb
 */
@Entity
@Table(name = "paquetes")
public class PaqueteTuristico implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "codigo_paquete")
    private int codigoPaquete;
    
    @Basic
    // El porcentaje de descuento es por defecto 10, pero al ser un atributo, si en el futuro se requiere se puede cambiar.
    private int porcDescuento = 10;
    
    
    /* Dado que la relación entre servicios y paquetes es n a n, se utiliza la 
    *  anotación ManyToMany para indicarle al ORM que debe crear la tabla intermedia
    *  compuesta por las PK de ambas tablas. En este caso, consideramos que el lado
    *  dueño de la tabla es el de servicios.
    */
    @ManyToMany(mappedBy = "paquete")
    private ArrayList<ServicioTuristico> serviciosIncluidos;
    
    private int habilitado = 1;

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(int porcDescuento, ArrayList<ServicioTuristico> serviciosIncluidos) {
        this.porcDescuento = porcDescuento;
        this.serviciosIncluidos = serviciosIncluidos;
    }

    public int getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(int codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public int getPorcDescuento() {
        return porcDescuento;
    }

    public void setPorcDescuento(int porcDescuento) {
        this.porcDescuento = porcDescuento;
    }

    public ArrayList<ServicioTuristico> getServiciosIncluidos() {
        return serviciosIncluidos;
    }

    public void setServiciosIncluidos(ArrayList<ServicioTuristico> serviciosIncluidos) {
        this.serviciosIncluidos = serviciosIncluidos;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }
    
    public double calcularCosto() {
        
        List<ServicioTuristico> servicios = this.getServiciosIncluidos();
        double acumulador = 0;
        
        for (ServicioTuristico serv : servicios){
            acumulador += serv.getCosto();
        }
        double costo = (acumulador * (100-porcDescuento)) / 100;
        
        return costo;
    }
    
    
    @Override
    public String toString() {
        return "PaqueteTuristico{" + "codigoPaquete=" + codigoPaquete + ", porcDescuento=" + porcDescuento + ", serviciosIncluidos=" + serviciosIncluidos + '}';
    }
    
    
    
    
    
}
