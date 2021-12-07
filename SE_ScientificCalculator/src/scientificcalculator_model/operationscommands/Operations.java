/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model.operationscommands;

import java.util.ArrayList;


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
    

