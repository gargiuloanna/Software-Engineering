/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.operationscommands;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import scientificcalculator_model.VariablesOperations;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;

/**
 *
 * @author Anna
 */
public class Operations {
    private ArrayList<Command> opers;
    
    
    public Operations(){
        opers= new ArrayList();
    }

    public ArrayList<Command> getOpers() {
        return opers;
    }

    
    public void addOperation(Command op){
        opers.add(op);
    }
    
    
}
    

