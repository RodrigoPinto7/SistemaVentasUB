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
public class Producto {
    
    int id;
    double precio;
    int stock;
    String estado;
    String nom;
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Producto() {
    }

    public Producto(int id, double precio, int stock, String estado, String nom) {
        this.id = id;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public Producto buscar(int id){
        Producto p = new Producto();
        String sql = "select * from producto where idproducto="+id;
        try{
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                
                
            }
        }catch(Exception e){
            
        }
        return p;
    }
    
    public int actualizarStock(int id, int stock){
        String sql = "update producto set Stock=? where idproducto=?";
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1,stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return r;
    }
    
    public List listar(){
        String sql="select * from producto";
        List<Producto>lista = new ArrayList<>();
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pd = new Producto();
                pd.setId(rs.getInt(1));
                pd.setNom(rs.getString(2));
                pd.setPrecio(rs.getDouble(3));
                pd.setStock(rs.getInt(4));
                pd.setEstado(rs.getString(5));
                lista.add(pd);
            }
        }catch(Exception e){
            
        }
        return lista;
    } 
    
    public int agregar(Producto pd){
        String sql = "insert into producto(Nombres,Precio,Stock,Estado)values(?,?,?,?)";
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,pd.getNom());
            ps.setDouble(2,pd.getPrecio());
            ps.setInt(3,pd.getStock());
            ps.setString(4,pd.getEstado());
    
            ps.executeUpdate();
            }
        catch(Exception e){
            
        }
        return r;
    }
    
    public Producto listarId(int id){
        Producto pd = new Producto();
        String sql = "select * from producto where IdProducto="+id;
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pd.setId(rs.getInt(1));
                pd.setNom(rs.getString(2));
                pd.setPrecio(rs.getDouble(3));
                pd.setStock(rs.getInt(4));
                pd.setEstado(rs.getString(5));
            }
        }catch(Exception e){
            
        }
        return pd;
    }
    
    public int actualizar(Producto pd){
        String sql = "update producto set Nombres=?,Precio=?,Stock=?,Estado=? where IdProducto=?";
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,pd.getNom());
            ps.setDouble(2,pd.getPrecio());
            ps.setInt(3,pd.getStock());
            ps.setString(4,pd.getEstado());
            ps.setInt(5,pd.getId());
            ps.executeUpdate();
            }
        catch(Exception e){
            
        }
        return r;
    }
    
    public void delete(int id){
        String sql = "delete from producto where IdProducto="+id;
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        
    }catch(Exception e) {
        
        }
    }
    
    
}
