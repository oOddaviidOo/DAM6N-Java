package CMD;

import java.io.*;
import java.net.*;
//Servidor espera conexiones a las que atenderá con un segundo socket
//Servidor saludará con frase "Hola cliente"

class ServidorCMD {

//puerto espera conexiones
    static final int PUERTO = 5000;
    String s = "";

    public ServidorCMD() {

        try {
            //crea socket y espera
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);

            //Primitiva accept() crea nuevo socket skCliente
            //skCliente atiene al cliente
            Socket skCliente = skServidor.accept(); // Crea objeto                                
            System.out.println("Conexion Establecida");
            FileWriter fichero = null;
            fichero = new FileWriter("fichero.txt");
            
            while (skCliente.isConnected()) {

                //recojo flujo de datos del socket
                InputStream auxi = skCliente.getInputStream();

                //asocio flujo de datos flujo de tipo DataInputStream
                DataInputStream flujoi = new DataInputStream(auxi);
                s = flujoi.readUTF();
                //Capturamos cadena del flujo con readUTF y muestro
                System.out.println("Cliente dice: " + s);
                fichero.write(s);
                
                
            }
            //cierro conexión
            fichero.close();
            skCliente.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    public static void main(String[] arg) {

        new ServidorCMD();

    }

}
