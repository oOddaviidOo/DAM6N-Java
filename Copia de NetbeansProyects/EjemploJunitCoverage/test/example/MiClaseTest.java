/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

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
public class MiClaseTest {
    
    public MiClaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of numero_mayor method, of class MiClase.
     */
    @Test
    public void testNumero_mayor_caso1() {        
        int a = 5;
        int b = 3;
        int c = 7;
        MiClase instance = new MiClase();
        int expResult = 7;
        int result = instance.numero_mayor(a, b, c);
        assertEquals(expResult, result);        
    }

    @Test
    public void testNumero_mayor_caso2() {        
        int a = 5;
        int b = 3;
        int c = 4;
        MiClase instance = new MiClase();
        int expResult = 5;
        int result = instance.numero_mayor(a, b, c);
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testNumero_mayor_caso3() {        
        int a = 5;
        int b = 7;
        int c = 6;
        MiClase instance = new MiClase();
        int expResult = 7;
        int result = instance.numero_mayor(a, b, c);
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testNumero_mayor_caso4() {        
        int a = 5;
        int b = 7;
        int c = 9;
        MiClase instance = new MiClase();
        int expResult = 9;
        int result = instance.numero_mayor(a, b, c);
        assertEquals(expResult, result);        
    }
    
}
