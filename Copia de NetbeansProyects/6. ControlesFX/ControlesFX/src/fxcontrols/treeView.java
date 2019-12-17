package fxcontrols;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class treeView extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }
        
	TreeView<String> spins; //treeView
	Label lblMostar;

    @Override 
    public void start(Stage primaryStage)
    {
	//creamos items para añadir al treeView 	
        TreeItem<String>  root, twd, bb, inexistente, fg;
        //nodo raiz        
	root = new TreeItem<>("Spin Offs");
	root.setExpanded(true);
        //añadimos un item al nodo raiz
        twd = makeShow("The Walking Dead", root);
        //añadimos un item a twd
        makeShow("Fear The Walking Dead", twd);
        //añadimos un item al nodo raiz
	bb = makeShow("Breaking Bad", root);
        //añadimos un item a bb
	inexistente = makeShow("Better Call Saul", bb);
        //añadimos dos items a inexistente
	makeShow("Debería hacerse algún spinoff 1", inexistente);
	makeShow("Debería hacerse algún spinoff 2", inexistente);
        //añadimos un item al nodo raiz        
        fg = makeShow("Family Guy", root);
        //añadimos un item a fg
        makeShow("Cleveland Show", fg);

        //instancimos el treeview pasándole el nodo raiz
	spins = new TreeView<String>(root);
        //que no se muestre el nodo raiz
	spins.setShowRoot(false);
        //escuhador del treeview
	spins.getSelectionModel().selectedItemProperty()
		    .addListener((v, oldValue, newValue) -> 
                            lblMostar.setText(newValue.getValue()));

	lblMostar = new Label();
        
        //panel y escenas
	VBox pane = new VBox(10);
	pane.setPadding(new Insets(20,20,20,20));
	pane.getChildren().addAll(spins, lblMostar);

	Scene scene = new Scene(pane);

	primaryStage.setScene(scene);
	primaryStage.setTitle("Spin Offs favoritos");
	primaryStage.show();

    }

    public TreeItem<String> makeShow(String title, TreeItem<String> parent)
    {
	//crea un nodo item con el texto pasado al método
        TreeItem<String> show = new TreeItem<String>(title);
	show.setExpanded(true);
        //añade el nodo creado al padre pasado al método 
	parent.getChildren().add(show);
	return show;
    }

}
