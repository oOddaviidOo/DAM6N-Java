package cuentahilos;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAM 6N
 */
public class SacarDinero extends Thread{
    private Cuenta c;
    String nom;

    public SacarDinero(String nom, Cuenta c) {
        super(nom);
        this.c = c;
        
    }
    public Cuenta getC() {
        return c;
    }
    public void setC(Cuenta c) {
        this.c = c;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void run(){
        for (int i = 1; i <=4; i++) {
            synchronized(c){
            c.RetirarDinero(10, getName());
            }
        }
    }
    
}
