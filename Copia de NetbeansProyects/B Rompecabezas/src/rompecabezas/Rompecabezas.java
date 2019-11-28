package rompecabezas;


import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Rompecabezas extends JFrame{
    JPanel panel = new Panel();
    
    public Rompecabezas(){
        this.setSize(400, 400);
        this.setTitle("Rompecabezas");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        
        
        // creo el grid layout
        GridLayout lay = new GridLayout(4,4);
        panel.setLayout(lay);
        
        // randomizo el array
        int nums [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Random random = new Random();
        for(int i = 0; i < nums.length; i++){
            int n = random.nextInt(nums.length);
            int aux = nums[i];
            nums[i] = nums[n];
            nums[n]=aux;
            
        }
        System.out.println(Arrays.toString(nums));
        
        // añado los botones al array
        
        JButton btn;
        for(int i = 0; i < nums.length; i++){
            btn = new JButton(String.valueOf(nums[i]));
            if(nums[i] == 16){
                btn.setVisible(false);                
            }
            btn.addActionListener(new Events(panel));
            panel.add(btn);
        }
        
        this.add(panel);
        
        
    }//fin del constructor
	//clase panel para poner imagen de fondo
	class Panel extends JPanel{ 
		private BufferedImage img;
		protected void paintComponent(Graphics g) {
			try {
				img = ImageIO.read(new File("imagen.jpg"));
				super.paintComponent(g);
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			} catch(IOException e) {
				e.printStackTrace();
			}
        
		}
	}//fin de panel
	//EVENTO DE BOTONES
	class Events implements ActionListener {
		JPanel panel;
		int x,y,x16,y16;
       
		public Events (JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton[][] botonesM = new JButton[4][4];
			JButton[] botones = new JButton[16];        
			int invisible = 0;
			int cambio = 0;
                
			//System.out.println(btn.getText());
			Component[] comp = panel.getComponents();
        
			for (int i = 0; i < comp.length; i++) {             
				botones[i] = (JButton) comp[i];
			}
        
			int cont = 0;
			for(int i = 0; i < botonesM.length; i++){
				for(int j = 0; j < botonesM[i].length; j++){
					botonesM[i][j] = botones[cont];                
					if( botones[cont] == (JButton) e.getSource()){
						x = i;
						y = j;
						cambio = cont;
					} 
					if( botones[cont].getText().equals("16")){
						x16 = i;
						y16 = j;
						invisible = cont;
					}
					cont++;
				}
			}
        
			if(
					x == (x16-1) && (y == y16)
					|| x == x16 && (y+1) == y16
					|| x == x16 && (y-1) == y16
					|| (x-1) == x16 && y == y16){
            
				JButton btnI = (JButton) comp[invisible];
				JButton btnE = (JButton) comp[cambio];
				btnI.setText(btnE.getText());
				btnI.setVisible(true);
				btnE.setVisible(false);
				btnE.setText("16");       
			}
			boolean validado = true;
			for(int i = 0; i < comp.length; i++){
				JButton boton = (JButton) comp[i];
				if(Integer.parseInt(boton.getText())-1 != i){
					validado = false;
					break;
				}
			}
			if(validado == true){
				for(int i = 0; i < comp.length; i++){
					JButton boton = (JButton) comp[i];
					boton.setVisible(false);
				}
			}
		}
    
	}//FIN EVENTO
	
	
	public static void main(String[] args) {//MAIN
        new Rompecabezas().setVisible(true);
    }

}//fin de frame
