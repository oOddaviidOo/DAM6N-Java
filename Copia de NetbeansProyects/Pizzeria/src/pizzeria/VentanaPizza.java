/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author DAM 6N
 */
public class VentanaPizza extends JFrame{
    private final String[] tamaño={"pequeña", "mediana", "grande"};
    private final String[] masas={"Delgada", "Gruesa"};
    private final String[] ingredientes={"Peperoni", "Salchicha", "Parmesano","Olivas", 
                    "Champi","Tomates","Anchoas","Pollo", "Ternera","Salsa Barbacoa"};
    private final String[] labels={"Nombre", "Telefono", "Direccion"};
    private final String[] bordes={"Tamaño", "Masas", "Ingredientes"};
    //pequeña, grande, mediana, delgada, gruesa
    public JRadioButton[] rb=new JRadioButton[5];
    //"Peperoni", "Salchicha", "Parmesano","Olivas", 
    //"Champi","Tomates","Anchoas","Pollo", "Ternera","Salsa Barbacoa"
    public JCheckBox[] cb=new JCheckBox[10];
    //haga su pedido ahora, nombre, telefono, direccion
    public JLabel[] l=new JLabel[4];
    //nombre, telefono, direccion
    public JTextField[] tf=new JTextField[3];
    //aceptar, cancelar
    public JButton b0=new JButton("Aceptar"),
        b1=new JButton("Salir");
    //bordes titulo
    public TitledBorder[] tb=new TitledBorder[3];
    public JTextArea jta=new JTextArea();
    
    public ButtonGroup bg=new ButtonGroup();
    public ButtonGroup bg1=new ButtonGroup();
    
    
    
    public VentanaPizza() {
        setTitle("Pedido Pizza");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        //Todo
        BorderLayout bola=new BorderLayout();
        //Nombre, tlf, direccion, tamaño, masa, ingredientes
        GridLayout gl1=new GridLayout(2, 1);
        //Nombre, tlf, direccion
        GridLayout gl2=new GridLayout(3, 2);
        //Tamaño, masa, ingredientes
        GridLayout gl25=new GridLayout(1, 3);
        //tamaño
        GridLayout gl3=new GridLayout(3, 1);
        //masa
        GridLayout gl4=new GridLayout(2, 1);
        //ingredientes
        GridLayout gl5=new GridLayout(4, 3);
        //botones
        FlowLayout fl=new FlowLayout(2);
        //todo
        JPanel panelPrincipal=new JPanel();
        //panel para clientes y pizza
        JPanel panelClientePizza=new JPanel();
        //aceptar, salir
        JPanel panelImprimir=new JPanel();
        //Nombre, tlf etc
        JPanel panelCliente=new JPanel();
        //Tamaño, masa, ingredientes
        JPanel panelPizza=new JPanel();
        //tamaño
        JPanel panelTamaño=new JPanel();
        //masa
        JPanel panelMasa=new JPanel();
        //ingredientes
        JPanel panelIngredientes=new JPanel();
        
                //botones aceptar y salir
        b0.addActionListener(new EscuchadorBoton());
        b1.addActionListener(new EscuchadorBoton());
            
        //puestos los layout
        panelPrincipal.setLayout(bola);
        panelClientePizza.setLayout(gl1);
        panelCliente.setLayout(gl2);
        panelPizza.setLayout(gl25);
        panelTamaño.setLayout(gl3);
        panelMasa.setLayout(gl4);
        panelIngredientes.setLayout(gl5);
        panelImprimir.setLayout(fl);
        
        
        //añadidos paneles a cada panels y el principal a la ventana
        add(panelPrincipal);
        panelPrincipal.add(panelClientePizza, bola.CENTER);
        panelPrincipal.add(panelImprimir, bola.SOUTH);
        panelImprimir.add(b0); panelImprimir.add(b1);
        panelClientePizza.add(panelCliente);
        panelClientePizza.add(panelPizza);
        panelPizza.add(panelTamaño);
        panelPizza.add(panelMasa);
        panelPizza.add(panelIngredientes);
        
        //tamaño
        for (int i = 0; i < tamaño.length; i++) {
            rb[i]=new JRadioButton();
            rb[i].setText(tamaño[i]);
            panelTamaño.add(rb[i]);
                    bg.add(rb[i]);
        }

        //masa
            rb[3]=new JRadioButton();
            rb[4]=new JRadioButton();
            rb[3].setText(masas[0]);
            rb[4].setText(masas[1]);
            bg1.add(rb[3]);
            bg1.add(rb[4]);
            panelMasa.add(rb[3]);
            panelMasa.add(rb[4]);

        
        //ingredientes
        for (int i = 0; i < ingredientes.length; i++) {
            cb[i]=new JCheckBox();
            cb[i].setText(ingredientes[i]);
            panelIngredientes.add(cb[i]);
        }
        //cliente y cabecera
        l[0]=new JLabel("Haga su pedido ahora");
        Font f=new Font("Calibri", 1, 30);
        l[0].setFont(f);
        panelPrincipal.add(l[0], bola.NORTH);
        
        for (int i = 0; i < labels.length; i++) {
            l[i]=new JLabel();
            l[i].setText(labels[i]);
        }
        //campos de cliente
        for (int i = 0; i < 3; i++) {
            tf[i]=new JTextField();
        }
        //añadidos al panel cliente los label y textfield
        panelCliente.add(l[0]);
        panelCliente.add(tf[0]);
        panelCliente.add(l[1]);
        panelCliente.add(tf[1]);
        panelCliente.add(l[2]);
        panelCliente.add(tf[2]);
        //creados bordes con titulo y añadidos
        for (int i = 0; i < bordes.length; i++) {
            tb[i]=new TitledBorder(bordes[i]);
        }
        panelTamaño.setBorder(tb[0]);
        panelMasa.setBorder(tb[1]);
        panelIngredientes.setBorder(tb[2]);

    }
    

    public class EscuchadorBoton implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) throws UnsupportedOperationException{
        Object source=ae.getSource();
        if (source==b0) {
            imprimir();
        }
        if (source==b1) {
            System.exit(0);
        }
    }
}

    
    public void imprimir(){
        for (int i = 0; i < 3; i++) {
            jta.append(tf[i].getText());
            jta.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            if (rb[i].isSelected()) {
                jta.append(rb[i].getText());
                jta.append(", ");
            }
        }

            if (rb[3].isSelected()) {
                jta.append(rb[3].getText());
                
            }
            if (rb[4].isSelected()) {
            jta.append(rb[4].getText());
            
        }
        jta.append("\n");
        for (int i = 0; i < 10; i++) {
            if (cb[i].isSelected()) {
                jta.append(cb[i].getText());
                if (i<9) {
                    jta.append(", ");
                }
            }
        }
        try {
            jta.print();
        } catch (PrinterException ex) {
            Logger.getLogger(VentanaPizza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

