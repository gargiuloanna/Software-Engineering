/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.personalizedoperations;

import scientificcalculator_model.ComplexStack;

/**
 *
 * @author Luigina
 */

/**
* The class implements a Drop command which removes the last element of a stack.
* If the stack is empty drop is not performed.
*/
public class DropCommand extends Command{
    
    private ComplexStack c;

    public DropCommand(ComplexStack c) {
        this.c = c;
    }
    
    @Override
    public void execute() {
        if (!c.isEmpty())
            c.pop();
    }
    
}
