/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.cosa.nueva;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DAM 6N
 */
public class Ventana extends JFrame{
int x=-100,y=-100;
int disparos=10;
    JLabel j;


    public Ventana() {
        setTitle("Ejemplo Cosa Nueva");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Panel p=new Panel();
        j=new JLabel("Disparos:     "+disparos);
        BorderLayout bl=new BorderLayout();
        p.setLayout(bl);
        p.add(j, bl.SOUTH);
        add(p);
        
    }
 
    public class Panel extends JPanel implements MouseListener{

        public Panel() {
        this.addMouseListener(this);
        }

        public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 10, 10);
        }
        
        @Override
        public void mouseClicked(MouseEvent me) {
            x=me.getX();
            y=me.getY();
            repaint();
            disparos--;
            j.setText("Disparos:     "+disparos);
            if (disparos==0) {
            JFrame frame=new JFrame("Derrota");
            JOptionPane.showMessageDialog(frame, "Derrota, no te quedan tiros");
            System.exit(0);
        }
        }
        @Override
        public void mousePressed(MouseEvent me) {
            
        }
        @Override
        public void mouseReleased(MouseEvent me) {
            
        }
        @Override
        public void mouseEntered(MouseEvent me) {
            
        }
        @Override
        public void mouseExited(MouseEvent me) {
            
            
        }
        
    }
    
    
}
