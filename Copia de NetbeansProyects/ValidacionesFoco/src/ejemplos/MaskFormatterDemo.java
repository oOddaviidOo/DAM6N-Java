package ejemplos;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class MaskFormatterDemo extends JFrame {

    private JPanel PanelPrincipal;
    private JLabel labelMascara1, labelMascara2;
    private JFormattedTextField campoMascara1; //campo de texto formateado
    private MaskFormatter mascara1; //mascara
    private JFormattedTextField campoMascara2; //campo de texto formateado
    private MaskFormatter mascara2; //mascara

    public MaskFormatterDemo() {
        setSize(500, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Uso de MaskFormatter");
        PanelPrincipal = new JPanel(new GridLayout(2, 2, 20, 20));
        add(PanelPrincipal);
        labelMascara1 = new JLabel("Mascara 1:");
        PanelPrincipal.add(labelMascara1);
        //campo de texto1 con mascara:
        //establecemos la máscara1
        mascara1 = new MaskFormatter();
        // Entramos en un try/catch por alguna eventualidad
        try {
         // Creamos el formato de nuestra contraseña
            //# -> un número 
            //U -> letra mayúscula 
            //L -> letra minúscula
            //* -> cualquier caracter 
            //' -> caracteres de escape
            //A -> cualquier letra o número 
            //? -> cualquier caracter
            //H -> cualquier caracter hexagonal (0-9, a-f or A-F).
            mascara1 = new MaskFormatter("U#####");
        } catch (ParseException e) {
            // Algún error que pueda ocurrir
            e.printStackTrace();
        }
        //asignamos la máscara al campo de texto1
        campoMascara1 = new JFormattedTextField(mascara1);
        campoMascara1.setToolTipText("Formato de la máscara: (A-Z)#####, ejemplo: A13455 ");
        campoMascara1.setColumns(10); //tamaño del campo       
        PanelPrincipal.add(campoMascara1);
        
        labelMascara2 = new JLabel("Máscara 2:");
        PanelPrincipal.add(labelMascara2);
        mascara2 = new MaskFormatter();
        try {
            mascara2 = new MaskFormatter("UU-##-###/L");
        } catch (ParseException e) {
            // Algún error que pueda ocurrir
            e.printStackTrace();
        }
        campoMascara2 = new JFormattedTextField(mascara2);
        campoMascara2.setToolTipText("Formato de la máscara: (A-A)(A-A)-##-###/(a-z), ejemplo: AB-13-455/a ");
        campoMascara2.setColumns(10);
        PanelPrincipal.add(campoMascara2);
        //establezco un listener sólo para comprobar los valores que se introducen
        CambiaCampo cambiaCampo = new CambiaCampo();
        campoMascara1.addPropertyChangeListener("value", cambiaCampo);
        campoMascara2.addPropertyChangeListener("value", cambiaCampo);
    }
    class CambiaCampo implements PropertyChangeListener {
        public void propertyChange(PropertyChangeEvent pce) {
            if (campoMascara1.getValue()!=null) System.out.println(campoMascara1.getValue());
            if (campoMascara2.getValue()!=null) System.out.println(campoMascara2.getValue());
        }
    }
    public static void main(String[] args) {
        (new MaskFormatterDemo()).setVisible(true);
    }

}
