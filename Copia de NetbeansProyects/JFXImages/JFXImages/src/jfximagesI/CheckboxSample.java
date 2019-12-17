package jfximagesI;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.layout.StackPane;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckboxSample extends Application {

    Rectangle rect = new Rectangle(90, 30);
    String[] names = new String[]{"Security", "Project", "Chart"};
    Image[] images = new Image[names.length];
    ImageView[] icons = new ImageView[names.length];
    CheckBox[] cbs = new CheckBox[names.length];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        FlowPane fp = new FlowPane();
        Scene scene = new Scene(fp);
        stage.setTitle("Checkbox & image Sample");
        stage.setWidth(250);
        stage.setHeight(150);

        rect.setArcHeight(10);
        rect.setArcWidth(10);
        rect.setFill(Color.rgb(41, 41, 41));

        for (int i = 0; i < names.length; i++) {
            //se crea variable final j para poder ser usada dentro del listener
            //si no se hace así la variable j desaparece con el método y no "quedaría"
            //con el listener que seguirá estando pues está "asociado" al cbs[]
            final int j = i;
            images[i]
                    = new Image(getClass().getResourceAsStream(names[i] + ".png"));
            icons[i] = new ImageView();
            cbs[i] = new CheckBox(names[i]);
            cbs[i].selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
                    icons[j].setImage(new_val ? images[j] : null);
                    //esta línea no funcionaría porque la varible i no es final, es propia del método
                    //icons[i].setImage(new_val ? images[i] : null);
                }
            });
        }

        VBox vbox = new VBox();
        vbox.getChildren().addAll(cbs);
        vbox.setSpacing(5);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(icons);
        hbox.setPadding(new Insets(0, 0, 0, 5));

        StackPane stack = new StackPane();
        //usamamos stackPane para poner un rectangulo de fondo
        //y las imágenes de encima
        stack.getChildren().add(rect);
        stack.getChildren().add(hbox);
        StackPane.setAlignment(rect, Pos.TOP_CENTER);

        HBox root = new HBox();
        root.getChildren().add(vbox);
        root.getChildren().add(stack);
        root.setSpacing(40);
        root.setPadding(new Insets(20, 10, 10, 20));

        fp.getChildren().add(root);

        stage.setScene(scene);
        stage.show();
    }
}
