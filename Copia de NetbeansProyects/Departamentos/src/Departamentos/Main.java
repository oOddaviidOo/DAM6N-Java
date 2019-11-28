/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Departamentos;

import java.util.ArrayList;
import java.util.Scanner;

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
        ArrayList<Departamento> a=new ArrayList();
        Scanner t=new Scanner(System.in);
        boolean flag=true;
        Departamento d1=new Departamento(5, "A", "a");
        Departamento d2=new Departamento(2, "B", "b");
        a.add(d1);a.add(d2);
        do {           
            System.out.println("Introduce num dep");
        int n=t.nextInt();
            for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getCod()==n) {
                System.out.println("Se ha encontrado el departamento");
                System.out.println(a.get(i).toString());
                break;
            } else {
                System.out.println("No encontrado");
                break;
            }
        }
            System.out.println("Seguir? s/n");
            String f=t.next();
            if (f.equals("n")) {
                flag=false;
            }
        } while (flag);
        

    }
    
}
