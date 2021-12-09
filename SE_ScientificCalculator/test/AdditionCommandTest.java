/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.AdditionCommand;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;

/**
 *
 * @author marco
 */
public class AdditionCommandTest {
    ExecuteCommand exe;
    ComplexStack stack;
       
    ComplexNumber oper1;
    ComplexNumber oper1_1;
    ComplexNumber oper2;
    ComplexNumber oper2_1;
    ComplexNumber oper3;
    ComplexNumber oper3_1;
    ComplexNumber oper4;
    ComplexNumber oper4_1;
    ComplexNumber result;
    
    public AdditionCommandTest() {
    }
    
    @Before
    public void setUp() {
        exe = new ExecuteCommand();
        stack = new ComplexStack();
        oper1 = new ComplexNumber(4, 4);
        oper1_1 = new ComplexNumber(2, 2);
        
        oper2 = new ComplexNumber(4, 4);
        oper2_1 = new ComplexNumber(2, 0);
        
        oper3 = new ComplexNumber(4, 4);
        oper3_1 = new ComplexNumber(0, 2);
        
        oper4 = new ComplexNumber(2, 0);
        oper4_1 = new ComplexNumber(0, 2);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void textExecute(){
        Command add = new AdditionCommand(stack);
        
        //(a+bj) + (a+bj)
        stack.push(oper1);
        stack.push(oper1_1);
        exe.execute(add);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(6, 6).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(6, 6).getImaginary(), result.getImaginary() ,0.0000001);
        
        //(a+bj) + a
        stack.push(oper2);
        stack.push(oper2_1);
        exe.execute(add);
        result = (ComplexNumber) stack.pop();
        assertEquals(new ComplexNumber(6, 4).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(6, 4).getImaginary(), result.getImaginary() ,0.0000001);
        
        //(a+bj) + bj
        stack.push(oper3);
        stack.push(oper3_1);
        exe.execute(add);
        result = (ComplexNumber) stack.pop();
        assertEquals(new ComplexNumber(4, 6).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(4, 6).getImaginary(), result.getImaginary() ,0.0000001);
        
        //a + bj
        stack.push(oper4);
        stack.push(oper4_1);
        exe.execute(add);
        result = (ComplexNumber) stack.pop();
        assertEquals(new ComplexNumber(2, 2).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(2, 2).getImaginary(), result.getImaginary() ,0.0000001);
        stack.stackClear();
    }
}
