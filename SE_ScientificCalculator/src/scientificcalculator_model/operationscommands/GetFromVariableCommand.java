/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.operationscommands;

import java.util.Map;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;

/**
* The class implements a GetFromVariable that saves into the stack the value stored in a variable
*/    
public class GetFromVariableCommand implements Command{
    
    ComplexStack c;
    Map<Character, ComplexNumber> variables;
    Character v;
    
    /**
     * Initializes a newly created GetFromVariableCommand object.
     * <p>
     * @param c the stack on which the command acts
     * @param variables the map that stores for different variables their specific values
     * @param v the variable that is involved in the command
     */
    public GetFromVariableCommand(ComplexStack c, Map<Character, ComplexNumber> variables, Character v) {
        this.c = c;
        this.variables = variables;
        this.v = v;
    }
    
     /**
     * The method executes the insertion into the stack of the value of the variable in input.
     * The result is pushed into the stack maintained by the command
     */  
    @Override
    public void execute() {
        if(variables.get(v) == null)
            throw new ArithmeticException();
        c.push(variables.get(v));   
    }
    
    /**
     * This method creates the string form of the GetFromVariableCommand.
     * <p>
     * @return the string form of the command
     */
    @Override
    public String toString() {
        return "<" + v;
    }
    
    
    
}
