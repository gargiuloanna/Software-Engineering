
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.AddToLastCommand;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;

/*
* This is a class to test the AddToLastCommand class.
*/
public class AddToLastCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
    ComplexNumber oper;
    ComplexNumber oper1;
    Map<Character, ComplexNumber> variables;
    char c;
    
    public AddToLastCommandTest() {
    }
    
    @Before
    public void setUp() {
        
        exe = new ExecuteCommand();
        stack = new ComplexStack();
        oper = new ComplexNumber(4, 0);
        oper1 = new ComplexNumber(5,0);
        variables = new HashMap<>();
        c = 'x';
        
    }
    
    @Test
    public void testExecute(){
        
        Command add = new AddToLastCommand(stack, variables, c);
        stack.push(oper);
        variables.put(c, oper1);
        exe.execute(add);
        
        assertEquals(new ComplexNumber(9,0).getReal(), variables.get(c).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(9,0).getImaginary(), variables.get(c).getImaginary(), 0.0000001);
        
    }
}
