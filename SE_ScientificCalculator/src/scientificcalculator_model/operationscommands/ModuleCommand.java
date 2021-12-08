/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.operationscommands;

import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;

/**
 *
 * @author Luigina
 */
/**
 * This class implements a Module command which makes the module of a complex number.
 */
public class ModuleCommand implements Command{
    
    private ComplexStack c;

    public ModuleCommand(ComplexStack c) {
        this.c = c;
    }
    
    @Override
    public void execute() {
        ComplexNumber a = (ComplexNumber) c.pop();
        c.push(new ComplexNumber(Math.sqrt(Math.pow(a.getReal(), 2) + Math.pow(a.getImaginary(), 2)), 0));
    }

    @Override
    public String toString() {
        return "mod";
    }
    
    
}
