
package scientificcalculator_model.operationscommands;

import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;


/**
* This class implements an Invert command that allows to invert the sign of the ComplexNumber.
*/
public class InvertCommand implements Command {
    
    private ComplexStack c;

    /**
     * Initializes a newly created InvertCommand object. 
     * <p>
     * @param c the stack on which the command acts
     */
    public InvertCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * The method executes the operation invert on the ComplexNumber.
     * It inverts the sign of the complex number.
     * The result is pushed into the stack maintained by the command.
     */  
    @Override
    public void execute() {
        if(c.isEmpty())
            throw new ArithmeticException();
        ComplexNumber a = (ComplexNumber) c.pop();
        c.push(new ComplexNumber(-a.getReal(), -a.getImaginary()));
    }
    
    /**
     * This method creates the string form of the DropCommand.
     * <p>
     * @return the string form of the command
     */ 
    @Override
    public String toString() {
        return "+-";
    }
    
    
    
}
