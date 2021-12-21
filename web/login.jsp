<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en" class="h-100">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
 
    <link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon">

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />


    <title>Login</title>
  </head>
  <body class="m-0 vh-100 row justify-content-center align-items-center ">
      
      <% request.getSession().invalidate();%>
      
        <h2>TP Agencia de viajes</h2><br>
    <main>
        <div class="col-auto p-5">
            <form action="SvUsuario" method="POST">
                <div class="card bg-dark text-white " style="width: 300px">
                    <div class="card-body mx-auto">
                        <h4 class="card-title">Ingreso</h4>
                        <div class="form-group">
                            <label for="name">Usuario</label>
                            <input type="text" class="form-control" id="nombre" name="usuario" placeholder="Ingrese usuario" required />
                        </div>
                        <div class="form-group">
                            <label for="name">Contraseña</label>
                            <input type="password" class="form-control" id="nombre" name="pass" placeholder="Ingrese contraseña" required />
                        </div>
                        <button type="submit" class="btn btn-primary">Ingresar</button>
                </div>
            </form>
        </div>
    </main>
    </body>