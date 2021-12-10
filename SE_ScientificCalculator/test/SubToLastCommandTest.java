
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.SubToLastCommand;

/*
* This is a class to test the SubToLastCommand class.
*/
public class SubToLastCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
    ComplexNumber oper;
    ComplexNumber oper1;
    Map<Character, ComplexNumber> variables;
    char c;
    
    
    public SubToLastCommandTest() {
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
        
        Command sub = new SubToLastCommand(stack, variables, c);
        stack.push(oper);
        variables.put(c, oper1);
        exe.execute(sub);
        
        assertEquals(new ComplexNumber(-1,0).getReal(), variables.get(c).getReal(), 0.0000001);
        assertEquals(new ComplexNumber(-1,0).getImaginary(), variables.get(c).getImaginary(), 0.0000001);
        
    }
            
    
    
}
