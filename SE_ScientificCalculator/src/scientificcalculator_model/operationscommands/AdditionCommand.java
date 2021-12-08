
package scientificcalculator_model.operationscommands;


import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;


/**
* This class implements an Addition command which makes the arithmetical addition between two complex numbers.
*/
public class AdditionCommand implements Command{
    
    private ComplexStack c;

    /**
     * Initializes a newly created AdditionCommand object. The c argument is the stack used to create a Command that allows to maintain the result of the operations executed using the Command.
     * <p>
     * @param c the stack used to create the command
     */
    public AdditionCommand(ComplexStack c) {
        this.c = c;
    }

    /**
     * The method executes the arithmetical addition between two complex numbers.
     * The result is pushed into the stack maintained by the command
     */    
    @Override
    public void execute() {
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
