/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * $(name} Creada el 14 nov. 2019, hora Desarrollada por David en la empresa IES
 * ABASTOS el dia 14 nov. 2019
 *
 * Puede contactar conmigo en $(mail}
 *
 * /**
 *
 * @author David
 * @version 1.0
 * @date 14 nov. 2019
 */
public class Ventana extends JFrame {

    public JPanel panel = new JPanel();
        JButton azul=new JButton("azul");
        JButton verde=new JButton("verde");
        JButton amarillo=new JButton("amarillo");
        JButton rosa=new JButton("rosa");
        JButton[] lista={verde,amarillo,azul,rosa};

    public Ventana() {
        BorderLayout bl=new BorderLayout();
        setTitle("Ejemplo con varios botones");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setBackground(Color.red);
        panel.setLayout(bl);
        for (int i = 0; i < lista.length; i++) {
            lista[i].addActionListener(new EBoton());
            switch(i){
                case 0: panel.add(lista[i], bl.NORTH);break;
                case 1: panel.add(lista[i], bl.EAST);break;
                case 2: panel.add(lista[i], bl.SOUTH);break;
                case 3: panel.add(lista[i], bl.WEST);break;
            }
        }
        
        add(panel);
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
        
        



