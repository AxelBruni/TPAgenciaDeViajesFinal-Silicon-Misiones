package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Cliente;
import logica.Empleado;
import logica.PaqueteTuristico;
import logica.ServicioTuristico;
import logica.TipoPago;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-20T21:56:24")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Integer> numVenta;
    public static volatile SingularAttribute<Venta, Cliente> cliente;
    public static volatile SingularAttribute<Venta, ServicioTuristico> servicio;
    public static volatile SingularAttribute<Venta, Empleado> empleado;
    public static volatile SingularAttribute<Venta, TipoPago> tipoPago;
    public static volatile SingularAttribute<Venta, Integer> habilitado;
    public static volatile SingularAttribute<Venta, PaqueteTuristico> paquete;
    public static volatile SingularAttribute<Venta, Date> fechaVenta;

}