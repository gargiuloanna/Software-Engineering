/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.OverCommand;

/**
 *
 * @author marco
 */
public class OverCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
       
    ComplexNumber oper1;
    ComplexNumber oper2;

    
    public OverCommandTest() {
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
        //The order of push is oper2 - oper1 (the last is the second push did)
        stack.push(oper1);
        stack.push(oper2);
        
        int sizeBeforeDrop = stack.size();
        
        Command ov = new OverCommand(stack);
        exe.execute(ov);
        
        int sizeAfterDrop = stack.size();
        //Check if the swap does not make size problem
        assertEquals(sizeBeforeDrop+1, sizeAfterDrop);
        
        //Last element after drop command
        ComplexNumber lastElement = (ComplexNumber) stack.pop();
        ComplexNumber secondLastBefore = (ComplexNumber) stack.pop();
        
        //Check that the dropped element is the element saved before the drop
        assertEquals(lastElement.getReal(), oper1.getReal(), 0.0000001);
        assertEquals(lastElement.getImaginary(), oper1.getImaginary(), 0.0000001);
        
        //Check that the new last item is the element oper1 (the first inserted element)
        assertEquals(secondLastBefore.getReal(), oper2.getReal(), 0.0000001);
        assertEquals(secondLastBefore.getImaginary(), oper2.getImaginary(), 0.0000001);
        
    }
}
