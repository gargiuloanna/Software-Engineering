/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Anna
 */

/**
* The class ComplexStack implements a Java Stack that can be used with Complex Numbers.
* The Stack uses and extends the Stack Class by implementing other methods such as 'Dup', 'Over', 'Stack_Clear', 'getMemory' and ''
*
* @param <ComplexNumber>
* @see         Stack
* @see         ComplexNumber
*/
public class ComplexStack<ComplexNumber> extends Stack{

    public ComplexStack() {
        super();
    }
    
    /**
    * The method reads and returns the last k elements from the stackayed.
    * The k arguments symbolizes the number of elements of the stack that need to be added to the ArrayList.
    * If the number of elements requested is higher than the number of elements contained in the stack, the method
    * will return the full content of the stack.
    * <p>
    * @param  k    the number of elements to retrieve
    * @return      an ArrayList containing the elements
    */
    public ObservableList<ComplexNumber> getMemory(int k){
        ObservableList<ComplexNumber> elements= FXCollections.observableArrayList();

        if(k>size())
            k=size();
        
        for(int index=0; index<k; index++)
            elements.add((ComplexNumber) pop());  
        for (int index=0; index<elements.size(); index++)
            add(elements.get(elements.size()-1-index));
            
        return elements;
    }
    
    /**
    * The method uses the clear method inherited from the class Stack.
    * <p>
    * @return      the size of the stack
    */
    
    public int stackClear(){
            clear();
        
        return size();
    }
    
    /**
    * The method swaps the last two elements of the stack
    * If the stack is empty or the size of the stack is less than two, then the swap is not performed and the method returns false.
    * <p>
    * @return      true if the swap has been successfull
    */
    public boolean swap(){
        
        if(empty())
            return false;
        
        if(size()<2)
            return false;
        
        ComplexNumber lastElement =(ComplexNumber) pop();
        ComplexNumber secondLastElement = (ComplexNumber) pop();
        
        push(lastElement);
        push(secondLastElement);

        return true;
        
    }
    /**
    * The method duplicates and adds the last element of the stack on top of the stack.
    * If the stack is empty the duplication is not performed and the method returns false.
    * <p>
    * @return      true if the duplication has been successfull
    */
    
    public boolean dup(){
        if (empty())
            return false;
        
        add(peek());
        return true;
    }
    
    /**
    * The method removes last element of the stack and returns true.
    * If the stack is empty drop is not performed and the method returns false.
    * <p>
    * @return      true if the last element of the stack has been removed
    */
    public boolean drop(){
        if (empty())
           return false;
        
        pop();
        return true;
    }
    
    /**
    * The method duplicates the second last element of the stack, adds it to the top of the stack and returns true.
    * If the stack is empty duplication is not performed and the method returns false.
    * <p>
    * @return      true if the second last element of the stack has been duplicated and added.
    */
    public boolean over(){

        if (swap()){
            ComplexNumber last= (ComplexNumber) peek();
            swap();
            add(last);
            return true;
        }
        
        return false;
    }
    
}
