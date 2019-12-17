package jfximagesII;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.io.*;

import static javafx.application.Application.launch;

public class JFXImages extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TilePane tile = new TilePane();
        tile.setHgap(20);
        tile.setVgap(20);
        tile.setPadding(new Insets(20));
        tile.setPrefColumns(4);
        //la instrucción getClass.... devuelve una cadena así:
        // File:\c:\ruta buscada
        //por eso el subsring para elimiar ese comienzo
        //puede que haya una manera más profesional, pero no la encontré :(
        String PATH = getClass().getResource("Pictures").toString().substring(6);
        //obtengo todos los ficheros del directorio y los dejo en un array de files
        File dir = new File(PATH);
        File[] files = dir.listFiles();
        for (File f : files) {
            //por cada fichero uso image e imageView para mostrar su contenido
            Image img = new Image(f.toURI().toString(),
                    200, 200, true, true);

            ImageView iview = new ImageView(img);
            iview.setFitWidth(200);
            iview.setFitHeight(200);
            iview.setPreserveRatio(true);

            iview.setOnMouseClicked(e -> {
                //reescalar la imagen
                iview.setScaleX(2.0);
                iview.setScaleY(2.0);
            });

            Text txt = new Text(f.getName());
            txt.setFont(new Font("Times New Roman", 16));

            VBox box = new VBox(10, iview, txt);
            box.setAlignment(Pos.CENTER);
            tile.getChildren().add(box);
        }

        //usamos un tile panel con scroll
        ScrollPane scroll = new ScrollPane(tile);
        scroll.setMinWidth(920);
        scroll.setMinHeight(450);

        Scene scene = new Scene(scroll);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Photo Viewer - " + PATH);
        primaryStage.show();
    }
}
