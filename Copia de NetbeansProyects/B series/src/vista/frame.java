package vista;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.show;
import controlador.controlador;
public class frame extends JFrame {
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JButton b1,b2,b3,b4,b5,b6,b7;
    private JLabel e1,e2,e3,e4,e5;
    private JTextField t1,t2,t3,t4,t5;
    //necesitaré un objeto controlador para poder llamar a los métodos del controlador
    private controlador c = null;
    //el contructor recibirá un objeto controlador
    public frame(controlador control){
        //igualo el objeto controlador que recibo como parámetro al que he defino arriba
        c=control;
        setSize(500,300);
        setTitle("Mis series");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(5,2,10,10));
        panel3.setLayout(new FlowLayout());
        add(panel1);
        panel1.add(panel3,BorderLayout.NORTH);
        panel1.add(panel2,BorderLayout.CENTER);
        b1=new JButton("|<");
        b2=new JButton("<");
        b3=new JButton(">");
        b4=new JButton(">|");
        b5=new JButton("+");
        b6=new JButton("-");
        b7=new JButton("*");
        panel3.add(b1);
        panel3.add(b2);
        panel3.add(b3);
        panel3.add(b4);
        panel3.add(b5);
        panel3.add(b6);
        panel3.add(b7);
        e1=new JLabel("Titulo");
        t1=new JTextField(50);
        panel2.add(e1);
        panel2.add(t1);
        e2=new JLabel("Guionista");
        t2=new JTextField(50);
        panel2.add(e2);
        panel2.add(t2);
        e3=new JLabel("Temporada");
        t3=new JTextField(5);
        panel2.add(e3);
        panel2.add(t3);
        e4=new JLabel("Género");
        t4=new JTextField(50);
        panel2.add(e4);
        panel2.add(t4);
        e5=new JLabel("Temp. Vistas");
        t5=new JTextField(5);
        panel2.add(e5);
        panel2.add(t5);
        buttonsListener bl = new buttonsListener();
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        b3.addActionListener(bl);
        b4.addActionListener(bl);
        b5.addActionListener(bl);
        b6.addActionListener(bl);
        b7.addActionListener(bl);
        //muestro primero
        actualiza(c.primero());
    }
    
     class buttonsListener implements ActionListener {
        	public void actionPerformed(ActionEvent e) {
                    show s=new show();
                    if (e.getSource()==b1){
                        s=c.primero();
                    }
                    if (e.getSource()==b2){
                        s=c.anterior();
                    }
                    if (e.getSource()==b3){
                        s=c.siguiente();
                    }
                    if (e.getSource()==b4){
                        s=c.ultimo();
                    }
                    //botón +
                    if (e.getSource()==b5){
                        if (b5.getText().equals("+")){
                            //vaciar textfield
                            t1.setText("");t2.setText("");t3.setText("");
                            t4.setText("");t5.setText("");
                            //deshabilitar resto botones
                            b1.setEnabled(false);b2.setEnabled(false);
                            b3.setEnabled(false);b4.setEnabled(false);
                            b6.setEnabled(false);b7.setEnabled(false);
                            //cabiar texto de b5
                            b5.setText("+++");
                        }else{
                            //Habilitar botones
                            b1.setEnabled(true);b2.setEnabled(true);b3.setEnabled(true);
                            b4.setEnabled(true);b6.setEnabled(true); b7.setEnabled(true);
                            //cabiar texto de b5
                            b5.setText("+");
                            //tomar los datos tecleados en los textfield
                            s=llenaShow();
                            //llamar al metodo nuevo del controlador
                            c.nuevo(s);
                        }
                    }
                    //boton -
                    if (e.getSource()==b6){
                        c.eliminar();
                        //cuando elimino uno me voy al primero, por ejemplo
                        s=c.primero();
                    }
                    //botón *
                    if (e.getSource()==b7){
                        //se supone que actualiza la serie en la que está
                        s=llenaShow();
                        c.actualizar(s);
                    }
                    actualiza(s);   
                    
        }
    }   
    private show llenaShow(){
         show s= new show(t1.getText(),t2.getText(),
                 Integer.parseInt(t3.getText()),
                 t4.getText(),Integer.parseInt(t5.getText()) );
         return s;
     }
     private void actualiza(show s) {
         t1.setText(s.getTitle());
         t2.setText(s.getScriptwriter());
         t3.setText(String.valueOf(s.getSeasons()));
         t4.setText(s.getGenre());
         t5.setText(String.valueOf(s.getViews()));
     }
        
}