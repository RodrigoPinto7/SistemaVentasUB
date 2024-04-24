/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author nacho
 */
public class VentaTot {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie(){
        String numeroserie="";
        String sql="select max(NumeroSerie) from Ventas";
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);
            }
            
        }catch(Exception e){
            
        }
        return numeroserie;
    }
    
    public String IdVentas(){
        String idventas="";
        String sql="select max(IdVentas) from ventas";
        try{
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                idventas=rs.getString(1);
            }
            
        }catch(Exception e){
            
        }
        return idventas;
    }
    
    public int guardarVenta(Venta ve){
        String sql = "insert into ventas(IdCliente,IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado)values(?,?,?,?,?,?)";
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1,ve.getIdcliente());
            ps.setInt(2,ve.getIdempleado());
            ps.setString(3,ve.getNumserie());
            ps.setString(4,ve.getFecha());
            ps.setDouble(5,ve.getMonto());
            ps.setString(6,ve.getEstado());
            
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return r;
    }
    
    public int guardarDetalleventas(Venta venta){
        String sql = "insert into detalle_ventas(IdVentas,IdProducto, Cantidad,PrecioVenta)values(?,?,?,?)";
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1,venta.getId());
            ps.setInt(2,venta.getIdproducto());
            ps.setInt(3,venta.getCantidad());
            ps.setDouble(4,venta.getPrecio());
            ps.executeUpdate();
            
        }catch(Exception e){
            
        }
        return r;
    }
    
    public List listar(){
        String sql="select * from ventas";
        List<Venta>lista = new ArrayList<>();
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Venta v = new Venta();
                v.setId(rs.getInt(1));
                v.setIdcliente(rs.getInt(2));
                v.setIdempleado(rs.getInt(3));
                v.setNumserie(rs.getString(4));
                v.setFecha(rs.getString(5));
                v.setMonto(rs.getDouble(6));
                v.setEstado(rs.getString(7));
                lista.add(v);
            }
        }catch(Exception e){
            
        }
        return lista;
    }
    
}
