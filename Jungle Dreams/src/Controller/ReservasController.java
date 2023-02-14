package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import Models.HabitacionesModel;
import Models.ReservasHabitacionesModel;
import Models.ReservasModel;
import Models.UserModel;
import View.CrearReserva;
import View.CrearUsuario;
import View.MenuPrincipal;
import View.ModificarHabitacion;
import View.ModificarReserva;
import View.ModificarUsuario;
import View.VerReservaHabitaci�n;

public class ReservasController implements ActionListener,MouseListener{
	ReservasModel reservasModel=new ReservasModel();
	ReservasHabitacionesModel reservasHabitacionesModel=new ReservasHabitacionesModel(); 
	HabitacionesModel habitacionesModel=new HabitacionesModel();
	MenuPrincipal menuPrincipal;
	VerReservaHabitaci�n verReservaHabitaci�n;
	CrearReserva crearReserva;
	int respuesta=1;
	String idReserva="1";
	ModificarReserva modificarReserva;
	public ReservasController(){}
	public ReservasController(MenuPrincipal menuprincipal) {
		this.menuPrincipal=menuprincipal;
	}
	public ReservasController(VerReservaHabitaci�n verReservaHabitaci�n) {
		this.verReservaHabitaci�n=verReservaHabitaci�n;
	}
	
