/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.SqrtCommand;

/**
 *
 * @author marco
 */
public class SqrtCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
       
    ComplexNumber oper1;
    ComplexNumber oper2;
    ComplexNumber result;
    
    public SqrtCommandTest() {
    }

    @Before
    public void setUp() {
        exe = new ExecuteCommand();
        stack = new ComplexStack();
        oper1 = new ComplexNumber(2, 2);
        oper2 = new ComplexNumber(2, 0);
    }

    @Test
    public void testExecute(){

        //Test for (a)
        Command rad = new SqrtCommand(stack);
        stack.push(oper2);
        exe.execute(rad);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(Math.sqrt(2), 0).getReal(), result.getReal(), 0.0000001);
        assertEquals(new ComplexNumber(Math.sqrt(2), 0).getImaginary(), result.getImaginary(), 0.0000001);
        
        //Test for (a+bj)
        stack.push(oper1);
        exe.execute(rad);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(1.55377397403, 0.6435942529055).getReal(), result.getReal(), 0.0000001);
        assertEquals(new ComplexNumber(1.55377397403, 0.6435942529055).getImaginary(), result.getImaginary(), 0.0000001);
        stack.stackClear();
    }
}
