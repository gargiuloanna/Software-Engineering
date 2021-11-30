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
import scientificcalculator_model.ComplexNumber;

/**
 *
 * @author marco
 */
public class ComplexNumberTest {

    public ComplexNumberTest() {
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
    
    @Test
    public void testStringToComplex(){
        //a+bj
        assertEquals(new ComplexNumber(15, 4).getReal(), ComplexNumber.stringToComplex("15+4j").getReal(), 0.0000001);
        assertEquals(new ComplexNumber(15, 4).getImaginary(), ComplexNumber.stringToComplex("15+4j").getImaginary(), 0.0000001);
        
        //a
        assertEquals(new ComplexNumber(15, 0).getReal(), ComplexNumber.stringToComplex("15").getReal(), 0.0000001);
        assertEquals(new ComplexNumber(15, 0).getImaginary(), ComplexNumber.stringToComplex("15").getImaginary(), 0.0000001);
        
        //bj
        assertEquals(new ComplexNumber(0, 4).getReal(), ComplexNumber.stringToComplex("4j").getReal(), 0.0000001);
        assertEquals(new ComplexNumber(0, 4).getImaginary(), ComplexNumber.stringToComplex("4j").getImaginary(), 0.0000001);
        
        //bj+a
        assertEquals(new ComplexNumber(15, 4).getReal(), ComplexNumber.stringToComplex("15+4j").getReal(), 0.0000001);
        assertEquals(new ComplexNumber(15, 4).getImaginary(), ComplexNumber.stringToComplex("15+4j").getImaginary(), 0.0000001);
    }
    @Test
    public void testPhase(){
        //4j
        assertEquals(Math.PI/2, new ComplexNumber(0,4).phase(),0.0000001);
        //-4j
        assertEquals(-Math.PI/2, new ComplexNumber(0,-4).phase(),0.0000001);
        //15+4j
        assertEquals(0.2606023, new ComplexNumber(15,4).phase(),0.0000001);
        //-15+4j
        assertEquals(2.8809902, new ComplexNumber(-15,4).phase(),0.0000001);
        //-15-4j
        assertEquals(-2.8809902, new ComplexNumber(-15,-4).phase(),0.0000001);
    }
    

}
