package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.json.JSONException;
import org.json.JSONObject;

import View.Login;
import View.MenuPrincipal;

public class MenuPrincipalController implements MouseListener,ActionListener{
	MenuPrincipal menuPrincipal;

	public MenuPrincipalController(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
		
	}

	boolean VerMenu=false;

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==menuPrincipal.getMenu()) {
			if(VerMenu==false) {
				VerMenu=true;
				menuPrincipal.getPanelMenu().setVisible(true);
			}else {
				VerMenu=false;
				menuPrincipal.getPanelMenu().setVisible(false);
			}
		}else if(e.getSource()==menuPrincipal.getFotoUsuariosMenu()||e.getSource()==menuPrincipal.getTextoUsuariosMenu()) {
			cambiarCardLayout(menuPrincipal.getPanelUsuarios());
			
		}else if(e.getSource()==menuPrincipal.getFotoPerfilMenu()||e.getSource()==menuPrincipal.getTextoPerfilMenu()) {
			cambiarCardLayout(menuPrincipal.getPanelPerfil());
			
		}else if(e.getSource()==menuPrincipal.getFotoReservasMenu()||e.getSource()==menuPrincipal.getTextoReservasMenu()) {
			cambiarCardLayout(menuPrincipal.getPanelReservas());
			
		}else if(e.getSource()==menuPrincipal.getFotoHabitacionesMenu()||e.getSource()==menuPrincipal.getTextoHabitacionesMenu()) {
			cambiarCardLayout(menuPrincipal.getPanelHabitaciones());
			
		}else if(e.getSource()==menuPrincipal.getFotoCerrarSesion()||e.getSource()==menuPrincipal.getTextoCerrarSesion()) {
			menuPrincipal.getFrmJungleDreams().setVisible(false);
			Login login=new Login();
			
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void cambiarCardLayout(JPanel panelElegido) {
		menuPrincipal.getPanelUsuarios().setVisible(false);
		menuPrincipal.getPanelPerfil().setVisible(false);
		menuPrincipal.getPanelReservas().setVisible(false);
		menuPrincipal.getPanelHabitaciones().setVisible(false);
		
		if (menuPrincipal.getPanelUsuarios()==panelElegido) {
			menuPrincipal.getPanelUsuarios().setVisible(true);
		}else if(menuPrincipal.getPanelPerfil()==panelElegido) {
			menuPrincipal.getPanelPerfil().setVisible(true);
		}else if(menuPrincipal.getPanelReservas()==panelElegido) {
			menuPrincipal.getPanelReservas().setVisible(true);
		}else if(menuPrincipal.getPanelHabitaciones()==panelElegido) {
			menuPrincipal.getPanelHabitaciones().setVisible(true);
		}
	}
	
	

}
