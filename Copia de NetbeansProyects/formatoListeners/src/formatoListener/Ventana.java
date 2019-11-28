package formatoListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Ventana extends JFrame{
     
       JPanel panel = new JPanel();
       private JButton azul,rosa,amarillo,verde;
    
    public Ventana(){
        setTitle("Ejemplo con varios botones");
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());
        
	//creo un objeto escuchador_boton para añadirlo 
	//como listener en todos botones
	       EBoton eBoton = new EBoton();
        azul = new JButton("Azul");
        azul.addActionListener(eBoton);
        
        
        verde = new JButton("Verde");
        verde.addActionListener(eBoton);
        
        
        amarillo = new JButton("Amarillo");
        amarillo.addActionListener(eBoton);
       
        
        rosa = new JButton("Rosa");
        rosa.addActionListener(eBoton);
        
        
        panel.add(azul,BorderLayout.SOUTH);
        panel.add(verde,BorderLayout.NORTH);
        panel.add(amarillo,BorderLayout.EAST);
        panel.add(rosa,BorderLayout.WEST);
        
        add(panel);
        panel.setBackground(Color.red);
        
        
    }
		
 //clase para escuchar los eventos del botón
 class EBoton implements ActionListener{
    public void actionPerformed (ActionEvent e){
        Object source = e.getSource();
        if (source ==azul)
            panel.setBackground(Color.blue);
        if (source ==verde)
            panel.setBackground(Color.green);
        if (source ==amarillo)
            panel.setBackground(Color.yellow);
        if (source ==rosa)
            panel.setBackground(Color.pink);
            
    }
  }//de escuchador_boton
}//de frame
