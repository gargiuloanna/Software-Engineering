
package scientificcalculator_model.operationscommands;

import java.util.Map;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;

 /**
 * The class implements an AddToLast Command which takes the top element from the stack and adds it to the value of the variable
 */   
public class AddToLastCommand implements Command{
    
    ComplexStack c;
    Map<Character, ComplexNumber> variables;
    Character v;
    
     /**
     * Initializes a newly created AddToLastCommand object.
     * <p>
     * @param c the stack used to create the command
     * @param variables the map that stores for different variables their specific values
     * @param v the variable that is involved in the command
     */
    public AddToLastCommand(ComplexStack c, Map<Character, ComplexNumber> variables, Character v) {
        this.c = c;
        this.variables = variables;
        this.v = v;
    }
    
    /**
     * The method executes the arithmetical addition between the top element of the stack and the value associated to the variable in input.
     * The result replaces the value associated to the variable in the map
     */ 
    @Override
    public void execute() {
        ComplexNumber last = (ComplexNumber) c.pop();
        ComplexNumber variableNumber = variables.get(v);
        ComplexNumber sum = new ComplexNumber(last.getReal() + variableNumber.getReal(), last.getImaginary() + variableNumber.getImaginary());
        variables.replace(v,sum);
    }
    
    /**
     * This method creates the string form of the AddToLastCommand.
     * <p>
     * @return the string form of the command
     */
    @Override
    public String toString() {
        return "+" + v;
    }
    
    
    
}
