/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package layouts;

import javafx.application.Application;
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


public class Layouts extends Application{
@Override
    public void start(Stage primaryStage) {
        //creamos un hbox
        HBox hbox = crearHBox();
        //creamos un VBox
        VBox vbox = crearVBox();
        //creamos un flowpane
        FlowPane flow = CrearFlowPane();
        //Creamos un stackpane
        StackPane stack=CrearStackPane();
        //añadimos el stack pane al hbox
        hbox.getChildren().add(stack);  
        //creamos un gridpane
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);
        
        //creamos un borderpane
        BorderPane border = new BorderPane();
        //añadimos los paneles a las diferentes posiciones del borderpane
        border.setTop(hbox);
        border.setLeft(vbox);
        border.setRight(flow);
        border.setCenter(grid); //como no tiene elemntos no se visualiza
         
        
        Scene scene = new Scene(border, 700, 500);
        primaryStage.setTitle("Prueba LauyOuts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //METODOS QUE CREAN LOS PANELES
    private HBox crearHBox(){
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color:#336699");
        Button b1=new Button("Boton 1");
        b1.setPrefSize(100, 20);
        Button b2=new Button("Boton 2");
        b2.setPrefSize(100, 20);
        hbox.getChildren().addAll(b1,b2);
        return hbox;
    }
    
    private VBox crearVBox(){
        VBox vbox = new VBox();
        
        return vbox;
    }
    
     private FlowPane CrearFlowPane() {

        FlowPane flow = new FlowPane();
        

        return flow;
    }
     
    private StackPane CrearStackPane() {
        StackPane stack = new StackPane();
        Rectangle r=new Rectangle(30.0, 25.0);
        Text t = new Text("?");
        stack.getChildren();
        r.setFill(Color.web("#9CX"));
        r.setStroke(Color.web("#D0E6FA"));
        r.arcWidthProperty(3.5);
        r.arcHeightProperty(3.5);
        
        return stack;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
