/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.*;


/**
 *
 * @author Luigina
 */
public class CommandTest {
    
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
    
    public CommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
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
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddition(){
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
    
    @Test
    public void testSubtraction(){
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
    
    @Test
    public void testProduct(){
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
    
    @Test
    public void testDivision(){
        Command div = new DivisionCommand(stack);
        
        //(a+bj)/(a+bj)
        stack.push(oper1);
        stack.push(oper1_1);
        exe.execute(div);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(0.5, 0).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(0.5, 0).getImaginary(), result.getImaginary() ,0.0000001);
        
        //(a+bj)/a
        stack.push(oper2);
        stack.push(oper2_1);
        exe.execute(div);
        result = (ComplexNumber) stack.pop();
        assertEquals(new ComplexNumber(0.25, -0.25).getReal(), result.getReal() ,0.0000001);
        assertEquals(new ComplexNumber(0.25, -0.25).getImaginary(), result.getImaginary() ,0.0000001);
        stack.stackClear();
    }
    
    @Test
    public void testInvert(){
        
        //Test for (a+bj)
        Command inv = new InvertCommand(stack);
        stack.push(oper1);
        exe.execute(inv);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(-4, -4).getReal(), result.getReal(), 0.0000001);
        assertEquals(new ComplexNumber(-4, -4).getImaginary(), result.getImaginary(), 0.0000001);
        stack.stackClear();
    }
    
    @Test
    public void testSqrt(){

        //Test for (a)
        Command rad = new SqrtCommand(stack);
        stack.push(oper4);
        exe.execute(rad);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(Math.sqrt(2), 0).getReal(), result.getReal(), 0.0000001);
        assertEquals(new ComplexNumber(Math.sqrt(2), 0).getImaginary(), result.getImaginary(), 0.0000001);
        
        //Test for (a)
        stack.push(oper1_1);
        exe.execute(rad);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(1.55377397403, 0.6435942529055).getReal(), result.getReal(), 0.0000001);
        assertEquals(new ComplexNumber(1.55377397403, 0.6435942529055).getImaginary(), result.getImaginary(), 0.0000001);
        stack.stackClear();
    }
    
    @Test 
    public void testModule(){
        
        //Test for (a+bj)
        Command mod = new ModuleCommand(stack);
        stack.push(oper1);
        exe.execute(mod);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(Math.sqrt(32), 0).getReal(), result.getReal(), 0.0000001);
        assertEquals(new ComplexNumber(Math.sqrt(32), 0).getImaginary(), result.getImaginary(), 0.0000001);
        stack.stackClear();
    }
    
    @Test 
    public void testPhase(){
        //Test for (a+bj)
        Command ph = new PhaseCommand(stack);
        stack.push(oper1);
        exe.execute(ph);
        result = (ComplexNumber) stack.pop();
        
        assertEquals(new ComplexNumber(0.78539816339744, 0).getReal(), result.getReal(), 0.0000001);
        assertEquals(new ComplexNumber(0.78539816339744, 0).getImaginary(), result.getImaginary(), 0.0000001);
        stack.stackClear();
    }
    
    @Test
    public void testDrop(){
        //Save the last element of the stack
        stack.push(oper1);
        int sizeBeforeDrop = stack.size();
        
        Command dr = new DropCommand(stack);
        exe.execute(dr);
        
        int sizeAfterDrop = stack.size();
        //Check if the element has been removed
        assertEquals(sizeBeforeDrop-1, sizeAfterDrop);
    }
    
    @Test
    public void testDup(){
        
    }
    
    @Test
    public void testSwap(){
        
    }
    
    @Test
    public void testOver(){
        
    }
}
