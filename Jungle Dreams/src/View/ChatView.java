package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ChatView {

	private JFrame frmJungleDreams;
	private JPanel panelFondoChat;
	private JTextField EnviarTextoChat;
	private JPanel panelEscribirChat;
	private JLabel EnviarBotonChat;
	private JPanel panelVerMensajeChat;

	/**
	 * Create the application.
	 */
	public ChatView() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frmJungleDreams = new JFrame();
		frmJungleDreams.setVisible(true);
		frmJungleDreams.setTitle("CHAT JUNGLE DREAMS");
		frmJungleDreams.setVisible(true);
		frmJungleDreams.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\J.PNG"));
		frmJungleDreams.setBounds(100, 100, 550, 403);
		frmJungleDreams.setResizable(false);
		frmJungleDreams.getContentPane().setLayout(null);
		frmJungleDreams.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panelFondoChat = new JPanel();
		panelFondoChat.setBounds(0, 0, 536, 366);
		panelFondoChat.setBackground(new Color(168, 255, 168));
		frmJungleDreams.getContentPane().add(panelFondoChat);
		panelFondoChat.setLayout(null);
		
		panelEscribirChat = new JPanel();
		panelEscribirChat.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEscribirChat.setBackground(new Color(255, 255, 255));
		panelEscribirChat.setBounds(10, 301, 516, 55);
		panelFondoChat.add(panelEscribirChat);
		panelEscribirChat.setLayout(null);
		
		EnviarTextoChat = new JTextField();
		EnviarTextoChat.setBounds(6, 6, 445, 42);
		EnviarTextoChat.setPreferredSize(new Dimension(200, 42));
		panelEscribirChat.add(EnviarTextoChat);
		EnviarTextoChat.setColumns(10);
		
		EnviarBotonChat = new JLabel("");
		EnviarBotonChat.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\enviar-mensaje.png"));
		EnviarBotonChat.setPreferredSize(new Dimension(42, 42));
		EnviarBotonChat.setBounds(461, 6, 45, 42);
		panelEscribirChat.add(EnviarBotonChat);
		
		panelVerMensajeChat = new JPanel();
		panelVerMensajeChat.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelVerMensajeChat.setBackground(new Color(255, 255, 255));
		panelVerMensajeChat.setBounds(10, 10, 516, 281);
		panelFondoChat.add(panelVerMensajeChat);
	}
}
