
package monochrome;

import java.awt.event.*;
import javax.swing.JTextArea;


public class Inicializar implements ActionListener{
    private JTextArea matriz;

    public Inicializar(JTextArea matriz) {
        this.matriz = matriz;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String [][] matriz = new String[16][16];
        String pintar = "";
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                pintar += "o";
            }
            pintar += "\r\n";
        }
        
        this.matriz.setText(pintar);
    }
    
}
