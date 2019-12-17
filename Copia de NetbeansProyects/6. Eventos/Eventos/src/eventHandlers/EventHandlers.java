package eventHandlers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class EventHandlers extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button("Button one");
        Button btn2 = new Button("Button two");
        // Create a MouseEvent handler
        EventHandler<MouseEvent> mouseEventHandler = e -> {  
            System.out.println(
                    ((Button)e.getSource()).getText()
            );  
        };
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        btn2.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(btn1, btn2);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Two buttons, one event handler!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
