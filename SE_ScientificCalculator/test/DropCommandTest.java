/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.DropCommand;
import scientificcalculator_model.operationscommands.ExecuteCommand;

/**
 *
 * @author marco
 */
public class DropCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
       
    ComplexNumber oper1;
    ComplexNumber oper2;

    
    public DropCommandTest() {
    }
    
    @Before
    public void setUp() {
        exe = new ExecuteCommand();
        stack = new ComplexStack();
        oper1 = new ComplexNumber(4, 4);
        oper2 = new ComplexNumber(2, 2);
    }
    
    @Test
    public void testExecute(){
        //Save the last element of the stack
        stack.push(oper1);
        stack.push(oper2);
        int sizeBeforeDrop = stack.size();
        ComplexNumber resultBefore = (ComplexNumber) stack.peek();
        
        Command dr = new DropCommand(stack);
        exe.execute(dr);
        
        int sizeAfterDrop = stack.size();
        //Check if the element has been removed
        assertEquals(sizeBeforeDrop-1, sizeAfterDrop);
        
        //Last element after drop command
        ComplexNumber resultAfter = (ComplexNumber) stack.peek();
        
        //Check that the dropped element is the element saved before the drop
        assertEquals(resultBefore.getReal(), oper2.getReal(), 0.0000001);
        assertEquals(resultBefore.getImaginary(), oper2.getImaginary(), 0.0000001);
        
        //Check that the new last item is the element oper1 (the first inserted element)
        assertEquals(resultAfter.getReal(), oper1.getReal(), 0.0000001);
        assertEquals(resultAfter.getImaginary(), oper1.getImaginary(), 0.0000001);
        
    }
}
