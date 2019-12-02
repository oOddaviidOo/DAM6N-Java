/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAM 6N
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

class Cliente {
    //nombre  máquina y puerto

    static final String HOST = "localhost";
    static final int PUERTO = 5000;
    boolean adios = false;
    String[] conver = {"Hola", "Como estas?", "Bien", "Adios"};
    Scanner t = new Scanner(System.in);

    public Cliente() {
        try {
            //se crea el socket y se conecta
            Socket skCliente = new Socket(HOST, PUERTO);
            System.out.println("Conexion establecida");
           
                do {                
                for (int i = 0; i < conver.length; i++) {
                    //asocio flujo salida de datos al socket
                    OutputStream auxo = skCliente.getOutputStream();
                    //asocio flujo de datos flujo de tipo DataOutputStream 
                    DataOutputStream flujoo = new DataOutputStream(auxo);
                    //escribo
                    System.out.println("    Yo digo: "+conver[i]);
                    flujoo.writeUTF(conver[i]);
                    //recojo flujo de datos del socket
                    InputStream auxi = skCliente.getInputStream();

                    //asocio flujo de datos flujo de tipo DataInputStream
                    DataInputStream flujoi = new DataInputStream(auxi);

                    //Capturamos cadena del flujo con readUTF y muestro
                    System.out.println("Servidor dice: "+flujoi.readUTF());
                    

                    if (conver[i].equals("Adios")) {
                        adios = true;
                    }
                }
            } while (adios=false);
            
            //Cierro el socket
            skCliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new Cliente();
    }
}
