
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.DupCommand;
import scientificcalculator_model.operationscommands.ExecuteCommand;

/*
* This is a class to test the DupCommand class.
*/
public class DupCommandTest{
    
    ExecuteCommand exe;
    ComplexStack stack;
    
    ComplexNumber oper1;
    
    public DupCommandTest() {
    }
    
    @Before
    public void setUp() {
        exe = new ExecuteCommand();
        stack = new ComplexStack();
        oper1 = new ComplexNumber(4, 4);
    }

    @Test
    public void testExecute(){
        //Save the last element of the stack
        stack.push(oper1);
        int sizeBeforeDrop = stack.size();
        
        Command dup = new DupCommand(stack);
        exe.execute(dup);
        
        int sizeAfterDrop = stack.size();
        //Check if the last element has beed duplicated
        assertEquals(sizeBeforeDrop, sizeAfterDrop-1);
        
        //Last element after drop command
        ComplexNumber lastElement = (ComplexNumber) stack.pop();
        ComplexNumber newLastElement = (ComplexNumber) stack.pop();
        
        //Check that the last inserted element is the duplicated value of the oper1 that is the last element of the stack before the command.
        assertEquals(lastElement.getReal(), newLastElement.getReal(), 0.0000001);
        assertEquals(lastElement.getImaginary(), newLastElement.getImaginary(), 0.0000001);

        
    }
}
