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


    <title>Venta Servicio / Buscar Cliente</title>
   
  </head>
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
            <a class="navbar-brand" href="Index.jsp">TP Final Agencia de viajes</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
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
            <h3>Venta Servicio</h3>
            <br>
            <h5>Buscar Cliente</h5>
            <form action="SvBuscarCliente" method="GET">
                <div class="form-group">
                    <label for="dni">DNI</label>
                    <input type="text" class="form-control" id="dni" name="dniClie" placeholder="Ingrese DNI" onkeypress="return isNumber(event)" required />
                    <input name="tipo" type="hidden" value="servicio">
                </div>
                <button type="submit" class="btn btn-primary">Buscar</button>
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
    

    <script src="assets/js/isNumber.js"></script>
    <script src="assets/js/datepicker.js"></script>
    <script src="assets/js/jquery-3.3.1.slim.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>