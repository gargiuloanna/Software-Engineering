/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package scientificcalculator_model;




import java.util.Collections;
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
* @see Stack
* @see ComplexNumber
*/
public class ComplexStack<ComplexNumber>{
    private ObservableList list;

    public ComplexStack() {
       list = FXCollections.observableArrayList();
}

/**
* The method reads and returns the full content from the stack.
* <p>
* @return an ArrayList containing the elements
*/
    public ObservableList<ComplexNumber> getMemory(){
       Collections.reverse(list);
       return list;
}

/**
* The method removes the last element inserted into the stack
* <p>
* @return the element removed
*/
    public ComplexNumber pop(){
       return (ComplexNumber) list.remove(list.size()-1);
    }

/**
* The method inserts number at the last position of the stack.
* <p>
* @param number the element to insert
*/

    public void push(ComplexNumber number){
        list.add(number);
}

/**
* The method returns, withour removing, the last element of the stack.
* <p>
* @return the last element of the stack
*/

    public ComplexNumber peek(){
        return (ComplexNumber) list.get(list.size()-1);
}

/**
* The method returns the size of the stack
* <p>
* @return the size of the stack
*/
    public int size(){
        return list.size();
}

/**
* The method checks if the stack is empty
* <p>
* @return true if the stack is empty
*/
    public boolean isEmpty(){
        return list.size()==0;
}

/**
* The method uses the clear method inherited from the class Stack.
* <p>
* @return the size of the stack
*/
    public int stackClear(){
        list.clear();
        return list.size();
}
    
/**
* The method swaps the last two elements of the stack
* If the stack is empty or the size of the stack is less than two, then the swap is not performed and the method returns false.
* <p>
* @return true if the swap has been successfull
*/
    public boolean swap(){
        if(list.isEmpty())
           return false;

        if(list.size()<2)
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
* @return true if the duplication has been successfull
*/

    public boolean dup(){
        if (list.isEmpty())
        return false;

        push(peek());
        return true;
}

/**
* The method removes last element of the stack and returns true.
* If the stack is empty drop is not performed and the method returns false.
* <p>
* @return true if the last element of the stack has been removed
*/
    public boolean drop(){
        if (list.isEmpty())
            return false;

        pop();
        return true;
}

/**
* The method duplicates the second last element of the stack, adds it to the top of the stack and returns true.
* If the stack is empty duplication is not performed and the method returns false.
* <p>
* @return true if the second last element of the stack has been duplicated and added.
*/
    public boolean over(){
        if (swap()){
            ComplexNumber last= (ComplexNumber) peek();
            swap();
            push(last);
            return true;
        }
        return false;
}

}