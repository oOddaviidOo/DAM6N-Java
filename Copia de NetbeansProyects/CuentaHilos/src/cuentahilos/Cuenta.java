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
public class Cuenta {
    private int saldo;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    
    
    public void RetirarDinero(int cant, String nom){
        if (getSaldo()>=cant) {
            System.out.println("Se va a retirar saldo (actual es: "+getSaldo()+")");
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
                restar(cant);
                System.out.println(nom+" retira => : "+cant+". Saldo Actual: "+getSaldo()+"");
            
        }
        else {
               System.out.println(nom+" No puede retirar dinero no hay saldo. Saldo Actual: "+getSaldo()+"");
        }
        
    }
    
    public void restar(int cantidad){
        int n=0;
        n=this.getSaldo()-cantidad;
        setSaldo(n);
    }
    
}
