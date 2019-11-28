/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class CalculandoTest {
    
    public CalculandoTest() {
    }
    
    @BeforeClass
    //Este método es ejecutado una vez antes de ejecutar todos los test.
    //Se usa para ejecutar actividades intensivas como conectar a una
    //base de datos. Los métodos marcados con esta anotación
    //necesitan ser definidos como static para trabajar con JUnit. 
    public static void setUpClass() {
    }
    
    @AfterClass
    //Este método es ejecutado una vez después que todos los tests
    //hayan terminado.Se usa para actividades de limpieza, como por
    //ejemplo, desconectar de la base de datos. Los métodos marcados
    //con esta anotación necesitan ser definidos como static para trabajar
    //con JUnit.
    public static void tearDownClass() {
    }
    
    @Before
    //Este método es ejecutado antes de cada test. Se usa para preparar
    //el entorno de test (p.ej., leer datos de entrada, inicializar la clase). 
    public void setUp() {
    }
    
    @After
    //Este método es ejecutado después de cada test. Se usa para
    //limpiar el entorno de test (p.ej., borrar datos temporales, restaurar
    //valores por defecto). Se puede usar también para ahorrar memoria
    //limpiando estructuras de memoria pesadas
    public void tearDown() {
    }

    /**
     * Test of add method, of class Calculando.
     */
    @Test
    //La anotación @Test identifica el método como método de test. 
    public void testAdd() {
        System.out.println("add");
        double number1 = 1.0; //cambio el supuesto
        double number2 = 1.0;
        Calculando instance = new Calculando();
        double expResult = 2.0; //establecer el resultado esperado
        double result = instance.add(number1, number2);//prueba el método
        assertEquals(expResult, result, 0.0); //comprueba que el resltado el mismo que el esperado
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype."); //como nos dice arriba lo comentamos
    }

    /**
     * Test of subtract method, of class Calculando.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        double number1 = 1.0;
        double number2 = 1.0;
        Calculando instance = new Calculando();
        double expResult = 0.0;
        double result = instance.subtract(number1, number2);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of multiply method, of class Calculando.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        double number1 = 1.0;
        double number2 = 1.0;
        Calculando instance = new Calculando();
        double expResult = 1.0;
        double result = instance.multiply(number1, number2);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of divide method, of class Calculando.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        double number1 = 1.0;
        double number2 = 1.0;
        Calculando instance = new Calculando();
        double expResult = 1.0;
        double result = instance.divide(number1, number2);
        assertEquals(expResult, result, 0.0);
        
    }
    
}
