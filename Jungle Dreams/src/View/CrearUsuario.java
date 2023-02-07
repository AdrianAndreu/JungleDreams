package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.UserController;

public class CrearUsuario {

	private JFrame frmJungleDreams;
	private JPanel panel;
	private JTextField Email;
	private JTextField Password;
	private JTextField Nombre;
	private JTextField Apellidos;
	private JTextField modificarEmail;
	private JTextField modificarPassword;
	private JTextField modificarNombre;
	private JTextField modificarApellidos;
	private JTextField modificarTelefono;
	private JTextField Telefono;
	private JButton botonInsertar;
	private JButton botonCancelar;

	/**
	 * Create the application.
	 */
	public CrearUsuario() {
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frmJungleDreams = new JFrame();
		frmJungleDreams.setVisible(true);
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
		
		Email = new JTextField();
		Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Email.setBounds(242, 21, 96, 19);
		panel.add(Email);
		Email.setColumns(10);
		
		Password = new JTextField();
		Password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Password.setBounds(242, 56, 96, 19);
		panel.add(Password);
		Password.setColumns(10);
		
		Nombre = new JTextField();
		Nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Nombre.setBounds(242, 94, 96, 19);
		panel.add(Nombre);
		Nombre.setColumns(10);
		
		Apellidos = new JTextField();
		Apellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Apellidos.setBounds(242, 133, 96, 19);
		panel.add(Apellidos);
		Apellidos.setColumns(10);
		
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
		
		Telefono = new JTextField();
		Telefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Telefono.setBounds(242, 173, 96, 19);
		panel.add(Telefono);
		Telefono.setColumns(10);
		
		botonInsertar = new JButton("Insertar");
		botonInsertar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonInsertar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonInsertar.setBounds(84, 208, 114, 37);
		panel.add(botonInsertar);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonCancelar.setBounds(252, 209, 114, 35);
		panel.add(botonCancelar);
		
		UserController userController=new UserController(this);
		botonInsertar.setActionCommand("crearUsuarioVerdadero");
		botonCancelar.setActionCommand("crearUsuarioCancelado");
		botonInsertar.addActionListener(userController);
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

	public JTextField getEmail() {
		return Email;
	}

	public void setEmail(JTextField email) {
		Email = email;
	}

	public JTextField getPassword() {
		return Password;
	}

	public void setPassword(JTextField password) {
		Password = password;
	}

	public JTextField getNombre() {
		return Nombre;
	}

	public void setNombre(JTextField nombre) {
		Nombre = nombre;
	}

	public JTextField getApellidos() {
		return Apellidos;
	}

	public void setApellidos(JTextField apellidos) {
		Apellidos = apellidos;
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

	public JTextField getTelefono() {
		return Telefono;
	}

	public void setTelefono(JTextField telefono) {
		Telefono = telefono;
	}

	public JButton getBotonInsertar() {
		return botonInsertar;
	}

	public void setBotonInsertar(JButton botonInsertar) {
		this.botonInsertar = botonInsertar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public void setBotonCancelar(JButton botonCancelar) {
		this.botonCancelar = botonCancelar;
	}
	
	

}
