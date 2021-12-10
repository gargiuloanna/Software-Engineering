
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.GetFromVariableCommand;

/*
* This is a class to test the GetFromVariableCommand class.
*/
public class GetFromVariableCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
    ComplexNumber oper;
    Map<Character, ComplexNumber> variables;
    char c;
    
    public GetFromVariableCommandTest() {
    }
    
    @Before
    public void setUp() {
        
        exe = new ExecuteCommand();
        stack = new ComplexStack();
        oper = new ComplexNumber(4, 0);
        variables = new HashMap<>();
        c = 'x';
    }
    
    @Test
    public void testExecute(){
        
        Command get = new GetFromVariableCommand(stack,variables,c);
        variables.put(c, oper);
        exe.execute(get);
        ComplexNumber c = (ComplexNumber) stack.pop();
        
        assertEquals(c.getReal(), oper.getReal(), 0.0000001);
        assertEquals(c.getImaginary(), oper.getImaginary(), 0.0000001);
        
        
    }
    
}
