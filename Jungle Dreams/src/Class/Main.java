package Class;

import java.awt.EventQueue;

import javax.swing.JFrame;

import View.Login;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window=new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
