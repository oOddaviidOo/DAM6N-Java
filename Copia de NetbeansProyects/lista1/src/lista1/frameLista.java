/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author DAM 6N
 */
public class frameLista extends JFrame{
    //elemento JList
    private JList listaJlistColores;
    //Array constante de colores
    private final String NOMBRECOLORES[]={"Negro", "Azul", "Cyan", 
        "Gris oscuro", "Gris", "Verde", "Gris Claro", "Magenta",
    "Naranja", "Rosa", "Rojo", "Blanco", "Amarillo"};
    //Los colores del array son de la clase Color
    private final Color COLORES[]={Color.BLACK, Color.BLUE, Color.CYAN,
    Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
    Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
    Color.YELLOW};
    //El tipico panel
    private JPanel panel=new JPanel();
    
    public frameLista(){
        //Propiedades tipicas del panel, el que se cierre, el tamaño y el titulo
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("Lista Simple");
        //Tipico añadir el panel
        add(panel);
        listaJlistColores= new JList(NOMBRECOLORES);
        listaJlistColores.setVisibleRowCount(5);
        listaJlistColores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Se implementa el tipo de layout
        panel.setLayout(new FlowLayout());
        //Se añade el elemento lista al panel, y el scroll
        panel.add(listaJlistColores);
        panel.add(new JScrollPane(listaJlistColores));
        //Se añade el metodo para interactuar con la lista
        listaJlistColores.addListSelectionListener(new ManejadorLista());
        
}
    
    //Al pulsar en un elemento de la lista, el indice cambia al asociado a ese
    //elemento, al hacer esto, se busca el elemento==indice de la array de colores
    //y se cambia el color del panel a ese color
    private class ManejadorLista implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            panel.setBackground(COLORES[listaJlistColores.getSelectedIndex()]);
        }
    }
}

