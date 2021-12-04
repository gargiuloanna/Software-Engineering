/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculator_model;

import scientificcalculator_model.personalizedoperations.Operations;

/**
 *
 * @author marco
 */
public class Entry {
    private String name;
    private String op;

    public Entry(String name, String op) {
        this.name = name;
        this.op = op;
    }

    public String getName() {
        return name;
    }

    public String getOp() {
        return op;
    }
    
}
