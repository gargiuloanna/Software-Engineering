/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculator_model.statecalculator;

import java.util.HashMap;
import java.util.Map;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.AdditionCommand;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.ExecuteCommand;
import scientificcalculator_model.operationscommands.Operations;

/**
 *
 * @author marco
 */
public class OperationState extends State{

   @Override
    public void addition(ComplexStack stack, Map<String, Operations> operations, String operationName) {
         Command add = new AdditionCommand(stack);
         operations.get(operationName).addOperation(add);
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
