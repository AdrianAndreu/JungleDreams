package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.ReservasController;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class VerReservaHabitación {

	private JFrame frmJungleDreams;
	private JPanel panel;
	private ReservasController reservasController;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel PrecioTotal;
	private double precio;
	private JPanel panelInteraccionesReservaHabitaciones;
	private JButton InsertarHabitacion;
	private JButton EliminarHabitacion;
	private JComboBox ElegirHabitacion;

	/**
	 * Create the application.
	 */
	public VerReservaHabitación() {
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
		frmJungleDreams.setBounds(130, 130, 804, 329);
		frmJungleDreams.setResizable(false);
		frmJungleDreams.getContentPane().setLayout(null);
		frmJungleDreams.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		reservasController=new ReservasController(this);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 790, 292);
		panel.setBackground(new Color(168, 255, 168));
		frmJungleDreams.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		PrecioTotal = new JLabel("Precio total:");
		PrecioTotal.setHorizontalAlignment(SwingConstants.CENTER);
		PrecioTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(PrecioTotal, BorderLayout.NORTH);
		
		panelInteraccionesReservaHabitaciones = new JPanel();
		panelInteraccionesReservaHabitaciones.setOpaque(false);
		panel_2.add(panelInteraccionesReservaHabitaciones, BorderLayout.SOUTH);
		
		ElegirHabitacion = new JComboBox();
		panelInteraccionesReservaHabitaciones.add(ElegirHabitacion);
		
		InsertarHabitacion = new JButton("Insertar");
		panelInteraccionesReservaHabitaciones.add(InsertarHabitacion);
		
		EliminarHabitacion = new JButton("Eliminar");
		panelInteraccionesReservaHabitaciones.add(EliminarHabitacion);
		
		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel.add(panel_4, BorderLayout.WEST);
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel.add(panel_3, BorderLayout.EAST);
		
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(new Color(168, 255, 168));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		panel.add(scrollPane, BorderLayout.CENTER);
		
		InsertarHabitacion.setActionCommand("insertarHabitacionReserva");
		InsertarHabitacion.addActionListener(reservasController);
		EliminarHabitacion.setActionCommand("eliminarHabitacionReserva");
		EliminarHabitacion.addActionListener(reservasController);
		AutoCompleteDecorator.decorate(ElegirHabitacion);
		construirTablaReservas();
		
		
	}
	
	public void construirTablaReservas() {
		String titulos[]={"ID","Habitacion ID","Reserva ID","Cantidad","Precio","Fecha de creación","Fecha de modificación"};
		String informacion[][]=reservasController.obtenerMatrizReservasHabitacion();
		precio=0;
		for(int i=0;i<informacion.length;i++) {
			precio+=Double.parseDouble(informacion[i][4].toString());
		}
		PrecioTotal.setText("Precio total: "+precio+"€");
		table = new JTable(informacion,titulos);
		table.setDefaultEditor(Object.class, null);
		table.setSelectionBackground(new Color(196, 245, 141));
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setBorder(null);
		table.setBackground(new Color(255, 255, 255));
		table.setOpaque(false);
		
		scrollPane.setViewportView(table);
		
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

	public ReservasController getReservasController() {
		return reservasController;
	}

	public void setReservasController(ReservasController reservasController) {
		this.reservasController = reservasController;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}

	public JPanel getPanel_4() {
		return panel_4;
	}

	public void setPanel_4(JPanel panel_4) {
		this.panel_4 = panel_4;
	}

	public JPanel getPanel_3() {
		return panel_3;
	}

	public void setPanel_3(JPanel panel_3) {
		this.panel_3 = panel_3;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JLabel getPrecioTotal() {
		return PrecioTotal;
	}

	public void setPrecioTotal(JLabel precioTotal) {
		PrecioTotal = precioTotal;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public JPanel getPanelInteraccionesReservaHabitaciones() {
		return panelInteraccionesReservaHabitaciones;
	}

	public void setPanelInteraccionesReservaHabitaciones(JPanel panelInteraccionesReservaHabitaciones) {
		this.panelInteraccionesReservaHabitaciones = panelInteraccionesReservaHabitaciones;
	}

	public JButton getInsertarHabitacion() {
		return InsertarHabitacion;
	}

	public void setInsertarHabitacion(JButton insertarHabitacion) {
		InsertarHabitacion = insertarHabitacion;
	}

	public JButton getEliminarHabitacion() {
		return EliminarHabitacion;
	}

	public void setEliminarHabitacion(JButton eliminarHabitacion) {
		EliminarHabitacion = eliminarHabitacion;
	}

	public JComboBox getElegirHabitacion() {
		return ElegirHabitacion;
	}

	public void setElegirHabitacion(JComboBox elegirHabitacion) {
		ElegirHabitacion = elegirHabitacion;
	}
	
	
}
