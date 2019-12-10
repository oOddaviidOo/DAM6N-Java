
import java.io.*;
import java.net.*;
import java.util.Scanner;

class ClienteGUI {

    //nombre  máquina y puerto
    public boolean adios = false;
    public final String HOST = "localhost";
    public final int PUERTO = 5000;
        String esc = "";
    Scanner t = new Scanner(System.in);

    public ClienteGUI() {
        try {
            
            //se crea el socket
            Socket skCliente = new Socket(HOST, PUERTO);

            
                esc = t.nextLine();
                //asocio flujo salida de datos al socket
                OutputStream auxo = skCliente.getOutputStream();
                //asocio flujo de datos flujo de tipo DataOutputStream 
                DataOutputStream flujoo = new DataOutputStream(auxo);
                //escribo


                flujoo.writeUTF(esc);
                if (esc.equals("adios")) {
                    adios=true;
                }
            
            //Cierro el socket
            skCliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        ClienteGUI cliente1 = new ClienteGUI();
    }
}
