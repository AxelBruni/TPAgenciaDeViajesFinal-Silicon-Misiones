package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author axelb
 */
@Entity
public class TipoPago implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_tipo_pago")
    private int idTipoPago;
    
    @Basic
    private String descripcion;
    
    private float porcCom;
    
    public TipoPago() {
    }

    public TipoPago(int idTipoPago, String descripcion, float porcCom) {
        this.idTipoPago = idTipoPago;
        this.descripcion = descripcion;
        this.porcCom = porcCom;
    }

    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPorcCom() {
        return porcCom;
    }

    public void setPorcCom(float porcDesc) {
        this.porcCom = porcDesc;
    }

    @Override
    public String toString() {
        return "TipoPago{" + "idTipoPago=" + idTipoPago + ", descripcion=" + descripcion + ", porcDesc=" + porcCom + '}';
    }
    
    
    
}
    
    