/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package scientificcalculator_model;


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
       return list;
}

/**
* The method removes the last element inserted into the stack
* <p>
* @return the element removed
*/
    public ComplexNumber pop(){
       return (ComplexNumber) list.remove(0);
    }

/**
* The method inserts number at the last position of the stack.
* <p>
* @param number the element to insert
*/

    public void push(ComplexNumber number){
        list.add(0,number);
        
}

/**
* The method returns, withour removing, the last element of the stack.
* <p>
* @return the last element of the stack
*/

    public ComplexNumber peek(){
        return (ComplexNumber) list.get(0);
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
        return list.isEmpty();
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
 

}