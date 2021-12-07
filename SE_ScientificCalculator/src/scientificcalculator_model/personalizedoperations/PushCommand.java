/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.personalizedoperations;

import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;

/**
 *
 * @author Luigina
 */
public class PushCommand extends Command{
    
    ComplexStack c;
    ComplexNumber a;

    public PushCommand(ComplexStack c, ComplexNumber a) {
        this.c = c;
        this.a = a;
    }

    @Override
    public void execute() {
        c.push(a);
    }
    
    
    
}
