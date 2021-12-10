
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.InvertCommand;

/**
 * This is a class to test the InvertCommand class.
 */
public class InvertCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
       
    ComplexNumber oper1;
    ComplexNumber result;
    
    public InvertCommandTest() {
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
        Command inv = new InvertCommand(stack);
        stack.push(oper1);
        exe.execute(inv);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(-4, -4).getReal(), result.getReal(), 0.0000001);
        assertEquals(new ComplexNumber(-4, -4).getImaginary(), result.getImaginary(), 0.0000001);
        stack.stackClear();
    }
}
