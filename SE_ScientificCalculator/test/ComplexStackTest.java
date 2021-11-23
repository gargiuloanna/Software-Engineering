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
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testGetMemory() {
        ComplexStack stack= new ComplexStack();
        
        stack.add(new ComplexNumber(3,0));
        stack.add(new ComplexNumber(4,0));
        stack.add(new ComplexNumber(5,0));
        
        ArrayList<ComplexNumber> expectedlist= stack.getMemory(3);
        
        ComplexNumber expected[] = null;
        
        
        stack.add(new ComplexNumber(3,0));
        stack.add(new ComplexNumber(4,0));
        stack.add(new ComplexNumber(5,0));
        
        expected[0]= new ComplexNumber(3,0);
        expected[1]= new ComplexNumber(4,0);
        expected[2]= new ComplexNumber(5,0);

        ComplexNumber actual[] = null;
        actual[0]= expectedlist.get(0);
        actual[1]= expectedlist.get(1);
        actual[2]= expectedlist.get(2);
        
        
        assertArrayEquals(expected, actual);
        
        
    
    }
}
