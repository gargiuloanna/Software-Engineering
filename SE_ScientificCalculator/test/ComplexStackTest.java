/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.Map;
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
    ComplexNumber three;
    ComplexNumber four;
    ComplexNumber five;

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
    @Test
    public void testClear(){
        assertEquals(0, stack.stackClear());
    }
    
    @Test
    public void testSwap(){

        
        //Check that swaps returns correctly
        assertEquals(true, stack.swap());
        
        //Save the last two elements
        ComplexNumber last= (ComplexNumber) stack.pop();
        ComplexNumber secondLast= (ComplexNumber) stack.pop();
        stack.add(secondLast);
        stack.add(last);
        
        //Check if the values have been swapped      
        assertEquals(four.getReal(), last.getReal(), 0.0000001);
        assertEquals(four.getImaginary(), last.getImaginary(), 0.0000001);
        assertEquals(five.getReal(), secondLast.getReal(), 0.0000001);
        assertEquals(five.getImaginary(), secondLast.getImaginary(), 0.0000001);
        
        //Check - stack contains only one element
        stack.pop();
        stack.pop();
        assertEquals(false, stack.over());
        
        //Check - stack is empty
        stack.stackClear();
        assertEquals(false, stack.over());

    }
    
        
    @Test
    public void testDup(){
        
        //Save the last element
        ComplexNumber lastBeforeDup= (ComplexNumber) stack.peek();
        
        //Check that dup returns correctly
        assertEquals(true, stack.dup());
        
        //save the elements after the dup
        ComplexNumber lastAfterDup= (ComplexNumber) stack.pop();
        ComplexNumber secondLastAfterDup= (ComplexNumber) stack.pop();
        
        stack.add(secondLastAfterDup);
        stack.add(lastAfterDup);
        
        //Check if the last element has been duplicated
        assertEquals(lastAfterDup.getReal(), lastBeforeDup.getReal(), 0.0000001);
        assertEquals(lastAfterDup.getImaginary(), lastBeforeDup.getImaginary(), 0.0000001);
        assertEquals(secondLastAfterDup.getReal(), lastBeforeDup.getReal(), 0.0000001);
        assertEquals(secondLastAfterDup.getImaginary(), lastBeforeDup.getImaginary(), 0.0000001);
        
        //Check-stack is empty
        stack.stackClear();
        assertEquals(false, stack.dup());
        
    }
    
    @Test
    public void testDrop(){
        //Save the last element of the stack
        int sizeBeforeDrop= stack.size();
        
        //Check that drop returns correctly
        assertEquals(true, stack.drop());
        
        int sizeAfterDrop= stack.size();

        //Check if the element has been removed
        assertEquals(sizeBeforeDrop-1, sizeAfterDrop);
        
        //Check-stack is empty
        stack.stackClear();
        assertEquals(false, stack.drop());
    }
    
    @Test
    public void testOver(){
        
        //Save the second last element of the stack
        stack.swap();
        ComplexNumber secondLast = (ComplexNumber) stack.peek();
        stack.swap();
        
        
        //Check that over returns correctly
        assertEquals(true, stack.over());
        
        ComplexNumber last= (ComplexNumber) stack.peek();

        //Check if the second last element has been duplicated
        assertEquals(secondLast.getReal(), last.getReal(), 0.0000001);
        assertEquals(secondLast.getImaginary(), last.getImaginary(), 0.0000001);
        
        //Check - stack contains only one element
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals(false, stack.over());
        
        //Check - stack is empty
        stack.stackClear();
        assertEquals(false, stack.over());

    }

}