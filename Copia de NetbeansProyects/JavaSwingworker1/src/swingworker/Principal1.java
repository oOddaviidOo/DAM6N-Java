package swingworker;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Ejemplo de SwingWorker. 
 * Una tarea que cuenta de 1 a 10 con esperas de un
 * segundo y al final marca en una etiqueta que esta hecho.
 * Se trata de comprobar que la tarea se ejecuta en un hilo separado y la
 * actualizacion de la etiqueta (JLabel) en el hilo de despacho de eventos.
 * 
 * 
 */
public class Principal1 {
        int c=Integer.parseInt(JOptionPane.showInputDialog(null, null, "Dime temporizador", 1));
        JButton b=new JButton("Start");
        JLabel etiqueta = new JLabel("Contador: "+ c);
        Worker1 worker = new Worker1(etiqueta, c);
        
    public static void main(String[] args) {
        try {
            Principal1 principal1 = new Principal1();
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Abre una ventana con una etiqueta y lanza un SwingWorker.
     */
    public Principal1() throws InterruptedException {
        // La venana principal 
        // al inicio pone sin hacer
        // mientras se ejecuta hilo en background
        
        JFrame ventanaPrincipal = new JFrame();
        JPanel p=new JPanel();
        ventanaPrincipal.setTitle("Juego de cartas");
        ventanaPrincipal.setSize(100, 100);
        ventanaPrincipal.getContentPane().add(etiqueta);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //método cerrar ventana
        ventanaPrincipal.setLocationRelativeTo(null);//coloca ventana en centro
        ventanaPrincipal.setVisible(true);//hace el JFrame visible
        b.addActionListener(new Escuchador());
        p.add(etiqueta);
        p.add(b);
        ventanaPrincipal.add(p);
        
        
        // Se lanza el hilo SwingWorker pasamos etiqueta
        
        
        

        try {
            // Se recoge el resultado del SwingWorker. Esta
            // llamada se queda bloqueada hasta que termine
            // de trabajar el SwingWorker.
            System.out.println("El resultado es " + worker.get());
        } catch (ExecutionException ex) {
            Logger.getLogger(Principal1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    class Escuchador implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) throws UnsupportedOperationException{
        worker.execute();
    }
    
}

}
