/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso8;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author DAM 6N
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DateFormat d=new SimpleDateFormat("mm/dd/yyyy");
        String f="03/07/2000";
        f=d.toString();
        System.out.println(f);
        // TODO code application logic here
    }
    
}
