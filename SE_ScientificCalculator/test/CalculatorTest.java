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
        assertEquals(new ComplexNumber(12.0, 1.0), c.stringToComplex("12+j"));
    }
    
    @Test
    public void testAddition(){
        assertEquals(new ComplexNumber(15, 4).getReal(), c.addition(new ComplexNumber(10, 2), new ComplexNumber(5, 2)).getReal(),0.0000001);
        assertEquals(new ComplexNumber(15, 4).getImaginary(), c.addition(new ComplexNumber(10, 2), new ComplexNumber(5, 2)).getImaginary(),0.0000001);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
