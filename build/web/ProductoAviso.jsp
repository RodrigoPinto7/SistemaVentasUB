<%-- 
    Document   : ProductoAviso
    Created on : 23 oct. 2023, 16:56:16
    Author     : nacho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <div class="alert col-sm-8 border border-danger rounded">
            <label>Error: No se guardó debido a campos vacíos.</label> 
            <span class="btn closebtn float-end" onclick="this.parentElement.style.display='none';">&times;</span>
            
        </div>
        <div class="">
            <div class="card col-sm-8">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <label>Producto</label>
                            <input type="text" value="${producto.getNom()}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="number" value="${producto.getPrecio()}" name="fltPrecio" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="number" value="${producto.getStock()}" name="intStock" class="form-control">
                        </div>  
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info mt-2">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success mt-2">
                    </form>

                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>PRODUCTO</th>
                            <th>PRECIO</th>
                            <th>STOCK</th>
                            
                            <th>ACCION</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pd" items="${productos}">
                        <tr>
                            <td>${pd.getId()}</td>
                            <td>${pd.getNom()}</td>
                            <td>${pd.getPrecio()}</td>
                            <td>${pd.getStock()}</td>
                            
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${pd.getId()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Delete&id=${pd.getId()}">Eliminar</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>           

            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </body>
</html>

