/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GradosCelsius;

import Ejercicio1.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    JButton limpiar = new JButton("Limpiar");
    JLabel lc = new JLabel("Grados Celsius");
    JLabel lk = new JLabel("Grados Kelvin");
    JTextField tfc = new JTextField();
    JTextField tfk = new JTextField();
    public int i = 0;

    public Ventana() {
        GridLayout l = new GridLayout(3, 2);
        setTitle("Convertidor Celsius-Kelvin");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(l);
        limpiar.addActionListener(new Listener());
        tfc.addActionListener(new Listener());
        tfk.addActionListener(new Listener());
        panel.add(lc);
        panel.add(tfc);
        panel.add(lk);
        panel.add(tfk);

        panel.add(limpiar);
        add(panel);
    }
    //clase para escuchar los eventos del botón

    class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (e.getSource() == limpiar) {
                tfc.setText("");
                tfk.setText("");
            }
            if (e.getSource()==tfc) {
                
                    i = Integer.parseInt(tfc.getText())+273;
                    tfk.setText(Integer.toString(i));
                
            }
                if (e.getSource()==tfk) {
                
                    i = Integer.parseInt(tfk.getText())-273;
                    tfc.setText(Integer.toString(i));
                
            }
        }
    }//de escuchador_boton
}//de frame

