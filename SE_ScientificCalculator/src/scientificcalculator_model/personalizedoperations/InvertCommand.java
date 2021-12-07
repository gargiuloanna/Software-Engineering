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
public class InvertCommand extends Command {
    
    private ComplexStack c;

    public InvertCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * This method acts like a - before the entire ComplexNumber to invert the sign
     * for the real and imaginary part.
     */
    @Override
    public void execute() {
        ComplexNumber a = (ComplexNumber) c.pop();
        c.push(new ComplexNumber(-a.getReal(), -a.getImaginary()));
    }
    
}
