package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.ReservasController;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CrearReserva {

	private JFrame frmJungleDreams;
	private JPanel panel;
	private JTextField fechaEntrada;
	private JTextField fechaSalida;
	private JTextField numeroAdultos;
	private JTextField numeroNinyos;
	private JTextField usuario;
	private JTextField textoFechaDeEntrada;
	private JTextField textoFechaDeSalida;
	private JTextField textoUsuario;
	private JTextField Habitacion;
	private JTextField textoHabitacion;
	private JSpinner elegirNumeroDeAdultos;
	private JSpinner elegirNumeroDeNinyos;
	private JButton botonInsertar;
	private JButton botonCancelar;
	private ReservasController reservasController;
	/**
	 * Create the application.
	 */
	public CrearReserva() {
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
		frmJungleDreams.setBounds(100, 100, 550, 403);
		frmJungleDreams.setResizable(false);
		frmJungleDreams.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 536, 366);
		panel.setBackground(new Color(168, 255, 168));
		frmJungleDreams.getContentPane().add(panel);
		panel.setLayout(null);
		
		fechaEntrada = new JTextField();
		fechaEntrada.setText("Fecha de entrada:");
		fechaEntrada.setOpaque(false);
		fechaEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		fechaEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		fechaEntrada.setEditable(false);
		fechaEntrada.setColumns(10);
		fechaEntrada.setBorder(null);
		fechaEntrada.setBounds(95, 25, 168, 19);
		panel.add(fechaEntrada);
		
		fechaSalida = new JTextField();
		fechaSalida.setText("Fecha de salida:");
		fechaSalida.setOpaque(false);
		fechaSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		fechaSalida.setFont(new Font("Tahoma", Font.BOLD, 14));
		fechaSalida.setEditable(false);
		fechaSalida.setColumns(10);
		fechaSalida.setBorder(null);
		fechaSalida.setBounds(112, 71, 151, 19);
		panel.add(fechaSalida);
		
		numeroAdultos = new JTextField();
		numeroAdultos.setText("N\u00FAmero de adultos:");
		numeroAdultos.setOpaque(false);
		numeroAdultos.setHorizontalAlignment(SwingConstants.RIGHT);
		numeroAdultos.setFont(new Font("Tahoma", Font.BOLD, 14));
		numeroAdultos.setEditable(false);
		numeroAdultos.setColumns(10);
		numeroAdultos.setBorder(null);
		numeroAdultos.setBounds(112, 116, 151, 19);
		panel.add(numeroAdultos);
		
		numeroNinyos = new JTextField();
		numeroNinyos.setText("Numero de ni\u00F1os:");
		numeroNinyos.setOpaque(false);
		numeroNinyos.setHorizontalAlignment(SwingConstants.RIGHT);
		numeroNinyos.setFont(new Font("Tahoma", Font.BOLD, 14));
		numeroNinyos.setEditable(false);
		numeroNinyos.setColumns(10);
		numeroNinyos.setBorder(null);
		numeroNinyos.setBounds(112, 162, 151, 19);
		panel.add(numeroNinyos);
		
		usuario = new JTextField();
		usuario.setText("Usuario:");
		usuario.setOpaque(false);
		usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		usuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		usuario.setEditable(false);
		usuario.setColumns(10);
		usuario.setBorder(null);
		usuario.setBounds(167, 207, 96, 19);
		panel.add(usuario);
		
		textoFechaDeEntrada = new JTextField();
		textoFechaDeEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoFechaDeEntrada.setColumns(10);
		textoFechaDeEntrada.setBounds(273, 27, 96, 19);
		panel.add(textoFechaDeEntrada);
		
		textoFechaDeSalida = new JTextField();
		textoFechaDeSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoFechaDeSalida.setColumns(10);
		textoFechaDeSalida.setBounds(273, 73, 96, 19);
		panel.add(textoFechaDeSalida);
		
		elegirNumeroDeAdultos = new JSpinner();
		elegirNumeroDeAdultos.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		elegirNumeroDeAdultos.setBounds(273, 118, 96, 20);
		panel.add(elegirNumeroDeAdultos);
		
		elegirNumeroDeNinyos = new JSpinner();
		elegirNumeroDeNinyos.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		elegirNumeroDeNinyos.setBounds(273, 164, 96, 20);
		panel.add(elegirNumeroDeNinyos);
		
		textoUsuario = new JTextField();
		textoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoUsuario.setColumns(10);
		textoUsuario.setBounds(273, 209, 96, 19);
		panel.add(textoUsuario);
		
		Habitacion = new JTextField();
		Habitacion.setText("Habitaci\u00F3n:");
		Habitacion.setOpaque(false);
		Habitacion.setHorizontalAlignment(SwingConstants.RIGHT);
		Habitacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		Habitacion.setEditable(false);
		Habitacion.setColumns(10);
		Habitacion.setBorder(null);
		Habitacion.setBounds(167, 249, 96, 19);
		panel.add(Habitacion);
		
		botonInsertar = new JButton("Insertar");
		botonInsertar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonInsertar.setActionCommand("crearUsuarioVerdadero");
		botonInsertar.setBounds(112, 302, 114, 37);
		panel.add(botonInsertar);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonCancelar.setActionCommand("crearUsuarioVerdadero");
		botonCancelar.setBounds(319, 302, 114, 37);
		panel.add(botonCancelar);
		
		textoHabitacion = new JTextField();
		textoHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoHabitacion.setColumns(10);
		textoHabitacion.setBounds(273, 251, 96, 19);
		panel.add(textoHabitacion);
		frmJungleDreams.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		reservasController=new ReservasController(this);
		botonInsertar.setActionCommand("crearReservaVerdadera");
		botonCancelar.setActionCommand("crearReservaCancelada");
		botonInsertar.addActionListener(reservasController);
		botonCancelar.addActionListener(reservasController);
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

	public JTextField getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(JTextField fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public JTextField getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(JTextField fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public JTextField getNumeroAdultos() {
		return numeroAdultos;
	}

	public void setNumeroAdultos(JTextField numeroAdultos) {
		this.numeroAdultos = numeroAdultos;
	}

	public JTextField getNumeroNinyos() {
		return numeroNinyos;
	}

	public void setNumeroNinyos(JTextField numeroNinyos) {
		this.numeroNinyos = numeroNinyos;
	}

	public JTextField getUsuario() {
		return usuario;
	}

	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}

	public JTextField getTextoFechaDeEntrada() {
		return textoFechaDeEntrada;
	}

	public void setTextoFechaDeEntrada(JTextField textoFechaDeEntrada) {
		this.textoFechaDeEntrada = textoFechaDeEntrada;
	}

	public JTextField getTextoFechaDeSalida() {
		return textoFechaDeSalida;
	}

	public void setTextoFechaDeSalida(JTextField textoFechaDeSalida) {
		this.textoFechaDeSalida = textoFechaDeSalida;
	}

	public JTextField getTextoUsuario() {
		return textoUsuario;
	}

	public void setTextoUsuario(JTextField textoUsuario) {
		this.textoUsuario = textoUsuario;
	}

	public JTextField getHabitacion() {
		return Habitacion;
	}

	public void setHabitacion(JTextField habitacion) {
		Habitacion = habitacion;
	}

	public JTextField getTextoHabitacion() {
		return textoHabitacion;
	}

	public void setTextoHabitacion(JTextField textoHabitacion) {
		this.textoHabitacion = textoHabitacion;
	}

	public JSpinner getElegirNumeroDeAdultos() {
		return elegirNumeroDeAdultos;
	}

	public void setElegirNumeroDeAdultos(JSpinner elegirNumeroDeAdultos) {
		this.elegirNumeroDeAdultos = elegirNumeroDeAdultos;
	}

	public JSpinner getElegirNumeroDeNinyos() {
		return elegirNumeroDeNinyos;
	}

	public void setElegirNumeroDeNinyos(JSpinner elegirNumeroDeNinyos) {
		this.elegirNumeroDeNinyos = elegirNumeroDeNinyos;
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

	public ReservasController getReservasController() {
		return reservasController;
	}

	public void setReservasController(ReservasController reservasController) {
		this.reservasController = reservasController;
	}
	
	
}
