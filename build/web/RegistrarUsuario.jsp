<%-- 
    Document   : RegistrarUsuario
    Created on : 29 sep. 2023, 10:24:14
    Author     : nacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
		<div class="container mt-4 col-lg-4">
			<div class="card col-sm-10">
				<div class="card-body">
					<form class="form-sign" action="Validar" method="POST">
						<div class="form-group text-center">
							<h3>Registrar Usuario</h3>
						</div>
                                                <div class="form-group">
							<label for="us">DNI:</label>
							<input type="text" name="txtDni" class="form-control" id="us">
						</div>
                                                <div class="form-group">
							<label for="us">Nombre y Apellido:</label>
							<input type="text" name="txtNombres" class="form-control" id="us">
						</div>
                                                
						<div class="form-group">
							<label for="us">Usuario:</label>
							<input type="text" name="txtUsuario" class="form-control" id="us">
						</div>
						<div class="form-group">
							<label for="contr">Teléfono:</label>
							<input type="text" name="txtTel" class="form-control" id="contr">
						</div>
                                                
						<input type="submit" name="registrar" value="Registrar" class="btn btn-primary btn-block mt-2">
                                                <div class="mt-4">
                                                    <a href="index.jsp" target="">Volver a Inicio Sesión</a>
                                                </div>
					</form>
				</div>
			</div>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
	</body>
</html>
