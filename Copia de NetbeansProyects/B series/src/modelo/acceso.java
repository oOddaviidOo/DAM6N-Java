
package modelo;

import java.io.*;
import java.net.URL;

public class acceso {
    
//    private URL fileLocation = getClass().getClassLoader().getResource("./fichero/series.dat");
    private File f=new File("series.dat");
    
    public  void guardarLS(listShow ls) {
        
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(ls);
            oos.close();
        } catch (IOException ex) {
            System.out.print("Fallo al escribir fichero" + ex.getMessage());
        }
    }
    public  listShow cargarLS(){
        listShow ls = new listShow();
        ObjectInputStream ois=null;
        try{
            FileInputStream fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ls=(listShow) ois.readObject();
            ois.close();
        }catch(IOException io){
            System.out.print("Fallo al leer en fichero" + io.getMessage());
        }finally{
            
            return ls;
        }
    }
    
}
