package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.ServicioTuristico;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-20T21:56:24")
@StaticMetamodel(PaqueteTuristico.class)
public class PaqueteTuristico_ { 

    public static volatile SingularAttribute<PaqueteTuristico, Integer> porcDescuento;
    public static volatile SingularAttribute<PaqueteTuristico, Integer> codigoPaquete;
    public static volatile SingularAttribute<PaqueteTuristico, Integer> habilitado;
    public static volatile ListAttribute<PaqueteTuristico, ServicioTuristico> serviciosIncluidos;

}