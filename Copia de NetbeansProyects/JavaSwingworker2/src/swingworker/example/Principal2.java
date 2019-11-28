package swingworker.example;

import java.util.concurrent.ExecutionException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 * Ejemplo de SwingWorker con una barra de progreso.
 * El SwingWorker hilo cuenta hasta 10 con esperas de un segundo en 
 * y actualiza  barra de progreso.
 * 
 * 
 * 
 */
public class Principal2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Principal2();
    }

    /**
     * Muestra una ventana con una etiqueta, un dialogo con un progress bar y
     * lanza un SwingWorker. Cierra la ventana de progreso cuando termina el
     * worker.
     */
    public Principal2() {
        // La ventana principal, con una etiqueta que pondr� "Hecho" cuando
        // termine el SwingWorker.
        int cont=Integer.parseInt(JOptionPane.showInputDialog(null, null, "Dime temporizador", 1));
        JFrame ventanaPrincipal = new JFrame();
        JLabel etiqueta = new JLabel("Comienza");
        ventanaPrincipal.getContentPane().add(etiqueta);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//método cerrar ventana
        ventanaPrincipal.pack(); // establezco tamaño más pequeño posible
        ventanaPrincipal.setLocationRelativeTo(null);//coloca ventana en centro
        ventanaPrincipal.setVisible(true);//hace el JFrame visible

        // Una ventana con la barra de progreso
        JProgressBar barraProgreso = new JProgressBar(0, cont);
        JDialog dialogoProgreso = new JDialog(ventanaPrincipal, "Temporizador");
        dialogoProgreso.getContentPane().add(barraProgreso);
        dialogoProgreso.pack(); //medidas pequeñas
        dialogoProgreso.setLocationRelativeTo(null); //ubicación centro

        // Hacemos visible la barra de progreso y lanzamos
        // el SwingWorker.
        dialogoProgreso.setVisible(true);
        Worker2 worker = new Worker2(etiqueta, barraProgreso, cont);
        worker.execute();
        // w.execute() devuelve el control inmediatamente, por lo que
        // no debemos ocultar la barra de progreso aqui

        // Mostramos el resultado y ocultamos la barra de progreso.
        try {
            // Esta llamada se queda bloqueada hasta que termine
            // el SwingWorker. Debemos ocultar la barra de progreso
            // inmediatamente despu�s.
            System.out.println("El resultado es " + worker.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        dialogoProgreso.setVisible(false);
    }
}
