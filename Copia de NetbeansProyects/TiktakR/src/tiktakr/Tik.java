/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiktakr;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * $(name}
* Creada el 18 nov. 2019, hora
*Desarrollada por David en la empresa IES ABASTOS el dia 18 nov. 2019
*
*Puede contactar conmigo en $(mail}
*
/**
*  
*@author David
*@version 1.0
*@date 18 nov. 2019
 */
public class Tik extends Thread{
@Override
public void run(){
    for (int i = 0; i < 10; i++) {
        System.out.println("Tik");
        try {
            sleep(999);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
}
