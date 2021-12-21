package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.PaqueteTuristico;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-20T21:56:24")
@StaticMetamodel(ServicioTuristico.class)
public class ServicioTuristico_ { 

    public static volatile SingularAttribute<ServicioTuristico, Integer> codigoServicio;
    public static volatile SingularAttribute<ServicioTuristico, Date> fecha;
    public static volatile SingularAttribute<ServicioTuristico, String> descripcionBreve;
    public static volatile SingularAttribute<ServicioTuristico, Integer> costo;
    public static volatile SingularAttribute<ServicioTuristico, String> destino;
    public static volatile SingularAttribute<ServicioTuristico, Integer> habilitado;
    public static volatile SingularAttribute<ServicioTuristico, String> nombre;
    public static volatile ListAttribute<ServicioTuristico, PaqueteTuristico> paquete;

}