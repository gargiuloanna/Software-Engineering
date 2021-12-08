/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.operationscommands;

import scientificcalculator_model.ComplexStack;

/**
 *
 * @author Luigina
 * 
 */

/**
* The class implements a Dup command which duplicates and
* adds the last element of the stack on top of a stack.
* If the stack is empty the duplication is not performed.
*/

public class DupCommand implements Command{
    
    ComplexStack c;

    public DupCommand(ComplexStack c) {
        this.c = c;
    }

    @Override
    public void execute() {
       if (!c.isEmpty())
           c.push(c.peek());
    }

    @Override
    public String toString() {
        return "dup";
    }
    
    
    
}
