/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Anna
 */
public class ObservableStack{
    ObservableList<ComplexStack> stack;
    
    public ObservableStack(){
        stack = FXCollections.observableArrayList();
        stack.add(new ComplexStack());
    }
    
    public ComplexNumber peek(){
        return (ComplexNumber) stack.get(0).peek(); 
    }
    
    public ComplexNumber pop(){
        return (ComplexNumber) stack.get(0).pop(); 
    }
    
    

        
}
