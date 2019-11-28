package formatoListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LamdaParaTodos extends JFrame {

    JPanel panel = new JPanel();
    private JButton azul, rosa, amarillo, verde;

    public LamdaParaTodos() {
        setTitle("Lamda con un método para todos");
        setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());

        azul = new JButton("Azul");
        azul.addActionListener(e -> {
            respondeEventos(e.getSource());
   
        });

        verde = new JButton("Verde");
        verde.addActionListener(e -> {
            respondeEventos(e.getSource());
        });

        amarillo = new JButton("Amarillo");
        amarillo.addActionListener(e -> {
            respondeEventos(e.getSource());
        });

        rosa = new JButton("Rosa");
        rosa.addActionListener(e -> {
            respondeEventos(e.getSource());
        });

        panel.add(azul, BorderLayout.SOUTH);
        panel.add(verde, BorderLayout.NORTH);
        panel.add(amarillo, BorderLayout.EAST);
        panel.add(rosa, BorderLayout.WEST);

        add(panel);
        panel.setBackground(Color.red);

    }

    private void respondeEventos(Object source) {
        if (source ==azul)
            panel.setBackground(Color.blue);
        if (source ==verde)
            panel.setBackground(Color.green);
        if (source ==amarillo)
            panel.setBackground(Color.yellow);
        if (source ==rosa)
            panel.setBackground(Color.pink);
    }
}//de frame
