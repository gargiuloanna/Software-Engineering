
package scientificcalculator_model.operationscommands;


import scientificcalculator_model.ComplexStack;


/**
* The class implements a Drop command which removes the last element of a stack.
* If the stack is empty drop is not performed.
*/
public class DropCommand implements Command{
    
    private ComplexStack c;
    
    /**
     * Initializes a newly created DropCommand object. The c argument is the stack used to create a Command that allows to maintain the result of the operations executed using the Command.
     * <p>
     * @param c the stack used to create the command
     */
    public DropCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * The method executes the operation Drop on the stack.
     * It eliminates the last element contained on the stack.
     * The result is pushed into the stack maintained by the command.
     */  
    @Override
    public void execute() {
        if (!c.isEmpty())
            c.pop();
    }
    
    /**
     * This method creates the string form of the DropCommand.
     * <p>
     * @return the string form of the command
     */ 
    @Override
    public String toString() {
        return "drop";
    }
    
    
}
