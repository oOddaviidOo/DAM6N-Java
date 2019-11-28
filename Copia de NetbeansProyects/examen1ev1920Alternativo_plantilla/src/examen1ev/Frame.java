package examen1ev;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;

public class Frame extends JFrame {

    JPanel panelPrincipal;
    //Matriz de string con los datos iniciales, 
    //el programa debe funcionar si se añaden, eliminan o modifican "líneas":
    String[][] datosIniciales = {
        /*j*/
        /*i*/{"Primero", "imagen", "1.png", "2.png", "3.png", "4.png"},
        {"Segundo", "textfield", "TextBox 1", "TextBox 2", "TextBox 3", "TextBox 4", "TextBox 5"},
        {"tercero", "checkbox", "CheckBox 1", "CheckBox 2", "CheckBox 3", "CheckBox 4", "CheckBox 5", "CheckBox 6", "CheckBox 7", "CheckBox 8", "CheckBox 9", "CheckBox 10", "CheckBox 11", "CheckBox 12", "CheckBox 13", "CheckBox 14", "CheckBox 15"},
        {"Cuarto", "radiobutton", "RadioButton 1", "RadioButton 2", "RadioButton 3", "RadioButton 4", "RadioButton 5", "RadioButton 6", "RadioButton 7"},
        {"Quinto", "list", "Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5", "Elemento 6", "Elemento 7", "Elemento 8", "Elemento 9", "Elemento 10", "Elemento 11", "Elemento 12"},
        {"Sexto", "button", "Botón 1", "Botón 2", "Botón 3"}
    };
    
    String disposicion = "cuadricula3x"; //valores posibles: vertical, horizontal,cuadricula2x y cuadricula3x
    
    int num_paneles = datosIniciales.length;
    int[] num_elementos_por_panel = new int[num_paneles];
    public JPanel[] paneles = new JPanel[num_paneles];
    public JList lista;
    int panelesConLista=0;
    int filas=1;
    

    public Frame() {
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Generador de Ventanas");
        GridLayout l = null;
        switch(disposicion){
            case "vertical":
                 l=new GridLayout(num_paneles, 1);
                break;
            case "horizontal":
                l=new GridLayout(1, num_paneles);
                break;
            case "cuadricula2x":
                
                if (num_paneles>2) {
                    filas=num_paneles/2;
                }
                l=new GridLayout(filas, 2);
                break;
            case "cuadricula3x":
                if (num_paneles>3) {
                    
                    filas=num_paneles/3;
                }
                l=new GridLayout(filas, 2);
                break;
        }
        panelPrincipal = new JPanel(l);
        add(panelPrincipal);
        calcularElementosPanel();
        generarPanelesConBorde();
        llenarPanelConElementos();

    }//constructor frame

    public void calcularElementosPanel() {
        //sacar cuantos elementos hay en cada fila
        for (int i = 0; i < num_paneles; i++) {
            num_elementos_por_panel[i] = datosIniciales[i].length;
        }
    }

    public void generarPanelesConBorde() {
        //genera paneles, les añade el borde con su titulo y los añade al panel 
        //principal
        for (int i = 0; i < num_paneles; i++) {
            paneles[i] = new JPanel();
            paneles[i].setBorder(new TitledBorder(datosIniciales[i][0]));
            paneles[i].setLayout(new GridLayout(1, num_elementos_por_panel[i]));
            panelPrincipal.add(paneles[i]);
        }
    }

    public void llenarPanelConElementos() {
        //rellena los paneles en base al tipo y numero de elementos
        for (int i = 0; i < num_paneles; i++) {
            for (int j = 0; j < num_elementos_por_panel[i] - 2; j++) {
                switch (datosIniciales[i][1]) {
                    case "imagen":
                        Icon[] imagenes=new ImageIcon[num_elementos_por_panel[i] - 2];
                        imagenes[j] = new ImageIcon(getClass().getResource(datosIniciales[i][j+2]));
                        JLabel jl = new JLabel(imagenes[j]);
                        paneles[i].add(jl);
                        break;
                    case "textfield":
                        JLabel[] etiquetas = new JLabel[num_elementos_por_panel[i] - 2];
                        etiquetas[j] = new JLabel(datosIniciales[i][j + 2]);
                        paneles[i].setLayout(new GridLayout(num_elementos_por_panel[i] - 2, 2));
                        JTextField[] campos = new JTextField[num_elementos_por_panel[i] - 2];
                        campos[j] = new JTextField();
                        paneles[i].add(etiquetas[j]);
                        paneles[i].add(campos[j]);
                        break;
                    case "checkbox":
                        JCheckBox[] checkboxes = new JCheckBox[num_elementos_por_panel[i] - 2];
                        checkboxes[j] = new JCheckBox(datosIniciales[i][j + 2]);
                        paneles[i].setLayout(new GridLayout(3, 5));
                        paneles[i].add(checkboxes[j]);
                        break;
                    case "radiobutton":
                        JRadioButton[] radiobutons = new JRadioButton[num_elementos_por_panel[i] - 2];
                        radiobutons[j] = new JRadioButton(datosIniciales[i][j + 2]);
                        paneles[i].setLayout(new GridLayout(2, 4));
                        paneles[i].add(radiobutons[j]);
                        break;
                    case "list":
                        panelesConLista=i;
                        break;
                    case "button":
                        JButton[] botones = new JButton[num_elementos_por_panel[i] - 2];
                        botones[j] = new JButton(datosIniciales[i][j + 2]);
                        botones[j].addActionListener(new EscuchadorBoton());
                        paneles[i].setLayout(new FlowLayout());
                        paneles[i].add(botones[j]);
                        break;

                }
                
                }
            //SI HAY UN PANEL CON LISTA, CREA LA LISTA CON LOS ELEMENTOS DEL PANEL
            if (panelesConLista>0) {
                    String elementos[] = new String[num_elementos_por_panel[panelesConLista] - 2];
                    for (int j = 0; j < elementos.length; j++) {
                    elementos[j] = datosIniciales[panelesConLista][j + 2];
                }
                    lista = new JList(elementos);
                    lista.setVisibleRowCount(5);
                    lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    paneles[panelesConLista].add(lista);
                    
            }panelesConLista=0;
        }
    }

    public class EscuchadorBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JFrame frame=new JFrame("Mensaje");
            JOptionPane.showMessageDialog(frame, "Clic en Boton");
        }
    }


}//clase
