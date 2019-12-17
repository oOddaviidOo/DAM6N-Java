package fxcontrols;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class listViewRect extends Application {

    ListView<String> list = new ListView<>();
    ObservableList<String> data = FXCollections.observableArrayList(
            "chocolate", "salmon", "gold", "coral", "darkorchid",
            "darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue",
            "blueviolet", "brown");
    final Label label = new Label();

    @Override
    public void start(Stage stage) {
        VBox box = new VBox();
        Scene scene = new Scene(box, 200, 200);
        stage.setScene(scene);
        stage.setTitle("ListViewSample");
        box.getChildren().addAll(list, label);
        VBox.setVgrow(list, Priority.ALWAYS);

        label.setLayoutX(10);
        label.setLayoutY(115);
        label.setFont(Font.font("Verdana", 20));

        list.setItems(data);
        //establece una nueva "fabrica de celdas", es decir
        //redibuja o reescribe como serán cada una de las
        //nuevas celdas.
        list.setCellFactory((ListView<String> l) -> {
            return new ColorRectCell();
        });
 
        list.getSelectionModel().selectedItemProperty().addListener(
            (ov, old_val,new_val) -> {
                    label.setText(new_val);
                    label.setTextFill(Color.web(new_val));
        });
        stage.show();
    }
    //para establecer el aspecto de las nuevas celdas
    //ceramos una clase que extienda a ListCell
    static class ColorRectCell extends ListCell<String> {
        @Override
        //rescribimos el método updateItem que esatblece
        //el aspecto de las celdas
        public void updateItem(String item, boolean empty) {
            //aunque está rescrito debemos llamar 
            //al updateItem de la clase padre para que haga las
            //operaciones por defecto
            super.updateItem(item, empty);
            //después establecemos el nuevo aspecto
            Rectangle rect = new Rectangle(100, 20);
            if (item != null) {
                rect.setFill(Color.web(item));
                setGraphic(rect);
            } else {
                setGraphic(null);
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
