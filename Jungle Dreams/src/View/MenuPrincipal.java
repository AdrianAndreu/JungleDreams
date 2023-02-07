package View;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Controller.MenuPrincipalController;
import Controller.ReservasController;
import Controller.UserController;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class MenuPrincipal {

	private JFrame frmJungleDreams;
	private JPanel panelToolBar;
	private JPanel panelToolBarLeft;
	private JLabel Menu;
	private JPanel panelToolBarRight;
	private JLabel masInfo;
	private JPanel panelToolBarCenter;
	private JLabel hotelLogoMenu;
	private JPanel panelMenu;
	private JTextField textoPerfilMenu;
	private JTextField textoUsuariosMenu;
	private JTextField textoReservasMenu;
	private JTextField textoHabitacionesMenu;
	private JLabel fotoUsuariosMenu;
	private JLabel fotoReservasMenu;
	private JLabel fotoPerfilMenu;
	private JLabel fotoHabitacionesMenu;
	private JPanel panelTodaInformacionMenu;
	private JPanel panelUsuarios;
	private JPanel panelPerfil;
	private JPanel panelReservas;
	private JPanel panelHabitaciones;
	private JScrollPane scrollPane;
	private MenuPrincipalController menuPrincipalController;
	private UserController userController=new UserController();
	private ReservasController reservasController=new ReservasController();
	private JTable table;
	private JPanel panelUsuariosLeft;
	private JPanel panelUsuariosRight;
	private JTextField TextoBuscarUsuarios;
	private JTextField textoCerrarSesion;
	private JLabel fotoCerrarSesion;
	private JPanel panelBuscarUsuarios;
	private JComboBox ElegirOpcionBuscarUsuarios;
	private JButton BotonBuscarUsuarios;
	private JPanel panelInteraccionUsuarios;
	private JPanel panelPaginadorUsuarios;
	private JPanel panelCrearElimiModUsuarios;
	private JPanel panelFondoPaginador;
	private JLabel dobleFlechaLeft;
	private JLabel normalFlechaLeft;
	private JTextField NumeroPagina;
	private JLabel dobleFlechaRight;
	private JLabel normalFlechaRight;
	private JButton crearUsuario;
	private JButton modificarUsuario;
	private JButton DarQuitarBajaUsuario;
	private JPanel panelBuscarReservas;
	private JPanel panelReservasLeft;
	private JPanel panelInteraccionReservas;
	private JPanel panelReservasRight;
	private JButton botonRefrescarUsuarios;
	private JScrollPane scrollPaneReservas;
	private JTable tableReservas;
	private JButton botonRefrescarReservas;
	private JTextField textoBuscarReservas;
	private JComboBox elegirOpcionBuscarReservas;
	private JButton botonBuscarReservas;
	private String usuario="";
	private JPanel panelCrearElimiModReservas;
	private JPanel panelPaginadorReservas;
	private JPanel panelFonfoPaginadorReservas;
	private JLabel dobleFlechaLeftReservas;
	private JLabel normalFlechaLeftReservas;
	private JTextField numeroPaginaReservas;
	private JLabel normalFlechaRightReservas;
	private JLabel dobleFlechaRightReservas;
	private JButton crearReserva;
	private JButton modificarReserva;
	private JButton DarQuitarBajaReservas;
	
	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmJungleDreams = new JFrame();
		frmJungleDreams.setEnabled(true);
		frmJungleDreams.setMinimumSize(new Dimension(1000, 600));
		frmJungleDreams.setTitle("JUNGLE DREAMS");
		frmJungleDreams.setVisible(true);
		frmJungleDreams.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\J.PNG"));
		frmJungleDreams.setBounds(200, 200, 900, 600);
		frmJungleDreams.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJungleDreams.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelToolBar = new JPanel();
		panelToolBar.setMinimumSize(new Dimension(300, 70));
		panelToolBar.setBackground(new Color(109, 243, 86));
		frmJungleDreams.getContentPane().add(panelToolBar, BorderLayout.NORTH);
		panelToolBar.setLayout(new BorderLayout(0, 0));
		
		panelToolBarLeft = new JPanel();
		panelToolBarLeft.setOpaque(false);
		panelToolBar.add(panelToolBarLeft, BorderLayout.WEST);
		panelToolBarLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 7));
		
		Menu = new JLabel("");
		Menu.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\menu.png"));
		Menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelToolBarLeft.add(Menu);
		
		panelToolBarRight = new JPanel();
		panelToolBarRight.setOpaque(false);
		panelToolBar.add(panelToolBarRight, BorderLayout.EAST);
		panelToolBarRight.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 7));
		
		masInfo = new JLabel("");
		masInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		masInfo.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\informacion.png"));
		panelToolBarRight.add(masInfo);
		
		panelToolBarCenter = new JPanel();
		panelToolBarCenter.setMinimumSize(new Dimension(144, 52));
		panelToolBarCenter.setOpaque(false);
		panelToolBar.add(panelToolBarCenter, BorderLayout.CENTER);
		panelToolBarCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 7));
		
		hotelLogoMenu = new JLabel("");
		hotelLogoMenu.setMinimumSize(new Dimension(144, 52));
		hotelLogoMenu.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\hotelp.png"));
		panelToolBarCenter.add(hotelLogoMenu);
		
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(39, 160, 51));
		panelMenu.setVisible(false);
		frmJungleDreams.getContentPane().add(panelMenu, BorderLayout.WEST);
		
		fotoPerfilMenu = new JLabel("");
		fotoPerfilMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fotoPerfilMenu.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\usuario_menu.png"));
		
		textoPerfilMenu = new JTextField();
		textoPerfilMenu.setForeground(new Color(255, 255, 255));
		textoPerfilMenu.setCaretColor(new Color(255, 255, 255));
		textoPerfilMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textoPerfilMenu.setBorder(null);
		textoPerfilMenu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textoPerfilMenu.setEditable(false);
		textoPerfilMenu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 28));
		textoPerfilMenu.setOpaque(false);
		textoPerfilMenu.setText("Perfil");
		textoPerfilMenu.setColumns(5);
		
		fotoUsuariosMenu = new JLabel("");
		fotoUsuariosMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fotoUsuariosMenu.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\clientes.png"));
		
		textoUsuariosMenu = new JTextField();
		textoUsuariosMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textoUsuariosMenu.setText("Usuarios");
		textoUsuariosMenu.setOpaque(false);
		textoUsuariosMenu.setForeground(Color.WHITE);
		textoUsuariosMenu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 28));
		textoUsuariosMenu.setEditable(false);
		textoUsuariosMenu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textoUsuariosMenu.setColumns(5);
		textoUsuariosMenu.setCaretColor(Color.WHITE);
		textoUsuariosMenu.setBorder(null);
		
		fotoReservasMenu = new JLabel("");
		fotoReservasMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fotoReservasMenu.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\reservas.png"));
		
		fotoHabitacionesMenu = new JLabel("");
		fotoHabitacionesMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fotoHabitacionesMenu.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\habitacion.png"));
		
		textoReservasMenu = new JTextField();
		textoReservasMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textoReservasMenu.setText("Reservas");
		textoReservasMenu.setOpaque(false);
		textoReservasMenu.setForeground(Color.WHITE);
		textoReservasMenu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 28));
		textoReservasMenu.setEditable(false);
		textoReservasMenu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textoReservasMenu.setColumns(5);
		textoReservasMenu.setCaretColor(Color.WHITE);
		textoReservasMenu.setBorder(null);
		
		textoHabitacionesMenu = new JTextField();
		textoHabitacionesMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textoHabitacionesMenu.setText("Habitaciones");
		textoHabitacionesMenu.setOpaque(false);
		textoHabitacionesMenu.setForeground(Color.WHITE);
		textoHabitacionesMenu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 28));
		textoHabitacionesMenu.setEditable(false);
		textoHabitacionesMenu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textoHabitacionesMenu.setColumns(5);
		textoHabitacionesMenu.setCaretColor(Color.WHITE);
		textoHabitacionesMenu.setBorder(null);
		
		textoCerrarSesion = new JTextField();
		textoCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textoCerrarSesion.setText("Cerrar Sesi\u00F3n");
		textoCerrarSesion.setOpaque(false);
		textoCerrarSesion.setForeground(Color.WHITE);
		textoCerrarSesion.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		textoCerrarSesion.setEditable(false);
		textoCerrarSesion.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textoCerrarSesion.setColumns(5);
		textoCerrarSesion.setCaretColor(Color.WHITE);
		textoCerrarSesion.setBorder(null);
		
		fotoCerrarSesion = new JLabel("");
		fotoCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fotoCerrarSesion.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\flecha.png"));
		GroupLayout gl_panelMenu = new GroupLayout(panelMenu);
		gl_panelMenu.setHorizontalGroup(
			gl_panelMenu.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelMenu.createSequentialGroup()
							.addContainerGap()
							.addComponent(fotoCerrarSesion)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textoCerrarSesion, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMenu.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelMenu.createSequentialGroup()
									.addComponent(fotoHabitacionesMenu, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textoHabitacionesMenu, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
								.addGroup(gl_panelMenu.createSequentialGroup()
									.addComponent(fotoReservasMenu, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textoReservasMenu, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
								.addGroup(gl_panelMenu.createSequentialGroup()
									.addComponent(fotoUsuariosMenu, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textoUsuariosMenu, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelMenu.createSequentialGroup()
									.addComponent(fotoPerfilMenu)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textoPerfilMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panelMenu.setVerticalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMenu.createSequentialGroup()
							.addContainerGap()
							.addComponent(fotoPerfilMenu))
						.addGroup(gl_panelMenu.createSequentialGroup()
							.addGap(18)
							.addComponent(textoPerfilMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMenu.createSequentialGroup()
							.addGap(18)
							.addComponent(fotoUsuariosMenu, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMenu.createSequentialGroup()
							.addGap(28)
							.addComponent(textoUsuariosMenu, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMenu.createSequentialGroup()
							.addGap(18)
							.addComponent(fotoReservasMenu, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(fotoHabitacionesMenu, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelMenu.createSequentialGroup()
							.addGap(30)
							.addComponent(textoReservasMenu, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(textoHabitacionesMenu, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
						.addComponent(fotoCerrarSesion)
						.addComponent(textoCerrarSesion, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelMenu.setLayout(gl_panelMenu);
		
		panelTodaInformacionMenu = new JPanel();
		frmJungleDreams.getContentPane().add(panelTodaInformacionMenu, BorderLayout.CENTER);
		panelTodaInformacionMenu.setLayout(new CardLayout(0, 0));
		
		panelUsuarios = new JPanel();
		panelUsuarios.setBackground(new Color(168, 255, 168));
		panelTodaInformacionMenu.add(panelUsuarios, "name_188240969463600");
		panelUsuarios.setLayout(new BorderLayout(0, 0));
		
		panelBuscarUsuarios = new JPanel();
		panelBuscarUsuarios.setOpaque(false);
		panelUsuarios.add(panelBuscarUsuarios, BorderLayout.NORTH);
		panelBuscarUsuarios.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		botonRefrescarUsuarios = new JButton("Refrescar");
		botonRefrescarUsuarios.setSelectedIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\actualizar.png"));
		botonRefrescarUsuarios.setIcon(null);
		panelBuscarUsuarios.add(botonRefrescarUsuarios);
		
		ElegirOpcionBuscarUsuarios = new JComboBox();
		ElegirOpcionBuscarUsuarios.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		ElegirOpcionBuscarUsuarios.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		ElegirOpcionBuscarUsuarios.setBorder(new EmptyBorder(0, 0, 0, 0));
		ElegirOpcionBuscarUsuarios.setBackground(new Color(255, 255, 255));
		ElegirOpcionBuscarUsuarios.setModel(new DefaultComboBoxModel(new String[] {"Email", "Nombre", "Apellidos", "Telefono", "De baja"}));
		panelBuscarUsuarios.add(ElegirOpcionBuscarUsuarios);
		
		TextoBuscarUsuarios = new JTextField();
		TextoBuscarUsuarios.setPreferredSize(new Dimension(420, 25));
		TextoBuscarUsuarios.setMinimumSize(new Dimension(220, 25));
		panelBuscarUsuarios.add(TextoBuscarUsuarios);
		TextoBuscarUsuarios.setColumns(10);
		
		BotonBuscarUsuarios = new JButton("Buscar");
		BotonBuscarUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelBuscarUsuarios.add(BotonBuscarUsuarios);
		
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setForeground(new Color(0, 255, 0));
		scrollPane.setBackground(new Color(0, 255, 0));
		scrollPane.setBorder(null);
		scrollPane.setMinimumSize(new Dimension(230, 230));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(new Color(168, 255, 168));
		panelUsuarios.add(scrollPane, BorderLayout.CENTER);
		
		panelUsuariosLeft = new JPanel();
		panelUsuariosLeft.setOpaque(false);
		panelUsuarios.add(panelUsuariosLeft, BorderLayout.WEST);
		panelUsuariosLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelUsuariosRight = new JPanel();
		panelUsuariosRight.setOpaque(false);
		panelUsuarios.add(panelUsuariosRight, BorderLayout.EAST);
		panelUsuariosRight.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelPerfil = new JPanel();
		panelPerfil.setBackground(new Color(168, 255, 168));
		panelTodaInformacionMenu.add(panelPerfil, "name_188120693022200");
		
		panelReservas = new JPanel();
		panelReservas.setBackground(new Color(168, 255, 168));
		panelTodaInformacionMenu.add(panelReservas, "name_188403985610500");
		panelReservas.setLayout(new BorderLayout(0, 0));
		
		panelBuscarReservas = new JPanel();
		panelBuscarReservas.setOpaque(false);
		panelReservas.add(panelBuscarReservas, BorderLayout.NORTH);
		panelBuscarReservas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		botonRefrescarReservas = new JButton("Refrescar");
		panelBuscarReservas.add(botonRefrescarReservas);
		
		elegirOpcionBuscarReservas = new JComboBox();
		elegirOpcionBuscarReservas.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		elegirOpcionBuscarReservas.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		elegirOpcionBuscarReservas.setBorder(new EmptyBorder(0, 0, 0, 0));
		elegirOpcionBuscarReservas.setBackground(new Color(255, 255, 255));
		elegirOpcionBuscarReservas.setModel(new DefaultComboBoxModel(new String[] {"ID Usuario", "Fecha entrada", "Fecha salida", "De baja"}));
		panelBuscarReservas.add(elegirOpcionBuscarReservas);
		
		textoBuscarReservas = new JTextField();
		textoBuscarReservas.setPreferredSize(new Dimension(420, 25));
		textoBuscarReservas.setMinimumSize(new Dimension(220, 25));
		panelBuscarReservas.add(textoBuscarReservas);
		textoBuscarReservas.setColumns(10);
		
		botonBuscarReservas = new JButton("Buscar");
		panelBuscarReservas.add(botonBuscarReservas);
		
		panelReservasLeft = new JPanel();
		panelReservasLeft.setOpaque(false);
		panelReservas.add(panelReservasLeft, BorderLayout.WEST);
		panelReservasLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelInteraccionReservas = new JPanel();
		panelInteraccionReservas.setOpaque(false);
		panelReservas.add(panelInteraccionReservas, BorderLayout.SOUTH);
		panelInteraccionReservas.setLayout(new BorderLayout(0, 0));
		
		panelCrearElimiModReservas = new JPanel();
		panelCrearElimiModReservas.setOpaque(false);
		panelInteraccionReservas.add(panelCrearElimiModReservas, BorderLayout.NORTH);
		panelCrearElimiModReservas.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 15));
		
		crearReserva = new JButton("Crear Reserva");
		crearReserva.setPreferredSize(new Dimension(125, 45));
		panelCrearElimiModReservas.add(crearReserva);
		
		modificarReserva = new JButton("Modificar Reserva");
		modificarReserva.setPreferredSize(new Dimension(145, 45));
		panelCrearElimiModReservas.add(modificarReserva);
		
		DarQuitarBajaReservas = new JButton("Dar/Quitar Baja");
		DarQuitarBajaReservas.setPreferredSize(new Dimension(145, 45));
		panelCrearElimiModReservas.add(DarQuitarBajaReservas);
		
		panelPaginadorReservas = new JPanel();
		panelPaginadorReservas.setOpaque(false);
		panelInteraccionReservas.add(panelPaginadorReservas, BorderLayout.SOUTH);
		panelPaginadorReservas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelFonfoPaginadorReservas = new JPanel();
		panelFonfoPaginadorReservas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelFonfoPaginadorReservas.setBackground(new Color(39, 160, 51));
		panelFonfoPaginadorReservas.setPreferredSize(new Dimension(550, 75));
		panelFonfoPaginadorReservas.setOpaque(true);
		panelPaginadorReservas.add(panelFonfoPaginadorReservas);
		
		dobleFlechaLeftReservas = new JLabel("");
		dobleFlechaLeftReservas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dobleFlechaLeftReservas.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\flechas-izquierda.png"));
		
		normalFlechaLeftReservas = new JLabel("");
		normalFlechaLeftReservas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		normalFlechaLeftReservas.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\flecha_izquierda_normal.png"));
		
		numeroPaginaReservas = new JTextField();
		numeroPaginaReservas.setText("1/2");
		numeroPaginaReservas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		numeroPaginaReservas.setEditable(false);
		numeroPaginaReservas.setHorizontalAlignment(SwingConstants.CENTER);
		numeroPaginaReservas.setMinimumSize(new Dimension(0, 0));
		numeroPaginaReservas.setPreferredSize(new Dimension(0, 0));
		numeroPaginaReservas.setForeground(new Color(0, 128, 0));
		numeroPaginaReservas.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 28));
		numeroPaginaReservas.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		numeroPaginaReservas.setColumns(5);
		numeroPaginaReservas.setCaretColor(Color.WHITE);
		numeroPaginaReservas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		numeroPaginaReservas.setColumns(10);
		
		normalFlechaRightReservas = new JLabel("");
		normalFlechaRightReservas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		normalFlechaRightReservas.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\flecha_derecha_normal.png"));
		
		dobleFlechaRightReservas = new JLabel("");
		dobleFlechaRightReservas.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\flechas-derecha.png"));
		dobleFlechaRightReservas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		GroupLayout gl_panelFonfoPaginadorReservas = new GroupLayout(panelFonfoPaginadorReservas);
		gl_panelFonfoPaginadorReservas.setHorizontalGroup(
			gl_panelFonfoPaginadorReservas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFonfoPaginadorReservas.createSequentialGroup()
					.addContainerGap()
					.addComponent(dobleFlechaLeftReservas)
					.addGap(18)
					.addComponent(normalFlechaLeftReservas)
					.addGap(118)
					.addComponent(numeroPaginaReservas, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
					.addGap(99)
					.addComponent(normalFlechaRightReservas)
					.addGap(18)
					.addComponent(dobleFlechaRightReservas)
					.addContainerGap())
		);
		gl_panelFonfoPaginadorReservas.setVerticalGroup(
			gl_panelFonfoPaginadorReservas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFonfoPaginadorReservas.createSequentialGroup()
					.addGroup(gl_panelFonfoPaginadorReservas.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelFonfoPaginadorReservas.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelFonfoPaginadorReservas.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(normalFlechaLeftReservas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(dobleFlechaLeftReservas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(dobleFlechaRightReservas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(normalFlechaRightReservas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panelFonfoPaginadorReservas.createSequentialGroup()
							.addGap(19)
							.addComponent(numeroPaginaReservas, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(25))
		);
		panelFonfoPaginadorReservas.setLayout(gl_panelFonfoPaginadorReservas);
		
		panelReservasRight = new JPanel();
		panelReservasRight.setOpaque(false);
		panelReservas.add(panelReservasRight, BorderLayout.EAST);
		panelReservasRight.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		scrollPaneReservas = new JScrollPane();
		scrollPaneReservas.setOpaque(false);
		scrollPaneReservas.setForeground(new Color(0, 255, 0));
		scrollPaneReservas.setBackground(new Color(0, 255, 0));
		scrollPaneReservas.setBorder(null);
		scrollPaneReservas.setMinimumSize(new Dimension(230, 230));
		scrollPaneReservas.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneReservas.getViewport().setBackground(new Color(168, 255, 168));
		panelReservas.add(scrollPaneReservas, BorderLayout.CENTER);
		
		panelHabitaciones = new JPanel();
		panelHabitaciones.setBackground(new Color(168, 255, 168));
		panelTodaInformacionMenu.add(panelHabitaciones, "name_188466359769000");
		
		menuPrincipalController=new MenuPrincipalController(this);
		userController=new UserController(this);
		reservasController=new ReservasController(this);
		BotonBuscarUsuarios.setActionCommand("buscarUsuarios");
		
		panelInteraccionUsuarios = new JPanel();
		panelInteraccionUsuarios.setOpaque(false);
		panelUsuarios.add(panelInteraccionUsuarios, BorderLayout.SOUTH);
		panelInteraccionUsuarios.setLayout(new BorderLayout(0, 0));
		
		panelCrearElimiModUsuarios = new JPanel();
		panelCrearElimiModUsuarios.setOpaque(false);
		panelInteraccionUsuarios.add(panelCrearElimiModUsuarios, BorderLayout.NORTH);
		panelCrearElimiModUsuarios.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 15));
		
		crearUsuario = new JButton("Crear Usuario");
		crearUsuario.setPreferredSize(new Dimension(125, 45));
		panelCrearElimiModUsuarios.add(crearUsuario);
		
		modificarUsuario = new JButton("Modificar Usuario");
		modificarUsuario.setPreferredSize(new Dimension(145, 45));
		panelCrearElimiModUsuarios.add(modificarUsuario);
		
		DarQuitarBajaUsuario = new JButton("Dar/Quitar baja");
		DarQuitarBajaUsuario.setPreferredSize(new Dimension(145, 45));
		panelCrearElimiModUsuarios.add(DarQuitarBajaUsuario);
		
		panelPaginadorUsuarios = new JPanel();
		panelPaginadorUsuarios.setOpaque(false);
		panelInteraccionUsuarios.add(panelPaginadorUsuarios, BorderLayout.SOUTH);
		panelPaginadorUsuarios.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelFondoPaginador = new JPanel();
		panelFondoPaginador.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelFondoPaginador.setBackground(new Color(39, 160, 51));
		panelFondoPaginador.setPreferredSize(new Dimension(550, 75));
		panelPaginadorUsuarios.add(panelFondoPaginador);
		
		dobleFlechaLeft = new JLabel("");
		dobleFlechaLeft.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dobleFlechaLeft.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\flechas-izquierda.png"));
		
		normalFlechaLeft = new JLabel("");
		normalFlechaLeft.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		normalFlechaLeft.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\flecha_izquierda_normal.png"));
		
		dobleFlechaRight = new JLabel("");
		dobleFlechaRight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dobleFlechaRight.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\flechas-derecha.png"));
		
		normalFlechaRight = new JLabel("");
		normalFlechaRight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		normalFlechaRight.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\flecha_derecha_normal.png"));
		
		NumeroPagina = new JTextField();
		NumeroPagina.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		NumeroPagina.setEditable(false);
		NumeroPagina.setHorizontalAlignment(SwingConstants.CENTER);
		NumeroPagina.setMinimumSize(new Dimension(0, 0));
		NumeroPagina.setPreferredSize(new Dimension(0, 0));
		NumeroPagina.setForeground(new Color(0, 128, 0));
		NumeroPagina.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 28));
		NumeroPagina.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		NumeroPagina.setColumns(5);
		NumeroPagina.setCaretColor(Color.WHITE);
		NumeroPagina.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_panelFondoPaginador = new GroupLayout(panelFondoPaginador);
		gl_panelFondoPaginador.setHorizontalGroup(
			gl_panelFondoPaginador.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFondoPaginador.createSequentialGroup()
					.addContainerGap()
					.addComponent(dobleFlechaLeft)
					.addGap(18)
					.addComponent(normalFlechaLeft, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(118)
					.addComponent(NumeroPagina, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
					.addGap(99)
					.addComponent(normalFlechaRight, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(dobleFlechaRight, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelFondoPaginador.setVerticalGroup(
			gl_panelFondoPaginador.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelFondoPaginador.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelFondoPaginador.createParallelGroup(Alignment.LEADING)
						.addComponent(normalFlechaRight, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(dobleFlechaRight, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(normalFlechaLeft, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(dobleFlechaLeft))
					.addGap(13))
				.addGroup(gl_panelFondoPaginador.createSequentialGroup()
					.addGap(19)
					.addComponent(NumeroPagina, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(25))
		);
		
		
		panelFondoPaginador.setLayout(gl_panelFondoPaginador);
		
		
		
		
		
		BotonBuscarUsuarios.addActionListener(userController);
		Menu.addMouseListener(menuPrincipalController);
		fotoHabitacionesMenu.addMouseListener(menuPrincipalController);
		fotoPerfilMenu.addMouseListener(menuPrincipalController);
		fotoReservasMenu.addMouseListener(menuPrincipalController);
		fotoUsuariosMenu.addMouseListener(menuPrincipalController);
		fotoCerrarSesion.addMouseListener(menuPrincipalController);
		textoHabitacionesMenu.addMouseListener(menuPrincipalController);
		textoPerfilMenu.addMouseListener(menuPrincipalController);
		textoReservasMenu.addMouseListener(menuPrincipalController);
		textoUsuariosMenu.addMouseListener(menuPrincipalController);
		textoCerrarSesion.addMouseListener(menuPrincipalController);
		dobleFlechaLeft.addMouseListener(userController);
		dobleFlechaRight.addMouseListener(userController);
		normalFlechaLeft.addMouseListener(userController);
		normalFlechaRight.addMouseListener(userController);
		crearUsuario.setActionCommand("crearUsuario");
		modificarUsuario.setActionCommand("modificarUsuario");
		DarQuitarBajaUsuario.setActionCommand("DarQuitarBajaUsuario");
		botonRefrescarUsuarios.setActionCommand("refrescarUsuarios");
		botonBuscarReservas.setActionCommand("buscarReservas");
		botonRefrescarReservas.setActionCommand("refrescarReservas");
		crearReserva.setActionCommand("crearReserva");
		modificarReserva.setActionCommand("modificarReserva");
		DarQuitarBajaReservas.setActionCommand("DarQuitarBajaReserva");
		crearUsuario.addActionListener(userController);
		modificarUsuario.addActionListener(userController);
		DarQuitarBajaUsuario.addActionListener(userController);
		botonRefrescarUsuarios.addActionListener(userController);
		botonBuscarReservas.addActionListener(reservasController);
		botonRefrescarReservas.addActionListener(reservasController);
		dobleFlechaLeftReservas.addMouseListener(reservasController);
		dobleFlechaRightReservas.addMouseListener(reservasController);
		normalFlechaLeftReservas.addMouseListener(reservasController);
		normalFlechaRightReservas.addMouseListener(reservasController);
		crearReserva.addActionListener(reservasController);
		modificarReserva.addActionListener(reservasController);
		DarQuitarBajaReservas.addActionListener(reservasController);
		
		construirTabla();
		construirTablaReservas();
	}

	public JFrame getFrmJungleDreams() {
		return frmJungleDreams;
	}

	public void setFrmJungleDreams(JFrame frmJungleDreams) {
		this.frmJungleDreams = frmJungleDreams;
	}

	public JButton getCrearUsuario() {
		return crearUsuario;
	}

	public void setCrearUsuario(JButton crearUsuario) {
		this.crearUsuario = crearUsuario;
	}

	public JButton getModificarUsuario() {
		return modificarUsuario;
	}

	public void setModificarUsuario(JButton modificarUsuario) {
		this.modificarUsuario = modificarUsuario;
	}

	public JButton getEliminarUsuario() {
		return DarQuitarBajaUsuario;
	}

	public void setEliminarUsuario(JButton eliminarUsuario) {
		this.DarQuitarBajaUsuario = eliminarUsuario;
	}

	public JTextField getTxtPerfil() {
		return textoPerfilMenu;
	}

	public void setTxtPerfil(JTextField txtPerfil) {
		this.textoPerfilMenu = txtPerfil;
	}

	public JPanel getPanelToolBar() {
		return panelToolBar;
	}

	public void setPanelToolBar(JPanel panelToolBar) {
		this.panelToolBar = panelToolBar;
	}

	public JLabel getMenu() {
		return Menu;
	}

	public void setMenu(JLabel menu) {
		Menu = menu;
	}

	public JLabel getMasInfo() {
		return masInfo;
	}

	public void setMasInfo(JLabel masInfo) {
		this.masInfo = masInfo;
	}


	public JLabel getHotelLogoMenu() {
		return hotelLogoMenu;
	}

	public void setHotelLogoMenu(JLabel hotelLogoMenu) {
		this.hotelLogoMenu = hotelLogoMenu;
	}

	public JPanel getPanelMenu() {
		return panelMenu;
	}

	public void setPanelMenu(JPanel panelMenu) {
		this.panelMenu = panelMenu;
	}

	public JLabel getLabelPerfil() {
		return fotoPerfilMenu;
	}

	public void setLabelPerfil(JLabel labelPerfil) {
		this.fotoPerfilMenu = labelPerfil;
	}

	public JTextField getTextoPerfilMenu() {
		return textoPerfilMenu;
	}

	public void setTextoPerfilMenu(JTextField textoPerfilMenu) {
		this.textoPerfilMenu = textoPerfilMenu;
	}

	public JTextField getTextoUsuariosMenu() {
		return textoUsuariosMenu;
	}

	public void setTextoUsuariosMenu(JTextField textoUsuariosMenu) {
		this.textoUsuariosMenu = textoUsuariosMenu;
	}

	public JTextField getTextoReservasMenu() {
		return textoReservasMenu;
	}

	public void setTextoReservasMenu(JTextField textoReservasMenu) {
		this.textoReservasMenu = textoReservasMenu;
	}

	public JTextField getTextoHabitacionesMenu() {
		return textoHabitacionesMenu;
	}

	public void setTextoHabitacionesMenu(JTextField textoHabitacionesMenu) {
		this.textoHabitacionesMenu = textoHabitacionesMenu;
	}

	public JLabel getFotoUsuariosMenu() {
		return fotoUsuariosMenu;
	}

	public void setFotoUsuariosMenu(JLabel fotoUsuariosMenu) {
		this.fotoUsuariosMenu = fotoUsuariosMenu;
	}

	public JLabel getFotoReservasMenu() {
		return fotoReservasMenu;
	}

	public void setFotoReservasMenu(JLabel fotoReservasMenu) {
		this.fotoReservasMenu = fotoReservasMenu;
	}

	public JLabel getFotoPerfilMenu() {
		return fotoPerfilMenu;
	}

	public void setFotoPerfilMenu(JLabel fotoPerfilMenu) {
		this.fotoPerfilMenu = fotoPerfilMenu;
	}

	public JLabel getFotoHabitacionesMenu() {
		return fotoHabitacionesMenu;
	}

	public void setFotoHabitacionesMenu(JLabel fotoHabitacionesMenu) {
		this.fotoHabitacionesMenu = fotoHabitacionesMenu;
	}

	public JPanel getPanelTodaInformacionMenu() {
		return panelTodaInformacionMenu;
	}

	public void setPanelTodaInformacionMenu(JPanel panelTodaInformacionMenu) {
		this.panelTodaInformacionMenu = panelTodaInformacionMenu;
	}

	public JPanel getPanelUsuarios() {
		return panelUsuarios;
	}

	public void setPanelUsuarios(JPanel panelUsuarios) {
		this.panelUsuarios = panelUsuarios;
	}

	public JPanel getPanelPerfil() {
		return panelPerfil;
	}

	public void setPanelPerfil(JPanel panelPerfil) {
		this.panelPerfil = panelPerfil;
	}

	public JPanel getPanelReservas() {
		return panelReservas;
	}

	public void setPanelReservas(JPanel panelReservas) {
		this.panelReservas = panelReservas;
	}

	public JPanel getPanelHabitaciones() {
		return panelHabitaciones;
	}

	public void setPanelHabitaciones(JPanel panelHabitaciones) {
		this.panelHabitaciones = panelHabitaciones;
	}

	public JPanel getPanelToolBarLeft() {
		return panelToolBarLeft;
	}

	public void setPanelToolBarLeft(JPanel panelToolBarLeft) {
		this.panelToolBarLeft = panelToolBarLeft;
	}

	public JPanel getPanelToolBarRight() {
		return panelToolBarRight;
	}

	public void setPanelToolBarRight(JPanel panelToolBarRight) {
		this.panelToolBarRight = panelToolBarRight;
	}

	public JPanel getPanelToolBarCenter() {
		return panelToolBarCenter;
	}

	public void setPanelToolBarCenter(JPanel panelToolBarCenter) {
		this.panelToolBarCenter = panelToolBarCenter;
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

	public MenuPrincipalController getMenuPrincipalController() {
		return menuPrincipalController;
	}

	public void setMenuPrincipalController(MenuPrincipalController menuPrincipalController) {
		this.menuPrincipalController = menuPrincipalController;
	}
	
	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public JTextField getTextoBuscarUsuarios() {
		return TextoBuscarUsuarios;
	}

	public void setTextoBuscarUsuarios(JTextField textoBuscarUsuarios) {
		TextoBuscarUsuarios = textoBuscarUsuarios;
	}

	public JTextField getTextoCerrarSesion() {
		return textoCerrarSesion;
	}

	public void setTextoCerrarSesion(JTextField textoCerrarSesion) {
		this.textoCerrarSesion = textoCerrarSesion;
	}

	public JLabel getFotoCerrarSesion() {
		return fotoCerrarSesion;
	}

	public void setFotoCerrarSesion(JLabel fotoCerrarSesion) {
		this.fotoCerrarSesion = fotoCerrarSesion;
	}

	public JPanel getPanelBuscarUsuarios() {
		return panelBuscarUsuarios;
	}

	public void setPanelBuscarUsuarios(JPanel panelBuscarUsuarios) {
		this.panelBuscarUsuarios = panelBuscarUsuarios;
	}

	public JComboBox getElegirOpcionBuscarUsuarios() {
		return ElegirOpcionBuscarUsuarios;
	}

	public void setElegirOpcionBuscarUsuarios(JComboBox elegirOpcionBuscarUsuarios) {
		ElegirOpcionBuscarUsuarios = elegirOpcionBuscarUsuarios;
	}

	public JButton getBotonBuscarUsuarios() {
		return BotonBuscarUsuarios;
	}

	public void setBotonBuscarUsuarios(JButton botonBuscarUsuarios) {
		BotonBuscarUsuarios = botonBuscarUsuarios;
	}

	public JPanel getPanelPaginadorUsuarios() {
		return panelInteraccionUsuarios;
	}

	public void setPanelPaginadorUsuarios(JPanel panelPaginadorUsuarios) {
		this.panelInteraccionUsuarios = panelPaginadorUsuarios;
	}

	public JPanel getPanelUsuariosLeft() {
		return panelUsuariosLeft;
	}

	public void setPanelUsuariosLeft(JPanel panelUsuariosLeft) {
		this.panelUsuariosLeft = panelUsuariosLeft;
	}

	public JPanel getPanelUsuariosRight() {
		return panelUsuariosRight;
	}

	public void setPanelUsuariosRight(JPanel panelUsuariosRight) {
		this.panelUsuariosRight = panelUsuariosRight;
	}

	public JPanel getPanelInteraccionUsuarios() {
		return panelInteraccionUsuarios;
	}

	public void setPanelInteraccionUsuarios(JPanel panelInteraccionUsuarios) {
		this.panelInteraccionUsuarios = panelInteraccionUsuarios;
	}

	public JPanel getPanelCrearElimiModUsuarios() {
		return panelCrearElimiModUsuarios;
	}

	public void setPanelCrearElimiModUsuarios(JPanel panelCrearElimiModUsuarios) {
		this.panelCrearElimiModUsuarios = panelCrearElimiModUsuarios;
	}

	public JPanel getPanelFondoPaginador() {
		return panelFondoPaginador;
	}

	public void setPanelFondoPaginador(JPanel panelFondoPaginador) {
		this.panelFondoPaginador = panelFondoPaginador;
	}

	public JLabel getDobleFlechaLeft() {
		return dobleFlechaLeft;
	}

	public void setDobleFlechaLeft(JLabel dobleFlechaLeft) {
		this.dobleFlechaLeft = dobleFlechaLeft;
	}

	public JLabel getNormalFlechaLeft() {
		return normalFlechaLeft;
	}

	public void setNormalFlechaLeft(JLabel normalFlechaLeft) {
		this.normalFlechaLeft = normalFlechaLeft;
	}

	public JTextField getNumeroPagina() {
		return NumeroPagina;
	}

	public void setNumeroPagina(JTextField numeroPagina) {
		NumeroPagina = numeroPagina;
	}

	public JLabel getDobleFlechaRight() {
		return dobleFlechaRight;
	}

	public void setDobleFlechaRight(JLabel dobleFlechaRight) {
		this.dobleFlechaRight = dobleFlechaRight;
	}

	public JLabel getNormalFlechaRight() {
		return normalFlechaRight;
	}

	public void setNormalFlechaRight(JLabel normalFlechaRight) {
		this.normalFlechaRight = normalFlechaRight;
	}

	public ReservasController getReservasController() {
		return reservasController;
	}

	public void setReservasController(ReservasController reservasController) {
		this.reservasController = reservasController;
	}

	public JButton getDarQuitarBajaUsuario() {
		return DarQuitarBajaUsuario;
	}

	public void setDarQuitarBajaUsuario(JButton darQuitarBajaUsuario) {
		DarQuitarBajaUsuario = darQuitarBajaUsuario;
	}

	public JPanel getPanelBuscarReservas() {
		return panelBuscarReservas;
	}

	public void setPanelBuscarReservas(JPanel panelBuscarReservas) {
		this.panelBuscarReservas = panelBuscarReservas;
	}

	public JPanel getPanelReservasLeft() {
		return panelReservasLeft;
	}

	public void setPanelReservasLeft(JPanel panelReservasLeft) {
		this.panelReservasLeft = panelReservasLeft;
	}

	public JPanel getPanelInteraccionReservas() {
		return panelInteraccionReservas;
	}

	public void setPanelInteraccionReservas(JPanel panelInteraccionReservas) {
		this.panelInteraccionReservas = panelInteraccionReservas;
	}

	public JPanel getPanelReservasRight() {
		return panelReservasRight;
	}

	public void setPanelReservasRight(JPanel panelReservasRight) {
		this.panelReservasRight = panelReservasRight;
	}

	public JButton getBotonRefrescarUsuarios() {
		return botonRefrescarUsuarios;
	}

	public void setBotonRefrescarUsuarios(JButton botonRefrescarUsuarios) {
		this.botonRefrescarUsuarios = botonRefrescarUsuarios;
	}

	public JScrollPane getScrollPaneReservas() {
		return scrollPaneReservas;
	}

	public void setScrollPaneReservas(JScrollPane scrollPaneReservas) {
		this.scrollPaneReservas = scrollPaneReservas;
	}

	public JTable getTableReservas() {
		return tableReservas;
	}

	public void setTableReservas(JTable tableReservas) {
		this.tableReservas = tableReservas;
	}

	public JButton getBotonRefrescarReservas() {
		return botonRefrescarReservas;
	}

	public void setBotonRefrescarReservas(JButton botonRefrescarReservas) {
		this.botonRefrescarReservas = botonRefrescarReservas;
	}

	public JTextField getTextoBuscarReservas() {
		return textoBuscarReservas;
	}

	public void setTextoBuscarReservas(JTextField textoBuscarReservas) {
		this.textoBuscarReservas = textoBuscarReservas;
	}

	public JComboBox getElegirOpcionBuscarReservas() {
		return elegirOpcionBuscarReservas;
	}

	public void setElegirOpcionBuscarReservas(JComboBox elegirOpcionBuscarReservas) {
		this.elegirOpcionBuscarReservas = elegirOpcionBuscarReservas;
	}

	public JButton getBotonBuscarReservas() {
		return botonBuscarReservas;
	}

	public void setBotonBuscarReservas(JButton botonBuscarReservas) {
		this.botonBuscarReservas = botonBuscarReservas;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public JPanel getPanelCrearElimiModReservas() {
		return panelCrearElimiModReservas;
	}

	public void setPanelCrearElimiModReservas(JPanel panelCrearElimiModReservas) {
		this.panelCrearElimiModReservas = panelCrearElimiModReservas;
	}

	public JPanel getPanelPaginadorReservas() {
		return panelPaginadorReservas;
	}

	public void setPanelPaginadorReservas(JPanel panelPaginadorReservas) {
		this.panelPaginadorReservas = panelPaginadorReservas;
	}

	public JPanel getPanelFonfoPaginadorReservas() {
		return panelFonfoPaginadorReservas;
	}

	public void setPanelFonfoPaginadorReservas(JPanel panelFonfoPaginadorReservas) {
		this.panelFonfoPaginadorReservas = panelFonfoPaginadorReservas;
	}

	public JLabel getDobleFlechaLeftReservas() {
		return dobleFlechaLeftReservas;
	}

	public void setDobleFlechaLeftReservas(JLabel dobleFlechaLeftReservas) {
		this.dobleFlechaLeftReservas = dobleFlechaLeftReservas;
	}

	public JLabel getNormalFlechaLeftReservas() {
		return normalFlechaLeftReservas;
	}

	public void setNormalFlechaLeftReservas(JLabel normalFlechaLeftReservas) {
		this.normalFlechaLeftReservas = normalFlechaLeftReservas;
	}

	public JTextField getNumeroPaginaReservas() {
		return numeroPaginaReservas;
	}

	public void setNumeroPaginaReservas(JTextField numeroPaginaReservas) {
		this.numeroPaginaReservas = numeroPaginaReservas;
	}

	public JLabel getNormalFlechaRightReservas() {
		return normalFlechaRightReservas;
	}

	public void setNormalFlechaRightReservas(JLabel normalFlechaRightReservas) {
		this.normalFlechaRightReservas = normalFlechaRightReservas;
	}

	public JLabel getDobleFlechaRightReservas() {
		return dobleFlechaRightReservas;
	}

	public void setDobleFlechaRightReservas(JLabel dobleFlechaRightReservas) {
		this.dobleFlechaRightReservas = dobleFlechaRightReservas;
	}

	public void construirTabla() {
		String titulos[]={"Email","Password","Token","Fecha de validez del token","Nombre","Apellidos","Teléfono","Fecha de baja","Fecha de creación","Fecha de modificación"};
		String informacion[][]=userController.obtenerMatriz();
		
		table = new JTable(informacion,titulos);
		table.setDefaultEditor(Object.class, null);
		table.setSelectionBackground(new Color(196, 245, 141));
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setBorder(null);
		table.setBackground(new Color(255, 255, 255));
		table.setOpaque(false);
		NumeroPagina.setText(userController.ponerPaginas());
		scrollPane.setViewportView(table);
	}
	
	public void construirTablaReservas() {
		String titulos[]={"ID","Fecha","Fecha de entrada","Fecha de salida","Numero de adultos","Numero de niños","Usuario","Fecha de baja","Fecha de creación","Fecha de modificación"};
		String informacion[][]=reservasController.obtenerMatriz();
		
		tableReservas = new JTable(informacion,titulos);
		tableReservas.setDefaultEditor(Object.class, null);
		tableReservas.setSelectionBackground(new Color(196, 245, 141));
		tableReservas.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		tableReservas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tableReservas.setBorder(null);
		tableReservas.setBackground(new Color(255, 255, 255));
		tableReservas.setOpaque(false);
		tableReservas.addMouseListener(reservasController);
		numeroPaginaReservas.setText(reservasController.ponerPaginas());
		scrollPaneReservas.setViewportView(tableReservas);
	}
}