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

/**
* This class implement an Subtraction command which makes the arithmetical addition between two operands
* ComplexNumber object (a+bj)-(c+dj).
*/
public class SubtractionCommand extends Command{
    
    private ComplexStack c;

    public SubtractionCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * This method makes the arithmetical subtraction between two operands
     * ComplexNumber object (a+bj)-(c+dj).
     */
    @Override
    public void execute() {
        ComplexNumber a = (ComplexNumber) c.pop();
        ComplexNumber b = (ComplexNumber) c.pop();
        c.push(new ComplexNumber(a.getReal() - b.getReal(),a.getImaginary() - b.getImaginary()));
    }
    
}
