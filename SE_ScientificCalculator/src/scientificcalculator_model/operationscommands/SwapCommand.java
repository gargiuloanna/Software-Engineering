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
* The class implements a Swap command which swaps the last two elements of a stack.
* If the stack is empty or the size of the stack is less than two, 
* then the swap is not performed
*/
public class SwapCommand implements Command {
    
    ComplexStack c;

    public SwapCommand(ComplexStack c) {
        this.c = c;
    }
   
    @Override
    public void execute() {
         if(!c.isEmpty() || c.size() > 2){
             ComplexNumber lastElement =(ComplexNumber) c.pop();
             ComplexNumber secondLastElement = (ComplexNumber) c.pop();
             c.push(lastElement);
             c.push(secondLastElement);
         }
    }

    @Override
    public String toString() {
        return "swap";
    }
    
    
    
}
