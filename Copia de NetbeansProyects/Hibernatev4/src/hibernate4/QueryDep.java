/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate4;

import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class QueryDep {

     public static void main(String[] args) {
        //Código mínimo
        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();        
        Session sesion = sesionf.openSession();
        Query q = sesion.createQuery("from Departamentos");
        //fin código mínimo
/*----------------------------------------------------------------*/   
//
//        List<Departamentos> lista = q.list();
//        for (Departamentos dep: lista) {
//            System.out.print(dep.getDeptNo()+" ");
//            System.out.print(dep.getDnombre()+" ");
//            System.out.print(dep.getLoc()+" ");
//            System.out.println("\n");
//        }
/*----------------------------------------------------------------*/       


        q.setFetchSize(2);
        Iterator iter = q.iterate();
        Departamentos depi;
        while(iter.hasNext()){
            depi = (Departamentos) iter.next();
            System.out.println(depi.getDeptNo()+" "+depi.getDnombre());
        }
   
        sesion.close();
    }

}