	public ReservasController(ModificarReserva modificarReserva) {
		this.modificarReserva=modificarReserva;
	}
	
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
			if(menuPrincipal.getTableReservas().getSelectedRow()>=0) {
				ArrayList<String> datosFila=new ArrayList<>();
				modificarReserva=new ModificarReserva();
				modificarReserva.initialize();
				
				
				datosFila=reservasModel.modificarReservasMandar(menuPrincipal.getTableReservas().getSelectedRow()+(ReservasModel.getNumRegistroPagina()*(ReservasModel.getNumPagina()-1)));
				fillDesplegablesReservasModificar();
				SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
				Date fechaEntradaDate=new Date();
				Date fechaSalidaDate=new Date();
				try {
					fechaEntradaDate = parser.parse(datosFila.get(0));
					fechaSalidaDate = parser.parse(datosFila.get(1));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
				String fechaEntrada1 = formatter.format(fechaEntradaDate);
				String fechaSalida1 = formatter.format(fechaSalidaDate);
				
				
				modificarReserva.getTextoFechaDeEntrada().getFormattedTextField().setText(fechaEntrada1);
				modificarReserva.getTextoFechaDeSalida().getFormattedTextField().setText(fechaSalida1);
				modificarReserva.getElegirNumeroDeAdultos().setValue(Integer.parseInt(datosFila.get(2)));
				modificarReserva.getElegirNumeroDeNinyos().setValue(Integer.parseInt(datosFila.get(3)));
				modificarReserva.getTextoUsuario().setSelectedItem(datosFila.get(4));
				
			}
			break;
		case "DarQuitarBajaReserva":
			reservasModel.DarQuitarBajaReserva(menuPrincipal.getTableReservas().getSelectedRow()+(ReservasModel.getNumRegistroPagina()*(ReservasModel.getNumPagina()-1)));
			menuPrincipal.construirTablaReservas();
			break;
		case "modificarReservaVerdadera":
			if(modificarReserva.getTextoFechaDeEntrada().getFormattedTextField().getText().toString()==null||modificarReserva.getTextoFechaDeEntrada().getFormattedTextField().getText().toString().equals("")||modificarReserva.getTextoFechaDeSalida().getFormattedTextField().getText().toString()==null||modificarReserva.getTextoFechaDeSalida().getFormattedTextField().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Las fechas no pueden estar vacias");
			}else {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					SimpleDateFormat parser = new SimpleDateFormat("d MMM yyyy");
					Date fechaEntradaDate = parser.parse(modificarReserva.getTextoFechaDeEntrada().getFormattedTextField().getText().toString());
					Date fechaSalidaDate = parser.parse(modificarReserva.getTextoFechaDeSalida().getFormattedTextField().getText().toString());
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String fechaEntrada1 = formatter.format(fechaEntradaDate);
					String fechaSalida1 = formatter.format(fechaSalidaDate);
					
					Date fechaEntrada=(Date)dateFormat.parse(fechaEntrada1);
					Date fechaSalida=(Date)dateFormat.parse(fechaSalida1);
					long miliseconds = System.currentTimeMillis();
	                Date hoy = new Date(miliseconds);
	                if(fechaEntrada.after(fechaSalida)||fechaEntrada.before(hoy)) {
	                	JOptionPane.showMessageDialog(null, "Las fechas no concuerdan");
					}else {
						
						reservasModel.modificarReservasConfirmar(fechaEntrada1, fechaSalida1, modificarReserva.getElegirNumeroDeAdultos().getValue().toString(), modificarReserva.getElegirNumeroDeNinyos().getValue().toString(), modificarReserva.getTextoUsuario().getSelectedItem().toString());
						modificarReserva.getFrmJungleDreams().setVisible(false);
					}
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			break;
		case "modificarReservaCancelada":
			modificarReserva.getFrmJungleDreams().setVisible(false);
			break;
		case "crearReservaVerdadera":
			
			if(crearReserva.getTextoFechaDeEntrada().getFormattedTextField().getText().toString()==null||crearReserva.getTextoFechaDeEntrada().getFormattedTextField().getText().toString().equals("")||crearReserva.getTextoFechaDeSalida().getFormattedTextField().getText().toString()==null||crearReserva.getTextoFechaDeSalida().getFormattedTextField().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Las fechas no pueden estar vacias");
			}else {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					SimpleDateFormat parser = new SimpleDateFormat("d MMM yyyy");
					Date fechaEntradaDate = parser.parse(crearReserva.getTextoFechaDeEntrada().getFormattedTextField().getText().toString());
					Date fechaSalidaDate = parser.parse(crearReserva.getTextoFechaDeSalida().getFormattedTextField().getText().toString());
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String fechaEntrada1 = formatter.format(fechaEntradaDate);
					String fechaSalida1 = formatter.format(fechaSalidaDate);
					
					Date fechaEntrada=(Date)dateFormat.parse(fechaEntrada1);
					Date fechaSalida=(Date)dateFormat.parse(fechaSalida1);
					long miliseconds = System.currentTimeMillis();
	                Date hoy = new Date(miliseconds);
	                if(fechaEntrada.after(fechaSalida)||fechaEntrada.before(hoy)) {
	                	JOptionPane.showMessageDialog(null, "Las fechas no concuerdan");
					}else {
						if(respuesta==1) {
							reservasModel.crearReserva(fechaEntrada1, fechaSalida1, crearReserva.getElegirNumeroDeAdultos().getValue().toString(), crearReserva.getElegirNumeroDeNinyos().getValue().toString(), crearReserva.getTextoUsuario().getSelectedItem().toString());
							idReserva=reservasModel.devolverUltimaReserva();
						}
						
						String precioHabitacion=habitacionesModel.getHabitacionPrecio(crearReserva.getTextoHabitacion().getSelectedItem().toString());
						String id=habitacionesModel.getHabitacionId(crearReserva.getTextoHabitacion().getSelectedItem().toString());
						reservasHabitacionesModel.crearReservasHabitaciones(id, idReserva, "1", precioHabitacion);
						crearReserva.getTextoFechaDeEntrada().setEnabled(false);
						crearReserva.getTextoFechaDeSalida().setEnabled(false);
						crearReserva.getElegirNumeroDeAdultos().setEnabled(false);
						crearReserva.getElegirNumeroDeNinyos().setEnabled(false);
						crearReserva.getTextoUsuario().setEnabled(false);
						respuesta=JOptionPane.showConfirmDialog(null, "�Desea agregar otra habitaci�n?","", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
						
						if(respuesta==1) {
							crearReserva.getFrmJungleDreams().setVisible(false);
						}
					}
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			break;
		case "crearReservaCancelada":
			crearReserva.getFrmJungleDreams().setVisible(false);
			break;
		case "refrescarReservas":
			ReservasModel.resetearQuery();
			menuPrincipal.construirTablaReservas();
			menuPrincipal.getTextoBuscarReservas().setText("");
			menuPrincipal.getNumeroPaginaReservas().setText(ponerPaginas());
			
			break;
		case "insertarHabitacionReserva":
			String precioHabitacion=habitacionesModel.getHabitacionPrecio(verReservaHabitaci�n.getElegirHabitacion().getSelectedItem().toString());
			String id=habitacionesModel.getHabitacionId(verReservaHabitaci�n.getElegirHabitacion().getSelectedItem().toString());
			String rId=""+ReservasHabitacionesModel.getIdReserva();
			reservasHabitacionesModel.crearReservasHabitaciones(id, rId, "1", precioHabitacion);
			verReservaHabitaci�n.construirTablaReservas();
			break;
		case "eliminarHabitacionReserva":
			if(verReservaHabitaci�n.getTable().getSelectedRow()>=0) {
				reservasHabitacionesModel.eliminarReservaHabitacion(verReservaHabitaci�n.getTable().getSelectedRow()+1);
				verReservaHabitaci�n.construirTablaReservas();
			}
			break;
		default:
			System.out.println("ERROR EN LA ACCI�N");
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
	
	public void fillDesplegablesReservas() {

		ArrayList<UserModel> listaUsers = UserModel.getAllUsers();
		ArrayList<HabitacionesModel> listaHabitaciones = HabitacionesModel.getAllHabitaciones();

		String[] userStrings = new String[listaUsers.size()];
		String[] habitacionStrings=new String[listaHabitaciones.size()];

		for (int i = 0; i < listaUsers.size(); i++) {
			userStrings[i] = listaUsers.get(i).getEmail();

		}
		for (int i = 0; i < listaHabitaciones.size(); i++) {
			habitacionStrings[i] = listaHabitaciones.get(i).getNombre();

		}

		crearReserva.getTextoUsuario().setModel(new DefaultComboBoxModel(userStrings));
		crearReserva.getTextoHabitacion().setModel(new DefaultComboBoxModel(habitacionStrings));
	}
	
	public void fillDesplegablesReservasModificar() {

		ArrayList<UserModel> listaUsers = UserModel.getAllUsers();
		
		String[] userStrings = new String[listaUsers.size()];
		
		for (int i = 0; i < listaUsers.size(); i++) {
			userStrings[i] = listaUsers.get(i).getEmail();

		}
		
		modificarReserva.getTextoUsuario().setModel(new DefaultComboBoxModel(userStrings));
	}
	
	public void fillDesplegablesReservasHabitaciones() {

		ArrayList<HabitacionesModel> listaHabitaciones = HabitacionesModel.getAllHabitaciones();
		
		String[] habitacionStrings=new String[listaHabitaciones.size()];
		
		for (int i = 0; i < listaHabitaciones.size(); i++) {
			habitacionStrings[i] = listaHabitaciones.get(i).getNombre();

		}
		
		verReservaHabitaci�n.getElegirHabitacion().setModel(new DefaultComboBoxModel(habitacionStrings));
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
				verReservaHabitaci�n=new VerReservaHabitaci�n();
				int id=Integer.parseInt(menuPrincipal.getTableReservas().getValueAt(menuPrincipal.getTableReservas().getSelectedRow(), 0).toString());
				ReservasHabitacionesModel.setIdReserva(id);
				verReservaHabitaci�n.initialize();
				fillDesplegablesReservasHabitaciones();
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
