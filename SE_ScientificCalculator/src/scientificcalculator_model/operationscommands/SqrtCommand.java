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
public class SqrtCommand extends Command{
    
    private ComplexStack c;

    public SqrtCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * This method makes the square root of a ComplexNumber.
     */
    @Override
    public void execute() {
        ComplexNumber a = (ComplexNumber) c.pop();
        if (a.getImaginary() == 0){
            c.push(new ComplexNumber(Math.sqrt(a.getReal()), 0));
        }
        else{
            double xABS = Math.sqrt(Math.pow(a.getReal(), 2) + Math.pow(a.getImaginary(), 2));

            double a1 = Math.sqrt((xABS+a.getReal())/2);
            double a2 = Math.sqrt((xABS-a.getReal())/2);
            
            c.push(new ComplexNumber(a1, a2));
        }
    }
    
}
