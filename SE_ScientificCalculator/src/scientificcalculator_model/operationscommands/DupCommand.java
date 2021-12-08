
package scientificcalculator_model.operationscommands;


import scientificcalculator_model.ComplexStack;


/**
* The class implements a Dup command which duplicates and adds the last element of the stack on top of a stack.
* If the stack is empty the duplication is not performed.
*/
public class DupCommand implements Command{
    
    ComplexStack c;

    /**
     * Initializes a newly created DupCommand object. The c argument is the stack used to create a Command that allows to maintain the result of the operations executed using the Command.
     * <p>
     * @param c the stack used to create the command
     */
    public DupCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * The method executes the operation Dup on the stack.
     * It duplicates the last element contained on the stack.
     * The result is pushed into the stack maintained by the command.
     */  
    @Override
    public void execute() {
       if (!c.isEmpty())
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
