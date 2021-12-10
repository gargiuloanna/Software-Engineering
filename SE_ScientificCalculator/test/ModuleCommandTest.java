
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.ModuleCommand;

/**
 * This is a class to test the ModuleCommand class.
 */
public class ModuleCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
       
    ComplexNumber oper1;
    ComplexNumber result;
    
    public ModuleCommandTest() {
    }
    
    @Before
    public void setUp() {
        exe = new ExecuteCommand();
        stack = new ComplexStack();
        oper1 = new ComplexNumber(4, 4);
    }

    @Test 
    public void testExecute(){
        
        //Test for (a+bj)
        Command mod = new ModuleCommand(stack);
        stack.push(oper1);
        exe.execute(mod);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(Math.sqrt(32), 0).getReal(), result.getReal(), 0.0000001);
        assertEquals(new ComplexNumber(Math.sqrt(32), 0).getImaginary(), result.getImaginary(), 0.0000001);
        stack.stackClear();
    }
}
