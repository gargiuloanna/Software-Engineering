/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculator_model.statecalculator;

import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.operationscommands.*;

/**
 *
 * @author marco
 */
public class CalculatorState extends State{
    
    private ComplexStack stack;
    private ExecuteCommand exe;

    public CalculatorState(ComplexStack stack) {
        this.stack = stack;
        exe = new ExecuteCommand();
    }

    
    @Override
    public void addition() {
        Command add = new AdditionCommand(stack);
        exe.execute(add);
    }

    
    @Override
    public void subtraction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
