
package olexample;

import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;

public class ObservableListDemoI {
    public static void main(String[] args) {
        // Usamos Java Collections para crear la lista.
        List<String> list = new ArrayList<String>();
 
        // Ahora agregamos la observabilidad envolviéndola con ObservableList
        ObservableList<String> observableList = FXCollections.observableList(list);
        
        observableList.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detectado un cambio!! ");
            }
        });
 
        // Los cambios en la lista serán notificados
        // Esta línea deberá provocar un evento
        observableList.add("item uno");
 
        // Los cambios en la lista subyaciente no serán notificados
        // Esto no deberá causar un evento
        list.add("item dos");
 
        System.out.println("Tamaño: " + observableList.size());
 
    }
}