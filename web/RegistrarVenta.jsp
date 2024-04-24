<%-- 
    Document   : RegistrarVenta
    Created on : 27 sep. 2023, 17:40:42
    Author     : nacho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venta</title>
        <style>
            @media print{
                .parte01, .btn, .accion{
                    display: none;
                }
            }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex">
             <div class="col-sm-4 parte01" style="padding: 5px">
                 <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body" style="padding: 5px">
                            <div class="form-group" style="padding: 5px">
                                <label>Ingrese DNI del Cliente</label>
                            </div>
                            <div class="form-group " style="padding: 5px">
                                <div class="col-sm-12 d-flex border border-success rounded" >
                                    <div class="m-1">
                                        <input type="text" name="codigocliente" value="${clienteB.getDni()}" class="form-control" >
                                    </div>
                                    <div class="m-1">
                                        <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-dark" >
                                    </div>
                                </div>

                                <div class="col-sm-12 d-flex m-2" style="padding: 5px">
                                    <div class="col-sm-4">
                                        <label >Nombre del Cliente: </label>
                                    </div>
                                    <div class="col-sm-8">
                                        <input type="text" name="nombrescliente" value="${clienteB.getNom()}" class="form-control" >
                                    </div>
                                </div>
                            </div>
                            <div class="form-group flex" style="padding: 5px">
                                <label style="padding: 5px">Ingrese ID del Producto</label>      
                            </div>
                            <div class="form-group" style="padding: 5px">
                                <div class="col-sm-12 d-flex border border-success rounded">
                                    <div class="m-2">
                                        <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control">
                                    </div>
                                    <div class="m-2">
                                        <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-dark">Buscar</button>
                                    </div>
                
                                </div>
                            
                                <div class="col-sm-12 d-flex" style="padding: 5px">
                                    <div class="m-1 col-sm-5">
                                        <label >Nombre del Producto: </label>
                                    </div>
                                    <div class="m-1 col-sm-6">
                                        <input type="text" name="nomproducto" value="${producto.getNom()}" class="form-control col-sm-5" style="padding: 5px" >
                                    </div>
                                </div>
                            </div>
                            <div class="form-group" style="padding: 5px">
                                <div class="col-sm-12 d-flex" style="padding: 5px">
                                    <div class="m-1 col-sm-5">
                                        <label>Precio por unidad ($): </label>
                                    </div>
                                    <div class="m-1 col-sm-6 ">
                                        <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" >
                                    </div>
                                </div>
                                <div class="col-sm-12 d-flex border border-success rounded" style="padding: 5px">
                                    <div class="m-1 col-sm-5">
                                        <label>Ingrese cantidad: </label>
                                    </div>
                                    <div class="m-1 col-sm-3 ">
                                        <input type="number" name="cant" value="1" class="form-control" >
                                    </div>
                                </div>

                                <div class="col-sm-12 d-flex" style="padding: 5px">
                                    <div class="m-1 col-sm-5">
                                        <label>Stock Disponible: </label>
                                    </div>
                                    <div class="m-1 col-sm-3 ">
                                        <input type="text" name="stock" value="${producto.getStock()}" class="form-control col-sm-5" >
                                    </div>
                                    
                                </div>
                            </div>
                            <div class="form-group" style="padding: 5px">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-dark">Agregar</button>
                            </div>
                        </div>
                   </form>
                 </div>
             </div>
             <div class="col-sm-7" style="padding: 5px">
                 <div class="card">
                     <div class="card-body">
                         <div class="d-flex col-sm-6 ml-auto">
                             <label>Numero Serie</label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                         </div>
                         <table class="table table-hover">
                             <thead>
                                 <tr>
                                     <th>Nro</th>
                                     <th>Codigo</th>
                                     <th>Descripcion</th>
                                     <th>Precio</th>
                                     <th>Cantidad</th>
                                     <th>SubTotal</th>
                                     <th class="accion">Acciones</th>
                                 </tr>
                             </thead>
                             <tbody>
                                 <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td >${list.getItem()}</td>
                                        <td >${list.getIdproducto()}</td>
                                        <td >${list.getDescripcionP()}</td>
                                        <td >${list.getPrecio()}</td>
                                        <td >${list.getCantidad()}</td>
                                        <td >${list.getSubtotal()}</td>
                                        <td class="parte01">
                                            <a href="#" class="parte01 btn btn-warning">Editar</a>
                                            <a href="Controlador?menu=NuevaVenta&accion=Eliminar&item=${list.getItem()}" class="parte01 btn btn-danger">Eliminar</a>
                                        </td>
                                    </tr>
                                 </c:forEach>
                             </tbody>
                         </table>
                     </div>
                     <div class="card-footer d-flex">
                         <div class="col-sm-6 parte01">
                             <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="parte01 btn btn-success">Generar Venta</a>
                             <a href="Controlador?menu=NuevaVenta&accion=Cancelar" class="parte01 btn btn-danger">Cancelar</a>
                         </div>
                         <div class="col-sm-3 ml-auto">
                             <input type="text" name="txtTotal" value="$/.${totalpagar}0" class="form-control">
                         </div>
                     </div>
                 </div>
             </div>
        </div>
      
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    </body>
</html>
