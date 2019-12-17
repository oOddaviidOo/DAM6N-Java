package fxcontrols;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class comboBox extends Application {
        public static void main(String[] args) {
        launch(args);
    }
    
    final Button button = new Button ("Enviar");
    final Label notificacion = new Label ();
    final TextField tema = new TextField("");
    final TextArea texto = new TextArea ("");
    
    
    String direccion = " ";
    
    @Override public void start(Stage stage) {
        //primer comboBox
        ComboBox email = new ComboBox();
        email.getItems().addAll(
            "dir1@gmail.com",
            "dir2@gmail.com",
            "dir3@gmail.com",
            "dir4@gmail.com",
            "dir5@gmail.com"  
        );
        
        email.setPromptText("Dirección:");
        email.setEditable(true);
        //añadiendo escuchador al primer combobox
        email.setOnAction((Event ev) -> {
            direccion = 
                email.getSelectionModel().getSelectedItem().toString();    
        });
        
        //segundo combo: 
        ComboBox priorityComboBox = new ComboBox();
        priorityComboBox.getItems().addAll(
            "Muy Alta",
            "Alta",
            "Normal",
            "Baja",
            "Muy Baja" 
        ); 
        
        priorityComboBox.setValue("Normal");
        
        //evento del botón
        button.setOnAction((ActionEvent e) -> {
            if (email.getValue() != null && 
                    !email.getValue().toString().isEmpty()){
                notificacion.setText("Mensaje enviado a:" + direccion);
                tema.clear();
                texto.clear();
            }
            else {
                notificacion.setText("No has seleccionado dirección");
            }
        });
        
        //panel y escena
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Para: "), 0, 0);
        grid.add(email, 1, 0);
        grid.add(new Label("Prioridad: "), 2, 0);
        grid.add(priorityComboBox, 3, 0);
        grid.add(new Label("Tema: "), 0, 1);
        grid.add(tema, 1, 1, 3, 1);            
        grid.add(texto, 0, 2, 4, 1);
        grid.add(button, 0, 3);
        grid.add (notificacion, 1, 3, 3, 1);
        
        Scene scene = new Scene(grid, 500, 300);
        stage.setScene(scene);
        stage.setTitle("ComboBox Ejemplo");
        stage.show();

    }    
}