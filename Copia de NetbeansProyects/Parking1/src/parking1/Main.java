/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking1;

/**
 *
 * @author DAM 6N
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Parking p=new Parking();
        Coche c1=new Coche(1, p);
        Coche c2=new Coche(2, p);
        Coche c3=new Coche(3, p);
        Coche c4=new Coche(4, p);
        Coche c5=new Coche(5, p);
        Coche c6=new Coche(6, p);
        Coche c7=new Coche(7, p);
        Coche c8=new Coche(8, p);
        Coche c9=new Coche(9, p);
        Coche c10=new Coche(10, p);
        Coche c11=new Coche(11, p);
        Coche c12=new Coche(12, p);
        System.out.println("Creo aparcamiento. Num plazas: "+p.getPlazas());
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
        c10.start();
        c11.start();
        c12.start();
        
        
        
        
        
    }
    
}
