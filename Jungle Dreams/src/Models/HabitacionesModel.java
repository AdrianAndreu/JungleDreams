package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Database.DBSingleton;

public class HabitacionesModel {
	private String id;
	private String nombre;
	private String descripcion;
	private String cantidad;
	private String precio;
	private String numero_maximo_personas;
	private String numero_camas;
	private String fecha_baja;
	private String created_at;
	private String updated_at;
	private static Statement stmt=null;
	private static ResultSet rs=null;
	private static int numPagina=1;
	private static int numRegistroPagina=10;
	private static int numMaxPaginas;
	private static int quedarse=0;
	
	ArrayList<HabitacionesModel> habitacionesDatabase;

	public HabitacionesModel(String id, String nombre, String descripcion, String cantidad, String precio,
			String numero_maximo_personas, String numero_camas, String fecha_baja, String created_at,
			String updated_at) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
		this.numero_maximo_personas = numero_maximo_personas;
		this.numero_camas = numero_camas;
		this.fecha_baja = fecha_baja;
		this.created_at = created_at;
		this.updated_at = updated_at;
		if(stmt==null) {
			try {
				stmt=(Statement)DBSingleton.getConexion().createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rs=stmt.executeQuery("SELECT * FROM habitaciones WHERE fecha_baja IS NULL");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	public HabitacionesModel() {
		if(stmt==null) {
			try {
				stmt=(Statement)DBSingleton.getConexion().createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rs=stmt.executeQuery("SELECT * FROM habitaciones WHERE fecha_baja IS NULL");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getNumero_maximo_personas() {
		return numero_maximo_personas;
	}
	public void setNumero_maximo_personas(String numero_maximo_personas) {
		this.numero_maximo_personas = numero_maximo_personas;
	}
	public String getNumero_camas() {
		return numero_camas;
	}
	public void setNumero_camas(String numero_camas) {
		this.numero_camas = numero_camas;
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
	public static int getNumPagina() {
		return numPagina;
	}
	public static void setNumPagina(int numPagina) {
		HabitacionesModel.numPagina = numPagina;
	}
	public static int getNumRegistroPagina() {
		return numRegistroPagina;
	}
	public static void setNumRegistroPagina(int numRegistroPagina) {
		HabitacionesModel.numRegistroPagina = numRegistroPagina;
	}
	public static int getNumMaxPaginas() {
		return numMaxPaginas;
	}
	public static void setNumMaxPaginas(int numMaxPaginas) {
		HabitacionesModel.numMaxPaginas = numMaxPaginas;
	}
	
	public void crearHabitacion(String nombre,String descripcion,String cantidad,String precio,String numero_maximo_personas,String numero_camas) {
		try {
			rs.moveToInsertRow();
			rs.updateString("nombre", nombre);
			rs.updateString("descripcion", descripcion);
			rs.updateString("cantidad", cantidad);
			rs.updateString("precio", precio);
			rs.updateString("numero_maximo_personas", numero_maximo_personas);
			rs.updateString("numero_camas", numero_camas);
			rs.updateString("created_at", LocalDateTime.now().toString());
			rs.insertRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> modificarHabitacionesMandar(int i) {
		ArrayList<String> guardarDatos=new ArrayList<>();
		try {
			rs.absolute(i+1);
			quedarse=i+1;
			guardarDatos.add(rs.getString("nombre"));
			guardarDatos.add(rs.getString("descripcion"));
			guardarDatos.add(rs.getString("cantidad"));
			guardarDatos.add(rs.getString("precio"));
			guardarDatos.add(rs.getString("numero_maximo_personas"));
			guardarDatos.add(rs.getString("numero_camas"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guardarDatos;
	}
	
	public void modificarUsuariosConfirmar(String nombre,String descripcion,String cantidad,String precio,String numero_maximo_personas,String numero_camas) {
		try {
			rs.absolute(quedarse);
			if(descripcion.equals("")||descripcion==null) {
				descripcion=null;
			}
			rs.updateString("nombre", nombre);
			rs.updateString("descripcion", descripcion);
			rs.updateString("cantidad", cantidad);
			rs.updateString("precio", precio);
			rs.updateString("numero_maximo_personas", numero_maximo_personas);
			rs.updateString("numero_camas", numero_camas);
			rs.updateString("updated_at", LocalDateTime.now().toString());
			rs.updateRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void DarQuitarBajaHabitacion(int i) {
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
	
	public void buscarHabitaciones(String buscador,String texto) {
		try {
			if(buscador.equals("Nombre")&&!texto.equals("")) {
				rs=stmt.executeQuery("SELECT * FROM habitaciones WHERE nombre LIKE \"%"+texto+"%\"");
				
			}else if(buscador.equals("Cantidad")&&!texto.equals("")) {
				rs=stmt.executeQuery("SELECT * FROM habitaciones WHERE cantidad LIKE \"%"+texto+"%\"");
				
			}else if(buscador.equals("Precio")&&!texto.equals("")){
				rs=stmt.executeQuery("SELECT * FROM habitaciones WHERE precio LIKE \"%"+texto+"%\"");
				
			}else if(buscador.equals("Numero max. de personas")&&!texto.equals("")){
				rs=stmt.executeQuery("SELECT * FROM habitaciones WHERE numero_maximo_personas LIKE \"%"+texto+"%\"");
				
			}else if(buscador.equals("Numero de camas")&&!texto.equals("")){
				rs=stmt.executeQuery("SELECT * FROM habitaciones WHERE numero_camas LIKE \"%"+texto+"%\"");
				
			}else if(buscador.equals("De baja")){
				rs=stmt.executeQuery("SELECT * FROM habitaciones WHERE fecha_baja IS NOT NULL");
				
			}else {
				rs=stmt.executeQuery("SELECT * FROM habitaciones WHERE fecha_baja IS NULL");
				
			}
			HabitacionesModel.numPagina=1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<HabitacionesModel> arrayListHabitaciones(){
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
		
		habitacionesDatabase=new ArrayList<>();
		int registrosPorPagina=0;
		
		try {
			rs.absolute((numRegistroPagina*(numPagina-1)));
			while(rs.next()&&registrosPorPagina<numRegistroPagina) {
				registrosPorPagina++;
				habitacionesDatabase.add(new HabitacionesModel(rs.getString("id"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getString("cantidad"), rs.getString("precio"), rs.getString("numero_maximo_personas"), rs.getString("numero_camas"),
						rs.getString("fecha_baja"), rs.getString("created_at"), rs.getString("updated_at")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(numMaxPaginas==0) {
			numPagina=0;
		}
		return habitacionesDatabase;
	}
	
	public String getHabitacionPrecio(String id) {
		String precioH="0.0";
		int idH=Integer.parseInt(id);
		try {
			rs=stmt.executeQuery("SELECT * FROM habitaciones WHERE fecha_baja IS NULL AND id="+idH+"");
			while(rs.next()) {
				precioH=rs.getString("precio");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return precioH;
	}
}
