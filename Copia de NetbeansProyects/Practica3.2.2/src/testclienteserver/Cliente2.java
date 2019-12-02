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

class Cliente2 {
    //nombre  máquina y puerto

    static final String HOST = "localhost";
    static final int PUERTO = 5000;
    boolean adios = false;
//    String[] conver = {"Hola", "Como estas?", "Bien", "Adios"};
        String esc="";
    Scanner t = new Scanner(System.in);

    public Cliente2() {
        try {
            //se crea el socket y se conecta
            Socket skCliente = new Socket(HOST, PUERTO);
            System.out.println("Conexion establecida");
           
                do {                
                    //asocio flujo salida de datos al socket
                    OutputStream auxo = skCliente.getOutputStream();
                    //asocio flujo de datos flujo de tipo DataOutputStream 
                    DataOutputStream flujoo = new DataOutputStream(auxo);
                    //escribo
                    esc=t.nextLine();
                    System.out.println("        Yo digo: "+esc);
                    flujoo.writeUTF(esc);
                    //recojo flujo de datos del socket
                    InputStream auxi = skCliente.getInputStream();

                    //asocio flujo de datos flujo de tipo DataInputStream
                    DataInputStream flujoi = new DataInputStream(auxi);

                    //Capturamos cadena del flujo con readUTF y muestro
                    System.out.println("Servidor dice: "+flujoi.readUTF());
                    

                    if (esc.equals("Adios")) {
                        adios = true;
                    }
                
            } while (adios=false);
            
            //Cierro el socket
            skCliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new Cliente2();
    }
}
