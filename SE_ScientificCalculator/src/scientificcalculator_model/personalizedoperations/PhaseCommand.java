/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.personalizedoperations;

import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;

/**
 *
 * @author Luigina
 */
public class PhaseCommand extends Command{
    
    private ComplexStack c;

    public PhaseCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * This method returns the phase of a ComplexNumber
     */
    @Override
    public void execute() {
       ComplexNumber a = (ComplexNumber) c.pop();
       c.push(Math.atan2(a.getImaginary(), a.getReal()));
    }
    
}
