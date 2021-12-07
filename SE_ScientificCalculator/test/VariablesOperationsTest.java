/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.*;


/**
 *
 * @author marco
 */

public class VariablesOperationsTest {
    
    VariablesOperations c;
    
    @Before
    public void setUp() {
        c = new VariablesOperations();
    }
        
    @Test
    public void testInsertInVariable(){
        ComplexStack s = new ComplexStack();
        ComplexNumber four=new ComplexNumber(4,0);
        s.push(four);
        Map<Character, ComplexNumber> variables = new HashMap<>();
        char x= 'x';
                
        //Insert the value in the variable x
        variables.put(x, four);
        
        //Check that the values has been modified/added
        assertEquals(true, c.insertInVariable(s,variables, x));
        assertEquals(variables.get(x), s.peek());
        
    }
    
    @Test
    public void testgetFromVariable(){
        ComplexStack s = new ComplexStack();
        ComplexNumber four=new ComplexNumber(4,0);
        s.push(four);
        Map<Character, ComplexNumber> variables = new HashMap<>();
        char x= 'x';
        
        //Check that the map doesnt contain the key
        assertEquals(false, c.getFromVariable(s,variables, x));
        
        //Insert the value in the variable x
        variables.put(x, four);
        
        //Check that the value has been added to the stack
        assertEquals(true, c.getFromVariable(s,variables, x));
        assertEquals(variables.get(x), s.peek());

    }
    
    @Test 
    public void testAddtoLast(){
        ComplexStack s = new ComplexStack();
        ComplexNumber four=new ComplexNumber(4,0);
        s.push(four);
        Map<Character, ComplexNumber> variables = new HashMap<>();
        char x= 'x';
        
        //Check that the map doesnt contain the key
        assertEquals(false, c.addToLast(s,variables, x));
        
        //Insert the value in the variable x
        variables.put(x, four);
        
        //Check that the addition has been performed successfully
        assertEquals(true, c.addToLast(s,variables, x));
        assertNotEquals(variables.get(x), s.peek());
    }
    
    @Test
    public void testSubtoLast(){
        ComplexStack s = new ComplexStack();
        ComplexNumber four=new ComplexNumber(4,0);
        s.push(four);
        Map<Character, ComplexNumber> variables = new HashMap<>();
        char x= 'x';
        
        //Check that the map doesnt contain the key
        assertEquals(false, c.subToLast(s,variables, x));
        
        //Insert the value in the variable x
        variables.put(x, four);
        
        //Check that the addition has been performed successfully
        assertEquals(true, c.subToLast(s,variables, x));
        assertNotEquals(variables.get(x), s.peek());
    }
}
