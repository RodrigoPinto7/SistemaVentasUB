<%-- 
    Document   : Principal.jsp
    Created on : 23 sep. 2023, 18:46:24
    Author     : nacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <h1 style="margin-left: 5px; border: none">Sistema Venta UB</h1>
        <nav class="navbar navbar-expand-lg bg-body-tertiary ">
            <div class="container-fluid">
              <a class="navbar-brand" href="#"></a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline" aria-current="page" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Productos</a>
                  </li>
                  <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleados</a>
                  </li>
                  <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
                  </li>
                  <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline" href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Venta</a>
                  </li>
                  <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline" href="Controlador?menu=HistorialVenta&accion=Listar" target="myFrame">Historial Ventas</a>
                  </li>
                </ul> 
                 <div class="dropdown" style="margin-right: 30px;">
                    <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                      ${usuario.getNom()}
                    </button>
                    <ul class="dropdown-menu text-center">
                        <li>${usuario.getUser()}</li>
                      <li><a class="dropdown-item" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">
                              Configuración
                          </a></li>
                      
              
                      <div class="dropdown-divider"></div>
                      <form action="Validar" method="POST">
                          <button name="accion" value="Salir" class="dropdown-item">Salir</button>
                      </form>
                    </ul>
                  </div>
      
                </div>
            </div>
         </nav>
         <div class="m-4" style="height: 550px; ">
             <iframe name="myFrame" style="height: 100%; width: 100%;"></iframe>              
         </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	
    </body>
</html>
