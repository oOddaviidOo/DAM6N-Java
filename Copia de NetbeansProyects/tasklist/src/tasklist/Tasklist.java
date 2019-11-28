/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasklist;

import java.io.*;

/**
 *
 * @author DAM 6N
 */
public class Tasklist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Runtime r=Runtime.getRuntime();
        String comando="tasklist /v > procesos.txt";
        Process p=null;
        
        
        try {
            FileOutputStream fos=new FileOutputStream(args[0]);
            PrintWriter pw=new PrintWriter(fos);
            p=r.exec(comando);
            InputStream is = p.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            String linea;
            while ((linea=br.readLine())!=null) {                
                System.out.println("Inserto en"+args[0]+" > "+linea);
                pw.println(linea);
            }
            br.close();
            pw.close();
        } catch (Exception e) {e.printStackTrace();
        }
        
        
    }
    
}
