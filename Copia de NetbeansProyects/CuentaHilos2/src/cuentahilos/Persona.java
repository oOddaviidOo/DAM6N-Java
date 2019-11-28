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
public class Persona extends Thread{
    private Cuenta c;
    String nom;
    int is;

    public Persona(String nom, Cuenta c, int is) {
        super(nom);
        this.c = c;
        this.is=is;
        
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
    
    @Override
    public void run(){
        int mr;
        for (int i = 1; i <=2; i++) {
            mr=c.mov_random();
            synchronized(c){
                if (this.is==0) {
                    c.IngresarDinero(mr, nom);
                }
                if (this.is==1) {
                    c.RetirarDinero(i, nom);
                }
            }
        }
    }
    
}
