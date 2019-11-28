package parking1;



//Estructuras hilo

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Coche extends Thread{
    
//     declaración atributos
    int matricula;
    int tiempo;
    Parking p;
    private boolean enParking=false;
//     implementa constructor 
	public Coche(int matricula, Parking p){
		this.matricula=matricula;
                //cada coche tiene un tiempo aleatorio de estancia en el parking
               this.tiempo=(int) (Math.random()*5000+2000);
                this.p=p;
	}
        
//      método run
        @Override
       public void run(){
        try {
            sleep(tiempo);
            entrarParking();
            sleep(tiempo);
            salirParking();
        } catch (InterruptedException ex) {
            Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
        }
                }
       
       
       synchronized public void entrarParking(){
           //se comprueba si el parking está lleno
           if (p.estaLleno()) {
               //si está lleno se avisa de que no se puede acceder
               System.out.println("Parking lleno. Coche "+ matricula+" no puede acceder");
           }
           else{
               //si el parking no está lleno y el coche no está en el parking se resta una plaza libre del parkin
               //y se cambia el estado del coche a "En parking"
               //se avisa de que el coche ha entrado, su matrícula y el número de plazas
           if (!enParking) {
               p.plazas-=1;
               enParking=true;
               System.out.println("Coche "+matricula+" entra en Parking. Plazas libres: "+p.getPlazas());
           }
           }
       
       
       }
       
       synchronized public void salirParking(){
           //si el coche está en el parking, se vacía la plaza libre, se cambia el estado a "No en parking"
           //se avisa de que el coche ha entrado, su matrícula y el número de plazas
           if (enParking) {
                p.plazas+=1;
               enParking=false;
               System.out.println("Coche "+matricula+" sale del Parking. Plazas libres: "+p.getPlazas());
           }
       
       }
       
     
}





        
   
    

//    Métodos sincronización hilos:
//     Uso synchronized
//     wait(),  notifyAll() y notify()


    



/*
Estructura clase swingworker


import java.util.List;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 * Ejemplo de SwingWorker2.
 * 
 * 
 * 
 * 

public class Worker1 extends SwingWorker<párametros> {

    
    constructor
    public Worker1(JLabel unaEtiqueta) {
    
    }

    
    @Override
    protected Double doInBackground() throws Exception {
      
        
     

         valor retorno
        return 100.0;
    }


    @Override
    protected void done() {
        
    }

  
    @Override
    protected void process(List<Integer> chunks) {
       
    }
}




*/
        

