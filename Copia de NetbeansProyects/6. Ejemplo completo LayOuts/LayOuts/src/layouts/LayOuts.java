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

public class LayOuts extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        HBox hbox = crearHBox();
        VBox vbox = crearVBox();
        FlowPane flow = CrearFlowPane();
        //Creamos un stackpane
        StackPane stack=CrearStackPane();
        //lo añadimos al hbox
        hbox.getChildren().add(stack); 
        //posiciona el stackpane con todo el espacio extra posible
        HBox.setHgrow(stack, Priority.ALWAYS);  
        //creamos un gridpane
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);
        
        //creamos un borderpane
        BorderPane border = new BorderPane();
        border.setTop(hbox);
        border.setLeft(vbox);
        border.setRight(flow);
        border.setCenter(grid); //como no tiene elemntos no se visualiza
         
        
        Scene scene = new Scene(border, 700, 500);
        primaryStage.setTitle("Prueba LauyOuts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox crearHBox(){
        HBox hbox = new HBox();
        //espacio alrededor del hbox
        hbox.setPadding(new Insets(15, 12, 15, 12));
        //espacio horizontal entre los nodos del hbox
        hbox.setSpacing(10);
		//los estilos css también se pueden poner aquí además de un fichero css aparte como ya vimos
        hbox.setStyle("-fx-background-color: #336699;");
        //crear un botón
        Button buttonCurrent = new Button("Botón 1");
        buttonCurrent.setPrefSize(100, 20);
        //crear otro botón
        Button buttonProjected = new Button("Botón 2");
        buttonProjected.setPrefSize(100, 20);
        //añadimos los botones al hbox
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);
        return hbox;
    }
    
    private VBox crearVBox(){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        //espacio vertical entre los nodos
        vbox.setSpacing(8);

        Text title = new Text("Información");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        Hyperlink options[] = new Hyperlink[] {
                new Hyperlink("Ventas"),
                new Hyperlink("Marketing"),
                new Hyperlink("Distribución"),
                new Hyperlink("Tesorería")
        };

        for (int i=0; i<4; i++) {
            //método estático de la clase para establecer márgenes en los nodos
            VBox.setMargin(options[i], new Insets(0, 0, 0, 25));
            vbox.getChildren().add(options[i]);
        }
        return vbox;
    }
    
     private FlowPane CrearFlowPane() {

        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170); // tamaño adecuado para dos imágenes por fila
        flow.setStyle("-fx-background-color: DAE6F3;");

        ImageView pages[] = new ImageView[8];
        for (int i=0; i<8; i++) {
            pages[i] = new ImageView(
                    new Image(LayOuts.class.getResourceAsStream(
                    "imagenes/chart_"+(i+1)+".png")));
            flow.getChildren().add(pages[i]);
        }

        return flow;
    }
     
    private StackPane CrearStackPane() {
        StackPane stack = new StackPane();
        //rectángulo
        Rectangle helpIcon = new Rectangle(30.0, 25.0);
        helpIcon.setFill(Color.web("#9CB6CF"));//color de relleno
        helpIcon.setStroke(Color.web("#D0E6FA"));//color de contorno
        helpIcon.setArcHeight(3.5);//define el contorno de las esquinas
        helpIcon.setArcWidth(3.5);//define el contorno de las esquinas

        Text helpText = new Text("?");//signo de interrogación
        helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        helpText.setFill(Color.WHITE);
        helpText.setStroke(Color.web("#7080A0")); 
        //añade los nodos unos encima de los otros
        stack.getChildren().addAll(helpIcon, helpText);
        stack.setAlignment(Pos.CENTER_RIGHT);
		//para hacer que el signo ? aparezca centrado en el stackpane
        StackPane.setMargin(helpText, new Insets(0, 10, 0, 0));
        return stack;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
