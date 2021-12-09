/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.InvertCommand;

/**
 *
 * @author marco
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
