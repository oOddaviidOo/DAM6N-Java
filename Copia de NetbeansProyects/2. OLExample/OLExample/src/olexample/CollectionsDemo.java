
package olexample;

import java.util.List;
import java.util.ArrayList;
 
public class CollectionsDemo {
 
    public static void main(String[] args) {
 
        // Crear una lista.
        System.out.println("Creando la lista...");
        List<String> list = new ArrayList<String>();
        list.add("Primer elemento");
        list.add("Segundo elemento");
        list.add("Tercer elemento");
 
        // Mostrar el contenido.
        muestraElementos(list);
        
        // Cambiando elemento en posición 0.
        System.out.println("Cambiando un elemento...");
        list.set(0, "Nuevo Elemento");
        muestraElementos(list);
        
        // Buscar el nuevo elemento.
        System.out.println("Buscando...");
        System.out.print("Contenido \"Nuevo Elemento\"? ");
        System.out.println(list.contains("Nuevo Elemento"));
        System.out.println("");
        
        // Crear sublista.
        System.out.println("creando una sublista...");
        list = list.subList(1,3);
        muestraElementos(list);
        
        // Borrar todo.
        System.out.println("Borrando todos los elementos...");
        list.clear();
        muestraElementos(list);
    }
    
    private static void muestraElementos(List<String> list) {
        System.out.println("Tamaño: "+list.size());
        for (Object o : list) {
            System.out.println(o.toString());
        }
        System.out.println("");
    }
}