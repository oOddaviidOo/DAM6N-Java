/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carticas;


import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Ventanica
  extends JFrame
  implements ActionListener
{
  private JPanel panelGlobal;
  private JPanel panelJuego;
  private TitledBorder b1;
  private final String[] images;
  private Image image;
  private JButton[] cartas;
  private int dinero;
  private int apostado;
  private int paloElegido; 
  private int cont; 
  private int contTot; 
  private JLabel credito; 
  private JTextField apuesta; 
  private JComboBox palo; 
  private String[] palos; 
  private JButton apostar; 
  private final JLabel empty0;
  
  public Ventanica() {
    //array con ruta de imagenes de los palos e incluyendo dorso de carta
    this.images = new String[] { "/images/espadas.png", "/images/bastos.png", 
    "/images/oros.png", "/images/copas.png", "/images/dorso.png" };
    
    //array con nombres de los palos, que hara referencia al indice de imagen
    this.palos = new String[] { "Espadas", "Bastos", "Oros", "Copas" };
    
    //Etiqueta en blanco, supongo para llenar hueco del grid
    this.empty0 = new JLabel(" ");
    
    //Llama al constructor
    ventana();
    //Define un array de botones para llenar el panel global
    this.cartas = new JButton[6];
    
    crearCarta();
    
    panelJuego();
    
    panelGlobal();
  }
  
  
  //constructor
  private void ventana() {
    setTitle("Juego de cartas");
    setSize(600, 450);
    setDefaultCloseOperation(3);
  }
  
  private void crearCarta() {
      //pone la imagen de una carta a la imagen del dorso
    this.image = (new ImageIcon(getClass().getResource(this.images[4]))).getImage();
    //para las 6 cartas...
    for (int i = 0; i < this.cartas.length; i++) {
      //crea el botón en el array de botones llamado cartas
      this.cartas[i] = new JButton("");
      //define un comando de accion
      this.cartas[i].setActionCommand("carta" + i);
      //añade this.image (definida arriba como dorso) al boton en la posicion i
      this.cartas[i].setIcon(new ImageIcon(this.image));
      //deshabilita el clicar el boton
      this.cartas[i].setEnabled(false);
      //agrega el boton al escuchador
      this.cartas[i].addActionListener(this);
    } 
  }
  
  
  private void panelJuego() {
      //crea el panel de juego con 4 filas y 1 columna
    this.panelJuego = new JPanel(new GridLayout(4, 1, 20, 20));

    //crea un titleBorder con el titulo panel de juego
    this.b1 = BorderFactory.createTitledBorder("Panel de juego");
    //lo añade
    this.panelJuego.setBorder(this.b1);

    //Muestra el inputDialog pidiendo dinero y asigna el valor a la variable 
    this.dinero = Integer.parseInt(JOptionPane.showInputDialog(null, null, "Dime dinero", 1));
    this.credito = new JLabel();
    this.credito.setText("Credito: " + this.dinero);
    
    this.apuesta = new JTextField();
    this.palo = new JComboBox(this.palos);
    this.apostar = new JButton("Apostar");
    this.apostar.setActionCommand("apostar");
    
    this.apostar.addActionListener(this);
    
    this.panelJuego.add(this.credito);
    this.panelJuego.add(this.apuesta);
    this.panelJuego.add(this.palo);
    this.panelJuego.add(this.apostar);
  }
  
  private void panelGlobal() {
    this.panelGlobal = new JPanel(new GridLayout(2, 4, 20, 20));
    
    añadirPaneles();
  }
  
  private void añadirPaneles() {
    this.panelGlobal.add(this.cartas[0]);
    this.panelGlobal.add(this.cartas[1]);
    this.panelGlobal.add(this.cartas[2]);
    this.panelGlobal.add(this.panelJuego);
    this.panelGlobal.add(this.cartas[3]);
    this.panelGlobal.add(this.cartas[4]);
    this.panelGlobal.add(this.cartas[5]);
    this.panelGlobal.add(this.empty0);
    
    add(this.panelGlobal);
  }
  
  //devuelve un numero aleatorio
  private int numRandom() {
    int numero = (int)(Math.random() * 4.0D + 0.0D);
    //si el numero aleatorio es igual al palo elegido se aumenta el contador
    if (numero == this.paloElegido) {
      this.cont++;
    }
    return numero;
  }
  

  //ejecuta acciones segun el action command
  public void actionPerformed(ActionEvent ae) {
      //
    if (ae.getSource() instanceof JButton) {
      switch (ae.getActionCommand()) {
        case "apostar":
          if (this.apuesta.getText().length() > 0) {
            this.apostado = Integer.parseInt(this.apuesta.getText());
            if (this.apostado <= this.dinero) {
              this.cont = 0;
              this.apuesta.setEnabled(false);
              this.apostar.setEnabled(false);
              this.palo.setEnabled(false);
              for (JButton c : this.cartas) {
                c.setEnabled(true);
              }
              this.paloElegido = this.palo.getSelectedIndex();
            } 
          } 
          return;
          //dependiendo del actioncommand cambia la carta i
        case "carta0":
          cambiarCarta(0);
          return;
        case "carta1":
          cambiarCarta(1);
          return;
        case "carta2":
          cambiarCarta(2);
          return;
        case "carta3":
          cambiarCarta(3);
          return;
        case "carta4":
          cambiarCarta(4);
          return;
        case "carta5":
          cambiarCarta(5);
          return;
      } 
      System.out.println("ERROR");
    } 
  }
  ///cambia la carta segun el switch de antes
  private void cambiarCarta(int numCarta) {
      //devuelve una imagen aleatoria a la carta numCarta
    this.cartas[numCarta].setIcon(new ImageIcon(asignarCarta()));
    this.cartas[numCarta].setEnabled(false);
    cartaPulsada();
  }
    
    //elige una imagen random del array de imagenes y la devuelve
    private Image asignarCarta() {
    this.image = (new ImageIcon(getClass().getResource(this.images[numRandom()]))).getImage();
    return this.image;
  }
  
  private void cartaPulsada() {
    this.contTot++;
    if (this.contTot == 6) {
      comprobar();
    }
  }
  
  private void comprobar() {
      //si el contador es menor a 2 (no hay dos cartas del palo elegido)
    if (this.cont < 2) {
        //muestra derrota, resta del dinero lo apostado, y muestra el dinero restante
      JOptionPane.showMessageDialog(this, "Has perdido " + this.apostado + " euros, NOOB!", "Resultado", 1);
      this.dinero -= this.apostado;
      this.credito.setText("Credito: " + this.dinero);
    } else {
      //muestra victoria, suma del dinero lo apostado, y muestra el dinero restante
      JOptionPane.showMessageDialog(this, "Has ganado " + this.apostado + " euros", "Resultado", 1);
      this.dinero += this.apostado;
      this.credito.setText("Credito: " + this.dinero);
    } 
    restart();
  }
  
    private void restart() {
        //pone todo a 0
    this.apostado = 0;
    this.paloElegido = 0;
    this.cont = 0;
    this.contTot = 0;
    //pone la variable imagen al dorso
    this.image = (new ImageIcon(getClass().getResource(this.images[4]))).getImage();
    //pone todos los botones de cartas con el dorso y las deshabilita
    for (JButton c : this.cartas) {
      c.setEnabled(false);
      c.setIcon(new ImageIcon(this.image));
    } 
    //habilita el boton de apostar, el combo de palos y el campo de apuesta
    this.apuesta.setEnabled(true);
    this.apostar.setEnabled(true);
    this.palo.setEnabled(true);
  }
  
}
