package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Database.DBSingleton;

public class ReservasModel {
	private String id;
	private String fecha;
	private String fecha_entrada;
	private String fecha_salida;
	private String numero_adultos;
	private String numero_ninyos;
	private String user_id;
	private String fecha_baja;
	private String created_at;
	private String updated_at;
	private static Statement stmt=null;
	private static ResultSet rs=null;
	private static int numPagina=1;
	private static int numRegistroPagina=10;
	private static int numMaxPaginas;
	private static int quedarse=0;
	
	ArrayList<ReservasModel> reservasDatabase;

	public ReservasModel(String id, String fecha, String fecha_entrada, String fecha_salida, String numero_adultos,
			String numero_ninyos, String user_id, String fecha_baja, String created_at, String updated_at) {
		this.id = id;
		this.fecha = fecha;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.numero_adultos = numero_adultos;
		this.numero_ninyos = numero_ninyos;
		this.user_id = user_id;
		this.fecha_baja = fecha_baja;
		this.created_at = created_at;
		this.updated_at = updated_at;
		if(stmt==null) {
			try {
				stmt=(Statement)DBSingleton.getConexion().createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rs=stmt.executeQuery("SELECT * FROM reservas WHERE fecha_baja IS NULL");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public ReservasModel() {
		if(stmt==null) {
			try {
				stmt=(Statement)DBSingleton.getConexion().createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rs=stmt.executeQuery("SELECT * FROM reservas WHERE fecha_baja IS NULL");
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(String fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public String getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public String getNumero_adultos() {
		return numero_adultos;
	}

	public void setNumero_adultos(String numero_adultos) {
		this.numero_adultos = numero_adultos;
	}

	public String getNumero_ninyos() {
		return numero_ninyos;
	}

	public void setNumero_ninyos(String numero_ninyos) {
		this.numero_ninyos = numero_ninyos;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
		ReservasModel.numPagina = numPagina;
	}

	public static int getNumRegistroPagina() {
		return numRegistroPagina;
	}

	public static void setNumRegistroPagina(int numRegistroPagina) {
		ReservasModel.numRegistroPagina = numRegistroPagina;
	}

	public static int getNumMaxPaginas() {
		return numMaxPaginas;
	}

	public static void setNumMaxPaginas(int numMaxPaginas) {
		ReservasModel.numMaxPaginas = numMaxPaginas;
	}
	
	public void crearReserva(String fecha_entrada, String fecha_salida, String numero_adultos, String numero_ninyos, String user_id) {
		try {
			rs.moveToInsertRow();
			rs.updateString("fecha_entrada", fecha_entrada);
			rs.updateString("fecha_salida", fecha_salida);
			rs.updateString("numero_adultos", numero_adultos);
			rs.updateString("numero_ninyos", numero_ninyos);
			rs.updateString("user_id", user_id);
			rs.updateString("created_at", LocalDateTime.now().toString());
			rs.insertRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> modificarReservasMandar(int i) {
		ArrayList<String> guardarDatos=new ArrayList<>();
		try {
			rs.absolute(i+1);
			quedarse=i+1;
			guardarDatos.add(rs.getString("fecha_entrada"));
			guardarDatos.add(rs.getString("fecha_salida"));
			guardarDatos.add(rs.getString("numero_adultos"));
			guardarDatos.add(rs.getString("numero_ninyos"));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guardarDatos;
	}
	
	public String devolverUltimaReserva() {
		String idReserva="1";
		try {
			rs=stmt.executeQuery("SELECT * FROM reservas");
			rs.last();
			idReserva=rs.getString("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idReserva;
	}
	
	public void modificarReservasConfirmar(String fecha_entrada, String fecha_salida, String numero_adultos, String numero_ninyos) {
		try {
			rs.absolute(quedarse);
			if(fecha_entrada.equals("")||fecha_entrada==null) {
				fecha_entrada=null;
			}
			if(fecha_salida.equals("")||fecha_salida==null) {
				fecha_salida=null;
			}
			if(numero_adultos.equals("")||numero_adultos==null) {
				numero_adultos=null;
			}
			if(numero_ninyos.equals("")||numero_ninyos==null) {
				numero_ninyos=null;
			}
			rs.updateString("fecha_entrada", fecha_entrada);
			rs.updateString("fecha_salida", fecha_salida);
			rs.updateString("numero_adultos", numero_adultos);
			rs.updateString("numero_ninyos", numero_ninyos);
			rs.updateString("updated_at", LocalDateTime.now().toString());
			rs.updateRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DarQuitarBajaReserva(int i) {
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
	
	public void buscarReservas(String buscador,String texto) {
		try {
			if(buscador.equals("ID Usuario")&&!texto.equals("")) {
				rs=stmt.executeQuery("SELECT * FROM reservas WHERE user_id LIKE \"%"+texto+"%\"");
			}else if(buscador.equals("De baja")){
				rs=stmt.executeQuery("SELECT * FROM reservas WHERE fecha_baja IS NOT NULL");
			}else if(buscador.equals("Fecha entrada")){
				rs=stmt.executeQuery("SELECT * FROM reservas WHERE fecha_entrada LIKE \"%"+texto+"%\"");
			}else if(buscador.equals("Fecha salida")){
				rs=stmt.executeQuery("SELECT * FROM reservas WHERE fecha_salida LIKE \"%"+texto+"%\"");
			}else {
				rs=stmt.executeQuery("SELECT * FROM reservas WHERE fecha_baja IS NULL");
			}
			ReservasModel.numPagina=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ReservasModel> arrayListReservas(){
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
		
		reservasDatabase=new ArrayList<>();
		int registrosPorPagina=0;
		
		try {
			rs.absolute((numRegistroPagina*(numPagina-1)));
			while(rs.next()&&registrosPorPagina<numRegistroPagina) {
				registrosPorPagina++;
				reservasDatabase.add(new ReservasModel(rs.getString("id"), rs.getString("fecha"), rs.getString("fecha_entrada"),
						rs.getString("fecha_salida"), rs.getString("numero_adultos"), rs.getString("numero_ninyos"), rs.getString("user_id"),
						rs.getString("fecha_baja"), rs.getString("created_at"), rs.getString("updated_at")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(numMaxPaginas==0) {
			numPagina=0;
		}
		return reservasDatabase;
	}
	
}
