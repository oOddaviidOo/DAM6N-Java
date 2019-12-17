
package propiertiesAndBindigAndControls;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.control.*;

public class RolePlayer extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    TextField txtCharacter;
    TextField txtActor;

    @Override public void start(Stage primaryStage)
    {

 		// Create the Character label
 		Label lblCharacter = new Label("Nombre Personaje:");
 		lblCharacter.setMinWidth(100);
 		lblCharacter.setAlignment(Pos.BOTTOM_RIGHT);

 		// Create the Character text field
 		txtCharacter = new TextField();
 		txtCharacter.setMinWidth(200);
 		txtCharacter.setMaxWidth(200);
 		txtCharacter.setPromptText("Escribe el nombre del personaje aquí.");

 		// Create the Actor label
 		Label lblActor = new Label("Nombre del actor:");
 		lblActor.setMinWidth(100);
 		lblActor.setAlignment(Pos.BOTTOM_RIGHT);

 		// Create the Actor text field
 		txtActor = new TextField();
 		txtActor.setMinWidth(200);
 		txtActor.setMaxWidth(200);
 		txtActor.setPromptText("Escribe el nombre del actor aqui.");

 		// Create the Role labels
 		Label lblRole1 = new Label("El personaje de  ");
 		Label lblRole2 = new Label();
 		Label lblRole3 = new Label(" fue interpretado por ");
 		Label lblRole4 = new Label();

 		// Create the Character pane
 		HBox paneCharacter = new HBox(20, lblCharacter, txtCharacter);
 		paneCharacter.setPadding(new Insets(10));

 		// Create the Actor pane
 		HBox paneActor = new HBox(20, lblActor, txtActor);
 		paneActor.setPadding(new Insets(10));

 		// Create the Role pane
 		HBox paneRole = new HBox(lblRole1, lblRole2, lblRole3, lblRole4);
 		paneRole.setPadding(new Insets(10));


 		// Add the Character and Actor panes to a VBox
 		VBox pane = new VBox(10, paneCharacter, paneActor, paneRole);

 		// Create the bindings
 		lblRole2.textProperty().bind(txtCharacter.textProperty());
 		lblRole4.textProperty().bind(txtActor.textProperty());


 		// Set the stage
 		Scene scene = new Scene(pane);
 		primaryStage.setScene(scene);
 		primaryStage.setTitle("Role Player");
		primaryStage.show();
    }

}
