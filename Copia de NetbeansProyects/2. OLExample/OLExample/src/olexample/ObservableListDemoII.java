
package olexample;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;

public class ObservableListDemoII {
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
            }
        });
 
        // Sort usando FXCollections
        FXCollections.sort(observableList);
 
    }
}
