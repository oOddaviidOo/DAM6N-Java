/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Style;

import java.awt.Label;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Style extends Application{


    public static void main(String[] args) {
        Application.launch(args);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Style");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        Text titulo=new Text("Style");
        Label iniciarsesion=new Label("Iniciar Sesion");
        TextField username=new TextField("Nombre de usuario");
        TextField palabrasecreta=new TextField("Palabra Secreta");
        Button btn=new Button("Iniciar sesion");
        Label nosepuede=new Label("¿No puede acceder a su cuenta?");
        stage.show();
    }
    
}
