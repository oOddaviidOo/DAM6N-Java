/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pintarcanvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author DAM 6N
 */
public class ventana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Canvas c = new Canvas();
        c.setVisible(true);
        for (int z = 0; z < 80; z++) {
            c.i+=10;
            c.p.repaint();
            try {
                sleep(100);
            } catch (InterruptedException ex) {
            }

        }

    }
}

class Canvas extends JFrame {

    public Panel p = new Panel();
    public int i = 0;
    public int j = 0;

    public Canvas() {
        setTitle("Dibujar");
        setBounds(0, 0, 700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.white);
        add(p);
    }
    
    

    public class Panel extends JPanel {

        @Override
        public void paint(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillOval(10, 10, 20, 20);
        }

    }

}
