/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package check;

import java.awt.FlowLayout;
 import java.awt.Font;
 import java.awt.event.ItemListener;
 import java.awt.event.ItemEvent;
 import javax.swing.JFrame;
 import javax.swing.JTextField;
 import javax.swing.JCheckBox;
 public class VentanaCheck extends JFrame{
 private JTextField campoTexto; // muestra el texto en tipos de letra cambiantes
 private JCheckBox negritaJCheckBox; // para seleccionar/deseleccionar negrita
 private JCheckBox cursivaJCheckBox; // para seleccionar/deseleccionar cursiva
 // El constructor de MarcoCasillaVerificacion agrega objetos JCheckBox a JFrame
 public VentanaCheck(){
 setTitle( "Prueba de JCheckBox" );
 setLayout( new FlowLayout() );
 // establece JTextField y su tipo de letra
 campoTexto = new JTextField( "Observe como cambia el estilo de tipo de letra", 20 );
 campoTexto.setFont( new Font( "Serif", Font.PLAIN, 14 ) );
 add( campoTexto ); // agrega campoTexto a JFrame
 negritaJCheckBox = new JCheckBox( "Negrita" ); // crea casilla de verificación "negrita"
 cursivaJCheckBox = new JCheckBox( "Cursiva" ); // crea casilla de verificación "cursiva"
 add( negritaJCheckBox ); // agrega casilla de verificación "negrita" a JFrame
 add( cursivaJCheckBox ); // agrega casilla de verificación "cursiva" a JFrame
 // listener de JCheckBox
 ManejadorCheckBox manejador = new ManejadorCheckBox(); 
 negritaJCheckBox.addItemListener( manejador );
 cursivaJCheckBox.addItemListener( manejador );
 }
 // clase para el escuchador de los JCheckBox, en este caso no es un ActionListener como en los botones, es un ItemListener
 private class ManejadorCheckBox implements ItemListener{
 private int valNegrita = Font.PLAIN; // controla el estilo de tipo de letra negrita
 private int valCursiva = Font.PLAIN; // controla el estilo de tipo de letra cursiva
 // cuando cambia el estado de un JCheckBox:
 public void itemStateChanged( ItemEvent evento ){
 // procesa los eventos de la casilla de verificación "negrita"
 if ( evento.getSource() == negritaJCheckBox )
 valNegrita = negritaJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;
 // procesa los eventos de la casilla de verificación "cursiva"
 if ( evento.getSource() == cursivaJCheckBox )
 valCursiva = cursivaJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;
 // establece el tipo de letra del campo de texto
 campoTexto.setFont( new Font( "Serif", valNegrita + valCursiva, 14 ) );
 }
 }
 }
