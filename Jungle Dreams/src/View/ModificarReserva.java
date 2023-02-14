package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import org.jdatepicker.JDatePicker;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import Controller.ReservasController;
import java.awt.event.ActionListener;

public class ModificarReserva {

	private JFrame frmJungleDreams;
	private JPanel panel;
	private JTextField fechaEntrada;
	private JTextField fechaSalida;
	private JTextField numeroAdultos;
	private JTextField numeroNinyos;
	private JTextField usuario;
	private JDatePicker textoFechaDeEntrada;
	private JDatePicker textoFechaDeSalida;
	private JComboBox textoUsuario;
	private JSpinner elegirNumeroDeAdultos;
	private JSpinner elegirNumeroDeNinyos;
	private JButton botonModificarHabitacion;
	private JButton botonCancelarHabitacion;
	private ReservasController reservasController;

	/**
	 * Create the application.
	 */
	public ModificarReserva() {
		
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
		frmJungleDreams.setBounds(0, 0, 551, 350);
		frmJungleDreams.setResizable(false);
		frmJungleDreams.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 537, 313);
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
		
		textoFechaDeEntrada = new JDatePicker();
		textoFechaDeEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoFechaDeEntrada.setBounds(273, 27, 151, 19);
		panel.add(textoFechaDeEntrada);
		
		textoFechaDeSalida = new JDatePicker();
		textoFechaDeSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoFechaDeSalida.setBounds(273, 73, 151, 19);
		panel.add(textoFechaDeSalida);
		
		elegirNumeroDeAdultos = new JSpinner();
		elegirNumeroDeAdultos.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		elegirNumeroDeAdultos.setBounds(273, 118, 151, 20);
		panel.add(elegirNumeroDeAdultos);
		
		elegirNumeroDeNinyos = new JSpinner();
		elegirNumeroDeNinyos.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		elegirNumeroDeNinyos.setBounds(273, 164, 151, 20);
		panel.add(elegirNumeroDeNinyos);
		
		textoUsuario = new JComboBox();
		textoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textoUsuario.setBounds(273, 209, 151, 19);
		panel.add(textoUsuario);
		
		botonModificarHabitacion = new JButton("Modificar");
		botonModificarHabitacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonModificarHabitacion.setActionCommand("crearUsuarioVerdadero");
		botonModificarHabitacion.setBounds(112, 255, 114, 37);
		panel.add(botonModificarHabitacion);
		
		botonCancelarHabitacion = new JButton("Cancelar");
		botonCancelarHabitacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonCancelarHabitacion.setActionCommand("crearUsuarioVerdadero");
		botonCancelarHabitacion.setBounds(310, 255, 114, 37);
		panel.add(botonCancelarHabitacion);
		frmJungleDreams.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		reservasController=new ReservasController(this);
		
		botonModificarHabitacion.setActionCommand("modificarReservaVerdadera");
		botonCancelarHabitacion.setActionCommand("modificarReservaCancelada");
		botonModificarHabitacion.addActionListener(reservasController);
		botonCancelarHabitacion.addActionListener(reservasController);
		
		AutoCompleteDecorator.decorate(textoUsuario);
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

	public JDatePicker getTextoFechaDeEntrada() {
		return textoFechaDeEntrada;
	}

	public void setTextoFechaDeEntrada(JDatePicker textoFechaDeEntrada) {
		this.textoFechaDeEntrada = textoFechaDeEntrada;
	}

	public JDatePicker getTextoFechaDeSalida() {
		return textoFechaDeSalida;
	}

	public void setTextoFechaDeSalida(JDatePicker textoFechaDeSalida) {
		this.textoFechaDeSalida = textoFechaDeSalida;
	}

	public JComboBox getTextoUsuario() {
		return textoUsuario;
	}

	public void setTextoUsuario(JComboBox textoUsuario) {
		this.textoUsuario = textoUsuario;
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
		return botonModificarHabitacion;
	}

	public void setBotonInsertar(JButton botonInsertar) {
		this.botonModificarHabitacion = botonInsertar;
	}

	public JButton getBotonCancelar() {
		return botonCancelarHabitacion;
	}

	public void setBotonCancelar(JButton botonCancelar) {
		this.botonCancelarHabitacion = botonCancelar;
	}

	public ReservasController getReservasController() {
		return reservasController;
	}

	public void setReservasController(ReservasController reservasController) {
		this.reservasController = reservasController;
	}

	public JButton getBotonInsertarHabitacion() {
		return botonModificarHabitacion;
	}

	public void setBotonInsertarHabitacion(JButton botonInsertarHabitacion) {
		this.botonModificarHabitacion = botonInsertarHabitacion;
	}
	
}
