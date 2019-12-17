package propertydemo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
 
class Factura {
 
    // define una variable para almacenar una propiedad
    private DoubleProperty cantidadDebida = new SimpleDoubleProperty();
 
    // getter
    public final double getCantidadDebida(){return cantidadDebida.get();}
 
    // setter 
    public final void setCantidadDebida(double value){cantidadDebida.set(value);}
 
     // getter de la propiedad misma
    public DoubleProperty cantidadDebidaProperty() {return cantidadDebida;}
 
}
