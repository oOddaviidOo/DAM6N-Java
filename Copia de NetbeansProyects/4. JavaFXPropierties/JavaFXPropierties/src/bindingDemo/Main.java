
package bindingDemo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.binding.NumberBinding;
public class Main {
    public static void main(String[] args) {
        //creando dos propiedades
        IntegerProperty num1 = new SimpleIntegerProperty(1);
        IntegerProperty num2 = new SimpleIntegerProperty(2);
        //vinculando con NumberBinding
        NumberBinding sum = num1.add(num2);
        System.out.println(sum.getValue());
        num1.set(2);
        System.out.println(sum.getValue());
        //creando una tercera propiedad
        IntegerProperty num3=new SimpleIntegerProperty();
        //vinculando con el método bind
        num3.bind(sum);
        System.out.println(num3.getValue());
    }
}