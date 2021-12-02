/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.personalizedoperations;

import scientificcalculator_model.ComplexStack;

/**
 *
 * @author Anna
 */
public class ExecuteOperationCommand implements Command{
    private Operations opers;
    private ComplexStack stack;

    public ExecuteOperationCommand(Operations opers, ComplexStack stack) {
        this.opers = opers;
        this.stack= stack;
    }
    

    @Override
    public void execute() {
        opers.exeOperation(stack);
    }
    
}
