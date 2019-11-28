


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginCSS extends Application {

   
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Login");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        //grid.setGridLinesVisible(true);
        Text title = new Text("Welcome");
        title.setId("welcome-text");
        title.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        grid.add(title, 0, 0,2,1);
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);
        PasswordField password = new PasswordField();
        grid.add(password, 1, 2);
        
        Button btn = new Button("Sign in");
        grid.add(btn, 0, 4);
        
        Text action = new Text();
        grid.add(action, 0, 6 ,2,1 );
        
        btn.setOnAction((e) -> {
            action.setFill(Color.FIREBRICK);
            action.setText("Sign in button pressed");
        });
        
        Scene scene = new Scene(grid,300,275);
        stage.setScene(scene);
        //no va el css
        scene.getStylesheets().add(LoginCSS.class.getResource("Login.css").
                toExternalForm());
        stage.show();
    }
    
}
