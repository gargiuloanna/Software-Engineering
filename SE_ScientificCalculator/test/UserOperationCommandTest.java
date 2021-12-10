/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.Operations;
import scientificcalculator_model.operationscommands.AdditionCommand;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.UserOperationCommand;

/*
* This is a class to test the UserOperationCommand class.
*/
public class UserOperationCommandTest {
    
    ComplexStack stack;
    String nomeOp;
    Map<String, Operations> op;
    ExecuteCommand exe;
    ComplexNumber oper1;
    ComplexNumber oper2;
    ComplexNumber oper3;
    
            
    public UserOperationCommandTest() {
    }
    
    
    @Before
    public void setUp() {
      stack = new ComplexStack();
      oper1 = new ComplexNumber(4, 4);
      oper2 = new ComplexNumber(2, 2);
      oper3 = new ComplexNumber(2, 0);
      
      op = new HashMap<>();
      op.addOperation(new AdditionCommand(stack));
      op.addOperation(new AdditionCommand(stack));
      nomeOp = "sum";
      exe = new ExecuteCommand();
    }
    
    @Test
    public void testExecute(){
      stack.push(oper1);
      stack.push(oper2);
      stack.push(oper3);
      Command user = new UserOperationCommand(nomeOp, op);
      exe.execute(user);
      
      ComplexNumber a = (ComplexNumber) stack.pop();
      
      assertEquals(new ComplexNumber(8, 6).getReal(), a.getReal() ,0.0000001);
      assertEquals(new ComplexNumber(8, 6).getImaginary(), a.getImaginary() ,0.0000001);
      
    }
    
    
}
