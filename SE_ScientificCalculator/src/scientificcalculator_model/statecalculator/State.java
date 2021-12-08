/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package scientificcalculator_model.statecalculator;

import java.util.Map;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.Command;
import scientificcalculator_model.operationscommands.Operations;

/**
 *
 * @author marco
 */
public abstract class State {

    public abstract void addition(ComplexStack stack, Map<String, Operations> operations, String operationName);
    public abstract void product(ComplexStack stack, Map<String, Operations> operations, String operationName);
    public abstract void subtraction(ComplexStack stack, Map<String, Operations> operations, String operationName);
    public abstract void division(ComplexStack stack, Map<String, Operations> operations, String operationName);
    public abstract void drop(ComplexStack stack, Map<String, Operations> operations, String operationName);
    public abstract void dup(ComplexStack stack, Map<String, Operations> operations, String operationName);
    public abstract void invert(ComplexStack stack, Map<String, Operations> operations, String operationName);
    public abstract void module(ComplexStack stack, Map<String, Operations> operations, String operationName);
    public abstract void over(ComplexStack stack, Map<String, Operations> operations, String operationName);
    public abstract void phase(ComplexStack stack, Map<String, Operations> operations, String operationName);
    public abstract void sqrt(ComplexStack stack, Map<String, Operations> operations, String operationName);
    public abstract void swap(ComplexStack stack, Map<String, Operations> operations, String operationName);
    public abstract void push(ComplexStack stack, ComplexNumber number);
}
