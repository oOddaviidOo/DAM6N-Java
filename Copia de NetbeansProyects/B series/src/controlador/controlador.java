package controlador;
import modelo.acceso;
import modelo.listShow;
import modelo.show;
public class controlador {
        private int posicion;
        private listShow ls;
        private acceso acc = new acceso();
        public controlador() {
            
            posicion=0;
            ls=new listShow();
            ls=acc.cargarLS();
        } 
         public show primero(){
            posicion=0;
            return ls.getShow(posicion);
        }
          public show ultimo(){
            posicion=ls.longitud()-1;
            return ls.getShow(posicion);
        }
        public show anterior(){
            if (posicion>0){
                posicion--;
            }
            return ls.getShow(posicion);
        }
        public show siguiente(){
            posicion++;
            if (posicion==ls.longitud()){
                posicion--;
            }
            return ls.getShow(posicion);
        }
        
        public void nuevo(show s){
            ls.setShow(s);
            posicion=ls.longitud()-1;
            acc.guardarLS(ls);
        }
        public void eliminar(){
            //elimino la posición actual y guardo cambios en fichero
            ls.eliminar(posicion);
            //guardo en fichero:
            acc.guardarLS(ls);
        }    
        public void actualizar(show s){
            //actualizo el listshow y guardo en fichero
            ls.actualizar(s, posicion);
            acc.guardarLS(ls);
        }
}

