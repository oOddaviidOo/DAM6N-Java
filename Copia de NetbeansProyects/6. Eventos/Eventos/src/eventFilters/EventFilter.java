// EventRegistration.java
package eventFilters;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EventFilter extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(150, 150, 50);
        circle.setFill(Color.CORAL);

        Text helpText = new Text("?");//signo de interrogación
        helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        helpText.setFill(Color.WHITE);
        helpText.setStroke(Color.web("#7080A0"));
        StackPane stack = new StackPane();
        stack.setAlignment(Pos.CENTER);
        stack.getChildren().add(circle);
        stack.getChildren().add(helpText);
        
        // Crear un  MouseEvent filter
        EventHandler<MouseEvent> mouseEventFilter
                = e -> System.out.println("Mouse event filter has been called.");
        //asignar el filtro al panel
        stack.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventFilter);
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(50));
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: linear-gradient(#2A5058, #61a2b1);");
        vbox.getChildren().add(stack);
        Scene scene = new Scene(vbox, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Registering Event Filters");
        stage.show();
        stage.sizeToScene();
    }
}
