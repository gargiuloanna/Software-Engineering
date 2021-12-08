
package scientificcalculator_model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
* The class ComplexStack implements a Java Stack that can be used with Complex Numbers.
* <p>
* @param <ComplexNumber>
* @see ComplexNumber
*/
public class ComplexStack<ComplexNumber>{
    private ObservableList list;

    /**
     * Initializes a new ComplexStack.
     */
    public ComplexStack() {
       list = FXCollections.observableArrayList();
}

    /**
    * The method reads and returns the full content from the stack.
    * <p>
    * @return an ObservableList containing the elements of the stack
    */
    public ObservableList<ComplexNumber> getMemory(){
       return list;
}

    /**
    * The method removes the last element inserted into the stack.
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
    * The method reads, withour removing, the last element of the stack.
    * <p>
    * @return the last element of the stack
    */
    public ComplexNumber peek(){
        return (ComplexNumber) list.get(0);
    }

    /**
    * The method returns the size of the stack.
    * <p>
    * @return the size of the stack
    */
    public int size(){
        return list.size();
    }

    /**
    * The method checks if the stack is empty.
    * <p>
    * @return true if the stack is empty
    */
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
    * The method uses the clear method inherited from the class List.
    * <p>
    * @return the size of the stack after clear
    */
    public int stackClear(){
        list.clear();
        return list.size();
    }
 

}