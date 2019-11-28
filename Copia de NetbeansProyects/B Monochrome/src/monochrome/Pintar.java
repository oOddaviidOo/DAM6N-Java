
package monochrome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;


public class Pintar implements ActionListener{
    private JTextArea textarea;
    private JTextField textfield;
    private int x;

    public Pintar(JTextArea textarea, JTextField textfield) {
        this.textarea = textarea;
        this.textfield = textfield;
        this.x = 16;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String orden = textfield.getText();
        if(orden.matches("^[1-4]{0,4}[xX]$")){
            String text = this.textarea.getText();
            if(text.length() == 0){
                // NO HAY CONTENIDO EN EL TEXTAREA
                JOptionPane.showMessageDialog(
                    null, 
                    "Inicia antes el juego.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);
            }else {
                // TODO OK
                String[] lineas = text.split("\r\n");
                
                int indices[] = calcularIndices(orden);
                String concat = "";
                for(int i = 0; i < lineas.length; i++){
                    for(int j = 0; j < lineas[i].length(); j++){
                        if(j >= indices[0] && j <= indices[1] && i >= indices[2] && i<= indices[3]){
                            concat+= "X";
                        }else {
                            concat += lineas[i].substring(j, j+1);
                        }
                    }
                    concat += "\r\n";
                }
                this.textarea.setText(concat);
            }            
        } else {
            // FORMATO NO VÁLIDO
            JOptionPane.showMessageDialog(
                null, 
                "El formato introducido no es válido.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public int[] calcularIndices(String orden){
        int divisiones = orden.length()-1;
        int [] indices = {0,this.x-1,0,this.x-1};
        for(int i = 0; i < divisiones; i++){
            int cuadrante = Integer.parseInt(orden.substring(i, i+1));
            indices = hacerSwitch(indices, cuadrante);
        }        
        return indices;
    }
    
    public int[] hacerSwitch(int[] indices, int cuadrante){
        //[0][15][0][15]
        int x = indices[0];  
        int y = indices[1]; 
        int x1 = indices[2];  
        int y1 = indices[3]; 
        
        switch(cuadrante){
                case 1:      
                    indices[1] = (x+y)/2;
                    indices[3] = (y1+x1)/2;
                    break;
                case 2:
                    indices[0] = (x+y)/2 + 1;
                    indices[3] = (y1+x1)/2;
                    break;
                case 3:     
                    indices[1] = (x+y)/2;
                    indices[2] = (y1+x1)/2+1;
                    indices[3] = y1;
                    break;
                case 4:
                    indices[0] = (x+y)/2 + 1;
                    indices[2] = (x1+y1)/2 + 1;
                    break;
            }
        return indices;
    }
    
}
