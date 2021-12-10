
package scientificcalculator_model.operationscommands;

import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;

/**
* This class implements a Push command which allows to push an element in the stack.
*/
public class PushCommand implements Command{
    
    ComplexStack c;
    ComplexNumber a;

    /**
     * Initializes a newly created PushCommand object. 
     * <p>
     * @param c the stack on which the command acts
     * @param a the element to be pushed
     */
    public PushCommand(ComplexStack c, ComplexNumber a) {
        this.c = c;
        this.a = a;
    }
    
    /**
     * The method executes the operation push on the stack.
     * The param a is pushed into the stack maintained by the command.
     */   
    @Override
    public void execute() {
        c.push(a);
    }

    /**
     * This method creates the string form of the PushCommand.
     * <p>
     * @return the string form of the command
     */ 
    @Override
    public String toString() {
        return a.toString();
    }
    
    
    
    
}
