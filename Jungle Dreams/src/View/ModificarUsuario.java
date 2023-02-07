package View;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.SwingConstants;

import Controller.UserController;

import javax.swing.JButton;

public class ModificarUsuario {

	private JFrame frmJungleDreams;
	private JPanel panel;
	private JTextField nuevoEmail;
	private JTextField nuevaPassword;
	private JTextField nuevoNombre;
	private JTextField nuevosApellidos;
	private JTextField modificarEmail;
	private JTextField modificarPassword;
	private JTextField modificarNombre;
	private JTextField modificarApellidos;
	private JTextField modificarTelefono;
	private JTextField nuevoTelefono;
	private JButton botonModificar;
	private JButton botonCancelar;
	

	/**
	 * Create the application.
	 */
	public ModificarUsuario() {
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frmJungleDreams = new JFrame();
		frmJungleDreams.setTitle("JUNGLE DREAMS");
		frmJungleDreams.setVisible(true);
		frmJungleDreams.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\J.PNG"));
		frmJungleDreams.setBounds(100, 100, 450, 300);
		frmJungleDreams.setResizable(false);
		frmJungleDreams.getContentPane().setLayout(null);
		frmJungleDreams.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		panel.setBackground(new Color(168, 255, 168));
		frmJungleDreams.getContentPane().add(panel);
		panel.setLayout(null);
		
		nuevoEmail = new JTextField();
		nuevoEmail.setEditable(false);
		nuevoEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nuevoEmail.setBounds(242, 21, 96, 19);
		panel.add(nuevoEmail);
		nuevoEmail.setColumns(10);
		
		nuevaPassword = new JTextField();
		nuevaPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nuevaPassword.setBounds(242, 56, 96, 19);
		panel.add(nuevaPassword);
		nuevaPassword.setColumns(10);
		
		nuevoNombre = new JTextField();
		nuevoNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nuevoNombre.setBounds(242, 94, 96, 19);
		panel.add(nuevoNombre);
		nuevoNombre.setColumns(10);
		
		nuevosApellidos = new JTextField();
		nuevosApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nuevosApellidos.setBounds(242, 133, 96, 19);
		panel.add(nuevosApellidos);
		nuevosApellidos.setColumns(10);
		
		modificarEmail = new JTextField();
		modificarEmail.setEditable(false);
		modificarEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		modificarEmail.setBorder(null);
		modificarEmail.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		modificarEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		modificarEmail.setOpaque(false);
		modificarEmail.setText("Email:");
		modificarEmail.setBounds(119, 21, 96, 19);
		panel.add(modificarEmail);
		modificarEmail.setColumns(10);
		
		modificarPassword = new JTextField();
		modificarPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		modificarPassword.setEditable(false);
		modificarPassword.setBorder(null);
		modificarPassword.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		modificarPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		modificarPassword.setOpaque(false);
		modificarPassword.setText("Password:");
		modificarPassword.setBounds(119, 54, 96, 19);
		panel.add(modificarPassword);
		modificarPassword.setColumns(10);
		
		modificarNombre = new JTextField();
		modificarNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		modificarNombre.setEditable(false);
		modificarNombre.setBorder(null);
		modificarNombre.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		modificarNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		modificarNombre.setOpaque(false);
		modificarNombre.setText("Nombre:");
		modificarNombre.setBounds(119, 92, 96, 19);
		panel.add(modificarNombre);
		modificarNombre.setColumns(10);
		
		modificarApellidos = new JTextField();
		modificarApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		modificarApellidos.setEditable(false);
		modificarApellidos.setBorder(null);
		modificarApellidos.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		modificarApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		modificarApellidos.setOpaque(false);
		modificarApellidos.setText("Apellidos:");
		modificarApellidos.setBounds(119, 131, 96, 19);
		panel.add(modificarApellidos);
		modificarApellidos.setColumns(10);
		
		modificarTelefono = new JTextField();
		modificarTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		modificarTelefono.setEditable(false);
		modificarTelefono.setBorder(null);
		modificarTelefono.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		modificarTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		modificarTelefono.setOpaque(false);
		modificarTelefono.setText("Tel\u00E9fono:");
		modificarTelefono.setBounds(119, 171, 96, 19);
		panel.add(modificarTelefono);
		modificarTelefono.setColumns(10);
		
		nuevoTelefono = new JTextField();
		nuevoTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nuevoTelefono.setBounds(242, 173, 96, 19);
		panel.add(nuevoTelefono);
		nuevoTelefono.setColumns(10);
		
		botonModificar = new JButton("Modificar");
		botonModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonModificar.setBounds(84, 208, 114, 37);
		panel.add(botonModificar);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonCancelar.setBounds(252, 209, 114, 35);
		panel.add(botonCancelar);
		
		UserController userController=new UserController(this);
		botonModificar.setActionCommand("modificarUsuarioVerdadero");
		botonCancelar.setActionCommand("modificarUsuarioCancelado");
		botonModificar.addActionListener(userController);
		botonCancelar.addActionListener(userController);
		
	}

	public JFrame getFrmJungleDreams() {
		return frmJungleDreams;
	}

	public void setFrmJungleDreams(JFrame frmJungleDreams) {
		this.frmJungleDreams = frmJungleDreams;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getNuevoEmail() {
		return nuevoEmail;
	}

	public void setNuevoEmail(JTextField nuevoEmail) {
		this.nuevoEmail = nuevoEmail;
	}

	public JTextField getNuevaPassword() {
		return nuevaPassword;
	}

	public void setNuevaPassword(JTextField nuevaPassword) {
		this.nuevaPassword = nuevaPassword;
	}

	public JTextField getNuevoNombre() {
		return nuevoNombre;
	}

	public void setNuevoNombre(JTextField nuevoNombre) {
		this.nuevoNombre = nuevoNombre;
	}

	public JTextField getNuevosApellidos() {
		return nuevosApellidos;
	}

	public void setNuevosApellidos(JTextField nuevosApellidos) {
		this.nuevosApellidos = nuevosApellidos;
	}

	public JTextField getModificarEmail() {
		return modificarEmail;
	}

	public void setModificarEmail(JTextField modificarEmail) {
		this.modificarEmail = modificarEmail;
	}

	public JTextField getModificarPassword() {
		return modificarPassword;
	}

	public void setModificarPassword(JTextField modificarPassword) {
		this.modificarPassword = modificarPassword;
	}

	public JTextField getModificarNombre() {
		return modificarNombre;
	}

	public void setModificarNombre(JTextField modificarNombre) {
		this.modificarNombre = modificarNombre;
	}

	public JTextField getModificarApellidos() {
		return modificarApellidos;
	}

	public void setModificarApellidos(JTextField modificarApellidos) {
		this.modificarApellidos = modificarApellidos;
	}

	public JTextField getModificarTelefono() {
		return modificarTelefono;
	}

	public void setModificarTelefono(JTextField modificarTelefono) {
		this.modificarTelefono = modificarTelefono;
	}

	public JTextField getNuevoTelefono() {
		return nuevoTelefono;
	}

	public void setNuevoTelefono(JTextField nuevoTelefono) {
		this.nuevoTelefono = nuevoTelefono;
	}

	public JButton getBotonModificar() {
		return botonModificar;
	}

	public void setBotonModificar(JButton botonModificar) {
		this.botonModificar = botonModificar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public void setBotonCancelar(JButton botonCancelar) {
		this.botonCancelar = botonCancelar;
	}
	
	
}
