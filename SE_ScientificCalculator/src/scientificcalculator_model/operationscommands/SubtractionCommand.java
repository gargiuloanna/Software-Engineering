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
* This class implements a Subtraction command which makes the arithmetical subtraction between two complex numbers.
*/
public class SubtractionCommand implements Command{
    
    private ComplexStack c;

    public SubtractionCommand(ComplexStack c) {
        this.c = c;
    }
 
    @Override
    public void execute() {
        ComplexNumber a = (ComplexNumber) c.pop();
        ComplexNumber b = (ComplexNumber) c.pop();
        c.push(new ComplexNumber(a.getReal() - b.getReal(),a.getImaginary() - b.getImaginary()));
    }

    @Override
    public String toString() {
        return "-";
    }
    
    
    
}
