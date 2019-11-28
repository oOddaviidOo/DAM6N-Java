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
public class PruebaFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Runtime r=Runtime.getRuntime();
        String comando="java Unsaludo \"Hola Mundo\"";
        Process p=null;
        try {
            //Al fos se le pasa el fichero
            FileOutputStream fos=new FileOutputStream(args[0]);
            //Al pw se le pasa el fos
            PrintWriter pw=new PrintWriter(fos);
            
            p=r.exec(comando);
            //Se cre is con el IS del proceso
            InputStream is=p.getInputStream();
            //Se crea un br con el ISR de IS
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String linea;
            //Mientras haya texto
            while ((linea=br.readLine())!=null) {                
                //Se escribe la linea
                pw.println(linea);
            }
            //se cierra receptor de lectura y escritura
            br.close();
            pw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        try {
           int exitVal=p.waitFor();
            System.out.println(exitVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
