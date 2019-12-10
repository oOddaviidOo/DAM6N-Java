/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CameosStanLee;

import java.util.Scanner;

public class CameosStanLee {

    public static void main(String[] args) {

        Scanner t = new Scanner(System.in);
        Scanner t2 = new Scanner(System.in);
        
        int entrada = 0;
        entrada = t.nextInt();
        
        String[] casosDelEjemplo = new String[entrada];

        
        for (int i = 0; i < casosDelEjemplo.length; i++) {
            casosDelEjemplo[i]=t2.nextLine();
        }

        for (int i = 0; i < casosDelEjemplo.length; i++) {
            int resultado = comprobarCameo(casosDelEjemplo[i]);
            
            System.out.println(resultado);
        }

    }

    //comprobar si el string contiene las letras que forman stanlee
    //contar cuantas veces aparece
    public static int comprobarCameo(String st) {
        int n_cameos = 0;
        boolean s = false, t = false, a = false, n = false, l = false, e1 = false, e2 = false;
        boolean contieneCameo = false;
        char[] caracteres = new char[st.length()];
        int c = 0;
        for (int i = 0; i < st.length(); i++) {
            caracteres[i] = st.charAt(i);
        }

        for (int i = 0; i < st.length(); i++) {
            if (caracteres[i] == 's' || caracteres[i] == 'S') {
                s = true;
                c++;
            }
            if (s && caracteres[i] == 't' || caracteres[i] == 'T') {
                t = true;
                c++;
            }
            if (s && t && caracteres[i] == 'a' || caracteres[i] == 'A') {
                a = true;
                c++;
            }
            if (s && t && a && caracteres[i] == 'n' || caracteres[i] == 'N') {
                n = true;
                c++;
            }
            if (s && t && a && n && caracteres[i] == 'l' || caracteres[i] == 'L') {
                l = true;
                c++;
            }
            if (s && t && a && n && l && caracteres[i] == 'e' || caracteres[i] == 'E') {
                e1 = true;
                c++;
            }
            if (s && t && a && n && l && e1 && caracteres[i] == 'e' || caracteres[i] == 'E') {
                e2 = true;
                c++;
            }

            if (s && t && a && n && l && e1 && e2) {
                contieneCameo = true;
                s = false;
                t = false;
                a = false;
                n = false;
                l = false;
                e1 = false;
                e2 = false;
            }
            if (contieneCameo) {
                n_cameos++;
                contieneCameo = false;
            }
        }

        return n_cameos;
    }

}
