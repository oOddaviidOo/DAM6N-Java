
package olexample;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class choiceBox extends Application {
    final Label label = new Label();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
      
        label.setFont(Font.font("Arial", 15));
        
        //Crear el Choice Box:
        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
           "Palabra 1", "Palabra 2", "Palabra 3", "Palabra 4", "Palabra 5")
        );
        //establecer un escuchador al choiceBox:                             
        cb.getSelectionModel().selectedIndexProperty().addListener(
               (ov,old_val, new_val) -> {
                    label.setText("Esto es "+ cb.getItems().get(new_val.intValue()).toString());            
        });
        //tooltip para choicebox:     
        cb.setTooltip(new Tooltip("Selecciona palabra"));
        //valor por defecto del choicebox:
        cb.setValue("Palabra 1");
        
        //instanciar grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
     
        //botnes y textbox:
        TextField nuevoElem = new TextField();
        Button btn_Añadir = new Button("Añade");
        btn_Añadir.setOnAction((ActionEvent e) -> {
            cb.getItems().add(nuevoElem.getText());  
        });
        grid.add(nuevoElem, 0, 0);
        grid.add(btn_Añadir, 1, 0);
        
        //Añadimos choice y label
        grid.add(cb, 0, 1,2,1);
        grid.add(label, 0, 2,2,1);
        
        Scene scene = new Scene(grid,400,200);
        scene.setFill(Color.ALICEBLUE);
        stage.setTitle("ChoiceBox Ejemplo");
        stage.setScene(scene);
        stage.show();     
    }
}