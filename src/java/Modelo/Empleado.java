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

public class Empleado {
        int id;
	String dni;
	String tel;
	String estado;
	String user;
	String nom;
        
        Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
        int r;


	public Empleado() {
		super();
	}

	public Empleado(int id, String dni, String tel, String estado, String user, String nom) {
		super();
		this.id = id;
		this.dni = dni;
		this.tel = tel;
		this.estado = estado;
		this.user = user;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
        
        public Empleado Validar(String user, String dni) {
		Empleado em = new Empleado();
		String sql = "SELECT * FROM empleado WHERE User=? AND Dni=?";
		try {
			con = cn.conexion();
			ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, dni);
			rs=ps.executeQuery();
			while(rs.next()) {
				em.setId(rs.getInt("IdEmpleado"));
				em.setUser(rs.getString("User"));
				em.setDni(rs.getString("Dni"));
				em.setNom(rs.getString("Nombres"));
                                em.setEstado(rs.getString("Estado"));
			}
		}catch (Exception e) {
		}
		return em;
	}
    //CRUD
        
    public List listar(){
        String sql="select * from empleado";
        List<Empleado>lista = new ArrayList<>();
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
        }catch(Exception e){
            
        }
        return lista;
    }
    
    public int agregar(Empleado em){
        String sql = "insert into empleado(Dni,Nombres,Telefono,Estado,User)values(?,?,?,?,?)";
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,em.getDni());
            ps.setString(2,em.getNom());
            ps.setString(3,em.getTel());
            ps.setString(4,em.getEstado());
            ps.setString(5,em.getUser());
            ps.executeUpdate();
            }
        catch(Exception e){
            
        }
        return r;
    }
    
    public Empleado listarId(int id){
        Empleado emp = new Empleado();
        String sql = "select * from empleado where IdEmpleado="+id;
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        }catch(Exception e){
            
        }
        return emp;
    }
    
    public int actualizar(Empleado em){
        String sql = "update empleado set Dni=?,Nombres=?,Telefono=?,Estado=?,User=? where IdEmpleado=?";
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,em.getDni());
            ps.setString(2,em.getNom());
            ps.setString(3,em.getTel());
            ps.setString(4,em.getEstado());
            ps.setString(5,em.getUser());
            ps.setInt(6,em.getId());
            ps.executeUpdate();
            }
        catch(Exception e){
            
        }
        return r;
    }
    
    
    public void delete(int id){
        String sql = "delete from empleado where IdEmpleado="+id;
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        
    }catch(Exception e) {
        
        }
    }
    
    public List listarUsuario(int id){
        String sql="select * from empleado where IdEmpleado="+id;
        List<Empleado>lista = new ArrayList<>();
        try{
            con = cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
        }catch(Exception e){
            
        }
        return lista;
    }
}
