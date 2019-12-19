/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate4;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryParam {

    public static void main(String[] args) {
        //Código mínimo
        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();
//
//
//
//
//
        Query q = sesion.createQuery("from Profesores");
        q.setInteger("s", 2000);
        //fin código mínimo
/*----------------------------------------------------------------*/

        List<Profesores> lista = q.list();
        for (Profesores prof : lista) {
            System.out.print(prof.getNrp() + " ");
            System.out.print(prof.getNombre() + " ");
            System.out.print(prof.getApellidos() + " ");
            System.out.print(prof.getEmail()+ " ");
            System.out.print(prof.getFechaAlta()+ " ");
            System.out.print(prof.getDepartamentos().getDeptNo()+ " ");
//            System.out.println(prof.getSueldo()+" ");
            System.out.println("\n");
        }
        /*----------------------------------------------------------------*/


        sesion.close();
    }

}
