package Config;

import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Conexion {
	Connection con; 
	String url = "jdbc:mysql://localhost:3306/bd_venta";//?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String user = "root";
	String pass = "SQL95583638";
	public Connection conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
                        //JOptionPane.showMessageDialog(null, "conexion exitosa");
                        
		}catch(Exception e) {
                    //JOptionPane.showMessageDialog(null, "conexion error");
		}
		return con;
	}
	

}
