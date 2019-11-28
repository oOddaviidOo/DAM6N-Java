

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author David
 */
public class PruebaOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Runtime r=Runtime.getRuntime();
        String comando="java EjemploLectura";
        Process p=null;
        try {
            p=r.exec(comando);
            OutputStream os=p.getOutputStream();
            os.write("Hola psp\n".getBytes());
            os.flush();
            
                
            
            //Se cre is con el IS del proceso
            InputStream is=p.getInputStream();
            //Se crea un br con el ISR de IS
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String linea;
            //Mientras haya texto
            while ((linea=br.readLine())!=null) {                
                //Se escribe la linea
                System.out.println(linea);
            }
            //se cierra receptor de lectura y escritura
            br.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        try {
           int exitVal=0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
