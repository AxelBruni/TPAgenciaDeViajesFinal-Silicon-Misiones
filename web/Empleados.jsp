<%@page import="logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
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

    <title>Empleados</title>
   
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
            <h3>Lista de empleados</h3>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Dirección</th>
                        <th scope="col">DNI</th>
                        <th scope="col">Fecha Nacimiento</th>
                        <th scope="col">Nacionalidad</th>
                        <th scope="col">Celular</th>
                        <th scope="col">Email</th>
                        <th scope="col">Cargo</th>
                        <th scope="col">Sueldo</th>
                        <th scope="col">Modificar</th>
                        <th scope="col">Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <%SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                     List<Empleado> listaEmpleados = (List) misession.getAttribute("listaEmpleados");
                        for (Empleado emp : listaEmpleados) {
                     %>
                     <tr>
                         <% int idEmp = emp.getIdPersona();
                            String nombreEmp = emp.getNombre();
                            String apellidoEmp = emp.getApellido();
                            String direEmp = emp.getDireccion();
                            int dniEmp = emp.getDni();
                            String fechaEmp = formatoFecha.format(emp.getFechaNac());
                            String nacionEmp = emp.getNacionalidad();
                            int celEmp = emp.getCelular();
                            String emailEmp = emp.getEmail();
                            String cargoEmp = emp.getCargo();
                            int sueldoEmp = emp.getSueldo();  
                        %>

                        <td><%=idEmp%></td>
                        <td><%=nombreEmp%></td>
                        <td><%=apellidoEmp%></td>
                        <td><%=nacionEmp%></td>
                        <td><%=dniEmp%></td>
                        <td><%=direEmp%></td>
                        <td><%=fechaEmp%></td>
                        <td><%=celEmp%></td>
                        <td><%=emailEmp%></td>
                        <td><%=cargoEmp%></td>
                        <td><%=sueldoEmp%></td>
                        <td>
                            <form action="SvModificarEmpleado" method="POST" style=display:inline>
                                <input type="hidden" name="idEmp" value="<%=idEmp%>">
                                    <button type="submit" class="btn btn-primary btn-sm" data-title="Modificar" style=display:inline>Modificar</button>
                            </form>
                        </td>
                        <td>
                            <form action="SvBorrarEmpleado" method="GET" style=display:inline>
                                <input type="hidden" name="idEmp" value="<%=idEmp%>">
                                    <button type="submit" class="btn btn-danger btn-sm" data-title="Borrar" style=display:inline>Borrar</button>
                            </form>
                        </td>
                     </tr>
                     <% } %>
                </tbody>
            </table>
            <div class="row justify-content-center align-items-center">
                    <a href="AltaEmpleado.jsp">
                        <button class="btn btn-primary btn-sm">Agregar Empleado</button>
                    </a>
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