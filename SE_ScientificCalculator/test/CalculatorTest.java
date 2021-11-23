/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.Calculator;
import scientificcalculator_model.ComplexNumber;

/**
 *
 * @author marco
 */

public class CalculatorTest {
    
    Calculator c;
    
    public CalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        c = new Calculator();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testStringToDouble(){
        //DEFINIZIONE CASI POSSIBILI DI INSERIMENTO
        
        //a+bj
        assertEquals(new ComplexNumber(15, 4).getReal(), c.stringToComplex("15+4j").getReal(), 0.0000001);
        assertEquals(new ComplexNumber(15, 4).getImaginary(), c.stringToComplex("15+4j").getImaginary(), 0.0000001);
        
        //a
        assertEquals(new ComplexNumber(15, 0).getReal(), c.stringToComplex("15").getReal(), 0.0000001);
        assertEquals(new ComplexNumber(15, 0).getImaginary(), c.stringToComplex("15").getImaginary(), 0.0000001);
        
        //bj
        assertEquals(new ComplexNumber(0, 4).getReal(), c.stringToComplex("4j").getReal(), 0.0000001);
        assertEquals(new ComplexNumber(0, 4).getImaginary(), c.stringToComplex("4j").getImaginary(), 0.0000001);
        
        //bj+a
        assertEquals(new ComplexNumber(15, 4).getReal(), c.stringToComplex("15+4j").getReal(), 0.0000001);
        assertEquals(new ComplexNumber(15, 4).getImaginary(), c.stringToComplex("15+4j").getImaginary(), 0.0000001);
    }
    
    @Test
    public void testAddition(){
        assertEquals(new ComplexNumber(15, 4).getReal(), c.addition(new ComplexNumber(10, 2), new ComplexNumber(5, 2)).getReal(),0.0000001);
        assertEquals(new ComplexNumber(15, 4).getImaginary(), c.addition(new ComplexNumber(10, 2), new ComplexNumber(5, 2)).getImaginary(),0.0000001);
    }
    
    @Test
    public void testProduct(){
        
        //Test di (1+j)(1-j)
        assertEquals(new ComplexNumber(2, 0).getReal(), c.product(new ComplexNumber(1, 1), new ComplexNumber(1, -1)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(2, 0).getImaginary(), c.product(new ComplexNumber(1, 1), new ComplexNumber(1, -1)).getImaginary(), 0.0000001);
        
        //Test di 12*12j
        assertEquals(new ComplexNumber(0, 144).getReal(), c.product(new ComplexNumber(12, 0), new ComplexNumber(0, 12)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(0, 144).getImaginary(), c.product(new ComplexNumber(12, 0), new ComplexNumber(0, 12)).getImaginary(), 0.0000001);
        
        //Test di (12+4j)(12+4j)
        assertEquals(new ComplexNumber(128, 96).getReal(), c.product(new ComplexNumber(12, 4), new ComplexNumber(12, 4)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(128, 96).getImaginary(), c.product(new ComplexNumber(12, 4), new ComplexNumber(12, 4)).getImaginary(), 0.0000001);
        
        //Test di 12*12
        assertEquals(new ComplexNumber(144, 00).getReal(), c.product(new ComplexNumber(12, 0), new ComplexNumber(12, 0)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(144, 00).getImaginary(), c.product(new ComplexNumber(12, 0), new ComplexNumber(12, 0)).getImaginary(), 0.0000001);
        
        //Test di 12j*12j
        assertEquals(new ComplexNumber(-144, 0).getReal(), c.product(new ComplexNumber(0, 12), new ComplexNumber(0, 12)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(-144, 0).getImaginary(), c.product(new ComplexNumber(0, 12), new ComplexNumber(0, 12)).getImaginary(), 0.0000001);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
