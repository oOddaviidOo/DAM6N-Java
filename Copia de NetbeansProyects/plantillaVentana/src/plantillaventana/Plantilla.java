/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantillaventana;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author DAM 6N
 */
public class Plantilla extends JFrame{
    public JPanel panel=new JPanel();
    private GridLayout ly=new GridLayout(3, 2, 10, 10);
    public Plantilla(){
    setTitle("Titulo");
    setSize(400,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(ly);

        add(panel);
    }
}
