/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculator_model.statecalculator;

import java.util.Map;
import scientificcalculator_model.*;
import scientificcalculator_model.operationscommands.*;

/**
 *The CalculatorState class implements the State of the Calculator that allows the user to execute normal operations using inserted operands.
 */
public class CalculatorState extends State{
    ExecuteCommand exe;

    public CalculatorState() {
        exe = new ExecuteCommand();
    }
    
    /**
    *The method sums two elements of the param Stack.
     * @param stack the stack containing the complex number imputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws ArithmeticException if the stack does not contain at least two elements.
    */
    @Override
    public void addition(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        if(stack.size()<2)
           throw new ArithmeticException();
        Command add = new AdditionCommand(stack);
        exe.execute(add);
    }
    
    /**
    *The method multiplies two elements of the param Stack.
     * @param stack the stack containing the complex number imputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws ArithmeticException if the stack does not contain at least two elements.
    */
    @Override
    public void product(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        if(stack.size()<2)
           throw new ArithmeticException();
        Command prod = new ProductCommand(stack);
        exe.execute(prod);
    }
    
    /**
    *The method subtracts two elements of the param Stack.
     * @param stack the stack containing the complex number imputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws ArithmeticException if the stack does not contain at least two elements.
    */
    @Override
    public void subtraction(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        if(stack.size()<2)
           throw new ArithmeticException();
        Command sub = new SubtractionCommand(stack);
        exe.execute(sub);
    }
    
    /**
    *The method divides two elements of the param Stack.
     * @param stack the stack containing the complex number imputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws ArithmeticException if the stack does not contain at least two elements.
    */
    @Override
    public void division(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        if(stack.size()<2)
           throw new ArithmeticException();
        Command div = new DivisionCommand(stack);
        exe.execute(div);
    }
    
    /**
    *The method eliminates the last element of the param Stack.
     * @param stack the stack containing the complex number imputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws ArithmeticException if the stack does not contain at least one element.
    */
    @Override
    public void drop(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        if(stack.isEmpty())
           throw new ArithmeticException();
        Command drop = new DropCommand(stack);
        exe.execute(drop);
    }
    
    /**
    *The method duplicates the last element of the param Stack.
     * @param stack the stack containing the complex number imputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws ArithmeticException if the stack does not contain at least one element.
    */
    @Override
    public void dup(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        if(stack.isEmpty())
           throw new ArithmeticException();
        Command dup = new DupCommand(stack);
        exe.execute(dup);
    }
    
    /**
    *The method inverts the sign of the last element of the param Stack.
     * @param stack the stack containing the complex number imputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws ArithmeticException if the stack does not contain at least one element.
    */
    @Override
    public void invert(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        if(stack.isEmpty())
           throw new ArithmeticException();
        Command invert = new InvertCommand(stack);
        exe.execute(invert);
    }
    
    /**
    *The method calculates the absolute value of the last element of the param Stack.
     * @param stack the stack containing the complex number imputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws ArithmeticException if the stack does not contain at least one element.
    */
    @Override
    public void module(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        if(stack.isEmpty())
           throw new ArithmeticException();
        Command module = new ModuleCommand(stack);
        exe.execute(module);
    }
    /**
    *The method duplicates the second last element of the param Stack.
     * @param stack the stack containing the complex number imputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws ArithmeticException if the stack does not contain at least two elements.
    */
    @Override
    public void over(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        if(stack.size()<2)
           throw new ArithmeticException();
        Command over = new OverCommand(stack);
        exe.execute(over);
    }
    
    /**
    *The method calculates the phase of the last element of the param Stack.
     * @param stack the stack containing the complex number imputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws ArithmeticException if the stack does not contain at least one element.
    */
    @Override
    public void phase(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        if(stack.isEmpty())
           throw new ArithmeticException();
        Command phase = new PhaseCommand(stack);
        exe.execute(phase);
    }
    
    /**
    *The method calculates the square root of the last element of the param Stack.
     * @param stack the stack containing the complex number imputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws ArithmeticException if the stack does not contain at least one element.
    */
    @Override
    public void sqrt(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        if(stack.isEmpty())
           throw new ArithmeticException();
        Command sqrt = new SqrtCommand(stack);
        exe.execute(sqrt);
    }
    
    /**
    *The method swaps the last two elements of the param Stack.
     * @param stack the stack containing the complex number imputs
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
     * @throws ArithmeticException if the stack does not contain at least two elements.
    */
    @Override
    public void swap(ComplexStack stack, Map<String, Operations> operations, String operationName) {
        if(stack.size()<2)
           throw new ArithmeticException();
        Command swap = new SwapCommand(stack);
        exe.execute(swap);
    }
    
    /**
    *The method pushes the element number in the Stack.
     * @param stack the stack containing the complex number imputs
     * @param number the number to push on the stack
     * @param operations the map where the user defined operations are located
     * @param operationName the name of the operation to define
    */
    @Override
    public void push(ComplexStack stack, ComplexNumber number, Map<String, Operations> operations, String operationName) {
        Command push = new PushCommand(stack, number);
        exe.execute(push);
    }

  
    
}
