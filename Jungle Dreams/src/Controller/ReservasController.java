package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Models.ReservasHabitacionesModel;
import Models.ReservasModel;
import Models.UserModel;
import View.CrearReserva;
import View.CrearUsuario;
import View.MenuPrincipal;
import View.ModificarUsuario;
import View.VerReservaHabitación;

public class ReservasController implements ActionListener,MouseListener{
	ReservasModel reservasModel=new ReservasModel();
	ReservasHabitacionesModel reservasHabitacionesModel=new ReservasHabitacionesModel(); 
	MenuPrincipal menuPrincipal;
	VerReservaHabitación verReservaHabitación;
	CrearReserva crearReserva;
	//ModificarReserva modificarReserva;
	public ReservasController(){}
	public ReservasController(MenuPrincipal menuprincipal) {
		this.menuPrincipal=menuprincipal;
	}
	public ReservasController(VerReservaHabitación verReservaHabitación) {
		this.verReservaHabitación=verReservaHabitación;
	}
	
	/*public ReservasController(ModificarReserva modificarReserva) {
		this.modificarReserva=modificarReserva;
	}
	*/
	public ReservasController(CrearReserva crearReserva) {
		this.crearReserva=crearReserva;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "buscarReservas":
			reservasModel.buscarReservas(menuPrincipal.getElegirOpcionBuscarReservas().getSelectedItem().toString(), menuPrincipal.getTextoBuscarReservas().getText().toString());
			menuPrincipal.construirTablaReservas();
			menuPrincipal.getNumeroPaginaReservas().setText(ponerPaginas());
			break;
		case "crearReserva":
			crearReserva=new CrearReserva();
			crearReserva.initialize();
			break;
		case "modificarReserva":
			
			break;
		case "DarQuitarBajaReserva":
			reservasModel.DarQuitarBajaReserva(menuPrincipal.getTableReservas().getSelectedRow()+(ReservasModel.getNumRegistroPagina()*(ReservasModel.getNumPagina()-1)));
			menuPrincipal.construirTablaReservas();
			break;
		case "modificarReservaVerdadera":
			
			break;
		case "modificarReservaCancelada":
			
			break;
		case "crearReservaVerdadera":
			if(crearReserva.getTextoFechaDeEntrada().getText().toString()==null||crearReserva.getTextoFechaDeEntrada().getText().toString().equals("")||crearReserva.getTextoFechaDeSalida().getText().toString()==null||crearReserva.getTextoFechaDeSalida().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Las fechas no pueden estar vacias");
			}else if(crearReserva.getElegirNumeroDeAdultos().getValue().toString().equals("0")) {
				JOptionPane.showMessageDialog(null, "Debe de haber mínimo 1 adulto en la reserva");
			}else if(crearReserva.getTextoUsuario().getText().toString()==null||crearReserva.getTextoUsuario().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Se necesita asociar un usuario a una reserva");
			}else if(crearReserva.getTextoHabitacion().getText().toString()==null||crearReserva.getTextoHabitacion().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Se necesita asociar una habitación a una reserva");
			}else {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date fechaEntrada=(Date)dateFormat.parse(crearReserva.getTextoFechaDeEntrada().getText().toString());
					Date fechaSalida=(Date)dateFormat.parse(crearReserva.getTextoFechaDeSalida().getText().toString());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				long miliseconds = System.currentTimeMillis();
                Date hoy = new Date(miliseconds);
				//if(fechaEntrada) {
					
				//}
			}
			break;
		case "crearReservaCancelada":
			crearReserva.getFrmJungleDreams().setVisible(false);
			break;
		case "refrescarReservas":
			menuPrincipal.construirTablaReservas();
			menuPrincipal.getTextoBuscarReservas().setText("");
			break;
		default:
			System.out.println("ERROR EN LA ACCIÓN");
			break;
		}
		
	}
	
	public String[][] obtenerMatriz(){
		ArrayList<ReservasModel> arrayReservas=reservasModel.arrayListReservas();
		String matrizInfo[][]=new String[arrayReservas.size()][10];
		
		for(int i=0; i<arrayReservas.size();i++) {
			matrizInfo[i][0]=arrayReservas.get(i).getId();
			matrizInfo[i][1]=arrayReservas.get(i).getFecha();
			matrizInfo[i][2]=arrayReservas.get(i).getFecha_entrada();
			matrizInfo[i][3]=arrayReservas.get(i).getFecha_salida();
			matrizInfo[i][4]=arrayReservas.get(i).getNumero_adultos();
			matrizInfo[i][5]=arrayReservas.get(i).getNumero_ninyos();
			matrizInfo[i][6]=arrayReservas.get(i).getUser_id();
			matrizInfo[i][7]=arrayReservas.get(i).getFecha_baja();
			matrizInfo[i][8]=arrayReservas.get(i).getCreated_at();
			matrizInfo[i][9]=arrayReservas.get(i).getUpdated_at();
		}
		return matrizInfo;
	}
	
	public String[][] obtenerMatrizReservasHabitacion(){
		ArrayList<ReservasHabitacionesModel> arrayReservasHabitacion=reservasHabitacionesModel.arrayListReservas();
		String matrizInfo[][]=new String[arrayReservasHabitacion.size()][10];
		
		for(int i=0; i<arrayReservasHabitacion.size();i++) {
			matrizInfo[i][0]=arrayReservasHabitacion.get(i).getId();
			matrizInfo[i][1]=arrayReservasHabitacion.get(i).getHabitacion_id();
			matrizInfo[i][2]=arrayReservasHabitacion.get(i).getReserva_id();
			matrizInfo[i][3]=arrayReservasHabitacion.get(i).getCantidad();
			matrizInfo[i][4]=arrayReservasHabitacion.get(i).getPrecio();
			matrizInfo[i][5]=arrayReservasHabitacion.get(i).getCreated_at();
			matrizInfo[i][6]=arrayReservasHabitacion.get(i).getUpdated_at();
		}
		return matrizInfo;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==menuPrincipal.getDobleFlechaLeftReservas()) {
			if(ReservasModel.getNumMaxPaginas()==0) {
				ReservasModel.setNumPagina(0);
			}else {
				ReservasModel.setNumPagina(1);
			}
			menuPrincipal.getNumeroPaginaReservas().setText(ponerPaginas());
			menuPrincipal.construirTablaReservas();
		}else if(e.getSource()==menuPrincipal.getDobleFlechaRightReservas()) {
			ReservasModel.setNumPagina(ReservasModel.getNumMaxPaginas());
			menuPrincipal.getNumeroPaginaReservas().setText(ponerPaginas());
			menuPrincipal.construirTablaReservas();
		}else if(e.getSource()==menuPrincipal.getNormalFlechaLeftReservas()) {
			if(ReservasModel.getNumPagina()>1) {
				ReservasModel.setNumPagina(ReservasModel.getNumPagina()-1);
				menuPrincipal.getNumeroPaginaReservas().setText(ponerPaginas());
				menuPrincipal.construirTablaReservas();
			}
		}else if(e.getSource()==menuPrincipal.getNormalFlechaRightReservas()) {
			if(ReservasModel.getNumPagina()<ReservasModel.getNumMaxPaginas()) {
				ReservasModel.setNumPagina(ReservasModel.getNumPagina()+1);
				menuPrincipal.getNumeroPaginaReservas().setText(ponerPaginas());
				menuPrincipal.construirTablaReservas();
			}
		}else if(e.getSource()==menuPrincipal.getTableReservas()) {
			if(e.getClickCount()==2) {
				verReservaHabitación=new VerReservaHabitación();
				int id=Integer.parseInt(menuPrincipal.getTableReservas().getValueAt(menuPrincipal.getTableReservas().getSelectedRow(), 0).toString());
				reservasHabitacionesModel.setIdReserva(id);
				verReservaHabitación.initialize();
				
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public String ponerPaginas() {
		return ReservasModel.getNumPagina()+"/"+ReservasModel.getNumMaxPaginas();
	}

}
