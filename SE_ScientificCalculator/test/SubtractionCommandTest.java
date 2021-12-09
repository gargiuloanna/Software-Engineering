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
import scientificcalculator_model.operationscommands.SubtractionCommand;

/**
 *
 * @author marco
 */
public class SubtractionCommandTest {
    
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
    
    public SubtractionCommandTest() {
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

    
    @Test
    public void testExecute(){
        Command sub = new SubtractionCommand(stack);
        
        //(a+bj) - (a+bj)
        stack.push(oper1);
        stack.push(oper1_1);
        exe.execute(sub);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(-2, -2).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(-2, -2).getImaginary(), result.getImaginary() ,0.0000001);
        
        //(a+bj) - a
        stack.push(oper2);
        stack.push(oper2_1);
        exe.execute(sub);
        result = (ComplexNumber) stack.pop();
        assertEquals(new ComplexNumber(-2, -4).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(-2, -4).getImaginary(), result.getImaginary() ,0.0000001);
        
        //(a+bj) - bj
        stack.push(oper3);
        stack.push(oper3_1);
        exe.execute(sub);
        result = (ComplexNumber) stack.pop();
        assertEquals(new ComplexNumber(-4, -2).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(-4, -2).getImaginary(), result.getImaginary() ,0.0000001);
        
        //a - bj
        stack.push(oper4);
        stack.push(oper4_1);
        exe.execute(sub);
        result = (ComplexNumber) stack.pop();
        assertEquals(new ComplexNumber(-2, 2).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(-2, 2).getImaginary(), result.getImaginary() ,0.0000001);
        stack.stackClear();
    }
}
