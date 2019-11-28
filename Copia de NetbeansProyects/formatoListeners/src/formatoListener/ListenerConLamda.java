package formatoListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ListenerConLamda extends JFrame {

    JPanel panel = new JPanel();
    private JButton azul, rosa, amarillo, verde;

    public ListenerConLamda() {
        setTitle("Usando lamda en cada listener");
        setBounds(70,70,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());

        azul = new JButton("Azul");
        azul.addActionListener(e -> {
            panel.setBackground(Color.blue);
        });

        verde = new JButton("Verde");
        verde.addActionListener(e -> {
            panel.setBackground(Color.green);
        });

        amarillo = new JButton("Amarillo");
        amarillo.addActionListener(e -> {
            panel.setBackground(Color.yellow);
        });

        rosa = new JButton("Rosa");
        rosa.addActionListener(e -> {
            panel.setBackground(Color.pink);
        });

        panel.add(azul, BorderLayout.SOUTH);
        panel.add(verde, BorderLayout.NORTH);
        panel.add(amarillo, BorderLayout.EAST);
        panel.add(rosa, BorderLayout.WEST);

        add(panel);
        panel.setBackground(Color.red);

    }
}//de frame
