package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DBSingleton;

public class ReservasHabitacionesModel {
	private String id;
	private static int idReserva=1;
	private String habitacion_id;
	private String reserva_id;
	private String cantidad;
	private String precio;
	private String created_at;
	private String updated_at;
	private static Statement stmt=null;
	private static ResultSet rs=null;
	
	ArrayList<ReservasHabitacionesModel> reservasHabitacionesDatabase;
	
	public ReservasHabitacionesModel(String id, String habitacion_id, String reserva_id, String cantidad, String precio,
			String created_at, String updated_at) {
		this.id = id;
		this.habitacion_id = habitacion_id;
		this.reserva_id = reserva_id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.created_at = created_at;
		this.updated_at = updated_at;
		if(stmt==null) {
			try {
				stmt=(Statement)DBSingleton.getConexion().createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ReservasHabitacionesModel() {
		if(stmt==null) {
			try {
				stmt=(Statement)DBSingleton.getConexion().createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				
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

	public String getHabitacion_id() {
		return habitacion_id;
	}

	public void setHabitacion_id(String habitacion_id) {
		this.habitacion_id = habitacion_id;
	}

	public String getReserva_id() {
		return reserva_id;
	}

	public void setReserva_id(String reserva_id) {
		this.reserva_id = reserva_id;
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
	
	public static int getIdReserva() {
		return idReserva;
	}

	public static void setIdReserva(int idReserva) {
		ReservasHabitacionesModel.idReserva = idReserva;
	}

	public ArrayList<ReservasHabitacionesModel> arrayListReservas(){
		reservasHabitacionesDatabase=new ArrayList<>();
		
		try {
			rs=stmt.executeQuery("SELECT * FROM reservas_habitaciones WHERE reserva_id="+idReserva+"");
			rs.beforeFirst();
			while(rs.next()) {
				
				reservasHabitacionesDatabase.add(new ReservasHabitacionesModel(rs.getString("id"), rs.getString("habitacion_id"), rs.getString("reserva_id"),
						rs.getString("cantidad"), rs.getString("precio"), rs.getString("created_at"), rs.getString("updated_at")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reservasHabitacionesDatabase;
	}
}
