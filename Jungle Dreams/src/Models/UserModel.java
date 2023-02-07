package Models;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import Database.DBSingleton;

public class UserModel {
	private String email;
	private String password;
	private String token;
	private String fecha_validez_Token;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String fecha_baja;
	private String created_at;
	private String updated_at;
	private static Statement stmt=null;
	private static ResultSet rs=null;
	private static int numPagina=1;
	private static int numRegistroPagina=10;
	private static int numMaxPaginas;
	private static int quedarse=0;
	
	ArrayList<UserModel> usuariosDatabase;
	
	
	final int VALIDEZ_TOKEN=30;

	public UserModel(String email, String password, String token, String fecha_validez_Token, String nombre,
			String apellidos, String telefono, String fecha_baja, String created_at, String updated_at) {
		
		this.email = email;
		this.password = password;
		this.token = token;
		this.fecha_validez_Token = fecha_validez_Token;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.fecha_baja = fecha_baja;
		this.created_at=created_at;
		this.updated_at=updated_at;
		if(stmt==null) {
			try {
				stmt=(Statement)DBSingleton.getConexion().createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rs=stmt.executeQuery("SELECT * FROM users WHERE fecha_baja IS NULL");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public UserModel(){
		if(stmt==null) {
			try {
				stmt=(Statement)DBSingleton.getConexion().createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rs=stmt.executeQuery("SELECT * FROM users WHERE fecha_baja IS NULL");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFecha_validez_Token() {
		return fecha_validez_Token;
	}

	public void setFecha_validez_Token(String fecha_validez_Token) {
		this.fecha_validez_Token = fecha_validez_Token;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(String fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	public static int getNumRegistroPagina() {
		return numRegistroPagina;
	}

	public static void setNumRegistroPagina(int numRegistroPagina) {
		UserModel.numRegistroPagina = numRegistroPagina;
	}

	public static int getNumMaxPaginas() {
		return numMaxPaginas;
	}

	public static void setNumMaxPaginas(int numMaxPaginas) {
		UserModel.numMaxPaginas = numMaxPaginas;
	}

	public String hacerLogin(String email, String password) throws IOException {
		URL url = new URL("http://localhost/gestionhotelera/sw_user.php");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("action", "login");
		parameters.put("user", "{\"email\":\""+email+"\", \"password\":\""+password+"\"}");

		con.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
		out.flush();
		out.close();
		
		//con.setRequestProperty("Content-Type", "application/json");
		//String contentType = con.getHeaderField("Content-Type");
		
		int status = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		String content = new String();
		while ((inputLine = in.readLine()) != null) {
		    content+=inputLine;
		}
		in.close();
		con.disconnect();
		return content;
	}
	
	public static class ParameterStringBuilder {
	    public static String getParamsString(Map<String, String> params)throws UnsupportedEncodingException{
	        StringBuilder result = new StringBuilder();

	        for (Map.Entry<String, String> entry : params.entrySet()) {
	          result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
	          result.append("=");
	          result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
	          result.append("&");
	        }

	        String resultString = result.toString();
	        return resultString.length() > 0
	          ? resultString.substring(0, resultString.length() - 1)
	          : resultString;
	    }
	}
	
	public boolean crearUsuarios(String email, String password, String nombre, String apellidos, String telefono) {
		try {
			String comprobante=null;
			rs=stmt.executeQuery("SELECT * FROM users WHERE email=\""+email+"\"");
			while(rs.next()) {
				comprobante=rs.getString("email");
			}
			if(comprobante==null) {
				rs.moveToInsertRow();
				rs.updateString("email", email);
				rs.updateString("password", password);
				rs.updateString("nombre", nombre);
				rs.updateString("apellidos", apellidos);
				rs.updateString("telefono", telefono);
				rs.updateString("created_at", LocalDateTime.now().toString());
				rs.insertRow();
				rs.beforeFirst();
			}else {
				return false;
			}
			rs=stmt.executeQuery("SELECT * FROM users WHERE fecha_baja IS NULL");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public ArrayList<String> modificarUsuariosMandar(int i) {
		ArrayList<String> guardarDatos=new ArrayList<>();
		try {
			rs.absolute(i+1);
			quedarse=i+1;
			guardarDatos.add(rs.getString("email"));
			guardarDatos.add(rs.getString("password"));
			guardarDatos.add(rs.getString("nombre"));
			guardarDatos.add(rs.getString("apellidos"));
			guardarDatos.add(rs.getString("telefono"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guardarDatos;
	}
	
	public void modificarUsuariosConfirmar(String email, String password, String nombre, String apellidos, String telefono) {
		try {
			rs.absolute(quedarse);
			if(email.equals("")||email==null) {
				email=null;
			}
			if(password.equals("")||password==null) {
				password=null;
			}
			if(nombre.equals("")||nombre==null) {
				nombre=null;
			}
			if(apellidos.equals("")||apellidos==null) {
				apellidos=null;
			}
			if(telefono.equals("")||telefono==null) {
				telefono=null;
			}
			rs.updateString("email", email);
			rs.updateString("password", password);
			rs.updateString("nombre", nombre);
			rs.updateString("apellidos", apellidos);
			rs.updateString("telefono", telefono);
			rs.updateString("updated_at", LocalDateTime.now().toString());
			rs.updateRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void DarQuitarBajaUsuario(int i) {
		if(i>=0) {
			try {
				rs.absolute(i+1);
				if(rs.getString("fecha_baja")==null) {
					rs.updateString("fecha_baja",LocalDateTime.now().toString());
				}else {
					rs.updateString("fecha_baja", null);
				}
				rs.updateRow();
				rs.beforeFirst();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void buscarUsuarios(String buscador,String texto) {
		try {
			if(buscador.equals("Email")&&!texto.equals("")) {
				UserModel.numPagina=1;
				rs=stmt.executeQuery("SELECT * FROM users WHERE email LIKE \"%"+texto+"%\"");
			}else if(buscador.equals("Nombre")&&!texto.equals("")) {
				UserModel.numPagina=1;
				rs=stmt.executeQuery("SELECT * FROM users WHERE nombre LIKE \"%"+texto+"%\"");
			}else if(buscador.equals("Apellidos")&&!texto.equals("")) {
				UserModel.numPagina=1;
				rs=stmt.executeQuery("SELECT * FROM users WHERE apellidos LIKE \"%"+texto+"%\"");
			}else if(buscador.equals("Telefono")&&!texto.equals("")){
				UserModel.numPagina=1;
				rs=stmt.executeQuery("SELECT * FROM users WHERE telefono LIKE \"%"+texto+"%\"");
			}else if(buscador.equals("De baja")){
				rs=stmt.executeQuery("SELECT * FROM users WHERE fecha_baja IS NOT NULL");
				UserModel.numPagina=1;
			}else {
				UserModel.numPagina=1;
				rs=stmt.executeQuery("SELECT * FROM users WHERE fecha_baja IS NULL");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<UserModel> arrayListUsuarios(){
		try {
			numMaxPaginas=0;
			int numRegistros=0;
			rs.beforeFirst();
			while (rs.next()) {
				numRegistros++;
				
			}
			numMaxPaginas=(int)(numRegistros/numRegistroPagina)+1;
			if(numRegistros%numRegistroPagina==0) {
				numMaxPaginas--;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		usuariosDatabase=new ArrayList<>();
		int registrosPorPagina=0;
		
		try {
			rs.absolute((numRegistroPagina*(numPagina-1)));
			while(rs.next()&&registrosPorPagina<numRegistroPagina) {
				registrosPorPagina++;
				usuariosDatabase.add(new UserModel(rs.getString("email"), rs.getString("password"), rs.getString("token"),
						rs.getString("fecha_validez_token"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("telefono"),
						rs.getString("fecha_baja"), rs.getString("created_at"), rs.getString("updated_at")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(numMaxPaginas==0) {
			numPagina=0;
		}
		return usuariosDatabase;
	}

	public static int getNumPagina() {
		return numPagina;
	}

	public static void setNumPagina(int numPagina) {
		UserModel.numPagina = numPagina;
	}
	
	
	
	
}
