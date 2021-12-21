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

    <title>Página Inicial</title>
   
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
            <a class="navbar-brand" href="#">TP Final Agencia de viajes</a>
            <div class="nav navbar-nav ml-auto">
                <ul class="nav navbar-nav ml-auto">
                    <div class="dropdown">
                        <button class="btn btn-dark btn-sm dropdown-toggle" type="button" id="dropdown1" data-toggle="dropdown">
                            <%=usu%> 
                        </button>
                        <div class="dropdown-menu">
                          <a class="dropdown-item" href="login.jsp">Cerrar Sesión</a>
                        </div>
                </ul>
            </div>
        </nav>
    </div>
        
    <main role="main" class="flex-shrink-0">
            <div class="container">
                <h3>Servicios</h3>   
                <div class="card-group mt-3">

                <div class="card text-center border-info">
                    <div class="card-body">
                        <h4 class="card-title">Servicios</h4>
                        <p class="card-text">Lista de los servicios para la venta,
                          y las opciones para agregar, quitar o modificarlos. </p>
                        <form action="SvServicio" method="GET">
                            <a href="SvServicio" class="submit btn btn-primary">Entrar</a>
                        </form>
                    </div>
                </div>
                <div class="card text-center border-info">
                  <div class="card-body">
                      <h4 class="card-title">Paquetes</h4>
                      <p class="card-text">Lista de los paquetes para la venta,
                        y las opciones para agregar, quitar o modificarlos. </p>
                        <form action="SvPaquete" method="GET">
                            <a href="SvPaquete" class="submit btn btn-primary">Entrar</a>
                        </form>
                    </div>
              </div>           
                <div class="card text-center border-info">
                    <div class="card-body">
                        <h4 class="card-title">Realizar Venta</h4>
                        <p class="card-text">Venta de servicios o de paquetes</p>
                            <div class="btn-wrapper text-center">
                            <a href="VentaServicioBuscarCliente.jsp" class="btn btn-primary pull-left">Servicios</a> 
                            <a href="VentaPaqueteBuscarCliente.jsp" class="btn btn-primary">Paquetes</a>
                            </div>
                    </div>
                </div>          
            </div>
        </div></br>
        <div class="container">
            <h3>Administración</h3>  
            <div class="card-deck mt-3">
            <div class="card text-center border-info">
                <div class="card-body">
                    <h4 class="card-title">Clientes</h4>
                    <p class="card-text">Lista de los clientes existentes,
                      y las opciones para agregar, quitar o modificarlos. </p>
                    <form action="SvClientes" method="GET">
                        <a href="SvClientes" class="btn btn-primary">Entrar</a>
                    </form>
                  </div>
            </div>          
            <div class="card text-center border-info">
                <div class="card-body">
                    <h4 class="card-title">Empleados</h4>
                    <p class="card-text">Lista de los empleados,
                      y las opciones para agregar, quitar o modificarlos. </p>
                    <form action="SvEmpleado" method="GET">
                        <a href="SvEmpleado" class="btn btn-primary">Entrar</a>
                    </form>
                </div>
            </div>                   
        </div>
        </div>    
            </br>
        <div class="container"> 
            <div class="card-deck mt-3">
            <div class="card text-center border-info">
                <div class="card-body">
                    <h4 class="card-title">Ventas</h4>
                    <p class="card-text">Lista de las ventas realizadas,
                      y las opciones para agregar, quitar o modificarlas. </p>
                    <form action="SvVentas" method="GET">
                        <a href="SvVentas" class="btn btn-primary">Entrar</a>
                    </form>
                  </div>
            </div>          
            <div class="card text-center border-info">
                <div class="card-body">
                    <h4 class="card-title">Tipos de pago</h4>
                    <p class="card-text">Lista de los tipos de pago disponibles</p>
                    <form action="SvTiposPago" method="GET">
                        <a href="SvTiposPago" class="btn btn-primary">Entrar</a>
                    </form>
                </div>
            </div>                   
        </div>
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
