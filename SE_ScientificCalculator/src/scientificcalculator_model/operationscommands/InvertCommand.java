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
* This class implements an Invert command which acts like a - before the entire ComplexNumber to invert the sign
* for the real and imaginary part.
*/
public class InvertCommand implements Command {
    
    private ComplexStack c;

    public InvertCommand(ComplexStack c) {
        this.c = c;
    }

    @Override
    public void execute() {
        ComplexNumber a = (ComplexNumber) c.pop();
        c.push(new ComplexNumber(-a.getReal(), -a.getImaginary()));
    }
    
}
