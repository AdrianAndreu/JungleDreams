package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.HabitacionesController;

public class ModificarHabitacion {

	private JFrame frmJungleDreams;
	private JPanel panel;
	private JTextField NombreHabitacion;
	private JTextField DescripcionHabitacion;
	private JTextField NMaxPHabitacion;
	private JTextField NCamasHabitacion;
	private JTextField PrecioHabitacion;
	private JTextField CantidadHabitacion;
	private JTextField textoNombre;
	private JTextField textoDescripcion;
	private JTextField textoNMaxP;
	private JTextField textoCantidad;
	private JTextField textoPrecio;
	private JTextField textoNCamas;
	private JButton botonModificarHabitacion;
	private JButton botonCancelarHabitacion;
	private HabitacionesController habitacionesController;

	/**
	 * Create the application.
	 */
	public ModificarHabitacion() {
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
		frmJungleDreams.setBounds(100, 100, 450, 300);
		frmJungleDreams.setResizable(false);
		frmJungleDreams.getContentPane().setLayout(null);
		frmJungleDreams.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		panel.setBackground(new Color(168, 255, 168));
		frmJungleDreams.getContentPane().add(panel);
		panel.setLayout(null);
		
		NombreHabitacion = new JTextField();
		NombreHabitacion.setText("Nombre:");
		NombreHabitacion.setOpaque(false);
		NombreHabitacion.setHorizontalAlignment(SwingConstants.RIGHT);
		NombreHabitacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		NombreHabitacion.setEditable(false);
		NombreHabitacion.setColumns(10);
		NombreHabitacion.setBorder(null);
		NombreHabitacion.setBounds(10, 24, 96, 19);
		panel.add(NombreHabitacion);
		
		DescripcionHabitacion = new JTextField();
		DescripcionHabitacion.setText("Descripci\u00F3n:");
		DescripcionHabitacion.setOpaque(false);
		DescripcionHabitacion.setHorizontalAlignment(SwingConstants.RIGHT);
		DescripcionHabitacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		DescripcionHabitacion.setEditable(false);
		DescripcionHabitacion.setColumns(10);
		DescripcionHabitacion.setBorder(null);
		DescripcionHabitacion.setBounds(10, 75, 96, 19);
		panel.add(DescripcionHabitacion);
		
		NMaxPHabitacion = new JTextField();
		NMaxPHabitacion.setText("N\u00BA max. P:");
		NMaxPHabitacion.setOpaque(false);
		NMaxPHabitacion.setHorizontalAlignment(SwingConstants.RIGHT);
		NMaxPHabitacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		NMaxPHabitacion.setEditable(false);
		NMaxPHabitacion.setColumns(10);
		NMaxPHabitacion.setBorder(null);
		NMaxPHabitacion.setBounds(10, 133, 96, 19);
		panel.add(NMaxPHabitacion);
		
		NCamasHabitacion = new JTextField();
		NCamasHabitacion.setText("N\u00BA camas:");
		NCamasHabitacion.setOpaque(false);
		NCamasHabitacion.setHorizontalAlignment(SwingConstants.RIGHT);
		NCamasHabitacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		NCamasHabitacion.setEditable(false);
		NCamasHabitacion.setColumns(10);
		NCamasHabitacion.setBorder(null);
		NCamasHabitacion.setBounds(196, 24, 96, 19);
		panel.add(NCamasHabitacion);
		
		PrecioHabitacion = new JTextField();
		PrecioHabitacion.setText("Precio:");
		PrecioHabitacion.setOpaque(false);
		PrecioHabitacion.setHorizontalAlignment(SwingConstants.RIGHT);
		PrecioHabitacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		PrecioHabitacion.setEditable(false);
		PrecioHabitacion.setColumns(10);
		PrecioHabitacion.setBorder(null);
		PrecioHabitacion.setBounds(196, 75, 96, 19);
		panel.add(PrecioHabitacion);
		
		CantidadHabitacion = new JTextField();
		CantidadHabitacion.setText("Cantidad:");
		CantidadHabitacion.setOpaque(false);
		CantidadHabitacion.setHorizontalAlignment(SwingConstants.RIGHT);
		CantidadHabitacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		CantidadHabitacion.setEditable(false);
		CantidadHabitacion.setColumns(10);
		CantidadHabitacion.setBorder(null);
		CantidadHabitacion.setBounds(196, 133, 96, 19);
		panel.add(CantidadHabitacion);
		
		textoNombre = new JTextField();
		textoNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoNombre.setColumns(10);
		textoNombre.setBounds(116, 24, 96, 19);
		panel.add(textoNombre);
		
		textoDescripcion = new JTextField();
		textoDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoDescripcion.setColumns(10);
		textoDescripcion.setBounds(116, 75, 96, 19);
		panel.add(textoDescripcion);
		
		textoNMaxP = new JTextField();
		textoNMaxP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoNMaxP.setColumns(10);
		textoNMaxP.setBounds(116, 133, 96, 19);
		panel.add(textoNMaxP);
		
		textoCantidad = new JTextField();
		textoCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoCantidad.setColumns(10);
		textoCantidad.setBounds(302, 133, 96, 19);
		panel.add(textoCantidad);
		
		textoPrecio = new JTextField();
		textoPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoPrecio.setColumns(10);
		textoPrecio.setBounds(302, 75, 96, 19);
		panel.add(textoPrecio);
		
		textoNCamas = new JTextField();
		textoNCamas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoNCamas.setColumns(10);
		textoNCamas.setBounds(302, 24, 96, 19);
		panel.add(textoNCamas);
		
		botonModificarHabitacion = new JButton("Insertar");
		botonModificarHabitacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonModificarHabitacion.setActionCommand("crearUsuarioVerdadero");
		botonModificarHabitacion.setBounds(65, 196, 114, 37);
		panel.add(botonModificarHabitacion);
		
		botonCancelarHabitacion = new JButton("Cancelar");
		botonCancelarHabitacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonCancelarHabitacion.setActionCommand("crearUsuarioVerdadero");
		botonCancelarHabitacion.setBounds(255, 196, 114, 37);
		panel.add(botonCancelarHabitacion);
		
		habitacionesController=new HabitacionesController(this);
		botonModificarHabitacion.setActionCommand("modificarHabitacionVerdadero");
		botonCancelarHabitacion.setActionCommand("modificarHabitacionCancelado");
		botonModificarHabitacion.addActionListener(habitacionesController);
		botonCancelarHabitacion.addActionListener(habitacionesController);
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

	public JTextField getNombreHabitacion() {
		return NombreHabitacion;
	}

	public void setNombreHabitacion(JTextField nombreHabitacion) {
		NombreHabitacion = nombreHabitacion;
	}

	public JTextField getDescripcionHabitacion() {
		return DescripcionHabitacion;
	}

	public void setDescripcionHabitacion(JTextField descripcionHabitacion) {
		DescripcionHabitacion = descripcionHabitacion;
	}

	public JTextField getNMaxPHabitacion() {
		return NMaxPHabitacion;
	}

	public void setNMaxPHabitacion(JTextField nMaxPHabitacion) {
		NMaxPHabitacion = nMaxPHabitacion;
	}

	public JTextField getNCamasHabitacion() {
		return NCamasHabitacion;
	}

	public void setNCamasHabitacion(JTextField nCamasHabitacion) {
		NCamasHabitacion = nCamasHabitacion;
	}

	public JTextField getPrecioHabitacion() {
		return PrecioHabitacion;
	}

	public void setPrecioHabitacion(JTextField precioHabitacion) {
		PrecioHabitacion = precioHabitacion;
	}

	public JTextField getCantidadHabitacion() {
		return CantidadHabitacion;
	}

	public void setCantidadHabitacion(JTextField cantidadHabitacion) {
		CantidadHabitacion = cantidadHabitacion;
	}

	public JTextField getTextoNombre() {
		return textoNombre;
	}

	public void setTextoNombre(JTextField textoNombre) {
		this.textoNombre = textoNombre;
	}

	public JTextField getTextoDescripcion() {
		return textoDescripcion;
	}

	public void setTextoDescripcion(JTextField textoDescripcion) {
		this.textoDescripcion = textoDescripcion;
	}

	public JTextField getTextoNMaxP() {
		return textoNMaxP;
	}

	public void setTextoNMaxP(JTextField textoNMaxP) {
		this.textoNMaxP = textoNMaxP;
	}

	public JTextField getTextoCantidad() {
		return textoCantidad;
	}

	public void setTextoCantidad(JTextField textoCantidad) {
		this.textoCantidad = textoCantidad;
	}

	public JTextField getTextoPrecio() {
		return textoPrecio;
	}

	public void setTextoPrecio(JTextField textoPrecio) {
		this.textoPrecio = textoPrecio;
	}

	public JTextField getTextoNCamas() {
		return textoNCamas;
	}

	public void setTextoNCamas(JTextField textoNCamas) {
		this.textoNCamas = textoNCamas;
	}

	public JButton getBotonModificarHabitacion() {
		return botonModificarHabitacion;
	}

	public void setBotonModificarHabitacion(JButton botonModificarHabitacion) {
		this.botonModificarHabitacion = botonModificarHabitacion;
	}

	public JButton getBotonCancelarHabitacion() {
		return botonCancelarHabitacion;
	}

	public void setBotonCancelarHabitacion(JButton botonCancelarHabitacion) {
		this.botonCancelarHabitacion = botonCancelarHabitacion;
	}

	public HabitacionesController getHabitacionesController() {
		return habitacionesController;
	}

	public void setHabitacionesController(HabitacionesController habitacionesController) {
		this.habitacionesController = habitacionesController;
	}
	
}
