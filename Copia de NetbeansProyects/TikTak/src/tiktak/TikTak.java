/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
/**
 *
 * @author DAM 6N
 */

public class TikTak extends Thread{
private String hilo;

    public TikTak(String hilo) {
        this.hilo=hilo;
    }
    public void run(){
        while (true) {            
            System.out.println(hilo);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TikTak h=null;
        TikTak h2=null;
        
        for (int i = 0; i < 2; i++) {
            h=new TikTak("TIK");
            h.start();
            try {
                h.sleep(100);
            } catch (InterruptedException e) {
            }
            h2=new TikTak("TAK");
            h2.start();
            try {
                h2.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
    
}
