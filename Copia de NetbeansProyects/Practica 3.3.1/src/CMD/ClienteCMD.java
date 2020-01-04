package CMD;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class ClienteCMD {

    //nombre  máquina y puerto
    public boolean adios = false;
    public final String HOST = "localhost";
    public final int PUERTO = 5000;
    public int inout=0;
    String ensa="", salir;
    String esc = "";
    Scanner t = new Scanner(System.in);
    Scanner t2 = new Scanner(System.in);
    Scanner t3 = new Scanner(System.in);

    public ClienteCMD() {
        try {

            //se crea el socket
            Socket skCliente = new Socket(HOST, PUERTO);

            while (!adios) {
                System.out.println("1.  ENTRADA");
                System.out.println("2.  SALIDA");
                inout=t.nextInt();
                if (inout==1) {
                    ensa="Entrada";
                }
                if (inout==2) {
                    ensa="Salida";
                }
                esc = t2.nextLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	       LocalDateTime now = LocalDateTime.now();
               
               esc="Numero empleado: "+esc+" ."+ensa+" "+dtf.format(now); 
                //asocio flujo salida de datos al socket
                OutputStream auxo = skCliente.getOutputStream();
                //asocio flujo de datos flujo de tipo DataOutputStream 
                DataOutputStream flujoo = new DataOutputStream(auxo);
                //escribo

                flujoo.writeUTF(esc);
                System.out.println("Salir? s/n");
                salir=t.next();
                if (salir.equals("s")) {
                    adios=true;
                }
                
            }
            //Cierro el socket
            skCliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        ClienteCMD cliente1 = new ClienteCMD();
    }
}
