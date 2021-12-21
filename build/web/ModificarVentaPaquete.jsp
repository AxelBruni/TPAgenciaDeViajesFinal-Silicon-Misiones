<%@page import="logica.TipoPago"%>
<%@page import="logica.Cliente"%>
<%@page import="logica.ServicioTuristico"%>
<%@page import="logica.PaqueteTuristico"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="en" class="h-100">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon">

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />


    <title>Modificar venta paquete</title>
   
  </head>
  </head>
  <body class="d-flex flex-column h-100">
    
	<%
	HttpSession misession = request.getSession();
	String usu = (String) misession.getAttribute("usuario");
        int idUsuario = (Integer) misession.getAttribute("idUsuario");

	if (usu == null) {
		response.sendRedirect("login.jsp");
	}
	else {		
	%>
	
	<% } %>
      
      
    <div class="container pt-4 pb-4">
        <nav class="navbar navbar-expand-lg navbar-light bg-light rounded">
            <a class="navbar-brand" href="Index.jsp">TP Final Agencia de viajes</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
    
            <div class="collapse navbar-collapse" id="navbarsExample09">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                            <form action="SvServicio" method="GET">
                                <a href="SvServicio" class="nav-link">Servicios</a>
                            </form>
                    </li>
                    <li class="nav-item">
                            <form action="SvClientes" method="GET">
                                <a href="SvClientes" class="nav-link">Clientes</a>
                            </form>
                    </li>
                    <li class="nav-item">
                            <form action="SvEmpleado" method="GET">
                                <a href="SvEmpleado" class="nav-link">Empleados</a>
                            </form>
                    </li>
                    <li class="nav-item">
                            <form action="SvTiposPago" method="GET">
                                <a href="SvTiposPago" class="nav-link">TiposPago</a>
                            </form>
                    </li>
                    <li class="nav-item">
                            <form action="SvVenta" method="GET">
                                <a href="SvVenta" class="nav-link">Ventas</a>
                            </form>
                    </li> 
                </ul>
                <div class="nav navbar-nav ml-auto">
                    <ul class="nav navbar-nav ml-auto">
                        <div class="dropdown">
                            <button class="btn btn-dark btn-sm dropdown-toggle" type="button" id="dropdown1" data-toggle="dropdown">
                              <%= usu %>
                            </button>
                            <div class="dropdown-menu">
                              <a class="dropdown-item" href="login.jsp">Cerrar Sesión</a>
                            </div>
                </div>
            </div>
        </nav>
    </div>
                            
 <main role="main" class="flex-shrink-0">
        <div class="container">
            <h3>Lista de paquetes</h3>
            <form action="SvModificarVenta" method="POST">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                    <th scope="col">Código</th>
                    <th scope="col">Servicios Incluidos</th>
                    <th scope="col">Costo</th>
                    <th scope="col">Seleccionar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                     List<PaqueteTuristico> listaPaquetes = (List) misession.getAttribute("listaPaquetes");
                     for (PaqueteTuristico paquete : listaPaquetes) {
                     %>
                     <tr>
                         <% int cod = paquete.getCodigoPaquete();
                            double costo = paquete.calcularCosto();
                            List<ServicioTuristico> servicios = paquete.getServiciosIncluidos();
                          %>
                          <td><%=cod%></td>
                          <td><%for (ServicioTuristico serv : servicios) {
                              String nombreServ = serv.getNombre() + " Destino " + serv.getDestino();%>
                              <%=nombreServ%><br>
                          <%}%>
                          </td>
                          <td><%=costo%></td>
                          <td>
                              <input class="form-check-input" type="radio" value="<%=cod%>" id="checkbox" name="paqVenta" checked>
                          </td>
                          <td>    
                          </td>
                     </tr>
                     <% } %>
                </tbody>
            </table>
  </div>
            <div class="row justify-content-center align-items-center">        
                <label for="control">Seleccione método de pago  </label> 
                    <select class="form-control" id="control1" name="tipoPago" style="max-width:30%;">
                        <% List<TipoPago> listaTiposPago = (List)misession.getAttribute("tiposPago");
                           for (TipoPago tipoPago : listaTiposPago){
                               int idPago = tipoPago.getIdTipoPago();
                               String descPago = tipoPago.getDescripcion();
                           %>
                           <option value="<%=idPago%>"><%=descPago%></option> 
                    <%}%>
                    </select>
          </div>
          <div class="row justify-content-center align-items-center">
              <br>
              </br>
              <% int idVentaModif = (Integer) misession.getAttribute("idVentaModificar");%>
                <input type="hidden" name="tipo" value="Paquete">
                <input type="hidden" name="idVenta" value="<%=idVentaModif%>">                
                <input type="hidden" name="idUsuario" value="<%=idUsuario%>">
                <button class="btn btn-primary btn-sm">Modificar Venta</button>
          </form>
          </div>  
    </main>