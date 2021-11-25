/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator_model;

import java.util.ArrayList;
import java.util.Stack;

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
    * Returns an ArrayList object that contains the k elements of the stack to be displayed. 
    * The k arguments symbolizes the number of elements of the stack that need to be added to the ArrayList.
    * If the number of elements requested is higher than the number of elements contained in the stack, the method
    * will return the full content of the stack.
    * <p>
    * @param  k    the number of elements to retrieve
    * @return      an ArrayList containing the elements
    */
    public ArrayList<ComplexNumber> getMemory(int k){
        ArrayList<ComplexNumber> elements= new ArrayList<>();
        
        if(k>size())
            k=size();
        
        for(int index=0; index<k; index++){
            elements.add((ComplexNumber) elementAt(size()-1-index));  
        }
        return elements;
    }
    
    /**
    * Returns the size of the empty stack after that it has been cleared.
    * The method uses the clear method inherited from the class Stack.
    * <p>
    * @return      the size of the stack
    */
    
    public int stack_clear(){
            clear();
        
        return size();
    }
    
    /**
    * Returns true if the elements have been swapped. 
    * The method swaps the last two elements of the stack.
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
    * Returns true if the last element has been duplicated and added to the stack. 
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
        
        
    
          
    
    
    
    
}
