/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentahilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAM 6N
 */
public class Cuenta {
    private int saldo;
    private int max_saldo=500;
    private boolean flag=false;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public int mov_random(){
    int mr=(int) Math.floor(Math.random()*(600-1+1)+1);
    return mr;
    }
    
    
    
    public void RetirarDinero(int cant, String nom){
                restar(cant);
                System.out.println(nom+" retira => : "+cant+". Saldo Actual: "+getSaldo()+"");
                try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        
    }
    
        public void IngresarDinero(int cant, String nom){
            sumar(cant);
            System.out.println(nom+" ingresa => : "+cant+". Saldo Actual: "+getSaldo()+"");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void restar(int cantidad){
        int n=0;
        try {
        if (cantidad>=getSaldo()) {
            n=this.getSaldo()-cantidad;
            setSaldo(n);
        } else{
            
                throw new Exception();}
            } catch (Exception e) {
                System.out.println("El saldo a restar es mayor que el saldo de la cuenta");
            }
        
        
    }
    
        public void sumar(int cantidad){
        int n=0;
            try {
                if (cantidad<=max_saldo) {
                n=this.getSaldo()+cantidad;
                setSaldo(n);
            } else {
                throw new Exception();
            }
            } catch (Exception e) {
                System.out.println("El saldo a introducir es mayor que 500");
            }
        
        
    }
    
}
