package ejemplos;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FocusListenerDemo extends JFrame {

    public FocusListenerDemo() {
        setTitle("FocuFocusTraversalPolicy Demo");
        setLayout(new GridLayout(2, 1, 30, 30));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        JTextField tx = new JTextField();
        add(tx);
        JButton boton = new JButton("Pulsame");
        add(boton);
        // Guardamos el color de background por defecto.
        Color colorBackgroundDefecto = boton.getBackground();
        //establecemos el listener
        boton.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                e.getComponent().setBackground(Color.RED);      
            }

            public void focusLost(FocusEvent e) {
                e.getComponent().setBackground(colorBackgroundDefecto);
            }
        });
    }

    public static void main(String args[]) {
        new FocusListenerDemo().setVisible(true);
    }
}
