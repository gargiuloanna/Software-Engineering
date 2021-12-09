/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.PhaseCommand;

/**
 *
 * @author marco
 */
public class PhaseCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
       
    ComplexNumber oper1;
    ComplexNumber result;
    
    public PhaseCommandTest() {
    }

    @Before
    public void setUp() {
        exe = new ExecuteCommand();
        stack = new ComplexStack();
        oper1 = new ComplexNumber(4, 4);
    }
    
    @Test 
    public void textExecute(){
        //Test for (a+bj)
        Command ph = new PhaseCommand(stack);
        stack.push(oper1);
        exe.execute(ph);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(0.78539816339744, 0).getReal(), result.getReal(), 0.0000001);
        assertEquals(new ComplexNumber(0.78539816339744, 0).getImaginary(), result.getImaginary(), 0.0000001);
        stack.stackClear();
    }
}
