
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.InsertInVariableCommand;

/*
* This is a class to test the InsertInVariableCommand class.
*/
public class InsertInVariableCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
    ComplexNumber oper;
    Map<Character, ComplexNumber> variables;
    char c;
    
    public InsertInVariableCommandTest() {
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
        
        Command insert = new InsertInVariableCommand(stack,variables,c);
        stack.push(oper);
        variables.put(c, new ComplexNumber(0,0));
        exe.execute(insert);
        
        assertEquals(variables.get(c).getReal(), oper.getReal(), 0.0000001);
        assertEquals(variables.get(c).getImaginary(), oper.getImaginary(), 0.0000001);
        
    }

}
