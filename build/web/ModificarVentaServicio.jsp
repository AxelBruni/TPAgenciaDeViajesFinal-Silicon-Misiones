<%@page import="logica.Cliente"%>
<%@page import="logica.TipoPago"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="logica.ServicioTuristico"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
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
    

    <title>Modificar Venta Servicios</title>
   
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
                            <form action="SvPaquete" method="GET">
                                <a href="SvPaquete" class="nav-link">Paquetes</a>
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
            <h3>Lista de servicios</h3>
            <form action="SvModificarVenta" method="POST">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                    <th scope="col">Código</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Descripción</th>
                    <th scope="col">Destino</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Costo</th>
                    <th scope="col">Seleccionar</th>
                    </tr>
                </thead>
                <tbody>
                    <%SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                     List<ServicioTuristico> listaServicios = (List) misession.getAttribute("listaServicios");
                     for (ServicioTuristico serv : listaServicios) {
                     %>
                     <tr>
                         <% int cod = serv.getCodigoServicio();
                            String nombre = serv.getNombre();
                            String desc = serv.getDescripcionBreve();
                            String destino = serv.getDestino();
                            String fecha = formatoFecha.format(serv.getFecha());
                            int costo = serv.getCosto();
                          %>
                          <td><%=cod%></td>
                          <td><%=nombre%></td>
                          <td><%=desc%></td>
                          <td><%=destino%></td>
                          <td><%=fecha%></td>
                          <td><%=costo%></td>
                          <td>
                              <input class="form-check-input" type="radio" value="<%=cod%>" id="checkbox1" name="servVenta" checked>  
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
              <br>
              <% int idVentaModif = (Integer) misession.getAttribute("idVentaModificar");%>
                <input type="hidden" name="tipo" value="Servicio">
                <input type="hidden" name="idVenta" value="<%=idVentaModif%>">
                <input type="hidden" name="idUsuario" value="<%=idUsuario%>">
                <button class="btn btn-primary btn-sm">Modificar Venta</button>
          </form>
          </div>  
    </main>
      
    <footer class="footer mt-auto py-3">
        <div class="container pb-5">
            <hr>
            <span class="text-muted">
                    Curso de Desarrollo Web Fullstack con Java || Silicon Misiones</a>
            </span>
        </div>
    </footer>

    
    <script src="assets/js/jquery-3.3.1.slim.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>