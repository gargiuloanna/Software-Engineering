
package scientificcalculator_model.statecalculator;

import java.util.Map;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.UserOperation;
import scientificcalculator_model.Operations;


/**
 * The abstract class State implements a State that allows to execute different operations depending on the state of the Context.
 */
public abstract class State {

    /**
    * @param stack the stack containing the complex number inputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void addition(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */    
    public abstract void product(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void subtraction(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void division(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void drop(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void dup(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void invert(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void module(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void over(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void phase(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void sqrt(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void swap(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param number the number to push on the stack
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void push(ComplexStack stack, ComplexNumber number, Map<String, Operations> operations, String operationName);
    
    /**
    * @param user the object representing the user defined operation
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void userDefinition(UserOperation user,  Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param variables the map where the variables are located
    * @param v the variable input
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void insertInVariable(ComplexStack stack, Map<Character, ComplexNumber> variables, Character v, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param variables the map where the variables are located
    * @param v the variable input
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void getFromVariable(ComplexStack stack, Map<Character, ComplexNumber> variables, Character v, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param variables the map where the variables are located
    * @param v the variable input
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void addToLast(ComplexStack stack, Map<Character, ComplexNumber> variables, Character v, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number inputs
    * @param variables the map where the variables are located
    * @param v the variable input
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void subToLast(ComplexStack stack, Map<Character, ComplexNumber> variables, Character v, Map<String, Operations> operations, String operationName);
}
