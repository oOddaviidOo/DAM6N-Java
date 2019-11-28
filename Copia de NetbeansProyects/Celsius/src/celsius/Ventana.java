/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celsius;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author DAM 6N
 */
public class Ventana extends JFrame{
    public JPanel panel=new JPanel();
    private GridLayout ly=new GridLayout(3, 2, 10, 10);
    JButton limpiar=new JButton("LIMPIAR");
    JTextField tfc, tfk;
    int cel=0, kel=0;
    public Ventana(){
    setTitle("Convertidor Celsius a Kelvin");
    setSize(400,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(ly);
    JLabel celsius=new JLabel("Grados celsius");
    JLabel kelvin=new JLabel("Grados kelvin");
    panel.add(celsius);
    tfc=new JTextField("Escribe la cantidad en celsius");
    tfc.addActionListener(new EscuchadorTextField());
    limpiar.addActionListener(new EscuchadorBoton());
    panel.add(tfc);
    panel.add(kelvin);
    tfk=new JTextField("Escribe la cantidad en kelvin");
    tfk.addActionListener(new EscuchadorTextField());
    panel.add(tfk);
    JLabel vacio=new JLabel();
    panel.add(vacio);
    panel.add(limpiar);
    add(panel);
    }
    
    
    class EscuchadorBoton implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) throws UnsupportedOperationException{
        Object source = e.getSource();
        if (source ==limpiar)
            tfc.setText("");
            tfk.setText("");
        
    }
    
}
    
   class EscuchadorTextField implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) throws UnsupportedOperationException{
            Object source =e.getSource();
            if (source==tfc) {
                cel=Integer.parseInt(tfc.getText());
                kel=cel+273;
                tfk.setText(Integer.toString(kel));
            }
            if (source==tfk) {
                kel=Integer.parseInt(tfk.getText());
                cel=kel-273;
                tfc.setText(Integer.toString(cel));
            }
            
        }
   
   }
    
}


