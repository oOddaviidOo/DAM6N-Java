/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantillafx;

import java.io.File;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class TiendaLibros extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //creamos un hbox
        HBox hbox = crearHBox();
        //creamos un VBox
        VBox vbox = crearVBox();
        //creamos un flowpane
//        FlowPane flow = CrearFlowPane();
        //Creamos un stackpane
        StackPane stack = CrearStackPane();
        //añadimos el stack pane al hbox
        hbox.getChildren().add(stack);
        HBox.setHgrow(stack, Priority.ALWAYS);
        //creamos un gridpane
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);

        //creamos un borderpane
        BorderPane border = new BorderPane();
        //añadimos los paneles a las diferentes posiciones del borderpane
        border.setTop(hbox);
        border.setLeft(vbox);
//        border.setRight(flow);
        border.setCenter(grid); //como no tiene elemntos no se visualiza
        
        Scene scene = new Scene(border, 700, 500);
        primaryStage.setTitle("Prueba LauyOuts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //METODOS QUE CREAN LOS PANELES
    private HBox crearHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color:#000000");
        Label l=new Label("Your book store");
        l.setFont(Font.font ("Bernadette Rough", 20));
        l.setAlignment(Pos.CENTER);
        l.setTextFill(Color.WHITE);
        hbox.getChildren().add(l);
        return hbox;
    }
    
    private VBox crearVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        Text title = new Text("Información");
        title.setFont(Font.font("Arial",
                FontWeight.BOLD, 14));
        vbox.getChildren().add(title);
        Hyperlink options[] = new Hyperlink[]{
            new Hyperlink("Ventas"),
            new Hyperlink("Marketing"),
            new Hyperlink("Distribución"),
            new Hyperlink("Tesorería"),};
        for (int i = 0; i < 4; i++) {
            VBox.setMargin(options[i],
                    new Insets(0, 0, 0, 25));
            vbox.getChildren().add(options[i]);
        }
        
        return vbox;
    }
    
    private FlowPane CrearFlowPane() {
        
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170);
        flow.setStyle("-fx-background-color: DAE6F3");
        
        return flow;
    }
    
    private StackPane CrearStackPane() {
        StackPane stack = new StackPane();
        Rectangle r = new Rectangle(30.0, 25.0);
        r.setFill(Color.web("#9CB6CF"));
        r.setStroke(Color.web("#D0E6FA"));
        r.setArcHeight(3.5);
        r.setArcWidth(3.5);
        Text t = new Text("?");
        t.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        t.setFill(Color.WHITE);
        t.setStroke(Color.web("#7080A0"));
        stack.getChildren().addAll(r, t);
        stack.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setMargin(t, new Insets(0, 10, 0, 0));
        return stack;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
