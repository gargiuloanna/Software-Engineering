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
public class ProductCommand extends Command{
    
    private ComplexStack c;

    public ProductCommand(ComplexStack c) {
        this.c = c;
    }
    
 /**
     * This method makes the arithmetical product between two operands
     * ComplexNumber object (a+bj)*(c+dj).
     */
    @Override
    public void execute() {
        ComplexNumber a = (ComplexNumber) c.pop();
        ComplexNumber b = (ComplexNumber) c.pop();
        double aa = a.getReal() * b.getReal();
        double aib_1 = a.getReal() * b.getImaginary();
        double aib_2 = a.getImaginary()* b.getReal();
        double iibb = -1 * b.getImaginary() * a.getImaginary();
        c.push(new ComplexNumber((aa + iibb), (aib_1 + aib_2)));
    }
    
}
