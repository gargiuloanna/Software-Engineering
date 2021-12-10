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
* The class implements an InsertVariable Command that saves into a variable the top element of the stack.
*/
public class InsertInVariableCommand implements Command {
    
    ComplexStack c;
    Map<Character, ComplexNumber> variables;
    Character v;
    
    /**
     * Initializes a newly created InsertInVariableCommand object.
     * <p>
     * @param c the stack on which the command acts
     * @param variables the map that stores for different variables their specific values
     * @param v the variable that is involved in the command
     */
    public InsertInVariableCommand(ComplexStack c, Map<Character, ComplexNumber> variables, Character v) {
        this.c = c;
        this.variables = variables;
        this.v = v;
    }
    
    /**
     * The method executes the extraction of the top element of the stack and saves it into the variable in input.
     * The result replaces the value associated to the variable in the map
     */     
    @Override
    public void execute() {
        variables.put(v, (ComplexNumber) c.pop());      
    }
    
     /**
     * This method creates the string form of the InsertInVariableCommand.
     * <p>
     * @return the string form of the command
     */
    @Override
    public String toString() {
        return ">" + v;
    }
    
    
}
