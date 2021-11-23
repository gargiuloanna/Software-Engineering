/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Anna
 */
public class ComplexStack<ComplexNumber> extends Stack{
    
    public ArrayList<ComplexNumber> getMemory(int k){
        ArrayList<ComplexNumber> elements= new ArrayList<>();
        
        for(int index=0; index<k; index++){
            elements.add((ComplexNumber) this.elementAt(this.size()-index));  
        }
       
        return elements;
    }
    
    
}
