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
* This class implements a Product command which makes the arithmetical product between two complex numbers.
*/
public class ProductCommand implements Command{
    
    private ComplexStack c;

    public ProductCommand(ComplexStack c) {
        this.c = c;
    }
    

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

    @Override
    public String toString() {
        return "*";
    }
    
    
    
}
