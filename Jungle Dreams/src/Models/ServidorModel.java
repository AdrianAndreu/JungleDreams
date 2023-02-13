package Models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorModel {
	private Socket socket;
	private ServerSocket serverSocket;
	private DataInputStream bufferDeEntrada;
	private DataOutputStream bufferDeSalida;
	private String respuesta;

	String COMANDO_TERMINACION = "salir";
	
	public void levantarConexion(int puerto) {
		try {
			serverSocket= new ServerSocket(puerto);
			System.out.println("Esperando conexi�n entrante en el puerto "+puerto+"...");
			socket = serverSocket.accept();
			System.out.println("Conexi�n establecida con: "+socket.getInetAddress().getHostName()+"\n\n\n");
		} catch (IOException e) {
			System.err.println("Error en levantarConexi�n(): "+e.getMessage());
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
			do {
				st=(String)bufferDeEntrada.readUTF();
				System.out.println("\n[Cliente] => "+st);
				
			}while(!st.equals(COMANDO_TERMINACION));
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
		while(true) {
			System.out.println("[Servidor] => ");
			enviar(respuesta);
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
			System.out.println("Conversaci�n finalizada...");
			System.exit(0);
		}
	}
	public void ejecutarConexion(int puerto) {
		Thread hilo=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						levantarConexion(puerto);
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
	
	public void iniciarServidor() {
		ejecutarConexion(5050);
		escribirDatos();
	}
}
