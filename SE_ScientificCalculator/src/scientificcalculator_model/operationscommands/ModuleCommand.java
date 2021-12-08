
package scientificcalculator_model.operationscommands;


import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;


/**
 * This class implements a Module command which makes the module of a complex number.
 */
public class ModuleCommand implements Command{
    
    private ComplexStack c;

    /**
     * Initializes a newly created ModuleCommand object. The c argument is the stack used to create a Command that allows to maintain the result of the operations executed using the Command.
     * <p>
     * @param c the stack used to create the command
     */
    public ModuleCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * The method executes the operation module on the ComplexNumber.
     * It calculates the absolute value of the complex number.
     * The result is pushed into the stack maintained by the command.
     */      
    @Override
    public void execute() {
        ComplexNumber a = (ComplexNumber) c.pop();
        c.push(new ComplexNumber(Math.sqrt(Math.pow(a.getReal(), 2) + Math.pow(a.getImaginary(), 2)), 0));
    }
    
    /**
     * This method creates the string form of the ModuleCommand.
     * <p>
     * @return the string form of the command
     */ 
    @Override
    public String toString() {
        return "mod";
    }
    
    
}
