package fxcontrols;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class MasListview extends Application {
    
    //Para rellenar las celdas con un combo
    public static final ObservableList comidas = 
        FXCollections.observableArrayList();
    //Para rellenar el ListView
    public static final ObservableList datos = 
        FXCollections.observableArrayList();
       
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejemplo de listView con combos");        
        
        final ListView listView = new ListView(datos);
        listView.setPrefSize(200, 250);
        listView.setEditable(true);
        //datos para los combos
        comidas.addAll(
             "paella","cocido maragato","fabada","butifarra",
	       "gazpachos	manchegos","pulpo con garbanzos"
        );
        //datos iniciales del listview 
        for (int i = 0; i < 18; i++) {
            datos.add("dieta");
        }  
        listView.setItems(datos);
        //llamo a setCellFactory pero con el listCell especial para combos
        listView.setCellFactory(ComboBoxListCell.forListView(comidas));              
               
        StackPane root = new StackPane();
        root.getChildren().add(listView);
        primaryStage.setScene(new Scene(root, 200, 250));
        primaryStage.show();
    }
}

