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
 * The class implements a SubToLast Command which takes the top element from the stack and subs it to the value of the variable
 */
public class SubToLastCommand implements Command{
    
    ComplexStack c;
    Map<Character, ComplexNumber> variables;
    Character v;
    
    /**
     * Initializes a newly created SubToLastCommand object.
     * <p>
     * @param c the stack on which the command acts
     * @param variables the map that stores for different variables their specific values
     * @param v the variable that is involved in the command
     */
    public SubToLastCommand(ComplexStack c, Map<Character, ComplexNumber> variables, Character v) {
        this.c = c;
        this.variables = variables;
        this.v = v;
    }
    
    /**
     * The method executes the arithmetical subtraction between the top element of the stack and the value associated to the variable in input.
     * The result replaces the value associated to the variable in the map
     */ 
    @Override
    public void execute() {
        if(c.isEmpty())
            throw new ArithmeticException();
        ComplexNumber last = (ComplexNumber) c.pop();
        ComplexNumber variableNumber = variables.get(v);
        ComplexNumber sub = new ComplexNumber(last.getReal() - variableNumber.getReal(), last.getImaginary() - variableNumber.getImaginary());
        variables.put(v,sub);
    }
    
     /**
     * This method creates the string form of the SubToLastCommand.
     * <p>
     * @return the string form of the command
     */
    @Override
    public String toString() {
        return "-" + v;
    }
    
    
}
