/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculator_model.statecalculator;

import java.util.Map;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.*;

/**
 *
 * @author marco
 */
public class CalculatorState extends State{
    ExecuteCommand exe;

    public CalculatorState() {
        exe = new ExecuteCommand();
    }
    
    

    @Override
    public void addition(ComplexStack stack, Map<String, Operations> operations, String operationName) {
         if(stack.size()<2)
            throw new RuntimeException();
        Command add = new AdditionCommand(stack);
        exe.execute(add);
    }

    @Override
    public void product(ComplexStack stack, Map<String, Operations> operations, String operationName) {
    }

    @Override
    public void subtraction(ComplexStack stack, Map<String, Operations> operations, String operationName) {
    }

    @Override
    public void division(ComplexStack stack, Map<String, Operations> operations, String operationName) {
    }

    @Override
    public void drop(ComplexStack stack, Map<String, Operations> operations, String operationName) {
    }

    @Override
    public void dup(ComplexStack stack, Map<String, Operations> operations, String operationName) {
    }

    @Override
    public void invert(ComplexStack stack, Map<String, Operations> operations, String operationName) {
    }

    @Override
    public void module(ComplexStack stack, Map<String, Operations> operations, String operationName) {
    }

    @Override
    public void over(ComplexStack stack, Map<String, Operations> operations, String operationName) {
    }

    @Override
    public void phase(ComplexStack stack, Map<String, Operations> operations, String operationName) {
    }

    @Override
    public void sqrt(ComplexStack stack, Map<String, Operations> operations, String operationName) {
    }

    @Override
    public void swap(ComplexStack stack, Map<String, Operations> operations, String operationName) {
    }

    @Override
    public void push(ComplexStack stack, ComplexNumber number) {
    }

  
    
}
