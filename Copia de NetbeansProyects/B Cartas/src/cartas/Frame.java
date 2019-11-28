
package cartas;

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


public class Frame extends JFrame implements ActionListener {

    private JPanel panelGlobal, panelJuego;
    private TitledBorder b1;

    private final String[] images = {"/images/espadas.png",
        "/images/bastos.png", "/images/oros.png", "/images/copas.png", "/images/dorso.png"};
    private Image image;
    private JButton[] cartas;

    private int dinero, apostado, paloElegido, cont, contTot;

    private JLabel credito;
    private JTextField apuesta;
    private JComboBox palo;
    private String[] palos = {"Espadas", "Bastos", "Oros", "Copas"};
    private JButton apostar;

    private final JLabel empty0 = new JLabel(" ");

    public Frame() {
        ventana();
        cartas = new JButton[6];

        //crearCarta
        crearCarta();
        //panelJuego
        panelJuego();
        //panelGlobal
        panelGlobal();
    }

    private void ventana() {
        setTitle("Juego de cartas");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void crearCarta() {
        image = new ImageIcon(this.getClass().getResource(images[4])).getImage();
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = new JButton("");
            cartas[i].setActionCommand("carta" + i);
            cartas[i].setIcon(new ImageIcon(image));
            cartas[i].setEnabled(false);
            cartas[i].addActionListener(this);
        }
    }

    private void cambiarCarta(int numCarta) {
        cartas[numCarta].setIcon(new ImageIcon(asignarCarta()));
        cartas[numCarta].setEnabled(false);
        cartaPulsada();
    }

    private void panelJuego() {
        panelJuego = new JPanel(new GridLayout(4, 1, 20, 20));

        //bordes
        b1 = BorderFactory.createTitledBorder("Panel de juego");
        panelJuego.setBorder(b1);

        //dar credito
        dinero = Integer.parseInt(JOptionPane.showInputDialog(null, null, "Dime dinero", WIDTH));
        credito = new JLabel();
        credito.setText("Credito: " + dinero);

        apuesta = new JTextField();
        palo = new JComboBox(palos);
        apostar = new JButton("Apostar");
        apostar.setActionCommand("apostar");

        apostar.addActionListener(this);

        panelJuego.add(credito);
        panelJuego.add(apuesta);
        panelJuego.add(palo);
        panelJuego.add(apostar);
    }

    private void panelGlobal() {
        panelGlobal = new JPanel(new GridLayout(2, 4, 20, 20));

        añadirPaneles();
    }

    private void añadirPaneles() {
        panelGlobal.add(cartas[0]);
        panelGlobal.add(cartas[1]);
        panelGlobal.add(cartas[2]);
        panelGlobal.add(panelJuego);
        panelGlobal.add(cartas[3]);
        panelGlobal.add(cartas[4]);
        panelGlobal.add(cartas[5]);
        panelGlobal.add(empty0);

        add(panelGlobal);
    }

    private Image asignarCarta() {
        image = new ImageIcon(this.getClass().getResource(images[numRandom()])).getImage();
        return image;
    }

    private int numRandom() {
        int numero = (int) (Math.random() * 4 + 0);
        if (numero == paloElegido) {
            cont++;
        }
        return numero;
    }

    private void restart() {
        apostado = 0;
        paloElegido = 0;
        cont = 0;
        contTot = 0;
        image = new ImageIcon(this.getClass().getResource(images[4])).getImage();
        for (JButton c : cartas) {
            c.setEnabled(false);
            c.setIcon(new ImageIcon(image));
        }
        apuesta.setEnabled(true);
        apostar.setEnabled(true);
        palo.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() instanceof JButton) {
            switch (ae.getActionCommand()) {
                case "apostar":
                    if (apuesta.getText().length() > 0) {
                        apostado = Integer.parseInt(apuesta.getText());
                        if (apostado <= dinero) {
                            cont = 0;
                            apuesta.setEnabled(false);
                            apostar.setEnabled(false);
                            palo.setEnabled(false);
                            for (JButton c : cartas) {
                                c.setEnabled(true);
                            }
                            paloElegido = palo.getSelectedIndex();
                        }
                    }
                    break;
                case "carta0":
                    cambiarCarta(0);
                    break;
                case "carta1":
                    cambiarCarta(1);
                    break;
                case "carta2":
                    cambiarCarta(2);
                    break;
                case "carta3":
                    cambiarCarta(3);
                    break;
                case "carta4":
                    cambiarCarta(4);
                    break;
                case "carta5":
                    cambiarCarta(5);
                    break;
                default:
                    System.out.println("ERROR");
            }
        }

    }

    private void cartaPulsada() {
        contTot++;
        if (contTot == 6) {
            comprobar();
        }
    }

    private void comprobar() {
        if (cont < 2) {
            JOptionPane.showMessageDialog(this, "Has perdido " + apostado + " euros, NOOB!", "Resultado", 1);
            dinero -= apostado;
            credito.setText("Credito: " + dinero);

        } else {
            JOptionPane.showMessageDialog(this, "Has ganado " + apostado + " euros", "Resultado", 1);
            dinero += apostado;
            credito.setText("Credito: " + dinero);
        }
        restart();
    }

}
