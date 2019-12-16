/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate4;



import java.util.Iterator;
import hibernate4.*;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;

public class EjerciosU3 {

    public static void main(String[] args) {
        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();        
        Session sesion = sesionf.openSession();
        Query q = sesion.createQuery("from Profesores");
/*----------------------------------------------------------------*/       
        List<Profesores> lista = q.list();
        for (Profesores dep: lista) {
            System.out.println(dep.getApellidos());
        }
/*----------------------------------------------------------------*/       
/*
        q.setFechSize(5);
        Iterator iter = q.iterate();
        Departamentos depi;
        while(iter.hasNext()){
            depi = (Departamentos) iter.next();
            System.out.println(dep.getDeptNo()+" "+dep.getDnombre());
        }
*/        
        sesion.close();
    }
}

