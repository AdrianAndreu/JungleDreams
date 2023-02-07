package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {
	public static Connection conexion=null;
	private String db;
	private String driver;
	private String url;
	private String usuario;
	private String password;
	
	private DBSingleton() throws ClassNotFoundException, SQLException{
		this.db = "gestion_hotelera";
		this.url = "jdbc:mariadb://localhost:3306/"+this.db+"";
		this.driver = "org.mariadb.jdbc.Driver";
		this.usuario = "root";
		this.password = "";
	
		Class.forName(driver);
		setConexion(DriverManager.getConnection(url, usuario, password));
	}

	public static Connection getConexion() throws ClassNotFoundException,SQLException {
		if (conexion == null){
			new DBSingleton();
		}

		return conexion;
	}

	public static void closeConexion() throws SQLException {
		if (conexion != null) {
			conexion.close();
		}

	}

	
	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}
	

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public static void setConexion(Connection conexion) {
		DBSingleton.conexion = conexion;
	}
}
