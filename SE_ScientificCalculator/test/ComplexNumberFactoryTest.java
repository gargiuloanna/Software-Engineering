/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.factorycomplexparser.ComplexNumberFactory;

/**
 *
 * @author marco
 */
public class ComplexNumberFactoryTest {

    public ComplexNumberFactoryTest() {
    }
    
    @Test
    public void testStringToComplex(){
        //a+bj
        assertEquals(new ComplexNumber(15, 4).getReal(), ComplexNumberFactory.buildComplexNumberFromString("15+4j").getReal(), 0.0000001);
        assertEquals(new ComplexNumber(15, 4).getImaginary(), ComplexNumberFactory.buildComplexNumberFromString("15+4j").getImaginary(), 0.0000001);
        
        //a
        assertEquals(new ComplexNumber(15, 0).getReal(), ComplexNumberFactory.buildComplexNumberFromString("15").getReal(), 0.0000001);
        assertEquals(new ComplexNumber(15, 0).getImaginary(), ComplexNumberFactory.buildComplexNumberFromString("15").getImaginary(), 0.0000001);
        
        //bj
        assertEquals(new ComplexNumber(0, 4).getReal(), ComplexNumberFactory.buildComplexNumberFromString("4j").getReal(), 0.0000001);
        assertEquals(new ComplexNumber(0, 4).getImaginary(), ComplexNumberFactory.buildComplexNumberFromString("4j").getImaginary(), 0.0000001);
        
        //bj+a
        assertEquals(new ComplexNumber(15, 4).getReal(), ComplexNumberFactory.buildComplexNumberFromString("15+4j").getReal(), 0.0000001);
        assertEquals(new ComplexNumber(15, 4).getImaginary(), ComplexNumberFactory.buildComplexNumberFromString("15+4j").getImaginary(), 0.0000001);
    }
    

}
