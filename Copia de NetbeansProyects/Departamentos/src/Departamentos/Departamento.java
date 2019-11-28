/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Departamentos;

/**
 *
 * @author DAM 6N
 */
public class Departamento {
    public int cod=0;
    public String nom="", loc="";

    public Departamento() {
    }
    
    public Departamento(int c, String n, String l) {
    this.cod=c;
    this.nom=n;
    this.loc=l;
    }

    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getLoc() {
        return loc;
    }
    public void setLoc(String loc) {
        this.loc = loc;
    }
    @Override
    public String toString() {
        return "Departamento{" + "cod=" + cod + ", nom=" + nom + ", loc=" + loc + '}';
    }

   
    
    
    
    
}
