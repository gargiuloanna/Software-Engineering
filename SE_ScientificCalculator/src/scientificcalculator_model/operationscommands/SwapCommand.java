
package scientificcalculator_model.operationscommands;

import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;


/**
* The class implements a Swap command which swaps the last two elements of a stack.
* If the stack is empty or the size of the stack is less than two, 
* then the swap is not performed
*/
public class SwapCommand implements Command {
    
    ComplexStack c;

    /**
     * Initializes a newly created SwapCommand object. 
     * <p>
     * @param c the stack used to create the command
     */
    public SwapCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * The method executes the operation swap on the stack.
     * It swaps the last two elements of the stack.
     * The result is pushed into the stack maintained by the command.
     */      
    @Override
    public void execute() {
        if (c.size() < 2) 
            throw new ArithmeticException();
        
        ComplexNumber lastElement = (ComplexNumber) c.pop();
        ComplexNumber secondLastElement = (ComplexNumber) c.pop();
        c.push(lastElement);
        c.push(secondLastElement);

    }
    
    /**
     * This method creates the string form of the SwapCommand.
     * <p>
     * @return the string form of the command
     */ 
    @Override
    public String toString() {
        return "swap";
    }
    
    
    
}
