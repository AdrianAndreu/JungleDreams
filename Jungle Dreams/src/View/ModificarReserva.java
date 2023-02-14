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
	private JTextField Habitacion;
	private JComboBox textoHabitacion;
	private JSpinner elegirNumeroDeAdultos;
	private JSpinner elegirNumeroDeNinyos;
	private JButton botonInsertar;
	private JButton botonCancelar;
	private ReservasController reservasController;

	/**
	 * Create the application.
	 */
	public ModificarReserva() {
		
	}

	/**
	 * Initialize the contents of the frame.
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
		
		textoHabitacion = new JComboBox();
		textoHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textoHabitacion.setBounds(273, 251, 151, 19);
		panel.add(textoHabitacion);
		frmJungleDreams.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		reservasController=new ReservasController(this);
		botonInsertar.setActionCommand("crearReservaVerdadera");
		botonCancelar.setActionCommand("crearReservaCancelada");
		botonInsertar.addActionListener(reservasController);
		botonCancelar.addActionListener(reservasController);
		
		AutoCompleteDecorator.decorate(textoUsuario);
		AutoCompleteDecorator.decorate(textoHabitacion);
		
		reservasController.fillDesplegablesReservas();
	}

}
