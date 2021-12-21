package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author axelb
 */

@Entity
@SequenceGenerator(name="Cod_Seq", initialValue=100, allocationSize=25)
@Table(name = "Servicios")
public class ServicioTuristico implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Cod_Seq")
    @Column(name = "codigo_servicio")
    private int codigoServicio;
    
    @Basic
    private String nombre;
    private String descripcionBreve;
    private String destino;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    private int costo;
    
    //para el borrado lógico, por defecto está habilitado.
    private int habilitado = 1;
    
    /* Se considera que este es el lado owner, por lo que solo se coloca la anotación
    *  mappedBy.
    */

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "servicios_paquetes",
            joinColumns = {@JoinColumn(name = "codigo_servicio")},
            inverseJoinColumns = {@JoinColumn(name = "codigo_paquete")}
    )
    private ArrayList<PaqueteTuristico> paquete;

    public ServicioTuristico() {
    }

    public ServicioTuristico(String nombre, String descripcionBreve, String destino, Date fecha, int costo) {
        this.nombre = nombre;
        this.descripcionBreve = descripcionBreve;
        this.destino = destino;
        this.fecha = fecha;
        this.costo = costo;
    }

    public ServicioTuristico(int codigoServicio, String nombre, String descripcionBreve, String destino, Date fecha, int costo, ArrayList<PaqueteTuristico> paquete) {
        this.codigoServicio = codigoServicio;
        this.nombre = nombre;
        this.descripcionBreve = descripcionBreve;
        this.destino = destino;
        this.fecha = fecha;
        this.costo = costo;
        this.paquete = paquete;
    }
    
    public int getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public ArrayList<PaqueteTuristico> getPaquete() {
        return paquete;
    }

    public void setPaquete(ArrayList<PaqueteTuristico> paquete) {
        this.paquete = paquete;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }
    

    @Override
    public String toString() {
        return "ServicioTuristico{" + "codigoServicio=" + codigoServicio + ", nombre=" + nombre + ", descripcionBreve=" + descripcionBreve + ", destino=" + destino + ", fecha=" + fecha + ", costo=" + costo + '}';
    }
    
    
    
}
