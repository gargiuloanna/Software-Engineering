/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import calculator_exception.DivisionForZeroException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.DivisionCommand;
import scientificcalculator_model.operationscommands.ExecuteCommand;

/*
* This is a class to test the Division Command class.
*/

public class DivisionCommandTest {
    
    ExecuteCommand exe;
    ComplexStack stack;
       
    ComplexNumber oper1;
    ComplexNumber oper1_1;
    ComplexNumber oper2;
    ComplexNumber oper2_1;
    ComplexNumber result;
    
    public DivisionCommandTest(){
    }

    
    @Before
    public void setUp(){
        exe = new ExecuteCommand();
        stack = new ComplexStack();
        oper1 = new ComplexNumber(4, 4);
        oper1_1 = new ComplexNumber(2, 2);
        
        oper2 = new ComplexNumber(4, 4);
        oper2_1 = new ComplexNumber(0, 0);
    }

    @Test
    public void testExecute(){
        Command div = new DivisionCommand(stack);
        
        //(a+bj)/(a+bj)
        stack.push(oper1);
        stack.push(oper1_1);
        exe.execute(div);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(0.5, 0).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(0.5, 0).getImaginary(), result.getImaginary() ,0.0000001);
        
        //(a+bj)/0
        stack.push(oper2_1);
        stack.push(oper2);
        
        //Test for division (a+bi)/0, expected exception for the 0 division.
        Throwable e = null;
        try{
           exe.execute(div);
        }catch(DivisionForZeroException ex){
            e = ex;
        }
        
        assertTrue(e instanceof DivisionForZeroException);
        stack.stackClear();
    }
}
