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
import View.CrearUsuario;
import View.MenuPrincipal;
import View.ModificarUsuario;

public class HabitacionesController implements ActionListener,MouseListener{
	HabitacionesModel habitacionesModel=new HabitacionesModel();
	MenuPrincipal menuPrincipal;
	
	public HabitacionesController(MenuPrincipal menuPrincipal) {
		this.menuPrincipal=menuPrincipal;
	}
	public HabitacionesController() {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "buscarHabitaciones":
			habitacionesModel.buscarHabitaciones(menuPrincipal.getElegirOpcionBuscarHabitaciones().getSelectedItem().toString(), menuPrincipal.getTextoBuscarHabitaciones().getText().toString());;
			menuPrincipal.construirTablaHabitaciones();
			menuPrincipal.getNumeroPaginasHabitaciones().setText(ponerPaginas());
			break;
		case "crearHabitacion":
			
			break;
		case "modificarHabitacion":
			
			break;
		case "DarQuitarBajaHabitacion":
			habitacionesModel.DarQuitarBajaHabitacion(menuPrincipal.getTableHabitaciones().getSelectedRow()+(HabitacionesModel.getNumRegistroPagina()*(HabitacionesModel.getNumPagina()-1)));
			menuPrincipal.construirTablaHabitaciones();
			break;
		case "modificarHabitacionVerdadero":
			
			break;
		case "modificarHabitacionCancelado":
			
			break;
		case "crearHabitacionVerdadero":
			
			break;
		case "crearHabitacionCancelado":

			break;
		case "refrescarHabitaciones":
			menuPrincipal.construirTablaHabitaciones();
			menuPrincipal.getTextoBuscarHabitaciones().setText("");
			menuPrincipal.getNumeroPaginasHabitaciones().setText(ponerPaginas());
			break;
		default:
			System.out.println("ERROR EN LA ACCI�N");
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