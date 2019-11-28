package ejemplos;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FocusTraversalPolicyDemo extends JFrame {

    private JTextField tf1 = new JTextField();
    private JTextField tf2 = new JTextField();
    private JTextField tf3 = new JTextField();
    private JTextField tf4 = new JTextField();

    public FocusTraversalPolicyDemo() {
        setTitle("FocuFocusTraversalPolicy Demo");
        setLayout(new GridLayout(2, 2,30,30));
        setSize(400,200);
        //añadimos los campos de texto en un orden
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        setLocationRelativeTo(null); //centrar ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Establecemos el nuevo orden
        Vector<Component> order = new Vector<>(4);
        order.add(tf1);
        order.add(tf4);
        order.add(tf3);
        order.add(tf2);
        MyOwnFocusTraversalPolicy newPolicy = new MyOwnFocusTraversalPolicy(order);
        this.setFocusTraversalPolicy(newPolicy);
    }
    /*ESTO SIEMPRE ES ASÍ VER: https://docs.oracle.com/javase/tutorial/uiswing/misc/focus.html*/ 
    public static class MyOwnFocusTraversalPolicy extends FocusTraversalPolicy
    {
        Vector<Component> order;
 
        public MyOwnFocusTraversalPolicy(Vector<Component> order) {
            this.order = new Vector<Component>(order.size());
            this.order.addAll(order);
        }
        public Component getComponentAfter(Container focusCycleRoot,
                                           Component aComponent)
        {
            int idx = (order.indexOf(aComponent) + 1) % order.size();
            return order.get(idx);
        }
 
        public Component getComponentBefore(Container focusCycleRoot,
                                            Component aComponent)
        {
            int idx = order.indexOf(aComponent) - 1;
            if (idx < 0) {
                idx = order.size() - 1;
            }
            return order.get(idx);
        }
 
        public Component getDefaultComponent(Container focusCycleRoot) {
            return order.get(0);
        }
 
        public Component getLastComponent(Container focusCycleRoot) {
            return order.lastElement();
        }
 
        public Component getFirstComponent(Container focusCycleRoot) {
            return order.get(0);
        }
    }
    /* FINMyOwnFocusTraversalPolicy*/
    
    public static void main(String args[]) {
        new FocusTraversalPolicyDemo().setVisible(true);
    }

}
