package ejemplos;

import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//Calcula el procentaje de una cantidad y muestra el día de hoy
public class JFormattedTextFieldDemo extends JFrame {

    private JPanel PanelPrincipal;
    private JLabel labelCantidad, labelPorcentaje, labelResultado, labelFecha;
    private JFormattedTextField campoCantidad; //campo de texto formateado
    private NumberFormat cantidadFormat; //formato numérico
    private JFormattedTextField campoPorcentaje; //campo de texto formateado
    private NumberFormat porcentajeFormat; //formato numérico
    private JFormattedTextField campoResultado; //campo de texto formateado
    private NumberFormat totalFormat; //formato numérico
    private JFormattedTextField campoFecha; //campo de texto formateado
    private DateFormat fechaFormat; //formato fecha
    
    public JFormattedTextFieldDemo() {
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Porcentajes con formatos");
        PanelPrincipal = new JPanel(new GridLayout(4, 2, 20, 20));
        add(PanelPrincipal);
        labelCantidad = new JLabel("Cantidad:");
        PanelPrincipal.add(labelCantidad);
        //campo de texto cantidad con formato:
        cantidadFormat = NumberFormat.getNumberInstance(); // se utiliza este objeto objeto para
        cantidadFormat.setMinimumFractionDigits(2); //numero mínimo de dígitos decimales
        //traducir el valor del campo a texto y el texto al valor del campo.
        campoCantidad = new JFormattedTextField(cantidadFormat);
        campoCantidad.setValue(new Double(100000)); //valor inicial
        campoCantidad.setColumns(10); //tamaño del campo
        CambiaCampo cambiaCampo = new CambiaCampo(); //instancio un escuchador
        campoCantidad.addPropertyChangeListener("value", cambiaCampo); //se necesitan dos parámetros
        //la propiedad que cambiará y el controlador
        PanelPrincipal.add(campoCantidad);

        labelPorcentaje = new JLabel("Porcentaje:");
        PanelPrincipal.add(labelPorcentaje);
        //campo de texto porcentaje con formato:
        porcentajeFormat = NumberFormat.getNumberInstance();

        campoPorcentaje = new JFormattedTextField(porcentajeFormat);
        campoPorcentaje.setValue(new Integer(10));
        campoPorcentaje.setColumns(10);
        campoPorcentaje.addPropertyChangeListener("value", cambiaCampo);
        PanelPrincipal.add(campoPorcentaje);

        labelResultado = new JLabel("Resultado:");
        PanelPrincipal.add(labelResultado);
        //campo de texto total con formato:
        totalFormat = NumberFormat.getCurrencyInstance(); //formato moneda
        campoResultado = new JFormattedTextField(totalFormat);
        campoResultado.setValue(calculaTotal(100000, 10));
        campoResultado.setColumns(10);
        campoResultado.setEditable(false);
        campoResultado.setForeground(Color.red);
        PanelPrincipal.add(campoResultado);
        
        //campo fecha con formato
        labelFecha = new JLabel("Estamos a día:");
        PanelPrincipal.add(labelFecha);
        //campo de texto total con formato:
        fechaFormat = DateFormat.getDateInstance();
        campoFecha = new JFormattedTextField(fechaFormat);
        campoFecha.setValue(new Date());
        campoFecha.setColumns(10);
        campoFecha.setEditable(false);
        PanelPrincipal.add(campoFecha);
    }

    private double calculaTotal(double cantidad, int porcentaje) {
        double resultado = 0.0;
        resultado = (cantidad * porcentaje) / 100;
        return resultado;

    }

    //escuchador para cambio de propiedades vincula de un Bean, todos los componentes Swing son Beans
    //este evento se genera si ha habido cambios justo antes de perder el foco por tab o por ratón
    class CambiaCampo implements PropertyChangeListener {

        //llamado cuando la propiedad de "value" de un campo cambia
        public void propertyChange(PropertyChangeEvent pce) {
            //obtener el valor de un JFormattedTextField
            double cantidad = ((Number) campoCantidad.getValue()).doubleValue();
            int porcentaje = ((Number) campoPorcentaje.getValue()).intValue();
             
            campoResultado.setValue(calculaTotal(cantidad,porcentaje));
            
        }
    }

    public static void main(String[] args) {
        (new JFormattedTextFieldDemo()).setVisible(true);
    }

}
