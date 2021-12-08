
package scientificcalculator_model.statecalculator;

import java.util.Map;
import scientificcalculator_model.ComplexNumber;
import scientificcalculator_model.ComplexStack;
import scientificcalculator_model.Entry;
import scientificcalculator_model.operationscommands.Operations;


/**
 * The abstract class State implementes a State that allows to execute different operations depending on the state of the Context.
 */
public abstract class State {

    /**
    * @param stack the stack containing the complex number imputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void addition(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number imputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */    
    public abstract void product(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number imputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void subtraction(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number imputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void division(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number imputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void drop(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number imputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void dup(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number imputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void invert(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number imputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void module(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number imputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void over(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number imputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void phase(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number imputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void sqrt(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number imputs
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void swap(ComplexStack stack, Map<String, Operations> operations, String operationName);
    
    /**
    * @param stack the stack containing the complex number imputs
    * @param number the number to push on the stack
    * @param operations the map where the user defined operations are located
    * @param operationName the name of the operation to define
    */
    public abstract void push(ComplexStack stack, ComplexNumber number, Map<String, Operations> operations, String operationName);
    
    public abstract void userDefinition(Entry user,  Map<String, Operations> operations, String operationName);
    
}
