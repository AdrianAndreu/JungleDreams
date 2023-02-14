package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Label;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Controller.UserController;
import Models.UserModel;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Point;

public class Login {

	private JFrame frmJungleDreams;
	private final JLabel jLabel = new JLabel("");
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField email;
	private JPasswordField password;
	
	public Login(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frmJungleDreams = new JFrame();
		frmJungleDreams.setLocation(new Point(20, 5));
		frmJungleDreams.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\J.PNG"));
		frmJungleDreams.setTitle("JUNGLE DREAMS");
		frmJungleDreams.setBounds(200, 200, 900, 600);
		frmJungleDreams.setResizable(false);
		frmJungleDreams.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJungleDreams.getContentPane().setLayout(null);
		
		JButton BLogin = new JButton("Entrar");
		BLogin.setForeground(new Color(255, 255, 255));
		BLogin.setBackground(new Color(117, 225, 128));
		
		
		password = new JPasswordField();
		password.setBorder(null);
		password.setOpaque(false);
		password.setText("");
		password.setBounds(393, 311, 186, 52);
		frmJungleDreams.getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\contrasena.png"));
		lblNewLabel_4.setBounds(332, 311, 56, 52);
		frmJungleDreams.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\usuario.png"));
		lblNewLabel_3.setBounds(332, 219, 56, 52);
		frmJungleDreams.getContentPane().add(lblNewLabel_3);
		
		email = new JTextField();
		email.setBorder(null);
		email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email.setToolTipText("");
		email.setOpaque(false);
		email.setBounds(393, 219, 186, 52);
		email.setText("");
		frmJungleDreams.getContentPane().add(email);
		email.setColumns(10);
		BLogin.setBounds(333, 414, 246, 37);
		frmJungleDreams.getContentPane().add(BLogin);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(332, 311, 247, 52);
		frmJungleDreams.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(332, 219, 247, 52);
		frmJungleDreams.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\Hotel.PNG"));
		lblNewLabel.setBounds(242, 10, 400, 135);
		frmJungleDreams.getContentPane().add(lblNewLabel);
		jLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Proyecto Jungle Dreams\\Java\\foto_login.png"));
		jLabel.setBounds(0, 0, 900, 600);
		frmJungleDreams.getContentPane().add(jLabel);
		frmJungleDreams.setVisible(true);
		
		UserController userController=new UserController(email,password,frmJungleDreams);
		BLogin.setActionCommand("login");
		BLogin.addActionListener(userController);
		
		
	}

	public JFrame getFrmJungleDreams() {
		return frmJungleDreams;
	}

	public void setFrmJungleDreams(JFrame frmJungleDreams) {
		this.frmJungleDreams = frmJungleDreams;
	}

	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		this.lblNewLabel_1 = lblNewLabel_1;
	}

	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	public void setLblNewLabel_2(JLabel lblNewLabel_2) {
		this.lblNewLabel_2 = lblNewLabel_2;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JLabel getjLabel() {
		return jLabel;
	}
	
}
