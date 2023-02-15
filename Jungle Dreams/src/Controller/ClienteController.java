package Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteController {
	private Socket socket;
	private DataInputStream bufferDeEntrada;
	private DataOutputStream bufferDeSalida;
	Scanner sc=new Scanner(System.in);
	String COMANDO="";
	
	public ClienteController() {}
	
	public void levantarConexion(String ip, int puerto) {
		try {
			socket= new Socket(ip, puerto);
			System.out.println("Conectado a :" + socket.getInetAddress().getHostName());
		} catch (IOException e) {
			System.err.println("Error en levantarConexión(): "+e.getMessage());
			System.exit(0);

		}
	}
	public void flujos() {
		try {
			bufferDeEntrada=new DataInputStream(socket.getInputStream());
			bufferDeSalida=new DataOutputStream(socket.getOutputStream());
			bufferDeSalida.flush();
		} catch (IOException e) {
			System.err.println("Error en la apertura de flujos");
		}
	}
	public void recibirDatos() {
		String st="";
		try {
			st=(String)bufferDeEntrada.readUTF();
			System.out.println("\n[Servidor] => "+st);
		} catch (IOException e) {
			cerrarConexion();
		}
	}
	
	public void enviar(String s) {
		try {
			bufferDeSalida.writeUTF(s);
			bufferDeSalida.flush();
		} catch (IOException e) {
			System.err.println("Error en enviar(): "+e.getMessage());
		}
	}
	
	public void escribirDatos() {
		String entrada="";
		while(true) {
			System.out.println("[Cliente] => ");
			entrada=sc.nextLine();
			if(entrada.length()>0) {
				enviar(entrada);
			}
		}
	}
	
	public void cerrarConexion() {
		try {
			bufferDeEntrada.close();
			bufferDeSalida.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Conversación finalizada...");
			System.exit(0);
		}
		
	}
	public void ejecutarConexion(String ip, int puerto) {
		Thread hilo=new Thread(new Runnable() {
		@Override
		public void run() {
			while(true) {
				try {
					levantarConexion(ip, puerto);
					flujos();
					recibirDatos();
				}finally {
					cerrarConexion();
				}
			}
			
		}
			
		});
		hilo.start();
	}
	public void iniciarCliente() throws IOException {
        ejecutarConexion("localhost", 5050);
        escribirDatos();
    }
}
