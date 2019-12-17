package convenienceMethods;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MouseEvents extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(100.0, Color.RED);

        circle.setOnMouseEntered(me -> {
            System.out.println("Mouse entered");
        });

        circle.setOnMouseExited(me -> {
            System.out.println("Mouse exited");
        });

        circle.setOnMousePressed(me -> {
            System.out.println("Mouse pressed");
        });

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(circle);

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Hello Mouse Events");
        stage.show();
    }
}
