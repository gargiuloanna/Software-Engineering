/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculator_model.statecalculator;

import java.util.HashMap;
import java.util.Map;
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

    private ComplexStack stack;
    private Map<String, Operations> opMemory;
    private String opName;
    private ExecuteCommand exe;
    
    public OperationState(ComplexStack stack, Map opMemory, String opName) {
        this.stack = stack;
        this.opMemory = opMemory;
        this.opName = opName;
        exe = new ExecuteCommand();
    }
    

    @Override
    public void addition() {
        Command add = new AdditionCommand(stack);
        opMemory.get(opName).addOperation(add);
    }

    @Override
    public void subtraction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
