/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantillafx;

import javafx.application.Application;
import javafx.stage.Stage;


public class PlantillaFX extends Application{


    public static void main(String[] args) {
        Application.launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hola Mundo");
        primaryStage.show();
    }
    
}
