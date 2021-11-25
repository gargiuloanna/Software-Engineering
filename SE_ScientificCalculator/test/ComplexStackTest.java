/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;

/**
 *
 * @author Anna
 */
public class ComplexStackTest {
    ComplexStack stack;
    ComplexNumber three=new ComplexNumber(3,0);
    ComplexNumber four=new ComplexNumber(4,0);
    ComplexNumber five=new ComplexNumber(5,0);

    public ComplexStackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stack= new ComplexStack();
        
        three=new ComplexNumber(3,0);
        four=new ComplexNumber(4,0);
        five=new ComplexNumber(5,0);
        
        stack.add(three);
        stack.add(four);
        stack.add(five);
    }
    
    @After
    public void tearDown() {
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testGetMemory() {
        
        ArrayList<ComplexNumber> actuals=stack.getMemory(3);
        
        //Comparison to see if five is pulled out correctly
        assertEquals(five.getReal(), actuals.get(0).getReal(), 0.0000001);
        assertEquals(five.getImaginary(), actuals.get(0).getImaginary(), 0.0000001);
        
        
        //Comparison to see if four is pulled out correctly
        assertEquals(four.getReal(), actuals.get(1).getReal(), 0.0000001);
        assertEquals(four.getImaginary(), actuals.get(1).getImaginary(), 0.0000001);
        
        //Comparison to see if three is pulled out correctly
        assertEquals(three.getReal(), actuals.get(2).getReal(), 0.0000001);
        assertEquals(three.getImaginary(), actuals.get(2).getImaginary(), 0.0000001);
        

    }
    
    @Test
    public void testClear(){
        assertEquals(0, stack.stack_clear());
    }
    
    @Test
    public void testSwap(){
        
        //Check that swaps returns correctly
        assertEquals(true, stack.swap());
        
        //Check if the values have been swapped
        ComplexNumber last= (ComplexNumber) stack.pop();
        ComplexNumber secondLast= (ComplexNumber) stack.pop();
        
        assertEquals(four.getReal(), last.getReal(), 0.0000001);
        assertEquals(four.getImaginary(), last.getImaginary(), 0.0000001);
        assertEquals(five.getReal(), secondLast.getReal(), 0.0000001);
        assertEquals(five.getImaginary(), secondLast.getImaginary(), 0.0000001);

    }
    
    
    
}
