package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.json.JSONException;
import org.json.JSONObject;

import Models.UserModel;
import View.CrearUsuario;
import View.Login;
import View.MenuPrincipal;
import View.ModificarUsuario;

public class UserController implements ActionListener,MouseListener{
	UserModel userModel=new UserModel();
	MenuPrincipal menuPrincipal;
	CrearUsuario crearUsuario;
	String mostrar;
	JTextField email;
	JTextField password;
	JFrame login;
	JSONObject jsonObject;
	String jsonRespuesta;
	ModificarUsuario modificarUsuario;
	
	public UserController(JTextField email, JTextField password, JFrame login) {
		this.email = email;
		this.password = password;
		this.login = login;
	}
	public UserController(){}
	public UserController(MenuPrincipal menuprincipal) {
		this.menuPrincipal=menuprincipal;
	}
	
	public UserController(ModificarUsuario modificarUsuario) {
		this.modificarUsuario=modificarUsuario;
	}
	
	public UserController(CrearUsuario crearUsuario) {
		this.crearUsuario=crearUsuario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "login":
				try {
					
					String tEmail=email.getText().toString();
					String tPassword=password.getText().toString();
					String jEmail;
					
					jsonRespuesta=userModel.hacerLogin(tEmail,tPassword);
					jsonObject=new JSONObject(jsonRespuesta);
					jEmail=(String)jsonObject.getJSONObject("data").get("email");
					login.setVisible(false);
					MenuPrincipal menuPrincipal=new MenuPrincipal();
					menuPrincipal.setUsuario(tEmail);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (JSONException e1) {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
				}
				break;
			case "buscarUsuarios":
				userModel.buscarUsuarios(menuPrincipal.getElegirOpcionBuscarUsuarios().getSelectedItem().toString(), menuPrincipal.getTextoBuscarUsuarios().getText().toString());
				menuPrincipal.construirTabla();
				menuPrincipal.getNumeroPagina().setText(ponerPaginas());
				break;
			case "crearUsuario":
				crearUsuario=new CrearUsuario();
				crearUsuario.initialize();
				
				break;
			case "modificarUsuario":
				if(menuPrincipal.getTable().getSelectedRow()>=0) {
					ArrayList<String> datosFila=new ArrayList<>();
					modificarUsuario=new ModificarUsuario();
					modificarUsuario.initialize();
					
					datosFila=userModel.modificarUsuariosMandar(menuPrincipal.getTable().getSelectedRow()+(UserModel.getNumRegistroPagina()*(UserModel.getNumPagina()-1)));
					modificarUsuario.getNuevoEmail().setText(datosFila.get(0));
					modificarUsuario.getNuevaPassword().setText(datosFila.get(1));
					modificarUsuario.getNuevoNombre().setText(datosFila.get(2));
					modificarUsuario.getNuevosApellidos().setText(datosFila.get(3));
					modificarUsuario.getNuevoTelefono().setText(datosFila.get(4));
				}
				break;
			case "DarQuitarBajaUsuario":
				userModel.DarQuitarBajaUsuario(menuPrincipal.getTable().getSelectedRow()+(UserModel.getNumRegistroPagina()*(UserModel.getNumPagina()-1)));
				menuPrincipal.construirTabla();
				break;
			case "modificarUsuarioVerdadero":
				modificarUsuario.getFrmJungleDreams().setVisible(false);
				userModel.modificarUsuariosConfirmar(modificarUsuario.getNuevoEmail().getText().toString(),modificarUsuario.getNuevaPassword().getText().toString(),modificarUsuario.getNuevoNombre().getText().toString(),modificarUsuario.getNuevosApellidos().getText().toString(),modificarUsuario.getNuevoTelefono().getText().toString());
				
				break;
			case "modificarUsuarioCancelado":
	
				modificarUsuario.getFrmJungleDreams().setVisible(false);
				
				break;
			case "crearUsuarioVerdadero":
				if(crearUsuario.getEmail().getText().toString()==null||crearUsuario.getEmail().getText().toString().equals("")||crearUsuario.getPassword().getText().toString()==null||crearUsuario.getPassword().getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "El email y la contraseña no pueden estar vacios");
				}else {
					if(userModel.crearUsuarios(crearUsuario.getEmail().getText().toString(), crearUsuario.getPassword().getText().toString(), crearUsuario.getNombre().getText().toString(), crearUsuario.getApellidos().getText().toString(), crearUsuario.getTelefono().getText().toString())) {
						crearUsuario.getFrmJungleDreams().setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "Ese email ya existe");
					}
					
				}
				break;
			case "crearUsuarioCancelado":

				crearUsuario.getFrmJungleDreams().setVisible(false);
				
				break;
			case "refrescarUsuarios":
				menuPrincipal.construirTabla();
				menuPrincipal.getTextoBuscarUsuarios().setText("");
				break;
			default:
				System.out.println("ERROR EN LA ACCIÓN");
				break;
		}
		
	}
	
	public String[][] obtenerMatriz(){
		ArrayList<UserModel> arrayUsuarios=userModel.arrayListUsuarios();
		String matrizInfo[][]=new String[arrayUsuarios.size()][10];
		
		for(int i=0; i<arrayUsuarios.size();i++) {
			matrizInfo[i][0]=arrayUsuarios.get(i).getEmail();
			matrizInfo[i][1]=arrayUsuarios.get(i).getPassword();
			matrizInfo[i][2]=arrayUsuarios.get(i).getToken();
			matrizInfo[i][3]=arrayUsuarios.get(i).getFecha_validez_Token();
			matrizInfo[i][4]=arrayUsuarios.get(i).getNombre();
			matrizInfo[i][5]=arrayUsuarios.get(i).getApellidos();
			matrizInfo[i][6]=arrayUsuarios.get(i).getTelefono();
			matrizInfo[i][7]=arrayUsuarios.get(i).getFecha_baja();
			matrizInfo[i][8]=arrayUsuarios.get(i).getCreated_at();
			matrizInfo[i][9]=arrayUsuarios.get(i).getUpdated_at();
		}
		return matrizInfo;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==menuPrincipal.getDobleFlechaLeft()) {
			if(UserModel.getNumMaxPaginas()==0) {
				UserModel.setNumPagina(0);
			}else {
				UserModel.setNumPagina(1);
			}
			menuPrincipal.getNumeroPagina().setText(ponerPaginas());
			menuPrincipal.construirTabla();
		}else if(e.getSource()==menuPrincipal.getDobleFlechaRight()) {
			UserModel.setNumPagina(UserModel.getNumMaxPaginas());
			menuPrincipal.getNumeroPagina().setText(ponerPaginas());
			menuPrincipal.construirTabla();
		}else if(e.getSource()==menuPrincipal.getNormalFlechaLeft()) {
			if(UserModel.getNumPagina()>1) {
				UserModel.setNumPagina(UserModel.getNumPagina()-1);
				menuPrincipal.getNumeroPagina().setText(ponerPaginas());
				menuPrincipal.construirTabla();
			}
		}else if(e.getSource()==menuPrincipal.getNormalFlechaRight()) {
			if(UserModel.getNumPagina()<UserModel.getNumMaxPaginas()) {
				UserModel.setNumPagina(UserModel.getNumPagina()+1);
				menuPrincipal.getNumeroPagina().setText(ponerPaginas());
				menuPrincipal.construirTabla();
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
		return UserModel.getNumPagina()+"/"+UserModel.getNumMaxPaginas();
	}

}
