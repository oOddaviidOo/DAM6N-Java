/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicacombo;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author DAM 6N
 */
public class frameCombo extends JFrame{
    //Definimos los elementos del panel y este
    private JComboBox combo;
    private JLabel etiqueta;
    private JPanel panel;
    //Definimos los nombres para identificar las imagenes
    private String[] imagenes={"Rabbit", "Cat", "Dog", "Bird", "Pig"};
    private Icon img;
    
    public frameCombo(){
        //Atributos del panel minimos
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setTitle("Combos e imagenes");
        //Instanciamos el panel dentro del constructor esta vez
        panel=new JPanel();
        //Añadimos el layout del panel
        panel.setLayout(new BorderLayout());
        //Añadimos el panel al Frame
        add(panel);
        //Instanciamos la combobox cargando el array de nombres
        combo=new JComboBox(imagenes);
        //Se añade la comboBox al panel y se indica la posicion en el layout de borde
        panel.add(combo,BorderLayout.NORTH);
        //Instanciamos el icono
        img = new ImageIcon(/*Cogemos de la clase frame, el recurso de la carpeta 
                a continuacion*/getClass().getResource("./imagenes/Rabbit.gif"));
        //Definimos la etiqueta
        etiqueta = new JLabel();
        etiqueta.setText("Rabbit");
        etiqueta.setIcon(img);
        //Se define la posicion horizontal del texto
        etiqueta.setHorizontalTextPosition(SwingConstants.CENTER);
        //Se define la posicion vertical del texto
        etiqueta.setVerticalTextPosition(SwingConstants.BOTTOM);
        //Texto al dejar el cursor
        etiqueta.setToolTipText("Esto es una etiqueta");
        //Añadimos la etiqueta con su posicion en el layout
        panel.add(etiqueta, BorderLayout.CENTER);
        //Añadimos el manejador de eventos del comboBox
        combo.addItemListener(new ManejadorCombo());
}
    
    //Segun el elemento pulsado, el indice cambia
    private class ManejadorCombo implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            //Elige el numero equivalente a la opcion del combobox
          int indice=combo.getSelectedIndex();
          //Coje el nombre de la imagen a la que hace referencia el indice 
          //dentro del array, los elementos del array estan ordenados
          String s=imagenes[indice];
          //Cambia la imagen asociada a la variable img
          img=new ImageIcon(getClass().getResource("./imagenes/"+s+".gif"));
          //Se cambia la imagen de la etiqueta
          etiqueta.setIcon(img);
          //Se cambia el texto de la etiqueta por el texto de la nueva imagen
          etiqueta.setText(s);
        }
        
    
    }
}
