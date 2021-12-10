
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.PushCommand;

/**
 * This is a class to test the PushCommand class.
 */
public class PushCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
       
    ComplexNumber oper1;

    public PushCommandTest() {
    }

    @Before
    public void setUp() {
        exe = new ExecuteCommand();
        stack = new ComplexStack();
        oper1 = new ComplexNumber(4, 4);

    }

    @Test
    public void testExecute(){
        
        //Save the size before the push command
        int sizeBefore = stack.size();
        
        Command ph = new PushCommand(stack, oper1);
        exe.execute(ph);
        
        //Save the size after the push command
        int sizeAfter = stack.size();
        
        //Verify the different size of each step
        assertEquals(sizeBefore, sizeAfter-1);
    }
}
