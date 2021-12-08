
package scientificcalculator_model.operationscommands;

import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;


/**
* This class implements a Product command which makes the arithmetical product between two complex numbers.
*/
public class ProductCommand implements Command{
    
    private ComplexStack c;

    /**
     * Initializes a newly created ProductCommand object. The c argument is the stack used to create a Command that allows to maintain the result of the operations executed using the Command.
     * <p>
     * @param c the stack used to create the command
     */
    public ProductCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * The method executes the operation product on the ComplexNumber.
     * The result is pushed into the stack maintained by the command.
     */   

    @Override
    public void execute() {
        ComplexNumber a = (ComplexNumber) c.pop();
        ComplexNumber b = (ComplexNumber) c.pop();
        double aa = a.getReal() * b.getReal();
        double aib_1 = a.getReal() * b.getImaginary();
        double aib_2 = a.getImaginary()* b.getReal();
        double iibb = -1 * b.getImaginary() * a.getImaginary();
        c.push(new ComplexNumber((aa + iibb), (aib_1 + aib_2)));
    }
    
    /**
     * This method creates the string form of the ProductCommand.
     * <p>
     * @return the string form of the command
     */ 
    @Override
    public String toString() {
        return "*";
    }
    
    
    
}
