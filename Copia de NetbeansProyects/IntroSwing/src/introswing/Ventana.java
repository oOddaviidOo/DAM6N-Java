/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author DAM 6N
 */
public class Ventana extends JFrame{
    //Definiendo los elementos del Frame; Son un panel y 4 botones sin instanciar
    private JPanel panel = new JPanel();  
    private JButton b1,b2,b3,b4;
    
//    El FlowLayout es Ordenado en filas y se define la alineacion de los elementos
//    y el espaciado vertical y horizontal. Dependiendo del tamaño del frame
//    los elementos se van desplazando
//    private FlowLayout l = new FlowLayout(FlowLayout.LEFT, 500, 200);
        
//    El GridLayout es Ordenado en forma de tabla, como las celdas en Excel
//    Puedes definir filas, columnas y espaciado vertical y horizontal
//    private GridLayout l= new GridLayout(2, 2, 50, 50);
    
//    BorderLayout es Ordenado por esquinas y centro, solo 5 opciones
    private BorderLayout l=new BorderLayout();
    //
    public Ventana(){
    //Elementos mínimos de la ventana
    setTitle("Hola");
    setSize(800,600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //Color del panel de la clase Color
    panel.setBackground(Color.RED);
    //Establecer el layout ya instanciado del panel
    panel.setLayout(l);
    //Codigo del botón 1, se define el texto que contendrá, se le asigna el 
    //metodo que lo maneja, se le asigna un tamaño
    b1 = new JButton("verde");
    b1.addActionListener(new Escuchador());
    b1.setPreferredSize(new Dimension(100, 40));
    //Se añade el elemento boton al panel junto con su posicion en el borderLayout
    panel.add(b1, BorderLayout.NORTH);
    b2 = new JButton("amarillo");
    b2.addActionListener(new Escuchador());
    b2.setPreferredSize(new Dimension(100, 40));
    panel.add(b2, BorderLayout.EAST);
    b3 = new JButton("azul");
    b3.addActionListener(new Escuchador());
    b3.setPreferredSize(new Dimension(100, 40));
    panel.add(b3, BorderLayout.SOUTH);
    b4 = new JButton("rosa");
    b4.addActionListener(new Escuchador());
    b4.setPreferredSize(new Dimension(100, 40));
    panel.add(b4, BorderLayout.WEST);
    //Se añade el Panel al Frame
    add(panel);
    
    //Se autogeneran botones con texto, y dependiendo del numero se le asigna 
    //una posicion en el borderLayout
//        for (int i = 0; i < 4; i++) {
//            JButton b = new JButton("b"+(i+1));
//  //            Tamaño Botón
//            b.setPreferredSize(new Dimension(100, 25));
//            switch(i){
//                case 0:panel.add(b, BorderLayout.NORTH);b.addActionListener(new Escuchador());break;
//                case 1:panel.add(b, BorderLayout.EAST);b.addActionListener(new Escuchador());break;
//                case 2:panel.add(b, BorderLayout.SOUTH);b.addActionListener(new Escuchador());break;
//                case 3:panel.add(b, BorderLayout.WEST);b.addActionListener(new Escuchador());break;
//            }
//        }
//    Ejemplo solo cambiar color 1 boton
//
//    JButton boton=new JButton("o/");
//    boton.addActionListener(new Escuchador());
//    Dimension d=new Dimension();
//    d.height=40;
//    d.width=100;
//    boton.setPreferredSize(d);
//    panel.add(boton);
    }
    
    
    
    
    
    
    
//    Clase Escuchar Boton
    
     class Escuchador implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) throws UnsupportedOperationException{
        Object source = e.getSource();
        if (source ==b3)
            panel.setBackground(Color.blue);
        if (source ==b1)
            panel.setBackground(Color.green);
        if (source ==b2)
            panel.setBackground(Color.yellow);
        if (source ==b4)
            panel.setBackground(Color.pink);
    }
    
}
}

