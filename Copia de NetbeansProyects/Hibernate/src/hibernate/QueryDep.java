package hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryDep {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int op, opt;
        System.out.println("Tipos de consulta");
        System.out.println("--------------------------");
        System.out.println("1.- Consulta con Iterate");
        System.out.println("2.- Consulta con List");
        System.out.println("3.- Listado de INFORMATICA");
        System.out.println("--------------------------");
        op = tec.nextInt();

        switch (op) {
            case 1:
                System.out.println("¿Que desea visualizar?");
                System.out.println("1.- Departamentos");
                System.out.println("2.- Profesores");
                opt = tec.nextInt();

                if (opt == 1) {
                    metodoIterateDepa();
                } else {
                    metodoIterateProf();
                }
                break;
            case 2:
                System.out.println("¿Que desea visualizar?");
                System.out.println("1.- Departamentos");
                System.out.println("2.- Profesores");
                opt = tec.nextInt();

                if (opt == 1) {
                    metodoListDepa();
                } else {
                    metodoListProf();
                }
                break;
            case 3:
                metodoListInformatica();
                break;
            default:
                System.out.println("ERROR");
                break;
        }

    }

    //METODO ITERATE DEPARTAMENTOS
    public static void metodoIterateDepa() {
        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();

        Query q = sesion.createQuery("from Departamentos");
        q.setFetchSize(5);

        Iterator iter = q.iterate();
        Departamentos depi;

        while (iter.hasNext()) {
            depi = (Departamentos) iter.next();
            System.out.println(depi.getDeptNo() + " * " + depi.getDnombre());
        }
        sesion.close();
    }

    //METODO ITERATE PROFESORES
    public static void metodoIterateProf() {
        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();

        Query q = sesion.createQuery("from Profesores");
        q.setFetchSize(5);

        Iterator iter = q.iterate();
        Profesores pro;

        while (iter.hasNext()) {
            pro = (Profesores) iter.next();
            System.out.println(pro.getNombre() + " * " + pro.getApellidos() + " * " + pro.getEmail());
        }
        sesion.close();
    }

    //METODO LIST DEPARTAMENTOS
    public static void metodoListDepa() {
        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();

        Query q = sesion.createQuery("from Departamentos");
        List<Departamentos> lista = q.list();

        for (Departamentos dep : lista) {
            System.out.println(dep.getDeptNo() + " * " + dep.getDnombre());
        }
        sesion.close();
    }

    //METODO LIST PROFESORES
    public static void metodoListProf() {
        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();

        Query q = sesion.createQuery("from Profesores");
        List<Profesores> lista = q.list();

        for (Profesores prof : lista) {
            System.out.println(prof.getNombre() + " * " + prof.getApellidos() + " * " + prof.getEmail());
        }
        sesion.close();
    }

    //METODO PARA RECUPERAR TODOS LOS DATOS DEL DEPARTAMENTO DE INFORMATICA
    public static void metodoListInformatica() {
        SessionFactory sesionf = SessionFactoryUtil.getSessionFactory();
        Session sesion = sesionf.openSession();
   
        Query q = sesion.createQuery("from Departamentos WHERE dnombre='Informatica'");
        
        Iterator iter = q.iterate();
        Departamentos dep;

        while (iter.hasNext()) {
            dep = (Departamentos) iter.next();
            System.out.println(dep.getDeptNo()+ " * " + dep.getDnombre() + " * " + dep.getLoc());
        }
        sesion.close();
    }
}