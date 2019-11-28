/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ahorcado;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * $(name}
* Creada el 15 nov. 2019, hora
*Desarrollada por David en la empresa IES ABASTOS el dia 15 nov. 2019
*
*Puede contactar conmigo en $(mail}
*
/**
*  
*@author David
*@version 1.0
*@date 15 nov. 2019
 */
public class Ventana extends JFrame{
JButton imagenBoton;
  JPanel panelPrincipal;
  JPanel panelIzda;
  JPanel panelDcha;
  JPanel panelDcha1;
  JPanel panelDcha2;
  TitledBorder title;
  JLabel e1;
  JButton botonJ1;
  
  public Ventana() {
    this.imagenBoton = new JButton();


    
    this.e1 = new JLabel("Palabra a adivinar");
    this.botonJ1 = new JButton("Aceptar");
    this.palabraAdivinar = new JPasswordField();
    
    this.e2 = new JLabel("Letra");
    this.letra = new JTextField();
    this.botonJ2 = new JButton("Aceptar");
    this.muestraAciertos = new JLabel();
    this.errores = 0;
    this.aciertos = 0;
    this.vecAdivinar = null;




    
    setSize(700, 500);
    setTitle("Juego del ahorcado");
    setDefaultCloseOperation(3);
    setLocationRelativeTo(null);
    
    this.imgs = new ImageIcon[5];
    
    this.imgs[0] = new ImageIcon(getClass().getResource("foto1.png"));
    this.imgs[1] = new ImageIcon(getClass().getResource("foto2.png"));
    this.imgs[2] = new ImageIcon(getClass().getResource("foto3.png"));
    this.imgs[3] = new ImageIcon(getClass().getResource("foto4.png"));
    this.imgs[4] = new ImageIcon(getClass().getResource("foto5.png"));



    
    this.panelPrincipal = new JPanel();
    this.panelPrincipal.setLayout(new GridLayout(1, 2, 5, 5));
    add(this.panelPrincipal);

    
    this.imagenBoton.setIcon(this.imgs[0]);
    this.panelIzda = new JPanel();
    this.title = BorderFactory.createTitledBorder("Imagen");
    this.panelIzda.setBorder(this.title);
    this.panelIzda.add(this.imagenBoton);
    this.panelPrincipal.add(this.panelIzda);

    
    this.panelDcha = new JPanel();
    this.panelDcha.setLayout(new GridLayout(2, 1, 5, 5));
    this.panelPrincipal.add(this.panelDcha);

    
    this.panelDcha1 = new JPanel();
    this.title = BorderFactory.createTitledBorder("Jugador1");
    this.panelDcha1.setBorder(this.title);
    this.panelDcha1.setLayout(new GridLayout(3, 1, 20, 20));
    this.panelDcha1.add(this.e1);
    this.panelDcha1.add(this.palabraAdivinar);
    this.panelDcha1.add(this.botonJ1);
    this.panelDcha.add(this.panelDcha1);

    
    this.panelDcha2 = new JPanel();
    this.title = BorderFactory.createTitledBorder("Jugador2");
    this.panelDcha2.setLayout(new GridLayout(4, 1, 20, 20));
    this.panelDcha2.add(this.e2);
    this.panelDcha2.add(this.letra);
    this.panelDcha2.add(this.botonJ2);
    this.muestraAciertos.setFont(new Font("Tahoma", 1, 40));
    this.muestraAciertos.setForeground(Color.red);
    this.panelDcha2.add(this.muestraAciertos);
    this.panelDcha2.setBorder(this.title);
    this.panelDcha.add(this.panelDcha2);
    this.letra.setEnabled(false);
    this.botonJ2.setEnabled(false);

    
    this.botonJ1.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent ae) {
            Ventana.this.vecAdivinar = Ventana.this.palabraAdivinar.getPassword();
            Ventana.this.vecMostrar = Ventana.this.palabraAdivinar.getPassword();
            for (int i = 0; i < Ventana.this.vecMostrar.length; i++) {
              Ventana.this.vecMostrar[i] = '-';
            }
            Ventana.this.muestraAciertos.setText(String.valueOf(Ventana.this.vecMostrar));
            Ventana.this.letra.setEnabled(true);
            Ventana.this.botonJ2.setEnabled(true);
            Ventana.this.palabraAdivinar.setEnabled(false);
            Ventana.this.botonJ1.setEnabled(false);
          }
        });

    
    this.botonJ2.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent ae) {
            if (Ventana.this.letra.getText().length() != 1) {
              JOptionPane.showMessageDialog(null, "Escribe solamente una letra");
              Ventana.this.letra.setText("");
            } else {
              Ventana.this.compruebaLetra(Ventana.this.letra.getText().toCharArray());
              Ventana.this.letra.setText("");
            } 
          }
        });
  }
  JPasswordField palabraAdivinar; JLabel e2; JTextField letra; JButton botonJ2; JLabel muestraAciertos; int errores; int aciertos; char[] vecAdivinar; char[] vecMostrar; private ImageIcon[] imgs;
  
  public void compruebaLetra(char[] c) {
    int aciertosparcial = 0;
    for (int i = 0; i < this.vecAdivinar.length; i++) {
      if (this.vecAdivinar[i] == c[0]) {
        this.vecMostrar[i] = c[0];
        this.muestraAciertos.setText(String.valueOf(this.vecMostrar));
        aciertosparcial++;
        this.aciertos++;
      } 
    } 
    if (aciertosparcial == 0) {
      this.errores++;
      this.imagenBoton.setIcon(this.imgs[this.errores]);
    } 
    if (this.aciertos == this.vecAdivinar.length) {
      JOptionPane.showMessageDialog(null, "HAS GANADO!!!");
      this.letra.setEnabled(false);
      this.botonJ2.setEnabled(false);
    } 
    if (this.errores == 4) {
      JOptionPane.showMessageDialog(null, "HAS PERDIDO!!!");
      this.letra.setEnabled(false);
      this.botonJ2.setEnabled(false);
    } 
  } }

