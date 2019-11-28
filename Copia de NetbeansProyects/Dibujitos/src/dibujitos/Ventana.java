/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujitos;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import static java.lang.Thread.sleep;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author DAM 6N
 */
public class Ventana extends JFrame {
    
    
    Panel pan = new Panel();
    public Ventana(){
        setSize(400, 400);
        setTitle("Dibujito");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pan);
    }
    private static class Panel extends JPanel{
    public void paint(Graphics g){
    super.paint(g);
    
            try {
            String im = "tenor.gif";
            BufferedImage img= ImageIO.read(new File(im));
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            
        } catch (Exception e) {
        
    }
    }
    }
}
    
