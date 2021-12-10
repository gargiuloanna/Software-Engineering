
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.ProductCommand;

/**
* This is a class to test the ProductCommand class.
*/
public class ProductCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
       
    ComplexNumber oper1;
    ComplexNumber oper1_1;
    ComplexNumber oper2;
    ComplexNumber oper2_1;
    ComplexNumber result;
    
    public ProductCommandTest() {
    }

    
    @Before
    public void setUp() {
        exe = new ExecuteCommand();
        stack = new ComplexStack();
        oper1 = new ComplexNumber(4, 4);
        oper1_1 = new ComplexNumber(2, 2);
        
        oper2 = new ComplexNumber(4, 4);
        oper2_1 = new ComplexNumber(2, 0);
    }

    @Test
    public void testExecute(){
        Command pro = new ProductCommand(stack);
        
        //(a+bj)*(a+bj)
        stack.push(oper1);
        stack.push(oper1_1);
        exe.execute(pro);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(0, 16).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(0, 16).getImaginary(), result.getImaginary() ,0.0000001);
        
        //(a+bj)*a
        stack.push(oper2);
        stack.push(oper2_1);
        exe.execute(pro);
        result = (ComplexNumber) stack.pop();
        assertEquals(new ComplexNumber(8, 8).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(8, 8).getImaginary(), result.getImaginary() ,0.0000001);
        stack.stackClear();
    }
}
