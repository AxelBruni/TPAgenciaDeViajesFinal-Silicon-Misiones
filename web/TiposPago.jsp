<%@page import="logica.TipoPago"%>
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

    <title>Servicios</title>
   
  </head>
  <body class="d-flex flex-column h-100">
    
   <%
	HttpSession misession = request.getSession();
	String usu = (String) misession.getAttribute("usuario");

	if (usu == null) {
		response.sendRedirect("login.jsp");
	}
	else {		
	%>
	
	<% } %>
      
    <div class="container pt-4 pb-4">
        <nav class="navbar navbar-expand-lg navbar-light bg-light rounded">
            <a class="navbar-brand" href="index.html">TP Final Agencia de viajes</a>
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
            <h3>Tipos de pago</h3>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                    <th scope="col">Código</th>
                    <th scope="col">Descripción</th>
                    <th scope="col">Comisión</th>
                    </tr>
                </thead>
                <tbody>
                    <%List<TipoPago> listaTipos = (List) misession.getAttribute("listaTipos");
                      for (TipoPago tipo : listaTipos) {
                        %>
                        <tr>  
                          <%int id = tipo.getIdTipoPago();
                            String descripcion = tipo.getDescripcion();
                            float comision = tipo.getPorcCom();%>
                            <td><%=id%></td>
                            <td><%=descripcion%></td>
                            <td><%=comision%></td>
                        </tr>
                        <% } %>
                </tbody>
            </table>
            <div class="row justify-content-center align-items-center">
            </div> 
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