package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.JSONObject;

import Models.HabitacionesModel;
import Models.UserModel;
import View.CrearHabitacion;
import View.CrearUsuario;
import View.MenuPrincipal;
import View.ModificarHabitacion;
import View.ModificarUsuario;

public class HabitacionesController implements ActionListener,MouseListener{
	HabitacionesModel habitacionesModel=new HabitacionesModel();
	MenuPrincipal menuPrincipal;
	CrearHabitacion crearHabitacion;
	ModificarHabitacion modificarHabitacion;
	
	public HabitacionesController(MenuPrincipal menuPrincipal) {
		this.menuPrincipal=menuPrincipal;
	}
	public HabitacionesController() {}
	public HabitacionesController(CrearHabitacion crearHabitacion) {
		this.crearHabitacion=crearHabitacion;
	}
	public HabitacionesController(ModificarHabitacion modificarHabitacion) {
		this.modificarHabitacion=modificarHabitacion;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "buscarHabitaciones":
			habitacionesModel.buscarHabitaciones(menuPrincipal.getElegirOpcionBuscarHabitaciones().getSelectedItem().toString(), menuPrincipal.getTextoBuscarHabitaciones().getText().toString());;
			menuPrincipal.construirTablaHabitaciones();
			menuPrincipal.getNumeroPaginasHabitaciones().setText(ponerPaginas());
			break;
		case "crearHabitacion":
			crearHabitacion=new CrearHabitacion();
			crearHabitacion.initialize();
			break;
		case "modificarHabitacion":
			if(menuPrincipal.getTableHabitaciones().getSelectedRow()>=0) {
				ArrayList<String> datosFila=new ArrayList<>();
				modificarHabitacion=new ModificarHabitacion();
				modificarHabitacion.initialize();
				
				datosFila=habitacionesModel.modificarHabitacionesMandar(menuPrincipal.getTableHabitaciones().getSelectedRow()+(HabitacionesModel.getNumRegistroPagina()*(HabitacionesModel.getNumPagina()-1)));
				modificarHabitacion.getTextoNombre().setText(datosFila.get(0));
				modificarHabitacion.getTextoDescripcion().setText(datosFila.get(1));
				modificarHabitacion.getTextoCantidad().setText(datosFila.get(2));
				modificarHabitacion.getTextoPrecio().setText(datosFila.get(3));
				modificarHabitacion.getTextoNMaxP().setText(datosFila.get(4));
				modificarHabitacion.getTextoNCamas().setText(datosFila.get(5));
			}
			break;
		case "DarQuitarBajaHabitacion":
			habitacionesModel.DarQuitarBajaHabitacion(menuPrincipal.getTableHabitaciones().getSelectedRow()+(HabitacionesModel.getNumRegistroPagina()*(HabitacionesModel.getNumPagina()-1)));
			menuPrincipal.construirTablaHabitaciones();
			break;
		case "modificarHabitacionVerdadero":
			if(modificarHabitacion.getTextoNombre().getText().toString()==null||modificarHabitacion.getTextoNombre().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "La habitación debe de tener un nombre");
			}else if(modificarHabitacion.getTextoPrecio().getText().toString()==null||modificarHabitacion.getTextoPrecio().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "La habitación debe de tener un precio");
			}else if(modificarHabitacion.getTextoCantidad().getText().toString()==null||modificarHabitacion.getTextoCantidad().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe de poner la cantidad de habitaciones de la que el hotel dispone");
			}else if(modificarHabitacion.getTextoNMaxP().getText().toString()==null||modificarHabitacion.getTextoNMaxP().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "La habitación debe de tener un numero máximo de personas preestablecido");
			}else if(modificarHabitacion.getTextoNCamas().getText().toString()==null||modificarHabitacion.getTextoNCamas().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "La habitación debe de tener un numero de camas preestablecido");
			}else {
				try {
					Integer.parseInt(modificarHabitacion.getTextoCantidad().getText().toString());
					Integer.parseInt(modificarHabitacion.getTextoNCamas().getText().toString());
					Integer.parseInt(modificarHabitacion.getTextoNMaxP().getText().toString());
					Double.parseDouble(modificarHabitacion.getTextoPrecio().getText().toString());
					
					habitacionesModel.modificarUsuariosConfirmar(modificarHabitacion.getTextoNombre().getText().toString(), modificarHabitacion.getTextoDescripcion().getText().toString(), modificarHabitacion.getTextoCantidad().getText().toString(), modificarHabitacion.getTextoPrecio().getText().toString(), modificarHabitacion.getTextoNMaxP().getText().toString(), modificarHabitacion.getTextoNCamas().getText().toString());
					modificarHabitacion.getFrmJungleDreams().setVisible(false);
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "El formato del precio, de la cantidad, de las camas o del numero máximo de personas es incorrecto, deben ser carácteres numericos. (ej: 60)");
				}
			}
			break;
		case "modificarHabitacionCancelado":
			modificarHabitacion.getFrmJungleDreams().setVisible(false);
			break;
		case "crearHabitacionVerdadero":
			if(crearHabitacion.getTextoNombre().getText().toString()==null||crearHabitacion.getTextoNombre().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "La habitación debe de tener un nombre");
			}else if(crearHabitacion.getTextoPrecio().getText().toString()==null||crearHabitacion.getTextoPrecio().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "La habitación debe de tener un precio");
			}else if(crearHabitacion.getTextoCantidad().getText().toString()==null||crearHabitacion.getTextoCantidad().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe de poner la cantidad de habitaciones de la que el hotel dispone");
			}else if(crearHabitacion.getTextoNMaxP().getText().toString()==null||crearHabitacion.getTextoNMaxP().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "La habitación debe de tener un numero máximo de personas preestablecido");
			}else if(crearHabitacion.getTextoNCamas().getText().toString()==null||crearHabitacion.getTextoNCamas().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "La habitación debe de tener un numero de camas preestablecido");
			}else {
				try {
					Integer.parseInt(crearHabitacion.getTextoCantidad().getText().toString());
					Integer.parseInt(crearHabitacion.getTextoNCamas().getText().toString());
					Integer.parseInt(crearHabitacion.getTextoNMaxP().getText().toString());
					Double.parseDouble(crearHabitacion.getTextoPrecio().getText().toString());
					
					habitacionesModel.crearHabitacion(crearHabitacion.getTextoNombre().getText().toString(), crearHabitacion.getTextoDescripcion().getText().toString(), crearHabitacion.getTextoCantidad().getText().toString(), crearHabitacion.getTextoPrecio().getText().toString(), crearHabitacion.getTextoNMaxP().getText().toString(), crearHabitacion.getTextoNCamas().getText().toString());
					crearHabitacion.getFrmJungleDreams().setVisible(false);
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "El formato del precio, de la cantidad, de las camas o del numero máximo de personas es incorrecto, deben ser carácteres numericos. (ej: 60)");
				}
			}
			break;
		case "crearHabitacionCancelado":
				crearHabitacion.getFrmJungleDreams().setVisible(false);
			break;
		case "refrescarHabitaciones":
			HabitacionesModel.resetearQuery();
			menuPrincipal.construirTablaHabitaciones();
			menuPrincipal.getTextoBuscarHabitaciones().setText("");
			menuPrincipal.getNumeroPaginasHabitaciones().setText(ponerPaginas());
			break;
		default:
			System.out.println("ERROR EN LA ACCIÓN");
			break;
	}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==menuPrincipal.getDobleFlechaLeftHabitaciones()) {
			if(HabitacionesModel.getNumMaxPaginas()==0) {
				HabitacionesModel.setNumPagina(0);
			}else {
				HabitacionesModel.setNumPagina(1);
			}
			menuPrincipal.getNumeroPaginasHabitaciones().setText(ponerPaginas());
			menuPrincipal.construirTablaHabitaciones();
		}else if(e.getSource()==menuPrincipal.getDobleFlechaRightHabitaciones()) {
			HabitacionesModel.setNumPagina(HabitacionesModel.getNumMaxPaginas());
			menuPrincipal.getNumeroPaginasHabitaciones().setText(ponerPaginas());
			menuPrincipal.construirTablaHabitaciones();
		}else if(e.getSource()==menuPrincipal.getNormalFlechaLeftHabitaciones()) {
			if(HabitacionesModel.getNumPagina()>1) {
				HabitacionesModel.setNumPagina(HabitacionesModel.getNumPagina()-1);
				menuPrincipal.getNumeroPaginasHabitaciones().setText(ponerPaginas());
				menuPrincipal.construirTablaHabitaciones();
			}
		}else if(e.getSource()==menuPrincipal.getNormalFlechaRightHabitaciones()) {
			if(HabitacionesModel.getNumPagina()<HabitacionesModel.getNumMaxPaginas()) {
				HabitacionesModel.setNumPagina(HabitacionesModel.getNumPagina()+1);
				menuPrincipal.getNumeroPaginasHabitaciones().setText(ponerPaginas());
				menuPrincipal.construirTablaHabitaciones();
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

	public String[][] obtenerMatriz(){
		ArrayList<HabitacionesModel> arrayHabitaciones=habitacionesModel.arrayListHabitaciones();
		String matrizInfo[][]=new String[arrayHabitaciones.size()][10];
		
		for(int i=0; i<arrayHabitaciones.size();i++) {
			matrizInfo[i][0]=arrayHabitaciones.get(i).getId();
			matrizInfo[i][1]=arrayHabitaciones.get(i).getNombre();
			matrizInfo[i][2]=arrayHabitaciones.get(i).getDescripcion();
			matrizInfo[i][3]=arrayHabitaciones.get(i).getCantidad();
			matrizInfo[i][4]=arrayHabitaciones.get(i).getPrecio();
			matrizInfo[i][5]=arrayHabitaciones.get(i).getNumero_maximo_personas();
			matrizInfo[i][6]=arrayHabitaciones.get(i).getNumero_camas();
			matrizInfo[i][7]=arrayHabitaciones.get(i).getFecha_baja();
			matrizInfo[i][8]=arrayHabitaciones.get(i).getCreated_at();
			matrizInfo[i][9]=arrayHabitaciones.get(i).getUpdated_at();
		}
		return matrizInfo;
	}
	
	public String ponerPaginas() {
		return HabitacionesModel.getNumPagina()+"/"+HabitacionesModel.getNumMaxPaginas();
	}

}