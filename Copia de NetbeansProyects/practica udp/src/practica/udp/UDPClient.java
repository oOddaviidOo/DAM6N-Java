
//UDPClient.java: A simple UDP client program.
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class UDPClient {

    public static void main(String args[]) {
        Scanner t = new Scanner(System.in);
        //args recibe mensaje host destino y puerto

        DatagramSocket aSocket = null; //declaro DatagramSocket
        System.out.println("Introduce mensaje");
        String mensaje = t.nextLine();
        System.out.println("Introduce host name");
        String hostname = t.nextLine();
        System.out.println("Introduce puerto");
        int puerto = t.nextInt();
        //control entrada argumentos
//	if (args.length < 3) {
//			System.out.println("Uso: java UDPClient <message> <Host name> <Port number>");
//			System.exit(1);
//		}

        try {

            //proceso envio datagrama 
            aSocket = new DatagramSocket(); //creo datagrama
            byte[] m = mensaje.getBytes(); //matriz de bytes
            InetAddress aHost = InetAddress.getByName(hostname); //recupero host de argumento

            int serverPort = puerto; //recupero puerto de argumento
            // int value devuelve valor tipo int

            DatagramPacket request = new DatagramPacket(m, mensaje.length(), aHost, serverPort); //datagrama a enviar

            aSocket.send(request); //envio datagrama

            //proceso recepci�n datagrama 
            byte[] buffer = new byte[1000]; //declaro matriz bytesmatriz de bytes
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length); // declaro datagrama respuesta
            aSocket.receive(reply); //recibo datagrama
            System.out.println("Reply: " + new String(reply.getData())); //muestro respuesta
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }
}
