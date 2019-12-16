

//UDPServer.java: A simple UDP server program.
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class UDPServer {
	public static void main(String args[]){
		Scanner t=new Scanner(System.in);
		DatagramSocket aSocket = null; //creo objeto DatagramSocket
		          System.out.println("Introduce el Puerto");
                          int puerto=t.nextInt();
		if (puerto<=0) { //se debe introducir puerto como argumento
		System.out.println("Introduce un puerto correcto");
		System.exit(1);
		}

		try {
			int socket_no = puerto; //gurdo num puerto
			aSocket = new DatagramSocket(socket_no); //creo DatagramSocket 
			byte[] buffer = new byte[1000]; //matriz de bytes
		
		while(true) {
			DatagramPacket request = new DatagramPacket(buffer, buffer.length); //declaro datagrama request 
			aSocket.receive(request); //construyo datagrama a recibir
			System.out.println("Recibo cliente: " + new String(request.getData())); //muestro cadena recibo
			
			DatagramPacket reply = new DatagramPacket(request.getData(),request.getLength(),request.getAddress(),
			request.getPort());  //construyo datagrama a enviar
			aSocket.send(reply); //envio datagrama a request.getAddress() y al puerto request.getPort() (del que he recibido)
				//envio el mismo mensaje que recibo
					}
		}
		catch (SocketException e) { //captura excepcion
		System.out.println("Socket: " + e.getMessage()); 
		}
		catch (IOException e) { //captura excepcion
		System.out.println("IO: " + e.getMessage());
		}
		finally {
			if (aSocket != null) //si el socket existe
		aSocket.close(); //cierro
		}
		}
	}
