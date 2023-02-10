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
		frmJungleDreams.setBounds(130, 130, 800, 300);
		frmJungleDreams.setResizable(false);
		frmJungleDreams.getContentPane().setLayout(null);
		frmJungleDreams.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		reservasController=new ReservasController(this);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 786, 263);
		panel.setBackground(new Color(168, 255, 168));
		frmJungleDreams.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2, BorderLayout.SOUTH);
		
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
		
		construirTablaReservas();
		
	}
	
	public void construirTablaReservas() {
		String titulos[]={"ID","Habitacion ID","Reserva ID","Cantidad","Precio","Fecha de creación","Fecha de modificación"};
		String informacion[][]=reservasController.obtenerMatrizReservasHabitacion();
		
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
}
