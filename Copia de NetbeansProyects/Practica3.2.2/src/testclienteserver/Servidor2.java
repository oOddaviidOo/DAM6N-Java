/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;
//Servidor espera conexiones a las que atenderá con un segundo socket
//Servidor saludará con frase "Hola cliente"

class Servidor2 {

//puerto espera conexiones
    static final int PUERTO = 5000;
    boolean adios = false;
//    String[] conver = {"Hola", "Bien y tu?", "Okey", "Adios"};
    Scanner t = new Scanner(System.in);
    String esc="";

    public Servidor2() {

        try {
            //crea socket y espera
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);
            //Primitiva accept() crea nuevo socket skCliente
            //skCliente atiene al cliente
            Socket skCliente = skServidor.accept(); // Crea objeto

            System.out.println("Conexion establecida ");

                         
                
            
                do {                
                

                    //recojo flujo de datos del socket
                    InputStream auxi = skCliente.getInputStream();

                    //asocio flujo de datos flujo de tipo DataInputStream
                    DataInputStream flujoi = new DataInputStream(auxi);

                    //Capturamos cadena del flujo con readUTF y muestro
                    System.out.println("Cliente dice: "+flujoi.readUTF());

                    //asocio flujo salida de datos al socket
                    OutputStream auxo = skCliente.getOutputStream();
                    //asocio flujo de datos flujo de tipo DataOutputStream 
                    DataOutputStream flujoo = new DataOutputStream(auxo);
                    //escribo
                    esc=t.nextLine();
                    System.out.println("        Yo digo: "+esc);
                    flujoo.writeUTF(esc);

                    if (esc.equals("Adios")) {
                        adios = true;
                    }
                

            
            } while (adios=false);
            //cierro conexión
            skCliente.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    public static void main(String[] arg) {

        new Servidor2();

    }

}
