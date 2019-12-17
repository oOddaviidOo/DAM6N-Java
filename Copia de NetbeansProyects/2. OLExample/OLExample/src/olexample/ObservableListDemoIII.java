
package olexample;

import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;

public class ObservableListDemoIII {
    public static void main(String[] args) {
        // Usamos Java Collections para crear la lista.
        List<String> list = new ArrayList<String>();
 
        // Ahora agregamos la observabilidad envolviéndola con ObservableList
        ObservableList<String> observableList = FXCollections.observableList(list);
        list.add("d");
        list.add("b");
        list.add("a");
        list.add("c");
        
        observableList.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detectado un cambio!! ");
                while (change.next()) {
                    System.out.println("¿Fue añadido? " + change.wasAdded());
                    System.out.println("¿Fue movido? " + change.wasRemoved());
                    System.out.println("¿Fue remplazado? " + change.wasReplaced());
                    System.out.println("¿Fue permutado? " + change.wasPermutated());
        }
            }
        });
 
        // Sort usando FXCollections
        FXCollections.sort(observableList);
 
    }
}
