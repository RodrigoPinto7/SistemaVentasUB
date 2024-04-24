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
public class Cliente {
        int id;
	String dni;
	String direccion;
	String estado;
	String nom;
        
        Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
        int r;
        
    public Cliente buscar(String dni){
        Cliente c = new Cliente();
        String sql = "select * from cliente where Dni="+dni;
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        }catch (Exception e){
            
        }
        return c;
    }

    public Cliente(int id, String dni, String direccion, String estado, String nom) {
        this.id = id;
        this.dni = dni;
        this.direccion = direccion;
        this.estado = estado;
        this.nom = nom;
    }

    public Cliente() {
    }
          
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        
    public List listar(){
        String sql="select * from cliente";
        List<Cliente>lista = new ArrayList<>();
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getString(5));
                lista.add(cl);
            }
        }catch(Exception e){
            
        }
        return lista;
    } 
    
    public int agregar(Cliente cl){
        String sql = "insert into cliente(Dni,Nombres,Direccion,Estado)values(?,?,?,?)";
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,cl.getDni());
            ps.setString(2,cl.getNom());
            ps.setString(3,cl.getDireccion());
            ps.setString(4,cl.getEstado());
            
            ps.executeUpdate();
            }
        catch(Exception e){
            
        }
        return r;
    }
    
    public Cliente listarId(int id){
        Cliente cl = new Cliente();
        String sql = "select * from cliente where IdCliente="+id;
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cl.setDni(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getString(5));
            }
        }catch(Exception e){
            
        }
        return cl;
    }
    
    public int actualizar(Cliente cl){
        String sql = "update cliente set Dni=?,Nombres=?,Direccion=?,Estado=? where IdCliente=?";
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,cl.getDni());
            ps.setString(2,cl.getNom());
            ps.setString(3,cl.getDireccion());
            ps.setString(4,cl.getEstado());
            ps.setInt(5,cl.getId());
            ps.executeUpdate();
            }
        catch(Exception e){
            
        }
        return r;
    }
    
    public void delete(int id){
        String sql = "delete from cliente where IdCliente="+id;
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        
    }catch(Exception e) {
        
        }
    }
    
    
}
