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
* The class implements an Over command which duplicates the second last element of a stack and
* adds it to the top of the stack.
* If the stack is empty duplication is not performed.
*/
public class OverCommand implements Command {
    
    private ComplexStack c;

    public OverCommand(ComplexStack c) {
        this.c = c;
    }
    
    @Override
    public void execute() {
        Command swap = new SwapCommand(c);
        swap.execute();
        ComplexNumber last= (ComplexNumber) c.peek();
        swap.execute();
        c.push(last);
    
    }

    @Override
    public String toString() {
        return "over";
    }
    
    
       
    
    
}
