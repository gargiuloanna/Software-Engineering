
package scientificcalculator_model.operationscommands;

import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;


/**
 * This class implements a Phase command which makes the phase of a complex number
 */
public class PhaseCommand implements Command{
    
    private ComplexStack c;

    /**
     * Initializes a newly created PhaseCommand object. The c argument is the stack used to create a Command that allows to maintain the result of the operations executed using the Command.
     * <p>
     * @param c the stack used to create the command
     */
    public PhaseCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * The method executes the operation phase on the ComplexNumber.
     * It calculates the phase of the complex number.
     * The result is pushed into the stack maintained by the command.
     */    
    @Override
    public void execute() {
       ComplexNumber a = (ComplexNumber) c.pop();
       c.push(new ComplexNumber(Math.atan2(a.getImaginary(), a.getReal()), 0));
    }
    
    /**
     * This method creates the string form of the PhaseCommand.
     * <p>
     * @return the string form of the command
     */ 
    @Override
    public String toString() {
        return "arg(z)";
    }
    
    
    
}
