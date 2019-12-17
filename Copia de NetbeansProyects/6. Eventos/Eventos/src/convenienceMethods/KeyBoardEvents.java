package convenienceMethods;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KeyBoardEvents extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextField textBox = new TextField();
        textBox.setPromptText("Write here");

        textBox.setOnKeyPressed(ke -> {
            System.out.println("Key Pressed: " + ke.getText());
        });

        textBox.setOnKeyReleased(ke -> {
            System.out.println("Key Released: " + ke.getText());
        });

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(textBox);

        Scene scene = new Scene(root, 400, 50);
        stage.setScene(scene);
        stage.setTitle("Hello KeyBoard Events");
        stage.show();
    }
}
