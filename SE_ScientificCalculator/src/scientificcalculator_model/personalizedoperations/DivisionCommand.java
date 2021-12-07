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
public class DivisionCommand extends Command{
    
    private ComplexStack c;

    public DivisionCommand(ComplexStack c) {
        this.c = c;
    }
    
    private ComplexNumber conjugated(ComplexNumber x){
        return new ComplexNumber(x.getReal(), -x.getImaginary());
    }
    /**
     * This method makes the arithmetical division between two operands
     * ComplexNumber object (a+bj)/(c+dj).
     */
    @Override
    public void execute() {
        ComplexNumber a = (ComplexNumber) c.pop();
        ComplexNumber b = (ComplexNumber) c.pop();
        ComplexNumber conj_b = conjugated(b);
        ComplexNumber N = new ComplexNumber((a.getReal() * conj_b.getReal()+ (-1 * a.getImaginary() * conj_b.getImaginary())), (a.getReal() * conj_b.getImaginary()+a.getImaginary()* conj_b.getReal()));
        ComplexNumber D = new ComplexNumber((b.getReal() * conj_b.getReal()+ (-1 * b.getImaginary() * conj_b.getImaginary())), (b.getReal() * conj_b.getImaginary()+b.getImaginary()* conj_b.getReal()));
        if(D.getImaginary() == 0 && D.getReal() == 0){
            throw new ArithmeticException();
        }
        else
            c.push(new ComplexNumber(N.getReal()/D.getReal(), N.getImaginary()/D.getReal()));
    }
    
}
