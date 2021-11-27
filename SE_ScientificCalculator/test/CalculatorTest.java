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
import scientificcalculator_model.*;


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
    public void testAddition(){
        //(a+bj) + (a+bj)
        assertEquals(new ComplexNumber(15, 4).getReal(), c.addition(new ComplexNumber(10, 2), new ComplexNumber(5, 2)).getReal(),0.0000001);
        assertEquals(new ComplexNumber(15, 4).getImaginary(), c.addition(new ComplexNumber(10, 2), new ComplexNumber(5, 2)).getImaginary(),0.0000001);
        
        //(a+bj) + a
        assertEquals(new ComplexNumber(15, 4).getReal(), c.addition(new ComplexNumber(10, 4), new ComplexNumber(5, 0)).getReal(),0.0000001);
        assertEquals(new ComplexNumber(15, 4).getImaginary(), c.addition(new ComplexNumber(10, 4), new ComplexNumber(5, 0)).getImaginary(),0.0000001);
        
        //(a+bj) + bj
        assertEquals(new ComplexNumber(10, 4).getReal(), c.addition(new ComplexNumber(10, 2), new ComplexNumber(0, 2)).getReal(),0.0000001);
        assertEquals(new ComplexNumber(10, 4).getImaginary(), c.addition(new ComplexNumber(10, 2), new ComplexNumber(0, 2)).getImaginary(),0.0000001);
        
        //a + a
        assertEquals(new ComplexNumber(15, 0).getReal(), c.addition(new ComplexNumber(10, 0), new ComplexNumber(5, 0)).getReal(),0.0000001);
        assertEquals(new ComplexNumber(15, 0).getImaginary(), c.addition(new ComplexNumber(10, 0), new ComplexNumber(5, 0)).getImaginary(),0.0000001);
        
        //bj + bj
        assertEquals(new ComplexNumber(0, 4).getReal(), c.addition(new ComplexNumber(0, 2), new ComplexNumber(0, 2)).getReal(),0.0000001);
        assertEquals(new ComplexNumber(0, 4).getImaginary(), c.addition(new ComplexNumber(0, 2), new ComplexNumber(0, 2)).getImaginary(),0.0000001);
    }
    
    @Test
    public void testSubtraction(){
        //(a+bj) - (a+bj)
        assertEquals(new ComplexNumber(5, 4).getReal(), c.subtraction(new ComplexNumber(10, 8), new ComplexNumber(5, 4)).getReal(),0.0000001);
        assertEquals(new ComplexNumber(5, 4).getImaginary(), c.subtraction(new ComplexNumber(10,8), new ComplexNumber(5, 4)).getImaginary(),0.0000001);
        
        //(a+bj) - a
        assertEquals(new ComplexNumber(5, 4).getReal(), c.subtraction(new ComplexNumber(10, 4), new ComplexNumber(5, 0)).getReal(),0.0000001);
        assertEquals(new ComplexNumber(5, 4).getImaginary(), c.subtraction(new ComplexNumber(10, 4), new ComplexNumber(5, 0)).getImaginary(),0.0000001);
        
        //(a+bj) - bj
        assertEquals(new ComplexNumber(10, 4).getReal(), c.subtraction(new ComplexNumber(10, 8), new ComplexNumber(0, 4)).getReal(),0.0000001);
        assertEquals(new ComplexNumber(10, 4).getImaginary(), c.subtraction(new ComplexNumber(10, 8), new ComplexNumber(0, 4)).getImaginary(),0.0000001);
        
        //a - a
        assertEquals(new ComplexNumber(10, 0).getReal(), c.subtraction(new ComplexNumber(15, 0), new ComplexNumber(5, 0)).getReal(),0.0000001);
        assertEquals(new ComplexNumber(10, 0).getImaginary(), c.subtraction(new ComplexNumber(15, 0), new ComplexNumber(5, 0)).getImaginary(),0.0000001);
        
        //bj - bj
        assertEquals(new ComplexNumber(0, 4).getReal(), c.subtraction(new ComplexNumber(0, 8), new ComplexNumber(0, 4)).getReal(),0.0000001);
        assertEquals(new ComplexNumber(0, 4).getImaginary(), c.subtraction(new ComplexNumber(0, 8), new ComplexNumber(0, 4)).getImaginary(),0.0000001);
    }
    
    @Test
    public void testProduct(){
        
        //Test for (1+j)(1-j)
        assertEquals(new ComplexNumber(2, 0).getReal(), c.product(new ComplexNumber(1, 1), new ComplexNumber(1, -1)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(2, 0).getImaginary(), c.product(new ComplexNumber(1, 1), new ComplexNumber(1, -1)).getImaginary(), 0.0000001);
        
        //Test for 12*12j
        assertEquals(new ComplexNumber(0, 144).getReal(), c.product(new ComplexNumber(12, 0), new ComplexNumber(0, 12)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(0, 144).getImaginary(), c.product(new ComplexNumber(12, 0), new ComplexNumber(0, 12)).getImaginary(), 0.0000001);
        
        //Test for (12+4j)(12+4j)
        assertEquals(new ComplexNumber(128, 96).getReal(), c.product(new ComplexNumber(12, 4), new ComplexNumber(12, 4)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(128, 96).getImaginary(), c.product(new ComplexNumber(12, 4), new ComplexNumber(12, 4)).getImaginary(), 0.0000001);
        
        //Test for 12*12
        assertEquals(new ComplexNumber(144, 00).getReal(), c.product(new ComplexNumber(12, 0), new ComplexNumber(12, 0)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(144, 00).getImaginary(), c.product(new ComplexNumber(12, 0), new ComplexNumber(12, 0)).getImaginary(), 0.0000001);
        
        //Test for 12j*12j
        assertEquals(new ComplexNumber(-144, 0).getReal(), c.product(new ComplexNumber(0, 12), new ComplexNumber(0, 12)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(-144, 0).getImaginary(), c.product(new ComplexNumber(0, 12), new ComplexNumber(0, 12)).getImaginary(), 0.0000001);
    }
    
    @Test
    public void testDivision(){
        
        //Test for 1/(1+j)
        assertEquals(new ComplexNumber(0.5, -0.5).getReal(), c.division(new ComplexNumber(1, 0), new ComplexNumber(1, 1)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(0.5, -0.5).getImaginary(), c.division(new ComplexNumber(1, 0), new ComplexNumber(1, 1)).getImaginary(), 0.0000001);
        
        //Test for (a+bj)/(c+dj)
        assertEquals(new ComplexNumber((double)3/113, (double)68/113).getReal(), c.division(new ComplexNumber(5, 4), new ComplexNumber(7, -8)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber((double)3/113, (double)68/113).getImaginary(), c.division(new ComplexNumber(5, 4), new ComplexNumber(7, -8)).getImaginary(), 0.0000001);
        
        //Test for j/(a+bj)
        assertEquals(new ComplexNumber((double)17/650, (double)6/650).getReal(), c.division(new ComplexNumber(0, 1), new ComplexNumber(12, 34)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber((double)17/650, (double)6/650).getImaginary(), c.division(new ComplexNumber(0, 1), new ComplexNumber(12, 34)).getImaginary(), 0.0000001);
        
        //Test for division (a+bi)/0
        Throwable e = null;
        try{
           ComplexNumber div = c.division(new ComplexNumber(5, 4), new ComplexNumber(0 ,0));
        }catch(ArithmeticException ex){
            e = ex;
        }
        
        assertTrue(e instanceof ArithmeticException);
    }
    
    @Test
    public void testInvert(){
        
        //Test for (a+bj)
        assertEquals(new ComplexNumber(-4, -4).getReal(), c.invert(new ComplexNumber(4, 4)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(-4, -4).getReal(), c.invert(new ComplexNumber(4, 4)).getImaginary(), 0.0000001);
        
    }
    
    @Test
    public void testSqrt(){
        
        //Test for (1+j)
        assertEquals(new ComplexNumber(1.09868411, 0.45508986).getReal(), c.sqrt(new ComplexNumber(1, 1)).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(1.09868411, 0.45508986).getImaginary(), c.sqrt(new ComplexNumber(1, 1)).getImaginary(), 0.0000001);
    }
}
