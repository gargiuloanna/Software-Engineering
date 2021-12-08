
package scientificcalculator_model.operationscommands;

import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;


/**
* This class implements an Invert command that allows to invert the sign of the ComplexNumber.
*/
public class InvertCommand implements Command {
    
    private ComplexStack c;

    /**
     * Initializes a newly created InvertCommand object. The c argument is the stack used to create a Command that allows to maintain the result of the operations executed using the Command.
     * <p>
     * @param c the stack used to create the command
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
