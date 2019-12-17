
package propertydemo;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
 
public class Main {
 
    public static void main(String[] args) {
 
      Factura electricBill = new Factura();
 
       electricBill.cantidadDebidaProperty().addListener(new ChangeListener(){
        @Override public void changed(ObservableValue o,Object oldVal, 
                 Object newVal){
             System.out.println("Electric bill has changed!");
        }
      });
      electricBill.setCantidadDebida(100.00);
    }
}