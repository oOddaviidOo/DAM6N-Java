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
public class Parking {
    public int plazas=7;
    //no meto nada en el constructor ya que solo utilizo un parking común para cada coche
    public Parking() {
        
    }

    public int getPlazas() {
        return plazas;
    }

//comprueba si no quedan plazas libres y devuelve true o false
    public boolean estaLleno(){
        if (plazas==0) {
            return true;
        }
        return false;
    }
    

    
}
