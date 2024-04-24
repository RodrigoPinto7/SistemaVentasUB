/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Config.GenerarSerie;
import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.Producto;
import Modelo.Venta;
import Modelo.VentaTot;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author nacho
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    Empleado em = new Empleado();
    
    Cliente cl = new Cliente();
    Producto pd = new Producto();
    int ide;
    int stck;
    double prc;
    
    Cliente cliente;
    
    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    
    String numeroserie;
    VentaTot vtot = new VentaTot();
    
  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        
       
        if (menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request,response);
            
        }
        if (menu.equals("PrincipalSimple")){
            request.getRequestDispatcher("PrincipalSimple.jsp").forward(request,response);
        }
        if (menu.equals("Empleado")){
            switch (accion){
                case "Listar" -> {
                    
                    List listado = em.listar();
                    request.setAttribute("empleados",listado);
                    request.getRequestDispatcher("Empleado.jsp").forward(request,response);
                }
                case "ListarAviso" -> {
                    
                    List listado = em.listar();
                    request.setAttribute("empleados",listado);
                    request.getRequestDispatcher("EmpleadoAviso.jsp").forward(request,response);
                }
                
                case "Agregar" -> {
                    if((request.getParameter("txtDni").isBlank())||(request.getParameter("txtNombres").isBlank())||(request.getParameter("txtTel").isBlank())||(request.getParameter("txtUsuario").isBlank())){
                        
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=ListarAviso").forward(request, response);
                    }else{
                        String dni = request.getParameter("txtDni");
                        String nom = request.getParameter("txtNombres");
                        String tel = request.getParameter("txtTel");
                        String est = "1";
                        String user = request.getParameter("txtUsuario");
                        em.setDni(dni);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEstado(est);
                        em.setUser(user);  
                        em.agregar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    }
                }
                case "Editar" -> {
                    ide=Integer.parseInt(request.getParameter("id"));
                    Empleado e=em.listarId(ide);
                    request.setAttribute("empleado",e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request,response);
                }
                case "Actualizar" -> {
                    if((request.getParameter("txtDni").isBlank())||(request.getParameter("txtNombres").isBlank())||(request.getParameter("txtTel").isBlank())||(request.getParameter("txtUsuario").isBlank())){
                        
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=ListarAviso").forward(request, response);
                    }else{
                        String dni1 = request.getParameter("txtDni");
                        String nom1 = request.getParameter("txtNombres");
                        String tel1 = request.getParameter("txtTel");
                        String est1 = "1";
                        String user1 = request.getParameter("txtUsuario");
                        em.setDni(dni1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setEstado(est1);
                        em.setUser(user1);  
                        em.setId(ide);
                        em.actualizar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request,response);
                    }
                }
                case "Delete" -> {
                    ide=Integer.parseInt(request.getParameter("id"));
                    em.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request,response);
                }
                case "ListarUsuario"-> {
                    ide=Integer.parseInt(request.getParameter("id"));
                    List listado = em.listarUsuario(ide);
                    Empleado e=em.listarId(ide);
                    request.setAttribute("empleados",listado);
                    request.setAttribute("empleado",e);
                    request.getRequestDispatcher("Cuenta.jsp").forward(request,response);
                }
                case "ActualizarCuenta" -> {
                    
                    String dni2 = request.getParameter("txtDni");
                    String nom2 = request.getParameter("txtNombres");
                    String tel2 = request.getParameter("txtTel");
                    String est2 = "1";
                    String user2 = request.getParameter("txtUsuario");
                    em.setDni(dni2);
                    em.setNom(nom2);
                    em.setTel(tel2);
                    em.setEstado(est2);
                    em.setUser(user2);  
                    em.setId(ide);
                    em.actualizar(em);
                    List listado = em.listarUsuario(ide);
                    Empleado e=em.listarId(ide);
                    request.setAttribute("empleados",listado);
                    request.setAttribute("empleado",e);
                    request.getRequestDispatcher("Cuenta.jsp").forward(request,response);
                }
                default -> throw new AssertionError();
            }
            //request.getRequestDispatcher("Empleado.jsp").forward(request,response);
        }
        if (menu.equals("Cliente")){
            switch (accion){
                case "Listar" -> {
                    List listado = cl.listar();
                    request.setAttribute("clientes",listado);
                    request.getRequestDispatcher("Clientes.jsp").forward(request,response);
                }
                case "ListarAviso" -> {
                    List listado = cl.listar();
                    request.setAttribute("clientes",listado);
                    request.getRequestDispatcher("ClientesAviso.jsp").forward(request,response);
                }
                case "Agregar" -> {
                    if((request.getParameter("txtDni").isBlank())||(request.getParameter("txtNombres").isBlank())||(request.getParameter("txtDir").isBlank())){
                        
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=ListarAviso").forward(request, response);
                    }else{
                        String dni = request.getParameter("txtDni");
                        String nom = request.getParameter("txtNombres");
                        String dir = request.getParameter("txtDir");
                        String est = "1";

                        cl.setDni(dni);
                        cl.setNom(nom);
                        cl.setDireccion(dir);
                        cl.setEstado(est);
                        cl.agregar(cl);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    }
                }
                case "Editar" -> {
                    ide=Integer.parseInt(request.getParameter("id"));
                    Cliente e=cl.listarId(ide);
                    request.setAttribute("cliente",e);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request,response);
                }
                case "Actualizar" -> {
                    if((request.getParameter("txtDni").isBlank())||(request.getParameter("txtNombres").isBlank())||(request.getParameter("txtDir").isBlank())){
                        
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=ListarAviso").forward(request, response);
                    }else{
                        String dni1 = request.getParameter("txtDni");
                        String nom1 = request.getParameter("txtNombres");
                        String dir1 = request.getParameter("txtDir");
                        String est1 = "1";
                        cl.setDni(dni1);
                        cl.setNom(nom1);
                        cl.setDireccion(dir1);
                        cl.setEstado(est1);  
                        cl.setId(ide);
                        cl.actualizar(cl);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request,response);
                    }
                }
                case "Delete" -> {
                    ide=Integer.parseInt(request.getParameter("id"));
                    cl.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request,response);
                }
                default -> throw new AssertionError();
            }
            
            //request.getRequestDispatcher("Clientes.jsp").forward(request,response);
        }
        if (menu.equals("Producto")){
            switch (accion){
                case "Listar" -> {
                    List listado = pd.listar();
                    request.setAttribute("productos",listado);
                    request.getRequestDispatcher("Producto.jsp").forward(request,response);
                }
                case "ListarAviso" -> {
                    List listado = pd.listar();
                    request.setAttribute("productos",listado);
                    request.getRequestDispatcher("ProductoAviso.jsp").forward(request,response);
                }
                case "Agregar" -> {
                    if((request.getParameter("txtNombre").isBlank())||(request.getParameter("fltPrecio").isBlank())||(request.getParameter("intStock").isBlank())){
       
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=ListarAviso").forward(request, response);
                    }else{
                        String nom = request.getParameter("txtNombre");
                        prc = Double.parseDouble(request.getParameter("fltPrecio"));
                        stck = Integer.parseInt(request.getParameter("intStock"));
                        String est = "1";

                        pd.setNom(nom);
                        pd.setPrecio(prc);
                        pd.setStock(stck);
                        pd.setEstado(est);
                        pd.agregar(pd);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                         }
                    }
                case "Editar" -> {
                    ide=Integer.parseInt(request.getParameter("id"));
                    Producto e=pd.listarId(ide);
                    request.setAttribute("producto",e);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request,response);
                }
                case "Actualizar" -> {
                    if((request.getParameter("txtNombre").isBlank())||(request.getParameter("fltPrecio").isBlank())||(request.getParameter("intStock").isBlank())){
       
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=ListarAviso").forward(request, response);
                    }else{
                        String nom1 = request.getParameter("txtNombre");
                        Double precio1;
                        precio1 = Double.valueOf(request.getParameter("fltPrecio"));
                        int stock1 = Integer.parseInt(request.getParameter("intStock"));
                        String est1 = "1";
                        pd.setNom(nom1);
                        pd.setPrecio(precio1);
                        pd.setStock(stock1);
                        pd.setEstado(est1);  
                        pd.setId(ide);
                        pd.actualizar(pd);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request,response);
                    }
                }
                case "Delete" -> {
                    ide=Integer.parseInt(request.getParameter("id"));
                    pd.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request,response);
                }
                default -> throw new AssertionError();
            }
            //request.getRequestDispatcher("Producto.jsp").forward(request,response);
        }
        if (menu.equals("NuevaVenta")){
            switch (accion) {
                case "BuscarCliente" -> {
                    String dni = request.getParameter("codigocliente");
                    if(dni.isBlank()){
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request,response);
                    }else{
                    cl.setDni(dni);
                    cliente = cl.buscar(dni);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("clienteB", cliente);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request,response);
                    }
                }
                case "BuscarProducto" -> {
                    String idprueba = request.getParameter("codigoproducto");
                    if(idprueba.isBlank()){
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request,response);
                    }else{
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    pd = pd.listarId(id);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("clienteB", cliente);
                    request.setAttribute("producto",pd);
                    request.setAttribute("lista",lista);
                    request.setAttribute("totalpagar", totalPagar );
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request,response);
                    }
                    
                }
                case "Agregar" -> {
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("clienteB", cliente);
                    totalPagar=0.0;
                    item = item+1;
                    cod=pd.getId();
                    descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;
                    
                    
                    v=new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for(int i=0; i<lista.size();i++){
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar );
                    request.setAttribute("lista",lista);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request,response);
                }
                case "GenerarVenta" -> {
                    boolean error = false;
                    for(int i=0;i<lista.size();i++){
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdproducto();
                        if(i<(lista.size()-1)){
                            for (int j=i+1; j<lista.size();j++){
                                if(idproducto == lista.get(j).getIdproducto()){
                                    int cantidadSumado=lista.get(j).getCantidad();
                                    cantidad = cantidad + cantidadSumado;
                                }   
                            }    
                        }
                        Producto pr = new Producto();
                        pr = pr.buscar(idproducto);
                        int sac = pr.getStock() - cantidad;
                        if (sac<0){
                            error = true;
                        }             
                    }
                    if(!error){
                        for(int i=0;i<lista.size();i++){
                            Producto pr = new Producto();
                            int cantidad=lista.get(i).getCantidad();
                            int idproducto=lista.get(i).getIdproducto();
                            pr = pr.buscar(idproducto);
                            int sac = pr.getStock() - cantidad;
                            pr.actualizarStock(idproducto, sac);

                        }
                    
                        v.setIdcliente(cliente.getId());
                        v.setIdempleado(10);
                        v.setNumserie(numeroserie);
                        v.setFecha("2023-01-01");
                        v.setMonto(totalPagar);
                        v.setEstado("1");

                        vtot.guardarVenta(v);


                        int idv = Integer.parseInt(vtot.IdVentas());


                        for(int i=0;i< lista.size();i++){
                            v=new Venta();
                            v.setId(idv);
                            v.setIdproducto(lista.get(i).getIdproducto());
                            v.setCantidad(lista.get(i).getCantidad());
                            v.setPrecio(lista.get(i).getPrecio());
                            vtot.guardarDetalleventas(v);

                        }
                        v=new Venta();
                        lista = new ArrayList<>();
                        GenerarSerie gs = new GenerarSerie();
                        int incrementar = Integer.parseInt(numeroserie);
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request,response);
                    }else{
                        v=new Venta();
                        lista = new ArrayList<>();
                        totalPagar = 0.0;
                        request.getRequestDispatcher("RegistrarVentaAviso.jsp").forward(request,response);
                    }
                    
                }
                
                case "Cancelar" -> {
                    lista.clear();
                    //request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=default").forward(request,response);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request,response);
                
                }
                case "Eliminar" -> {
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("clienteB", cliente);
                    int items = Integer.parseInt(request.getParameter("item"));
                    for(int j=0; j<lista.size();j++){
                        if(lista.get(j).getItem() == items){
                            lista.remove(lista.get(j));
                        }
                    }
                    totalPagar = 0.0;
                    for(int i=0; i<lista.size();i++){
                        
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    
                    request.setAttribute("totalpagar", totalPagar );
                    request.setAttribute("lista",lista);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request,response);
                    
                }
                default -> {
                    numeroserie = vtot.GenerarSerie();
                    if(numeroserie==null){
                        numeroserie="00000001";
                        request.setAttribute("nserie", numeroserie);
                        
                    }
                    else{
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                         
                    }
                    //request.getRequestDispatcher("RegistrarVenta.jsp").forward(request,response);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request,response);
                    
                }
                
                
                
                
                
            }
            
                    
            //request.getRequestDispatcher("RegistrarVenta.jsp").forward(request,response);
        }
        if (menu.equals("HistorialVenta")){
                switch (accion){
                    case "Listar" -> {
                        List listado = vtot.listar();
                        request.setAttribute("ventas",listado);
                        
                    }
                    default -> throw new AssertionError();
                }
                request.getRequestDispatcher("HistorialVenta.jsp").forward(request,response);
            }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
