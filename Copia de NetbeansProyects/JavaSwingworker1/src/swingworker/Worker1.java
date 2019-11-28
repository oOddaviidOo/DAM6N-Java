package swingworker;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 * Ejemplo de SwingWoker.
 * El tipo de resultado a devolver es un Double. 
 * void es el tipo de dato si informamos del avance (no en este caso) 
 * 
 */
public class Worker1 extends SwingWorker<Double, Integer> {
    /** JLabel en el que se marcara que ha terminado el trabajo */
    private final JLabel etiqueta;
    private int c=0;

    /**
     * Se le pasa el JLabel en el que se quiere que se ponga la palabra "Hecho"
     * cuando el SwingWoker haya terminado.
     * 
     * @param unaEtiqueta
     */
    public Worker1(JLabel unaEtiqueta, int c) {
        etiqueta = unaEtiqueta;
        this.c=c;
    }

    /**
     * Tarea que tarda mucho y que queremos que se ejecute en un hilo separado.
     */
    @Override
    protected Double doInBackground() throws Exception {
        System.out.println("doInBackground() esta en el hilo "
                + Thread.currentThread().getName());

        // Un simbre bucle hasta 10, con esperas de un segundo entre medias.
        for (int i = 0; i < 10; i++) {
            try {
                c++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("interrumpido");
            }
            publish(c);
        }
        // devuevlo resultado
        return 100.0;
    }

    /**
     * Cuando termine la tarea, SwingWorker llama a done a este metodo en el hilo de
     * despacho de eventos(importante!!).
     * Aqui es donde debemos actualizar el JLabel.
     */
    @Override
    protected void done() {
        System.out.println("done() esta en el hilo "  + Thread.currentThread().getName());
        etiqueta.setText("hecho");
    }
 
    @Override
    protected void process(List<Integer> chunks) {
        System.out.println("process() esta en el hilo "
                + Thread.currentThread().getName());
        etiqueta.setText("Contador: "+ chunks.get(0));
    }
    
}
