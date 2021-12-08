/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.operationscommands;

import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;

/**
 *
 * @author Luigina
 */

/**
* The class implements an Over command which duplicates the second last element of a stack and adds it to the top of the stack.
* If the stack is empty duplication is not performed.
*/
public class OverCommand implements Command {
    
    private ComplexStack c;

    /**
     * Initializes a newly created AdditionCommand object. The c argument is the stack used to create a Command that allows to maintain the result of the operations executed using the Command.
     * <p>
     * @param c the stack used to create the command
     */
    public OverCommand(ComplexStack c) {
        this.c = c;
    }
    
    /**
     * The method executes the operation Over on the Stack.
     * It duplicates the second last element contained on the stack.
     * The result is pushed into the stack maintained by the command.
     */        
    @Override
    public void execute() {
        Command swap = new SwapCommand(c);
        swap.execute();
        ComplexNumber last= (ComplexNumber) c.peek();
        swap.execute();
        c.push(last);
    }

    /**
     * This method creates the string form of the OverCommand.
     * <p>
     * @return the string form of the command
     */  
    @Override
    public String toString() {
        return "over";
    }
    
    
       
    
    
}
