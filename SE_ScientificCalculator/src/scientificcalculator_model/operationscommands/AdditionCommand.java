
package scientificcalculator_model.operationscommands;


import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;


/**
* This class implements an Addition command which makes the arithmetical addition between two complex numbers.
*/
public class AdditionCommand implements Command{
    
    private ComplexStack c;

    /**
     * Initializes a newly created AdditionCommand object. 
     * <p>
     * @param c the stack on which the command acts
     */
    public AdditionCommand(ComplexStack c) {
        this.c = c;
    }

    /**
     * The method executes the arithmetical addition between two complex numbers.
     * The result is pushed into the stack maintained by the command
     * <p>
     * @throws ArithmeticException if the stack does not contain at least two elements.
     */    
    @Override
    public void execute() {
         if (c.size() < 2) {
            throw new ArithmeticException();
        }
        ComplexNumber a = (ComplexNumber) c.pop();
        ComplexNumber b = (ComplexNumber) c.pop();
        c.push(new ComplexNumber(a.getReal() + b.getReal(),a.getImaginary() + b.getImaginary()));
    }
    
    /**
     * This method creates the string form of the AdditionCommand.
     * <p>
     * @return the string form of the command
     */    
    @Override
    public String toString() {
        return "+";
    }
    
    
    
}
