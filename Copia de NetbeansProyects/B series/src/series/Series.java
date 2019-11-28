package series;
import controlador.controlador;
//import modelo.acceso;
//import modelo.listShow;
//import modelo.show;
import vista.frame;
public class Series {
    public static void main(String[] args) {
        
        //instancio un controlador para pasárselo a la vista
        controlador control=new controlador();
        //instancio una ventana pasándole un controlador
        frame f = new frame(control);
        f.setVisible(true);
       
//            //PRUEBA LEER DEL FICHERO       
//            //instanciamos una lista de series:
//        listShow ls = new listShow();
//        //leemos del fichero:
//        ls=acceso.cargarLS();
//        //instanciamos un objeto de tipo serie:
//        show sh=new show();
//        //obtenemos el primer elemento del arrayList:
//        sh=ls.getShow(0);
//        //mostramos el título:
//        System.out.print("titulo:");
//        System.out.println(sh.getTitle());
//        //obtenemos y mostramos el segundo:
//        sh=ls.getShow(1);
//        System.out.print("titulo:");
//        System.out.println(sh.getTitle());
        
//        //PRUEBA ESCRIBIR EN FICHERO
//        //prueba de guardar en fichero:
//        //instanciamos un show con los datos de una serie:
//        show sh=new show("Breaking Bad", "Vincent Guilligan",5,"Drama",5);
//        //instanciamos una lista de series:
//        listShow ls = new listShow();
//        //añadimos las serie a la lista de series:
//        ls.setShow(sh);
//        //creamos una segunda serie:
//        sh=new show("Juego de Tronos", "David Benioff",6,"Drama Comedia",6);
//        ls.setShow(sh);
//        //guardamos en el fichero los datos creados
//        acceso.guardarLS(ls);
//        //mensaje para saber que ha acabado:
//        System.out.print("series guardadas");
        
    }
}



 
