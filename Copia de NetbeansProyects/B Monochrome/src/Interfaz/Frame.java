
package Interfaz;

import java.awt.*;
import javax.swing.*;
import monochrome.*;


public class Frame extends JFrame {
    private JTextArea cuadrado;
    
    public Frame() {
        this.setTitle("Monochrome");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    
        this.setMinimumSize(new Dimension(300, 400));
        this.setSize(300, 400);
        this.setLayout(new BorderLayout());
        
        JButton iniciar = new JButton("Iniciar");        
        JTextField input = new JTextField(6);
        JButton pintar = new JButton("Orden");
        
        JPanel header = new JPanel();
        header.setLayout(new FlowLayout());
        header.add(iniciar);
        header.add(input);
        header.add(pintar);
        
        
        cuadrado = new JTextArea();
        JPanel centro = new JPanel();
        centro.setLayout(new FlowLayout());
        cuadrado.setEditable(false);
        centro.add(cuadrado);
        
        this.add(header, BorderLayout.NORTH);
        this.add(centro, BorderLayout.CENTER);
        
        // eventos
        iniciar.addActionListener(new Inicializar(cuadrado));
        pintar.addActionListener(new Pintar(cuadrado, input));
        
        // mostrar ventana
        this.setVisible(true);
    }
}
