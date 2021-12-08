/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculator_model;

import java.util.ArrayList;
import scientificcalculator_model.operationscommands.Operations;


/**
 *
 * @author marco
 */
public class Entry {
    private String name;
    private Operations op;

    public Entry(String name,Operations op) {
        this.name = name;
        this.op = op;
    }

    public String getName() {
        return name;
    }

    public Operations getOp() {
        return op;
    }

    
    
    
}
