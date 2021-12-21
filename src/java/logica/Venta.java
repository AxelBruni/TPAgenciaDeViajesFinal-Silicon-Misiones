package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numVenta;
  
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    
    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;
    
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    

    @ManyToOne
    @JoinColumn(name = "codigo_paquete")
    private PaqueteTuristico paquete;
    
    @ManyToOne
    @JoinColumn(name = "codigo_servicio")
    private ServicioTuristico servicio;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_pago")
    private TipoPago tipoPago;
    
    int habilitado = 1;

    public Venta() {
    }

    public Venta(Date fechaVenta, String medioPago, Empleado empleado, Cliente cliente, PaqueteTuristico paquete, ServicioTuristico servicio) {
        this.fechaVenta = fechaVenta;
        this.empleado = empleado;
        this.cliente = cliente;
        this.paquete = paquete;
        this.servicio = servicio;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        this.paquete = paquete;
    }

    public ServicioTuristico getServicio() {
        return servicio;
    }

    public void setServicio(ServicioTuristico servicio) {
        this.servicio = servicio;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }
    
    
    
    public double calcularCosto() {
        
        double costo = 0;
        
        if(this.servicio != null){
            costo = this.servicio.getCosto();
        }
        else{
            costo = this.paquete.calcularCosto();
        }
        
        return costo;
    }
    
    public double calcularGanancia() {
        
        double costo = this.calcularCosto();
        
        double ganancia = ((costo * this.tipoPago.getPorcCom())/100);
        
        return ganancia;
    }

    @Override
    public String toString() {
        return "Venta{" + "numVenta=" + numVenta + ", fechaVenta=" + fechaVenta +  ", empleado=" + empleado + ", cliente=" + cliente + ", paquete=" + paquete + ", servicio=" + servicio + '}';
    }
    
    
    
}
