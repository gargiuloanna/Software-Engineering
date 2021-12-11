
package scientificcalculator_model.operationscommands;


import scientificcalculator_model.ComplexStack;


/**
* The class implements a Dup command which duplicates and adds the last element of the stack on top of a stack.
* If the stack is empty the duplication is not performed.
*/
public class DupCommand implements Command{
    
    ComplexStack c;

    /**
     * Initializes a newly created DupCommand object. 
     * <p>
     * @param c the stack on which the command acts
     */
    public DupCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * The method executes the operation Dup on the stack.
     * It duplicates the last element contained on the stack.
     * The result is pushed into the stack maintained by the command.
     * <p>
     * @throws ArithmeticException if the stack is empty.
     */  
    @Override
    public void execute() {
       if (c.isEmpty())
           throw new ArithmeticException();
        c.push(c.peek());
    }
    
    /**
     * This method creates the string form of the DupCommand.
     * <p>
     * @return the string form of the command
     */ 
    @Override
    public String toString() {
        return "dup";
    }
    
    
    
}
