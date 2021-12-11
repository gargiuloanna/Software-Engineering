
package scientificcalculator_model.operationscommands;

import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;


/**
* This class implements a Sqrt command which makes the square root of a complex number.
*/
public class SqrtCommand implements Command{
    
    private ComplexStack c;

    /**
     * Initializes a newly created SqrtCommand object. 
     * <p>
     * @param c the stack on which the command acts
     */
    public SqrtCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * The method executes the operation sqrt on the ComplexNumber.
     * It calculates the square rootof the complex number.
     * The result is pushed into the stack maintained by the command.
     * <p>
     * @throws ArithmeticException if the stack is empty.
     */    
    @Override
    public void execute() {
        if(c.isEmpty())
            throw new ArithmeticException();
        ComplexNumber a = (ComplexNumber) c.pop();
        if (a.getImaginary() == 0){
            c.push(new ComplexNumber(Math.sqrt(a.getReal()), 0));
        }
        else{
            double xABS = Math.sqrt(Math.pow(a.getReal(), 2) + Math.pow(a.getImaginary(), 2));

            double a1 = Math.sqrt((xABS+a.getReal())/2);
            double a2 = Math.sqrt((xABS-a.getReal())/2);
            
            c.push(new ComplexNumber(a1, a2));
        }
    }

    /**
     * This method creates the string form of the SqrtCommand.
     * <p>
     * @return the string form of the command
     */ 
    @Override
    public String toString() {
        return "sqrt";
    }
    
    
    
}
