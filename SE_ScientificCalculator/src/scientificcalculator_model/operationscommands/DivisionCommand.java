//
package scientificcalculator_model.operationscommands;


import calculator_exception.DivisionForZeroException;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;


/**
* This class implements a Division command which makes the arithmetical division between two complex numbers.
*/
public class DivisionCommand implements Command{
    
    private ComplexStack c;

    /**
     * Initializes a newly created DivisionCommand object. 
     * <p>
     * @param c the stack on which the command acts
     */
    public DivisionCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * The method returns the conjugated (same real part, inverted imaginary part) of the ComplexNumber passed as an arguemnt.
     * @param x the ComplexNumber on which the function is executed
     * @return the conjugated version of the number
     */
    private ComplexNumber conjugated(ComplexNumber x){
        return new ComplexNumber(x.getReal(), -x.getImaginary());
    }
    
    /**
     * The method executes the arithmetical division between two complex numbers.
     * The result is pushed into the stack maintained by the command
     * <p>
     * @throws DivisionForZeroException
     */        
    @Override
    public void execute() {
        if (c.size() < 2) {
            throw new ArithmeticException();
        }
        ComplexNumber a = (ComplexNumber) c.pop();
        ComplexNumber b = (ComplexNumber) c.pop();
        ComplexNumber conj_b = conjugated(b);
        ComplexNumber N = new ComplexNumber((a.getReal() * conj_b.getReal()+ (-1 * a.getImaginary() * conj_b.getImaginary())), (a.getReal() * conj_b.getImaginary()+a.getImaginary()* conj_b.getReal()));
        ComplexNumber D = new ComplexNumber((b.getReal() * conj_b.getReal()+ (-1 * b.getImaginary() * conj_b.getImaginary())), (b.getReal() * conj_b.getImaginary()+b.getImaginary()* conj_b.getReal()));
        if(D.getImaginary() == 0 && D.getReal() == 0){
            c.push(b);
            c.push(a);
            throw new DivisionForZeroException();
        } else
            c.push(new ComplexNumber(N.getReal()/D.getReal(), N.getImaginary()/D.getReal()));
    }
    
    /**
     * This method creates the string form of the DivisionCommand.
     * <p>
     * @return the string form of the command
     */   
    @Override
    public String toString() {
        return "/";
    }
    
    
    
}
