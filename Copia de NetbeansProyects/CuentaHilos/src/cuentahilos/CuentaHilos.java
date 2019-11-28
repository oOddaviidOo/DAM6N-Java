/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentahilos;

/**
 *
 * @author DAM 6N
 */
public class CuentaHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cuenta c=new Cuenta(40);
        SacarDinero h1=new SacarDinero("Ana", c);
        SacarDinero h2=new SacarDinero("Juan", c);
        
        h1.start();
        h2.start();
    }
    
}
